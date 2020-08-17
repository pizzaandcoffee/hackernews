package rocks.pizzaandcoffee.hackernews.v0;

import org.json4s.FieldSerializer
import org.json4s.FieldSerializer._
import rocks.pizzaandcoffee.hackernews.Item; 
import rocks.pizzaandcoffee.hackernews.Story; 

case class V0Item(
  id: Int,
  deleted: Option[Boolean],
  `type`: String,
  by: String,
  time: Int,
  text: Option[String],
  dead: Option[Boolean],
  parent: Option[Int],
  kids: List[Int],
  url: Option[String],
  score: Int,
  title: Option[String],
  parts: List[String],
  descendants: Option[Int]
) {
  def toStory() = {
    new V0Story(
      id, 
      by, 
      score, 
      time, 
      kids, 
      parent, 
      dead.getOrElse(false), 
      deleted.getOrElse(false), 
      title.getOrElse(""), 
      url.getOrElse("")
    )
  }
} 

case class V0Story (
  // item
  id: Int,
  by: String,
  score: Int,
  time: Int,
  kids: List[Int],
  parent: Option[Int],
  dead: Boolean,
  deleted: Boolean,
  // story 
  title: String,
  url: String
) extends Story
