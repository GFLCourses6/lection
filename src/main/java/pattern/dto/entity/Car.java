package pattern.dto.entity;



public class Car {
  private long id;
  private String name;
  private int year;
  private String color;
  private String model;

  public Car() {

  }

  public Car(long id, String name, int year, String color, String model) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.color = color;
    this.model = model;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", year=" + year +
        ", color='" + color + '\'' +
        ", model='" + model + '\'' +
        '}';
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
