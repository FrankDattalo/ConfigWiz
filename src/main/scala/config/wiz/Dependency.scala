package config.wiz

import org.json.JSONObject

case class Dependency(val name : String, val version : Int) {

  var fileFetcher : FileFetcher = null

  def url : String = s"${name}@${version}"
}

object Dependency {
  def fromJSON(json: JSONObject): Dependency = {
    val name = json getString "name"
    val version = json getInt "version"
    Dependency(name, version)
  }
}