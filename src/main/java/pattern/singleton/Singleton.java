package pattern.singleton;

public class Singleton {
  private String value;

  private static Singleton instance = new Singleton("Initial");

  private Singleton(String value) {
    this.value = value;
  }

  public static Singleton getInstance(String value) {
    if (value != null) {
      instance.value = value;
    } else {
      instance.value = null;
    }
    return instance;
  }

  public String getValue() {
    return value;
  }
}
