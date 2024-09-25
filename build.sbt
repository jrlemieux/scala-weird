name := "weird"
scalaVersion := "3.5.0"
organization := "com.playzone"

javacOptions ++= Seq("-source", "17", "-target", "17", "-Xlint")
scalacOptions ++= Seq("-feature", "-deprecation:true", "-unchecked", "-release:17", "-Wunused:imports")
semanticdbEnabled := true

updateSbtClassifiers / updateConfiguration := (updateSbtClassifiers / updateConfiguration).value.withMissingOk(true)

Compile / packageDoc / publishArtifact := false
Compile / packageSrc / publishArtifact := false

resolvers ++= Seq(
  Resolver.typesafeRepo("releases")
)

assembly / test := {}

assembly / assemblyJarName := "weird.jar"

assembly / mainClass := Some("com.playzone.Main")

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}
