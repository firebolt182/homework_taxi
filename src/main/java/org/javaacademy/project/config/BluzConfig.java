package org.javaacademy.project.config;

import org.javaacademy.project.car.Car;
import org.javaacademy.project.taxi.BluzTaxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("bluz")
public class BluzConfig {

    @Bean
    public Car bluz1Car() {
        return new Car("bluz1");
    }

    @Bean
    public Car bluz2Car() {
        return new Car("bluz2");
    }

    @Bean
    public BluzTaxi bluzTaxiCreate(List<Car> cars) {
        return new BluzTaxi(cars);
    }

}
