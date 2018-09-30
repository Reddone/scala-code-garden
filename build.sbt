import sbt.Keys.libraryDependencies

addCommandAlias("verify", ";clean;coverage;test")

lazy val root = (project in file("."))
  .settings(Commons.settings: _*)
  .settings(
    // project
    organization := "it.code.garden",
    name := "scala-code-garden",
    libraryDependencies ++= Dependencies.JarManager.libraries
  )
  .settings(
    // scalafmt
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true
  )

cancelable in Global := true
