package org.javaacademy.project.config;

import org.javaacademy.project.car.Car;
import org.javaacademy.project.taxi.LunaTaxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("luna")
public class LunaConfig {

    @Bean
    public Car luna1Car() {
        return new Car("luna1");
    }

    @Bean
    public Car luna2Car() {
        return new Car("luna2");
    }

    @Bean
    public Car luna3Car() {
        return new Car("luna3");
    }

    @Bean
    public LunaTaxi lunaTaxiCreate() {
        return new LunaTaxi(Arrays.asList(luna1Car(), luna2Car(), luna3Car()));
    }

}
