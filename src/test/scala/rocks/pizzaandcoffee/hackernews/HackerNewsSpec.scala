import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions.assert
import rocks.pizzaandcoffee.hackernews.HackerNews

class HackerNewsSpec extends AnyFlatSpec {
  "things" should "work" in {
    val hn = new HackerNews()
    val story = hn.getStory(21672481).get
    assert(story.id == 21672481) 
  }
}
