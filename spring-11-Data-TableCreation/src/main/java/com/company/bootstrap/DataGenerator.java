package com.company.bootstrap;

import com.company.entity.Car;
import com.company.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {


    private final CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW", "320");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Corolla");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
