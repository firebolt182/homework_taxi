package org.javaacademy.taxi;

import lombok.ToString;
import org.javaacademy.Car;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Profile("luna")
public class LunaTaxi extends TaxiPark {

    public LunaTaxi(List<Car> cars) {
        super(cars);
    }
}
