import sbt._
import sbt.Keys._

object Commons {

  val settings: Seq[Def.Setting[_]] = Seq(
    // scala compiler options
    scalaVersion := "2.12.6",
    scalacOptions := Seq(
      "-deprecation",
      "-encoding",
      "utf8",
      "-feature",
      "-unchecked",
      "-Xexperimental",
      "-Ywarn-adapted-args",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused:_"
    ),
    // avoid parallel and concurrent tests
    fork := true,
    parallelExecution in Test := false,
    testForkedParallel in Test := false,
    concurrentRestrictions in Global += Tags.limit(Tags.Test, 1),
    javaOptions in Test += "-Xms2048m",
    javaOptions in Test += "-Xmx2048m",
    javaOptions in Test += "-XX:ReservedCodeCacheSize=256m",
    javaOptions in Test += "-XX:MaxMetaspaceSize=512m",
    // dependencies resolvers
    resolvers in ThisBuild ++= Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots"),
      Resolver.mavenLocal
    )
  )
}
