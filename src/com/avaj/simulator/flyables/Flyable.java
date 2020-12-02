package com.avaj.simulator.flyables;

import com.avaj.simulator.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}