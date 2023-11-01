package pattern.dto.dto;


public class CarDTO {
  private String name;
  private int year;
  private String color;
  private String model;

  public CarDTO() {
  }

  public CarDTO(String name, int year, String color, String model) {
    this.name = name;
    this.year = year;
    this.color = color;
    this.model = model;
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
