package org.javaacademy;

import lombok.Getter;

@Getter
public class Client {
    private String address;

    public Client(String address) {
        this.address = address;
    }
}
