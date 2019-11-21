package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}