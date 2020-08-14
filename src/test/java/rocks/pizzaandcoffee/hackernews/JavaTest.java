package rocks.pizzaandcoffee.hackernews;

import static org.junit.Assert.*;
import org.junit.Test;

import rocks.pizzaandcoffee.hackernews.Client;
import rocks.pizzaandcoffee.hackernews.java.V0ClientFactory;


public class JavaTest {
 
    @Test
    public void create() {
        HackerNews hn = new HackerNews();
    }

    @Test
    public void createWithClient() {
        Client client = (new V0ClientFactory()).build();
        HackerNews hn = new HackerNews(client);
    }

}
