package it.code.garden.service

import it.code.garden.magnet.BuildMagnet
import it.code.garden.model.Build

import scala.concurrent.Future

trait BuildService {

  def build(build: Build): Future[BuildMagnet#Result]
}
