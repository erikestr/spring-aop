package dev.erikestr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.erikestr.interfaces.Speakers;
import dev.erikestr.interfaces.Tyres;
import dev.erikestr.model.Song;

@Service
public class VehicleService {

    @Autowired
    private Tyres tyres;

    @Autowired
    private Speakers speakers;

    public VehicleService() {

    }

    public String playMusic(boolean vehicleStarted, Song song) {
        return vehicleStarted ? speakers.makeSound(song) : null;
    }

    public void moveVehicle(boolean vehicleStarted) {
        if (vehicleStarted) {
            tyres.rotate();
        }
    }

    public String applyBrake(boolean vehicleStarted) {
        return vehicleStarted ? tyres.stopRotation() : null;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Speakers getSpeakers() {
        return speakers;
    }
}
