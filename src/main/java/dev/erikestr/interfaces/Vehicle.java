package dev.erikestr.interfaces;

import dev.erikestr.model.Song;

public interface Vehicle extends Product {

    void performVehicleTestFunctions();

    Tyres getTyres();

    Speakers getSpeakers();

    Song systemSound();
}
