package com.avaj.simulator;

import com.avaj.simulator.weather.WeatherTower;
import com.avaj.simulator.flyables.Flyable;
import com.avaj.simulator.errors.NoSuchFileException;
import com.avaj.simulator.errors.SimulatorException;
import java.io.PrintWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Simulator {
	public static PrintWriter printWriter;

	private static String readAllLines(BufferedReader reader) throws IOException {
		StringBuilder content = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			content.append(line);
			content.append("\n");
		}
		return content.toString();
	}

	private static int parseNbSimu(String nbSimu) throws SimulatorException {
		int nb = 0;
		try {
			nb = Integer.parseInt(nbSimu);
		} catch (Exception e) {
			throw new SimulatorException("Number of simulations must be an integer!");
		}
		if (nb < 0) {
			throw new SimulatorException("Number of simulations must be positive!");
		}
		return nb;
	}

	private static int parseLongitude(String longitude) throws SimulatorException {
		int nb = 0;
		try {
			nb = Integer.parseInt(longitude);
		} catch (Exception e) {
			throw new SimulatorException("Longitude must be an integer!");
		}
		if (nb < 0) {
			throw new SimulatorException("Longitude must be positive!");
		}
		return nb;
	}
	
	private static int parseLatitude(String latitude) throws SimulatorException {
		int nb = 0;
		try {
			nb = Integer.parseInt(latitude);
		} catch (Exception e) {
			throw new SimulatorException("Latitude must be an integer!");
		}
		if (nb < 0) {
			throw new SimulatorException("Latitude must be positive!");
		}
		return nb;
	}
	
	private static int parseHeight(String height) throws SimulatorException {
		int nb = 0;
		try {
			nb = Integer.parseInt(height);
		} catch (Exception e) {
			throw new SimulatorException("Height must be an integer!");
		}
		if (nb < 0 || nb > 100) {
			throw new SimulatorException("Height must be between 0 and 100!");
		}
		return nb;
	}

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage : java com.avaj.simulator.Simulator scenario.txt");
			return;
		}
		try {
			if (Files.notExists(Paths.get(args[0])))
				throw new NoSuchFileException();
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			File file_simu = new File("simulation.txt");
			printWriter = new PrintWriter(file_simu);
			String lines[];
			lines = readAllLines(reader).split("\n");
			int nbSimu = parseNbSimu(lines[0]);
			if (lines.length < 2) {
				throw new SimulatorException("It looks like you don't have any Flyables!");
			}
			int index = 0;
			WeatherTower weatherTower = new WeatherTower();
			for (String line : lines) {
				if (index == 0) {
					index++;
					continue;
				}
				String[] splitted = line.split(" +");
				if (splitted.length != 5) {
					throw new SimulatorException("A Flyable line is not well formatted!");
				}
				int longitude = parseLongitude(splitted[2]);
				int latitude = parseLatitude(splitted[3]);
				int height = parseHeight(splitted[4]);	
								
				Flyable aircraft = AircraftFactory.newAircraft(splitted[0], splitted[1], longitude, latitude, height);
				if (aircraft == null) {
					throw new SimulatorException("Wrong aircraft, do you even know what you're doing?");
				} else {
					aircraft.registerTower(weatherTower);
				}
				index++;
			}
			while (nbSimu > 0) {
				weatherTower.changeWeather();
				nbSimu--;
			}
			System.out.println("Simulation has ended, you can find the results in the file simulation.txt");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (printWriter != null)
				printWriter.close();
		}
	}
}
