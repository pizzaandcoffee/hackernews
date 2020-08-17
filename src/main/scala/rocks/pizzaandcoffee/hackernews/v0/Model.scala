package rocks.pizzaandcoffee.hackernews.v0;

import org.json4s.FieldSerializer
import org.json4s.FieldSerializer._
import rocks.pizzaandcoffee.hackernews.Item; 
import rocks.pizzaandcoffee.hackernews.Story; 
import rocks.pizzaandcoffee.hackernews.Comment; 

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
  score: Option[Int],
  title: Option[String],
  parts: List[String],
  descendants: Option[Int]
) {
  def toStory() = {
    new V0Story(
      id,
      by,
      time,
      kids,
      parent,
      dead.getOrElse(false),
      deleted.getOrElse(false),
      title.getOrElse(""),
      url.getOrElse(""),
      score.getOrElse(0)
    )
  }

  def toComment() = {
    new V0Comment(
      id, 
      by, 
      time, 
      kids, 
      parent, 
      dead.getOrElse(false),
      deleted.getOrElse(false),
      text.getOrElse("")
    )
  }

} 

case class V0Story (
  // item
  id: Int,
  by: String,
  time: Int,
  kids: List[Int],
  parent: Option[Int],
  dead: Boolean,
  deleted: Boolean,
  // story 
  title: String,
  url: String,
  score: Int
) extends Story

case class V0Comment (
  // item
  id: Int,
  by: String,
  time: Int,
  kids: List[Int],
  parent: Option[Int],
  dead: Boolean,
  deleted: Boolean,
  // story 
  text: String
) extends Comment 
