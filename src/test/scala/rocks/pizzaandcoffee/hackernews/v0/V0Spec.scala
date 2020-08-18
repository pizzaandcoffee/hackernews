package rocks.pizzaandcoffee.hackernews.v0;

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._
import org.scalatestplus.junit.JUnitRunner
import org.junit.runner.RunWith
import rocks.pizzaandcoffee.hackernews.v0._

@RunWith(classOf[JUnitRunner])
class V0Spec extends AnyFlatSpec {
  "V0Client" should "fetch a story" in {
    V0Client.getStory(21672481) match {
      case Some(v) =>
        assert(v.id == 21672481)
      
      case None => 
        assert(false)
    }
  }

  it should "fetch a comment" in {
    val comment = V0Client.getComment(22524321).get
    assert(comment.id == 22524321) 
  }

  "V0Story" should "fetch kids" in {
    val story = V0Client.getStory(1).get
    val children = story.kids
    assert(children.length >= 7)
    assert(children.head.id == 15)
  }

  "V0Comment" should "fetch kids" in {
    val comment = V0Client.getComment(17).get
    val children = comment.kids
    assert(children.length >= 1)
    assert(children.head.id == 1079)
  }

  "V0Comment" should "fetch parent" in {
    val comment = V0Client.getComment(1079).get
    val parent = comment.parent.get
    assert(parent.id == 17)
  }

}
