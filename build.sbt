name := "config-wiz"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.jgrapht" % "jgrapht-core" % "1.0.1"

libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"

libraryDependencies += "org.json" % "json" % "20160810"

mainClass in (Compile, run) := Some("config.wiz.App")