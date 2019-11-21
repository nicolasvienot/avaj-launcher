package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Baloonrrr");
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Baloon#" + _name + "(" + _id + ") registered to weather tower.");
        Simulator.printWriter.println("Tower says: Baloon#" + _name + "(" + _id + ") registered to weather tower.");

    }

}