package org.javaacademy.project.tariff;

import lombok.Getter;

@Getter
public enum DistanceGuide {
    BEREZOVAYA_ROCHA("Березовая Роща", 10),
    KANDIKULYA("Кандикюля", 4),
    STROITEL("Строитель", 12);

    private String name;
    private int distance;

    DistanceGuide(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
