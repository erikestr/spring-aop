package dev.erikestr.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Speakers;
import dev.erikestr.interfaces.Tyres;
import dev.erikestr.interfaces.Vehicle;
import dev.erikestr.model.Song;
import dev.erikestr.services.VehicleService;

@Component(value = "honda")
public class VehicleHonda implements Vehicle {

    private final String brand = "Honda";

    private final String model = "e:HEV Z";

    private VehicleService vehicleService;

    public VehicleHonda() {
        System.out.println("Honda constructor called");
    }

    @Autowired
    public VehicleHonda(VehicleService vehicleService) {
        System.out.println("Honda constructor called");
        this.vehicleService = vehicleService;
    }

    @Override
    public void performVehicleTestFunctions() {
        System.out.println("----------- \u001B[32m Testing of Honda started  \u001B[0m -----------");

        boolean vehicleStarted = false;

        // Testing Sound System
        Song currentSong = systemSound();
        String music = vehicleService.playMusic(vehicleStarted, currentSong);
        System.out.println("\u001B[35mMusic playing: " + music + "\u001B[0m");

        // Testing Movement
        String movementMessage = vehicleService.moveVehicle(vehicleStarted);
        System.out.println("\u001B[35mVehicle moved: " + movementMessage + "\u001B[0m");

        // Testing Brake
        String brakeMessage = vehicleService.applyBrake(vehicleStarted);
        System.out.println("\u001B[35mBrake message: " + brakeMessage + "\u001B[0m");

        System.out.println("----------- \u001B[32m Testing of Honda finished \u001B[0m -----------");
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
    public Tyres getTyres() {
        return vehicleService.getTyres();
    }

    @Override
    public Speakers getSpeakers() {
        return vehicleService.getSpeakers();
    }

    @Override
    public String toString() {
        return "Honda Data {brand='" + brand + "', model='" + model + "'}";
    }

    @Override
    public Song systemSound() {
        return new Song("Honda Theme", "Instrumental", 180);
    }
}
