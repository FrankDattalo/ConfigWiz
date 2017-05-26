package config.wiz

import java.io.{File, IOException}

import org.apache.commons.io.FileUtils

import scala.collection.mutable.ArrayBuffer

object OutputWriter {
  def write(outputLocation: String, tasks: ArrayBuffer[Dependency]): Unit = {
    val file = new File(outputLocation)

    cleanDirectory(file)

    tasks.remove(tasks.length - 1)

    var i = 1
    
    tasks foreach { task =>
      val from = new File(task.fileFetcher.baseUrl)
      val to = new File(outputLocation + s"[$i]-${task.url}")

      cleanDirectory(to)

      Logger.log(s"Copying ${from.getAbsolutePath} to ${to.getAbsolutePath}")

      FileUtils.copyDirectory(from, to)

      i += 1
    }
  }
  
  def cleanDirectory(f: File) {
     if(f.exists) {
      Logger.log(s"Removing contents of directory ${f.getAbsolutePath}")
      FileUtils.cleanDirectory(f)
    } else {
      Logger.log(s"Creating directory ${f.getAbsolutePath}")       
      if (!file.mkdir) {
        throw new IOException(s"Could not create directory: ${file.getAbsolutePath}")
      }
    }
  }
}
