package org.javaacademy;

import org.javaacademy.project.client.Client;
import org.javaacademy.project.taxi.TaxiPark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Runner.class, args);
        TaxiPark taxiPark = context.getBean(TaxiPark.class);
        Client client1 = new Client("Кандикюля");
        Client client4 = new Client("Строитель");
        Client client3 = new Client("Березовая Роща");
        Client client2 = new Client("Ломоносов");
        taxiPark.takeOrder(client1, true);
        taxiPark.takeOrder(client2, true);
        taxiPark.takeOrder(client3, false);
        taxiPark.takeOrder(client4, true);
        context.close();
    }
}