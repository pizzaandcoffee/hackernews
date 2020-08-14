package rocks.pizzaandcoffee.hackernews.v0; 

import scalaj.http._
import org.json4s._
import org.json4s.native.JsonMethods._
import rocks.pizzaandcoffee.hackernews.Client; 

object V0Client extends Client {
  val url = "https://hacker-news.firebaseio.com/"

  def getItem(id: Int) = {
    val itemUrl = s"$url/v0/item/$id.json";
    val response: HttpResponse[String] = Http(itemUrl).asString
    println(response)
  }
}

