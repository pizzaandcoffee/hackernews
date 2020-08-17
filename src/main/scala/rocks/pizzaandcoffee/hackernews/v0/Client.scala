package rocks.pizzaandcoffee.hackernews.v0; 

import scalaj.http._
import org.json4s._
import org.json4s.native.JsonMethods.parse
import rocks.pizzaandcoffee.hackernews.Client
import rocks.pizzaandcoffee.hackernews.{Story, Comment}


object V0Client extends Client {
  val url = "https://hacker-news.firebaseio.com/"

  implicit val formats = DefaultFormats
  private def getItem(id: Int): V0Item = {
    val itemUrl = s"$url/v0/item/$id.json";
    val response: HttpResponse[String] = Http(itemUrl).asString
    val item = parse(response.body).extract[V0Item]
    item
  }

  def getStory(id: Int): Option[Story] = {
    val item = this.getItem(id) 
    item.`type` match {
      case "story" =>
        Some(item.toStory())
    }
  }

  def getComment(id: Int): Option[Comment] = {
    val item = this.getItem(id) 
    item.`type` match {
      case "comment" =>
        Some(item.toComment())
    }
  }
}

