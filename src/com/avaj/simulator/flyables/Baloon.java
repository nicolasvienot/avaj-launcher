package com.avaj.simulator.flyables;

import com.avaj.simulator.coordinates.Coordinates;
import com.avaj.simulator.weather.WeatherTower;
import com.avaj.simulator.Simulator;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = _weatherTower.getWeather(_coordinates);
		switch (weather) {
		case "RAIN":
			Simulator.printWriter.println("Baloon#" + _name + "(" + _id + "): It's raining!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 5);
			break;
		case "FOG":
			Simulator.printWriter.println("Baloon#" + _name + "(" + _id + "): What the hell is that fog?");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 3);
			break;
		case "SUN":
			Simulator.printWriter.println("Baloon#" + _name + "(" + _id + "): What a beaufiful sun!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude() + 2,
					_coordinates.getHeight() + 4);
			break;
		case "SNOW":
			Simulator.printWriter.println("Baloon#" + _name + "(" + _id + "): It's snowing!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 15);
			break;
		default:
			Simulator.printWriter.println("There was a problem with our Baloon!");
		}
		if (_coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("Baloon#" + _name + "(" + _id + ") landing at latitude " + _coordinates.getLatitude()
					+ " and longitude " + _coordinates.getLongitude() + ".");
			_weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: Baloon#" + _name + "(" + _id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		_weatherTower.register(this);
		Simulator.printWriter.println("Tower says: Baloon#" + _name + "(" + _id + ") registered to weather tower.");
	}

}
