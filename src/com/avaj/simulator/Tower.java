package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;
import java.util.*;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {

		// for (Flyable fly : observers) {
		// fly.updateConditions();
		// }

		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}
