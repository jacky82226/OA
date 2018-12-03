name := "OA"

version := "0.1"

scalaVersion := "2.12.7"


// For encoding and decoding
val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
)
// For test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"