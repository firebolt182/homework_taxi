package org.javaacademy.config;

import org.javaacademy.Car;
import org.javaacademy.taxi.LunaTaxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
