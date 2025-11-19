package dev.erikestr.interfaces;

import dev.erikestr.model.Song;

public interface Speakers extends Product {

    int getVolume();

    void setVolume(int volume);

    String makeSound(Song song);

}
