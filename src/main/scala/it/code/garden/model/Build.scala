package it.code.garden.model

sealed trait Context

case object LocalContext  extends Context
case object DockerContext extends Context

case class Build(repoURL: String, context: Context)
