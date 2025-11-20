package dev.erikestr.interfaces;

public interface Tyres extends Product {

    int getDurability();

    void setDurability(int durability);

    String rotate();

    String stopRotation();

}
