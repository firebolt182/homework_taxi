package org.javaacademy.project.taxi;

import org.javaacademy.project.car.Car;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("luna")
public class LunaTaxi extends TaxiPark {

    public LunaTaxi(List<Car> cars) {
        super(cars);
    }
}
