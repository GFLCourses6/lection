package pattern.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.dto.dto.CarDTO;
import pattern.dto.entity.Car;
import pattern.dto.mapper.CarMapper;

public class DtoApp {

  private static final Logger LOGGER = LogManager.getLogger(DtoApp.class.getName());

  public static void main(String[] args) {
    DtoApp appDto = new DtoApp();
    appDto.run();
  }

  private void run() {
    Car car = new Car(1, "CarName", 2023, "Red", "CarModel");
    LOGGER.info(car);

    //  Car to CarDTO
    CarDTO carDtoFromCar = CarMapper.carToCarDTO(car);
    LOGGER.info(carDtoFromCar);

    CarDTO carDto = new CarDTO("CarDtoName", 2022, "Blue", "CarDtoModel");
    LOGGER.info(carDto);

    // CarDTO to Car
    Car carFromCarDto = CarMapper.carDTOToCar(carDto);
    LOGGER.info(carFromCarDto);
  }
}

