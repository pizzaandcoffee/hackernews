import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions.assert
import rocks.pizzaandcoffee.hackernews.HackerNews

class HackerNewsSpec extends AnyFlatSpec {
  "things" should "work" in {
    val hn = new HackerNews()
    hn.getItem(42)
  }
}
