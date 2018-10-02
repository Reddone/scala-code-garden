package it.code.garden.service

import scala.concurrent.Future

trait DefaultRepoDownloader extends RepoDownloader[Future] {

  val onlyWorksForMe = "/home/skynet/Projects/idea-projects/java-code-garden"

  override def downloadRepo(repoUrl: String): Future[String] = Future.successful(onlyWorksForMe)
}
