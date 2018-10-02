package it.code.garden.magnet

import cats.effect.IO
import it.code.garden.model.{DockerEnv, LocalEnv}

import scala.language.implicitConversions
import scala.sys.process._

sealed trait BuildMagnet {
  type Result
  def get: Result
}

object BuildMagnet {
  implicit def buildOnLocalMachine(env: LocalEnv): BuildMagnet = new BuildMagnet {
    override type Result = Int

    override def get =
      IO {
        val cmd = "echo local"
        cmd.!
      }.unsafeRunSync()
  }

  implicit def buildOnDockerContainer(env: DockerEnv): BuildMagnet = new BuildMagnet {
    override type Result = Int

    override def get =
      IO {
        val cmd = "echo docker"
        cmd.!
      }.unsafeRunSync()
  }
}
