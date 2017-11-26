import Dependencies._
import sbt.Keys.libraryDependencies

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
    libraryDependencies += "joda-time" % "joda-time" % "2.9.9",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.5.3",
    libraryDependencies += "org.json4s" %% "json4s-ext" % "3.5.3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "org.scalatra" %% "scalatra" % "2.6.2",
    libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210",
    libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"



  )
enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)