package config.wiz

object App {
  def main(args: Array[String]): Unit = {
    val home =  System getenv "CONFIG_WIZ_HOME"

    Logger.log(s"Home location: $home")

    Logger.log(s"Resolving: ${args(0)}dependency.json")

    val gs = new GraphSerializer(new FileFetcher(args(0)), new FileFetcher(home))

    Logger.log(s"Serializing graph")

    val tasks = gs.serialize

    Logger.log(s"Serializing done")

    Logger.log(s"Writing output to: ${args(0)}output/")

    OutputWriter write (args(0) + "output/", tasks)

    Logger.log("Done!")

  }
}
