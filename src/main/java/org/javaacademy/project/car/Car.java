package org.javaacademy.project.car;

import lombok.Getter;
import org.javaacademy.project.client.Client;
import org.javaacademy.project.exception.IncorrectAddressException;
import org.javaacademy.project.tariff.DistanceGuide;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.util.Arrays;

@Getter
public class Car {
    @Value("${car.night}")
    private int nightBid;
    @Value("${car.day}")
    private int dayBid;
    private String carNumber;
    private BigDecimal incomeMoney = BigDecimal.ZERO;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal takeOrder(Client client, boolean isDay) throws IncorrectAddressException {
        if (!checkUnknownAddress(client)) {
            BigDecimal income = isDay ? tripIncome(client, dayBid) : tripIncome(client, nightBid);
            incomeMoney = incomeMoney.add(income);
            return income;
        }
        return BigDecimal.ZERO;
    }

    //Проверяем адрес на некорректность
    private boolean checkUnknownAddress(Client client) throws IncorrectAddressException {
        if (Arrays.stream(DistanceGuide.values())
                .noneMatch(address -> address.getName().equals(client.getAddress()))) {
            throw new IncorrectAddressException("Такого адреса не существует");
        }
        return false;
    }

    private BigDecimal tripIncome(Client client, int bid) {
        DistanceGuide distanceGuide = Arrays.stream(DistanceGuide.values())
                .filter(address -> address.getName().equals(client.getAddress()))
                .findFirst().orElseThrow();
        return BigDecimal.valueOf((distanceGuide.getDistance() * bid) * 0.5);
    }
}
