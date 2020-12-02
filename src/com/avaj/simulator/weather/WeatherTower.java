package com.avaj.simulator.weather;

import com.avaj.simulator.coordinates.Coordinates;
import com.avaj.simulator.Tower;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		String test = WeatherProvider.getProvider().getCurrentWeather(coordinates);
		return (test);
	}

	public void changeWeather() {
		conditionsChanged();
	}
}
