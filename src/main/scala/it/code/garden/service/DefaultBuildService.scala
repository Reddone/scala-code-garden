package it.code.garden.service

import it.code.garden.magnet.BuildMagnet
import it.code.garden.model.{Build, DockerEnv}

import scala.concurrent.Future

trait DefaultBuildService extends BuildService { self: RepoDownloader =>
  private def completeBuild(magnet: BuildMagnet): magnet.Result = magnet.get

  def build(build: Build): Future[BuildMagnet#Result] = {
    val repoPath = downloadRepo(build.repoUrl)
    repoPath.map(path => {
      build match {
        case x @ Build(_, "LOCAL")  => completeBuild(x)
        case x @ Build(_, "DOCKER") => completeBuild(x, DockerEnv("dasdsa", ""))
        case _                      => throw new RuntimeException("Build type not supported")
      }
    })
  }
}
