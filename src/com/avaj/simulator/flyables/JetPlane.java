package com.avaj.simulator.flyables;

import com.avaj.simulator.coordinates.Coordinates;
import com.avaj.simulator.weather.WeatherTower;
import com.avaj.simulator.Simulator;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = _weatherTower.getWeather(_coordinates);
		switch (weather) {
		case "RAIN":
			Simulator.printWriter.println("JetPlane#" + _name + "(" + _id + "): It's raining!");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 5, _coordinates.getLongitude(),
					_coordinates.getHeight());
			break;
		case "FOG":
			Simulator.printWriter.println("JetPlane#" + _name + "(" + _id + "): What the hell is that fog?");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 1, _coordinates.getLongitude(),
					_coordinates.getHeight());
			break;
		case "SUN":
			Simulator.printWriter.println("JetPlane#" + _name + "(" + _id + "): What a beaufiful sun!");
			_coordinates = new Coordinates(_coordinates.getLatitude() + 10, _coordinates.getLongitude(),
					_coordinates.getHeight() + 2);
			break;
		case "SNOW":
			Simulator.printWriter.println("JetPlane#" + _name + "(" + _id + "): It's snowing!");
			_coordinates = new Coordinates(_coordinates.getLatitude(), _coordinates.getLongitude(),
					_coordinates.getHeight() - 7);
			break;
		default:
			Simulator.printWriter.println("There was a problem with our JetPlane!");
		}
		if (_coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("JetPlane#" + _name + "(" + _id + ") landing at latitude " + _coordinates.getLatitude()
					+ " and longitude " + _coordinates.getLongitude() + ".");
			_weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: JetPlane#" + _name + "(" + _id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		weatherTower.register(this);
		Simulator.printWriter.println("Tower says: JetPlane#" + _name + "(" + _id + ") registered to weather tower.");
	}

}
