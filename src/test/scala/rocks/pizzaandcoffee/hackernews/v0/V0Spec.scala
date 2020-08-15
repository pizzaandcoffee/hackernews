import org.scalatest.flatspec.AnyFlatSpec
import rocks.pizzaandcoffee.hackernews.v0._

class V0Spec extends AnyFlatSpec {
  "things" should "work" in {
    V0Client.getItem(42)
  }
}
