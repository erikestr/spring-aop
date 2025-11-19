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
        System.out.println("\t\tHonda constructor called");
    }

    @Autowired
    public VehicleHonda(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void performVehicleTestFunctions() {
        System.out.println("\u001B[32m--- Service Working ---\u001B[0m");

        // Testing Sound System
        Song currentSong = systemSound();
        String music = vehicleService.playMusic(true, currentSong);
        System.out.println("\u001B[35mMusic playing: " + music + "\u001B[0m");

        // Testing Movement
        vehicleService.moveVehicle(true);
        String brakeMessage = vehicleService.applyBrake(true);
        System.out.println("\u001B[35mBrake message: " + brakeMessage + "\u001B[0m");

        System.out.println("\u001B[32m--- Service Stopped ---\u001B[0m");
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
