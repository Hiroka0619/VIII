import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "AnkiApp"
  val appVersion      = "0.1"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.github.seratch" %% "scalikejdbc"  % "[1.6,)",
    "com.github.seratch" %% "scalikejdbc-interpolation" % "[1.6,)",
    "org.slf4j" % "slf4j-simple" % "[1.7,)",
    "mysql" % "mysql-connector-java" % "5.1.26"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
