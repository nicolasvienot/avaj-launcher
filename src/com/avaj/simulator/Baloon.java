package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = _weatherTower.getWeather(_coordinates);
		switch (weather) {
		case "RAIN":
			System.out.println("Baloon#" + _name + "(" + _id + "): It's raining!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 5);
			break;
		case "FOG":
			System.out.println("Baloon#" + _name + "(" + _id + "): What the hell is that fog?");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 3);
			break;
		case "SUN":
			System.out.println("Baloon#" + _name + "(" + _id + "): What a beaufiful sun!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude() + 2,
					_coordinates.getHeight() + 4);
			break;
		case "SNOW":
			System.out.println("Baloon#" + _name + "(" + _id + "): It's snowing!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 15);
			break;
		default:
			System.out.println("problem case baloon");
		}
		if (_coordinates.getHeight() <= 0) {
			System.out.println("Baloon#" + _name + "(" + _id + ") landing at latitude " + _coordinates.getLatitude()
					+ " and longitude " + _coordinates.getLongitude() + ".");
			_weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		_weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + _name + "(" + _id + ") registered to weather tower.");
		Simulator.printWriter.println("Tower says: Baloon#" + _name + "(" + _id + ") registered to weather tower.");
	}

}
