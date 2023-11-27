package org.example.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class CarTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void test() {
        Car car = new Car();
        assertNotNull(car);
        assertNull(car.getColor());
        assertNull(car.getGps());
    }

    @Test
    public void test2() {
        Car car = new Car();
        car.setBrand("Test");
        car.setModel("Test");
        car.setColor("Test");
        car.setPrice(1L);
        car.setYear(1);
        car.setGps("Test");
        car.setHasClimateControl(false);
        car.setEngineType("Test");
        car.setFuelType("Test");
        Car car2 = new Car("Test", "Test", "Test", 1L, 1, "Test", false, "Test", "Test");
        assertEquals(car, car2);
    }
    // test for getters/setters, equals() and hashcode()
}
// когда мы тестируем определенную бизнес логику - mockать нужно дополнительную бизнес логику
// что используется в основной(откуда берутся данные с бд, другой сервис и тд)
// то есть нам нужны данные для коректного тестирования конкретно этой бизнес логики, то мы мокаем оте
// сервисы те что внутри
// и когда будем тестировать, через мок возвращаем тот результат, который нам нужен