package it.code.garden.service

import it.code.garden.magnet.BuildMagnet
import it.code.garden.model._

import scala.concurrent.Future

trait DefaultRepoBuilder extends RepoBuilder[Future] { self: RepoDownloader[Future] =>
  private def completeBuild(magnet: BuildMagnet): magnet.Result = magnet.get

  def dockerImage: String

  override def build(build: Build): Future[BuildMagnet#Result] = {
    val repoPath = downloadRepo(build.repoURL)
    repoPath.map(path => {
      build match {
        case Build(_, LocalContext)  => completeBuild(LocalEnv(path))
        case Build(_, DockerContext) => completeBuild(DockerEnv(path, dockerImage))
        case _                       => throw new RuntimeException("Build type not supported")
      }
    })
  }
}
