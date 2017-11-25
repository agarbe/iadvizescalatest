import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scalamock" % "scalamock_2.12" % "4.0.0" % Test,
    libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.0.0",
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9"


  )
