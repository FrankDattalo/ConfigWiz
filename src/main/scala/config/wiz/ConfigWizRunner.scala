package config.wiz

object ConfigWizRunner {
  def apply(dependencyLocation: String): Unit = {
    val home =  System getenv "CONFIG_WIZ_HOME"

    Logger.log(s"Home location: $home")

    Logger.log(s"Resolving: ${dependencyLocation}dependency.json")

    val gs = new GraphSerializer(new FileFetcher(dependencyLocation), new FileFetcher(home))

    Logger.log(s"Serializing graph")

    val tasks = gs.serialize

    Logger.log(s"Serializing done")

    Logger.log(s"Writing output to: ${dependencyLocation}output/")

    OutputWriter write (dependencyLocation + "output/", tasks)

    Logger.log("Done!")
  }
}
