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
        System.out.println("\t\tNissan constructor called");
    }

    @Autowired
    public VehicleNissan(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void performVehicleTestFunctions() {
        System.out.println("\t\tTesting functions of Nissan vehicle:");
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
        return "Nissan Data {brand='" + brand + "', model='" + model + "'}";
    }

    @Override
    public Song systemSound() {
        return new Song("Nissan Anthem", "Instrumental", 200);
    }
}
