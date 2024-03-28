package org.javaacademy.taxi;

import org.javaacademy.Car;
import org.springframework.context.annotation.Profile;;
import java.util.List;

@Profile("bluz")
public class BluzTaxi extends TaxiPark {

    public BluzTaxi(List<Car> cars) {
        super(cars);
    }
}
