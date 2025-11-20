package dev.erikestr.beans.tyres;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Tyres;

@Component(value = "bridgestone")
@Primary
public class BridgeStoneTyres implements Tyres {

    private final String brand = "BridgeStone";

    private final String model = "BS-1000";

    private int durability = 100;

    public BridgeStoneTyres() {
        System.out.println("BridgeStoneTyres constructor called");
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
        System.out.println("\u001B[35mBridgeStone tyres are rotating\u001B[0m");
    }

    @Override
    public String stopRotation() {
        String message = "\u001B[35mBridgeStone tyres have stopped\u001B[0m";
        return message;
    }
}
