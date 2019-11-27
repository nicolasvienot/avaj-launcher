package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = _weatherTower.getWeather(_coordinates);
		switch (weather) {
		case "RAIN":
			System.out.println("JetPlane#" + _name + "(" + _id + "): It's raining!");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 5, _coordinates.getLongitude(),
					_coordinates.getHeight());
			break;
		case "FOG":
			System.out.println("JetPlane#" + _name + "(" + _id + "): What the hell is that fog?");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 1, _coordinates.getLongitude(),
					_coordinates.getHeight());
			break;
		case "SUN":
			System.out.println("JetPlane#" + _name + "(" + _id + "): What a beaufiful sun!");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 10, _coordinates.getLongitude(),
					_coordinates.getHeight() + 2);
			break;
		case "SNOW":
			System.out.println("JetPlane#" + _name + "(" + _id + "): It's snowing!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 7);
			break;
		default:
			System.out.println("problem case JetPlane");
		}
		if (_coordinates.getHeight() <= 0) {
			System.out.println("JetPlane#" + _name + "(" + _id + ") landing at latitude " + _coordinates.getLatitude()
					+ " and longitude " + _coordinates.getLongitude() + ".");
			_weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + _name + "(" + _id + ") registered to weather tower.");
		Simulator.printWriter.println("Tower says: JetPlane#" + _name + "(" + _id + ") registered to weather tower.");
	}

}
