package it.code.garden.service

import it.code.garden.model.Build

import scala.language.higherKinds

trait RepoBuilder[F[_]] {

  def build(build: Build): F[_]
}
