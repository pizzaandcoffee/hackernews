package rocks.pizzaandcoffee.hackernews;

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
  def time: Int
  def kids: List[Item]
  def parent: Option[Item]
  def dead: Boolean
  def deleted: Boolean
}

trait Story extends Item {
  def title: String
  def url: String
  def score: Int
}

trait Comment extends Item {
  def text: String
}

trait Client {
  def getStory(id: Int): Option[Story]
  def getComment(id: Int): Option[Comment]
}

trait ClientFactory {
  def build(): Client
}

