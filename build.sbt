import sbt.Keys.version

resolvers in ThisBuild += Resolver.sonatypeRepo("snapshots")

lazy val lib = (project in file("."))
  .settings(
      libraryDependencies ++= Seq(
        "com.novocode" % "junit-interface" % "0.11" % Test,
        "com.typesafe.play" %% "play-json" % "2.9.0",
        "io.lemonlabs" %% "scala-uri" % "2.2.2",
        "org.apache.jena" % "jena-core" % jenaVersion,
        "org.scalatest" %% "scalatest" % "3.1.2" % Test,
        "org.slf4j" % "slf4j-simple" % slf4jVersion % Test,
        "org.typelevel" %% "cats-core" % "2.1.1"
      ),
    name := "commonsense-models",
    organization := "io.github.tetherless-world",
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
    version := "1.0.0-SNAPSHOT"
  )

scalaVersion := "2.13.2"
val jenaVersion = "3.15.0"
val slf4jVersion = "1.7.30"