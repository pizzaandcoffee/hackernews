package rocks.pizzaandcoffee.hackernews;

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions.assert
import org.scalatestplus.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class HackerNewsSpec extends AnyFlatSpec {
  "HackerNews" should "fetch a story" in {
    val hn = new HackerNews()
    val story = hn.getStory(21672481).get
    assert(story.id == 21672481) 
  }

  it should "fetch a comment" in {
    val hn = new HackerNews()
    val comment = hn.getComment(22524321).get
    assert(comment.id == 22524321) 
  }

}
