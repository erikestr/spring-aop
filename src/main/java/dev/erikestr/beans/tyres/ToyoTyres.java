package dev.erikestr.beans.tyres;

import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Tyres;

@Component(value = "toyo")
public class ToyoTyres implements Tyres {

    private final String brand = "Toyo";

    private final String model = "Toyo-2000";

    private int durability = 99;

    public ToyoTyres() {
        System.out.println("ToyoTyres constructor called");
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public void rotate() {
        System.out.println("\u001B[35mToyo tyres are rotating\u001B[0m");
    }

    @Override
    public String stopRotation() {
        String message = "\u001B[35mToyo tyres have stopped\u001B[0m";
        System.out.println(message);
        return message;
    }

}
