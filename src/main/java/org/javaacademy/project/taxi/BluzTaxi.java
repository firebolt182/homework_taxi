package org.javaacademy.project.taxi;

import org.javaacademy.project.car.Car;
import org.springframework.context.annotation.Profile;;
import java.util.List;

@Profile("bluz")
public class BluzTaxi extends TaxiPark {

    public BluzTaxi(List<Car> cars) {
        super(cars);
    }
}
