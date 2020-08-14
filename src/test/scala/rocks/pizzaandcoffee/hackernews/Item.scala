import org.scalatest._
import rocks.pizzaandcoffee.hackernews.Foo

class ItemSuite extends FlatSpec {
  "things" should "work" in {
    assert(Foo.message == "hello world")
  }
}
