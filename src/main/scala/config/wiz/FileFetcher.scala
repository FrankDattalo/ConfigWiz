package config.wiz

import java.io.{File, FileNotFoundException}

class FileFetcher(val baseUrl: String) {
  def fetch (url : String) : File = {

    val fullUrl = baseUrl + url

    Logger.log(s"Fetching $fullUrl")

    val f = new File(fullUrl)

    if(!f.exists) throw new FileNotFoundException(s"${f.getName} does not exist")

    f
  }
}
