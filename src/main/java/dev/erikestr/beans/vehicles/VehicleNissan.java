package dev.erikestr.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Speakers;
import dev.erikestr.interfaces.Tyres;
import dev.erikestr.interfaces.Vehicle;
import dev.erikestr.model.Song;
import dev.erikestr.services.VehicleService;

@Component(value = "nissan")
@Primary
public class VehicleNissan implements Vehicle {

    private final String brand = "Nissan";

    private final String model = "Elgrand";

    private VehicleService vehicleService;

    public VehicleNissan() {
        System.out.println("Nissan constructor called");
    }

    @Autowired
    public VehicleNissan(VehicleService vehicleService) {
        System.out.println("Nissan constructor called");
        this.vehicleService = vehicleService;
    }

    @Override
    public void performVehicleTestFunctions() {
        System.out.println("----------- \u001B[32m Testing of Nissan started  \u001B[0m -----------");

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

        System.out.println("----------- \u001B[32m Testing of Nissan finished \u001B[0m -----------");
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
        return "Nissan Data {brand='" + brand + "', model='" + model + "'}";
    }

    @Override
    public Song systemSound() {
        return new Song("Nissan Anthem", "Instrumental", 200);
    }
}
