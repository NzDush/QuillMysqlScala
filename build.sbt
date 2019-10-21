name := "QuillMysqlScala"

version := "0.1"

//scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "io.getquill" %% "quill-async-mysql" % "3.4.10",
  "mysql" % "mysql-connector-java" % "8.0.17",
//  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.1" % Test
)
