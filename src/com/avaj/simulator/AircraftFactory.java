package com.avaj.simulator;

import com.avaj.simulator.coordinates.Coordinates;
import com.avaj.simulator.flyables.Flyable;
import com.avaj.simulator.flyables.Helicopter;
import com.avaj.simulator.flyables.JetPlane;
import com.avaj.simulator.flyables.Baloon;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter") || type.equals("2ab8b43468e8b92b0fc5c81e70e35a2d")) {
            return new Helicopter(name, coordinates);
        }
        if (type.equals("JetPlane") || type.equals("554cd647d6b135f7e36ab1214c5e816a")) {
            return new JetPlane(name, coordinates);
        }
        if (type.equals("Baloon") || type.equals("994736b4f0aec72f6e5ae580051d012f")) {
            return new Baloon(name, coordinates);
        }
        return (null);
    }
}