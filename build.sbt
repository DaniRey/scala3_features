val dottyVersion = "0.27.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-features",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Yexplicit-nulls",
  "-deprecation",
  "-unchecked"
)
