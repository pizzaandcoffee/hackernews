package rocks.pizzaandcoffee.hackernews.java;

import rocks.pizzaandcoffee.hackernews.Client;
import rocks.pizzaandcoffee.hackernews.ClientFactory;
import rocks.pizzaandcoffee.hackernews.v0.V0Client;

class V0ClientFactory extends ClientFactory {
  def build(): Client = {
    V0Client
  }
}


