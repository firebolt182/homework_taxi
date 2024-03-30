package org.javaacademy.project.taxi;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.javaacademy.project.car.Car;
import org.javaacademy.project.client.Client;
import org.javaacademy.project.exception.IncorrectAddressException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.util.*;

@Component
@Getter
public abstract class TaxiPark {
    @Value("${taxiPark.name}")
    private String name;
    private BigDecimal allIncomeMoney = BigDecimal.ZERO;
    private List<Car> cars;

    public TaxiPark(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void takeOrder(Client client, boolean isDay) {
        Car car = cars.remove(0);
        try {
            BigDecimal parkIncome = car.takeOrder(client, isDay);
            allIncomeMoney = allIncomeMoney.add(parkIncome);
        } catch (IncorrectAddressException exception) {
            //Ничего не делаем в случае ввода некорректного адреса
        }
        finally {
            cars.add(car);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.printf(name);
        System.out.println("Заработано : " + allIncomeMoney);
        for (Car car : cars) {
            System.out.println("Водитель машины " + car.getCarNumber()
                    + " заработал: " + car.getIncomeMoney());
        }
    }
}
