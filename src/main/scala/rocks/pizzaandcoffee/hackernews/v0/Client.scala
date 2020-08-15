package rocks.pizzaandcoffee.hackernews.v0; 

import scalaj.http._
import org.json4s._
import org.json4s.native.JsonMethods.parse
import rocks.pizzaandcoffee.hackernews.Client
import rocks.pizzaandcoffee.hackernews.Item


object V0Client extends Client {
  val url = "https://hacker-news.firebaseio.com/"

  implicit val formats = DefaultFormats // Brings in default date formats etc.
  def getItem(id: Int): Item = {
    val itemUrl = s"$url/v0/item/$id.json";
    val response: HttpResponse[String] = Http(itemUrl).asString
    val item = parse(response.body).extract[V0Item]
    item
  }
}

