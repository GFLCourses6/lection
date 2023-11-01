package pattern.dto.mapper;


import pattern.dto.dto.CarDTO;
import pattern.dto.entity.Car;

public class CarMapper {

  public static CarDTO carToCarDTO(Car car) {
    CarDTO carDTO = new CarDTO();
    carDTO.setName(car.getName());
    carDTO.setYear(car.getYear());
    carDTO.setColor(car.getColor());
    carDTO.setModel(car.getModel());
    return carDTO;
  }

  public static Car carDTOToCar(CarDTO carDTO) {
    Car car = new Car();
    car.setName(carDTO.getName());
    car.setYear(carDTO.getYear());
    car.setColor(carDTO.getColor());
    car.setModel(carDTO.getModel());
    return car;
  }
}

