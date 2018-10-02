package it.code.garden

import it.code.garden.model.{Build, DockerContext, LocalContext}
import it.code.garden.service.{DefaultRepoBuilder, DefaultRepoDownloader}

import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object MainRunner extends App with DefaultRepoBuilder with DefaultRepoDownloader {

  implicit val ec: ExecutionContext = Implicits.global

  val dockerImage = "ubuntu:latest"

  val build1 = Build("http://firstrepository", LocalContext)
  val build2 = Build("http://secondrepository", DockerContext)

  val buildList = List(build1, build2)

  lazy val buildResult = buildList.map(build)

  Await.result(Future.sequence(buildResult), Duration.Inf)
}
