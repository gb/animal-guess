name := "Animal Guess"

version := "1.0"

organization := "com.gabrielsuch"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test->default",
  "org.scala-lang" % "scala-swing" % "2.8.1"
)

