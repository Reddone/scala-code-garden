package it.code.garden

import it.code.garden.model.{Build, DockerContext, LocalContext}
import it.code.garden.service.{DefaultRepoBuilder, DefaultRepoDownloader}

import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object MainRunner extends App with DefaultRepoBuilder with DefaultRepoDownloader {

  implicit val ec: ExecutionContext = Implicits.global

  val localMaven  = "/home/skynet/Applications/maven"
  val dockerImage = "maven:latest"

  val build1 = Build("http://firstrepository", LocalContext)
  val build2 = Build("http://secondrepository", DockerContext)

  val buildList = List(build1, build2)

  lazy val buildSequence = buildList.map(build)

  lazy val buildResult = Future.sequence(buildSequence) andThen {
    case Success(res) => res.foreach(println)
    case Failure(ex)  => println(ex.getMessage)
  }

  Await.result(buildResult, Duration.Inf)
}
