package it.code.garden.service

import scala.concurrent.{ExecutionContext, Future}

trait RepoDownloader {

  implicit def ec: ExecutionContext

  def downloadRepo(repoUrl: String): Future[String]
}
