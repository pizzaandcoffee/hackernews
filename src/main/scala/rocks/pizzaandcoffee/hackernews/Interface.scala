package rocks.pizzaandcoffee.hackernews;

trait Client {
  def getItem(id: Int)
}

object ItemType extends Enumeration {
  type ItemType = Value
  val Job = Value("job")
  val Story = Value("story")
  val Comment = Value("comment")
  val Poll = Value("poll")
  val Pollopt = Value("pollopt")
}

trait Item {
  def id: Int
  def by: String
  def score: Int
  def time: Int
  def kids: List[Int]
  def parent: Option[Int]
  def dead: Boolean
  def deleted: Boolean
}

trait Story {
  def title: String
}
