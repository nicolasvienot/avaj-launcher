package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		String test = WeatherProvider.getProvider().getCurrentWeather(coordinates);
		return (test);
	}

	public void changeWeather() {
		conditionsChanged();
	}
}
