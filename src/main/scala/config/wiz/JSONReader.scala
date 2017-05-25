package config.wiz

import java.io.File

import org.apache.commons.io.FileUtils
import org.json.JSONObject

object JSONReader {
  def readFile(f : File) : JSONObject = {

    val sb = new StringBuilder("")

    FileUtils readLines f forEach (line => sb append line)

    new JSONObject(sb.toString)
  }
}
