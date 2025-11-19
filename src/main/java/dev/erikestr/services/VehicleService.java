package dev.erikestr.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Instant;

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

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public VehicleService() {

    }

    public String playMusic(boolean vehicleStarted, Song song) {
        logger.info("playMusic started: {} ms", 0);
        Instant start = Instant.now();

        String music = null;
        if (vehicleStarted == true) {
            music = speakers.makeSound(song);
        } else {
            logger.error("Vehicle not started to perform the operation");
        }

        logger.info("method execution start");
        Instant finish = Instant.now();

        long timeElapsed = java.time.Duration.between(start, finish).toMillis();
        logger.info("playMusic finished: {} ms", timeElapsed);

        return music;
    }

    public void moveVehicle(boolean vehicleStarted) {
        logger.info("move started: {} ms", 0);
        Instant start = Instant.now();

        if (vehicleStarted == true) {
            tyres.rotate();
        } else {
            logger.error("Vehicle not started to perform the operation");
        }

        Instant finish = Instant.now();

        long timeElapsed = java.time.Duration.between(start, finish).toMillis();
        logger.info("move finished: {} ms", timeElapsed);
    }

    public String applyBrake(boolean vehicleStarted) {
        logger.info("applyBrake started: {} ms", 0);
        Instant start = Instant.now();

        String message = null;
        if (vehicleStarted == true) {
            message = tyres.stopRotation();
        } else {
            logger.error("Vehicle not started to perform the operation");
        }

        Instant finish = Instant.now();

        long timeElapsed = java.time.Duration.between(start, finish).toMillis();
        logger.info("applyBrake finished: {} ms", timeElapsed);
        return message;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Speakers getSpeakers() {
        return speakers;
    }
}
