package it.code.garden

import it.code.garden.magnet.BuildMagnet
import it.code.garden.model.Build
import it.code.garden.service.{DefaultBuildService, DefaultRepoDownloader}

import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object MainRunner extends App with DefaultBuildService with DefaultRepoDownloader {
  implicit val ec: ExecutionContext = Implicits.global

  val build1 = Build("http://github", "SYNC")
  val build2 = Build("http://github", "ASYNC")

  val buildList                                    = List(build1, build2)
  val buildResult: Seq[Future[BuildMagnet#Result]] = buildList.map(build)

  val programResult: Seq[BuildMagnet#Result] = Await.result(Future.sequence(buildResult), Duration.Inf)
  programResult.foreach(res => println(res.toString))
}
