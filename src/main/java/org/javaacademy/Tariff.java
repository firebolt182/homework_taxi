package org.javaacademy;

import lombok.Getter;

@Getter
public enum Tariff {
    BEREZOVAYA_ROCHA("Березовая Роща", 10),
    KANDIKULYA("Кандикюля", 4),
    STROITEL("Строитель", 12);

    private String name;
    private int distance;

    Tariff(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
