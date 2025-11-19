package dev.erikestr.beans.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Vehicle;

@Component
@Lazy
public class Person {

    private String name = "Customer";

    private final Vehicle vehicle;

    @Autowired
    @Lazy
    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("\u001B[32mPerson constructor called\u001B[0m");
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {name='" + name + "', vehicle=" + vehicle + "}";
    }
}