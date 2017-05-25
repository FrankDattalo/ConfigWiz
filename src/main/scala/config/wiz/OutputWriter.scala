package config.wiz

import java.io.{File, IOException}

import org.apache.commons.io.FileUtils

import scala.collection.mutable.ArrayBuffer

object OutputWriter {
  def write(outputLocation: String, tasks: ArrayBuffer[Dependency]): Unit = {
    val file = new File(outputLocation)

    if(file.exists) {
      Logger.log(s"Removing contents of directory ${file.getAbsolutePath}")
      FileUtils.cleanDirectory(file)

    } else if (!file.mkdir) {
      throw new IOException(s"Could not create directory: ${file.getAbsolutePath}")
    }

    tasks.remove(tasks.length - 1)

    var i = 1
    tasks foreach { task =>
      val from = new File(task.fileFetcher.baseUrl)
      val to = new File(outputLocation + s"[$i]-${task.url}")

      Logger.log(s"Creating directory ${to.getAbsolutePath}")

      if(!to.mkdir) {
        throw new IOException(s"Could not create directory ${to.getAbsolutePath}")
      }

      Logger.log(s"Copying ${from.getAbsolutePath} to ${to.getAbsolutePath}")

      FileUtils.copyDirectory(from, to)

      i += 1
    }
  }
}
