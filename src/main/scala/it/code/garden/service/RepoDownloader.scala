package it.code.garden.service

import scala.language.higherKinds

trait RepoDownloader[F[_]] {

  def downloadRepo(repoUrl: String): F[String]
}
