import org.scalatest._
import rocks.pizzaandcoffee.hackernews.HackerNews

class HackerNewsSpec extends FlatSpec {
  "things" should "work" in {
    val hn = new HackerNews()
    hn.getItem(42)
  }
}
