import org.scalatest._
import rocks.pizzaandcoffee.hackernews.v0._

class V0Spec extends FlatSpec {
  "things" should "work" in {
    V0Client.getItem(42)
  }
}
