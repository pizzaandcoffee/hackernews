package rocks.pizzaandcoffee.hackernews; 

import rocks.pizzaandcoffee.hackernews.v0.V0Client; 

class HackerNews(client: Client = V0Client) {
  def this() = this(V0Client)

  def getItem(id: Int) = {
    this.client.getItem(id)
  }
}
