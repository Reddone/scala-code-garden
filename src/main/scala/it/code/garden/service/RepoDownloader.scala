package it.code.garden.service

import scala.concurrent.ExecutionContext
import scala.language.higherKinds

trait RepoDownloader[F[_]] {

  implicit def ec: ExecutionContext

  def downloadRepo(repoUrl: String): F[String]
}
