package config.wiz

import java.text.SimpleDateFormat
import java.util.Date

object Logger {

  private val df = new SimpleDateFormat("HH:mm:ss")

  def log(message: String): Unit = {
    println(s"[${df.format(new Date())}] - ${message}")
  }
}
