package com.avaj.simulator.flyables;

import com.avaj.simulator.coordinates.Coordinates;

public class Aircraft {
	protected long _id;
	protected String _name;
	protected Coordinates _coordinates;
	private static long _idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		_name = name;
		_coordinates = coordinates;
		_id = nextId();
	}

	private long nextId() {
		return ++_idCounter;
	}

}
