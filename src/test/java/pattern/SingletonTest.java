package pattern;

import org.junit.jupiter.api.Test;
import pattern.singleton.Singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SingletonTest {

  @Test
  public void testGetInstance() {
    Singleton singleton = Singleton.getInstance("Hello, Singleton!");
    assertEquals("Hello, Singleton!", singleton.getValue());
  }

  @Test
  public void testGetInstanceWithNullValue() {
    Singleton singleton = Singleton.getInstance(null);
    assertNull(singleton.getValue());
  }

  @Test
  public void testGetInstanceMultipleTimes() {
    Singleton firstInstance = Singleton.getInstance("Hello, Singleton!");
    Singleton secondInstance = Singleton.getInstance("Another Value");

    assertSame(firstInstance, secondInstance);
  }
}
