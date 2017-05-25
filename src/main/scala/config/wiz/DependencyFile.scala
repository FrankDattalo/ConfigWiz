package config.wiz

import java.io.File

import org.json.JSONObject

case class DependencyFile(val task : Dependency, val dependencies: Array[Dependency]) {
}

object DependencyFile {
  def fromJSON(json: JSONObject): DependencyFile = {
    val dep = Dependency fromJSON json

    val jsonArray = json getJSONArray "dependencies"

    val length = jsonArray length

    val array = new Array[Dependency](length)

    for(i <- 0 until length) {
      array(i) = Dependency fromJSON ( jsonArray getJSONObject i )
    }

    new DependencyFile(dep, array)
  }

  def apply(file: File) : DependencyFile = {
    DependencyFile fromJSON (JSONReader readFile file)
  }
}