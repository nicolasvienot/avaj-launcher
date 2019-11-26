package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower _weatherTower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		System.out.println("Helicopterrrr");
	}

	public void registerTower(WeatherTower weatherTower) {
		this._weatherTower = weatherTower;
		weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + _name + "(" + _id + ") registered to weather tower.");
		Simulator.printWriter.println("Tower says: Helicopter#" + _name + "(" + _id + ") registered to weather tower.");
	}

}
