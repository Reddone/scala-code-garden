import sbt._

object Dependencies {

  object Cats {
    lazy val version       = "1.4.0"
    lazy val namespace     = "org.typelevel"
    lazy val core          = namespace %% "cats-core" % version
  }

  object CatsEffect {
    lazy val version       = "1.0.0"
    lazy val namespace     = "org.typelevel"
    lazy val core          = namespace %% "cats-effect" % version
  }

  object Monix {
    lazy val version       = "3.0.0-RC1"
    lazy val namespace     = "io.monix"
    lazy val core          = namespace %% "monix" % version
  }

  object ScalaTest {
    lazy val version   = "3.0.5"
    lazy val namespace = "org.scalatest"
    lazy val core      = namespace %% "scalatest" % version
  }

  object Mockito {
    lazy val version   = "2.22.0"
    lazy val namespace = "org.mockito"
    lazy val core      = namespace % "mockito-core" % version
  }

  object JarManager {
    lazy val libraries = Seq(
      Cats.core,
      CatsEffect.core,
      Monix.core,
      ScalaTest.core % Test,
      Mockito.core   % Test
    )
  }
}
