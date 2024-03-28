package org.javaacademy.project.car;

import lombok.Getter;
import org.javaacademy.project.client.Client;
import org.javaacademy.project.exception.IncorrectAddressException;
import org.javaacademy.project.tariff.Tariff;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.util.Arrays;

@Getter
public class Car {
    @Value("${car.nightBid}")
    private int nightBid;
    @Value("${car.dayBid}")
    private int dayBid;
    private String carNumber;
    private BigDecimal incomeMoney = BigDecimal.ZERO;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal takeOrder(Client client, boolean isDay) throws IncorrectAddressException {
        if (!checkUnknownAddress(client)) {
            BigDecimal income;
            if (isDay) {
                income = tripIncome(client, dayBid);
            } else {
                income = tripIncome(client, nightBid);
            }
            incomeMoney = incomeMoney.add(income);
            return income;
        }
        return BigDecimal.ZERO;
    }

    //Проверяем адрес на некорректность
    private boolean checkUnknownAddress(Client client) throws IncorrectAddressException {
        if (Arrays.stream(Tariff.values())
                .noneMatch(address -> address.getName().equals(client.getAddress()))) {
            throw new IncorrectAddressException("Такого адреса не существует");
        }
        return false;
    }

    private BigDecimal tripIncome(Client client, int bid) {
        Tariff tariff = Arrays.stream(Tariff.values())
                .filter(address -> address.getName().equals(client.getAddress()))
                .findFirst().orElseThrow();
        return BigDecimal.valueOf((tariff.getDistance() * bid) * 0.5);
    }
}
