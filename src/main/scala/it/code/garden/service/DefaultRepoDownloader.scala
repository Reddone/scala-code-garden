package it.code.garden.service

import scala.concurrent.{ExecutionContext, Future}

trait DefaultRepoDownloader extends RepoDownloader[Future] {

  private val onlyWorksForMe = "/home/skynet/Projects/idea-projects/java-code-garden"

  implicit def ec: ExecutionContext

  override def downloadRepo(repoUrl: String): Future[String] = Future.successful(onlyWorksForMe)
}
