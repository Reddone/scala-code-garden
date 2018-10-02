package it.code.garden.magnet

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

    override def get: Int = {
      val buildCmd = s"${env.localMaven}/mvn -f ${env.repoPath}/pom.xml clean package"
      buildCmd.!
    }
  }

  implicit def buildOnDockerContainer(env: DockerEnv): BuildMagnet = new BuildMagnet {
    override type Result = String

    override def get: String = {
      val buildCmd = "docker run " +
        "--rm " +
        s"-v ${env.repoPath}:/home/build " +
        "-w /home/build " +
        s"${env.dockerImage} mvn clean package"
      buildCmd.!!
    }
  }
}
