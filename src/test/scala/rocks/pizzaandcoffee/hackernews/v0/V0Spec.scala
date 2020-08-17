import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._
import rocks.pizzaandcoffee.hackernews.v0._

class V0Spec extends AnyFlatSpec {
  "V0Client" should "fetch a story" in {
    V0Client.getStory(21672481) match {
      case Some(v) =>
        assert(v.id == 21672481)
      
      case None => 
        assert(false)
    }
  }

  "V0Client" should "fetch a comment" in {
    val comment = V0Client.getComment(22524321).get
    assert(comment.id == 22524321) 
  }
}
