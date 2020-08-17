import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._
import rocks.pizzaandcoffee.hackernews.v0._

class V0Spec extends AnyFlatSpec {
  "V0Client.getStory" should "fetch a story" in {
    V0Client.getStory(21672481) match {
      case Some(v) =>
        assert(v.id == 21672481)
      
      case None => 
        assert(false)
    }
  }
}
