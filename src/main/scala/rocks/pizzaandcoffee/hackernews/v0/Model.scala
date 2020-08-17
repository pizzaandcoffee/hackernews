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
  kidIds: List[Int],
  parentId: Option[Int],
  dead: Boolean,
  deleted: Boolean,
  // story 
  title: String,
  url: String,
  score: Int
) extends Story {
  private var kidObjects: Option[List[Item]] = None

  def kids: List[Item] = {
    this.kidObjects match {
      case Some(x) => 
        x
      case None =>
        val children = this.kidIds.map(
          x => V0Client.getComment(x)
        ).filter(x => x.nonEmpty).map(x => x.get)
        this.kidObjects = Some(children)
        children
    }
  }

  // Stories never have a parent
  def parent: Option[Item] = None
}

case class V0Comment (
  // item
  id: Int,
  by: String,
  time: Int,
  kidIds: List[Int],
  parentId: Option[Int],
  dead: Boolean,
  deleted: Boolean,
  // story 
  text: String
) extends Comment {
  private var kidObjects: Option[List[Item]] = None
  private var parentObject: Option[Option[Item]] = None

  def kids: List[Item] = {
    this.kidObjects match {
      case Some(x) => 
        x
      case None =>
        val children = this.kidIds.map(
          x => V0Client.getComment(x)
        ).filter(x => x.nonEmpty).map(x => x.get)
        this.kidObjects = Some(children)
        children
    }
  }
  
  def parent: Option[Item] = {
    this.parentObject match {
      case Some(x) =>
        x
      case None =>
        val parentObj: Option[Comment] = this.parentId match {
          case None =>
            None
          case Some(y) => {
            V0Client.getComment(y)
          }
        }
        this.parentObject = Some(parentObj)
        parentObj
    }
  }

}
