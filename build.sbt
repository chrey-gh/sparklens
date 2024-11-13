import sbt._

name := "sparklens"
organization := "com.qubole"

scalaVersion := "2.12.17"
version := "0.5.0"

// Define the custom keys
val spName = settingKey[String]("The name of the Spark application")
val sparkVersion = settingKey[String]("The Version of the Spark Runtime")
val spAppendScalaVersion = settingKey[Boolean]("Flag to append Scala version")

// Assign values to the custom keys
spName := "qubole/sparklens"
sparkVersion := "3.0.0"
spAppendScalaVersion := true

// Set the name of the output assembly
assemblyJarName in assembly := s"${name.value}-${version.value}-scala-${scalaVersion.value}.jar"


libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion.value % "provided"

libraryDependencies +=  "org.apache.hadoop" % "hadoop-client" % "2.6.5" % "provided"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.6" % "provided"

libraryDependencies += "org.apache.httpcomponents" % "httpmime" % "4.5.6" % "provided"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"


test in assembly := {}

testOptions in Test += Tests.Argument("-oF")

scalacOptions ++= Seq("-target:jvm-11")
javacOptions ++= Seq("-source", "11", "-target", "11")

publishMavenStyle := true


licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")


pomExtra :=
  <url>https://github.com/qubole/sparklens</url>
  <scm>
    <url>git@github.com:qubole/sparklens.git</url>
    <connection>scm:git:git@github.com:qubole/sparklens.git</connection>
  </scm>
  <developers>
    <developer>
      <id>iamrohit</id>
      <name>Rohit Karlupia</name>
      <url>https://github.com/iamrohit</url>
    </developer>
    <developer>
      <id>beriaanirudh</id>
      <name>Anirudh Beria</name>
      <url>https://github.com/beriaanirudh</url>
    </developer>
    <developer>
      <id>mayurdb</id>
      <name>Mayur Bhosale</name>
      <url>https://github.com/mayurdb</url>
    </developer>
  </developers>

