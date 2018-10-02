package it.code.garden.service

import it.code.garden.magnet.BuildMagnet
import it.code.garden.model._

import scala.concurrent.{ExecutionContext, Future}

trait DefaultRepoBuilder extends RepoBuilder[Future] { self: RepoDownloader[Future] =>

  private def completeBuild(magnet: BuildMagnet): magnet.Result = magnet.get

  implicit def ec: ExecutionContext

  def localMaven: String

  def dockerImage: String

  override def build(build: Build): Future[BuildMagnet#Result] = {
    val repoPath = downloadRepo(build.repoURL)
    repoPath.map(path => {
      build match {
        case Build(_, LocalContext)  => completeBuild(LocalEnv(path, localMaven))
        case Build(_, DockerContext) => completeBuild(DockerEnv(path, dockerImage))
        case _                       => throw new RuntimeException("Build type not supported")
      }
    })
  }
}
