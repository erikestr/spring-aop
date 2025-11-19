package dev.erikestr.beans.speakers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import dev.erikestr.interfaces.Speakers;
import dev.erikestr.model.Song;

@Component(value = "sony")
@Primary
public class SonySpeakers implements Speakers {

    private final String brand = "Sony";

    private final String model = "Sony X123";

    private int volume = 50;

    public SonySpeakers() {
        System.out.println("SonySpeakers constructor called");
    }

    @Override
    public String makeSound(Song song) {
        System.out.println("\u001B[34mSonySpeakers " + model + " is making sound at volume " + volume + "\u001B[0m");
        return "Sound playing: " + (song != null ? song.getTitle() : "No song");
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
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}