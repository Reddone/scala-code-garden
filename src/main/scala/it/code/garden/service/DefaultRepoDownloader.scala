package it.code.garden.service

import scala.concurrent.Future

trait DefaultRepoDownloader extends RepoDownloader {

  override def downloadRepo(repoUrl: String): Future[String] = Future { "" }
}
