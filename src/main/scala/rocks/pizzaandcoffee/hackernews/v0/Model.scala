package rocks.pizzaandcoffee.hackernews.v0;

import rocks.pizzaandcoffee.hackernews.Item; 

case class V0Item(
  id: Int,
  by: String,
  score: Int,
  time: Int,
  kids: List[Int],
  parent: Option[Int],
  url: Option[String],
  title: String,
  dead: Boolean,
  deleted: Boolean
) extends Item 

