package org.javaacademy.config;

import org.javaacademy.Car;
import org.javaacademy.taxi.BluzTaxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    public BluzTaxi bluzTaxiCreate() {
        return new BluzTaxi(Arrays.asList(bluz1Car(), bluz2Car()));
    }

}
