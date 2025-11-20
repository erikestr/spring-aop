package dev.erikestr.beans.speakers;

import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Speakers;
import dev.erikestr.model.Song;

@Component(value = "bose")
public class BoseSpeakers implements Speakers {

    private final String brand = "Bose";
    private final String model = "Bose Y456";
    private int volume = 50;

    public BoseSpeakers() {
        System.out.println("BoseSpeakers constructor called");
    }

    @Override
    public String makeSound(Song song) {
        return "Sound playing: " + (song != null ? song.getTitle() : "No song");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}