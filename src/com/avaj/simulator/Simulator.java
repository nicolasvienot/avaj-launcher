package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

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

	public static void main(String args[]) {
		// PrintWriter printWriter;
		if (args.length < 1) {
			System.out.println("Please provide a scenario file!");
			return;
		}
		// Reading file

		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			File file_simu = new File("simulation.txt");
			printWriter = new PrintWriter(file_simu);
			String documents[];
			documents = readAllLines(reader).split("\n");
			int nbsimu = Integer.parseInt(documents[0]);
			// System.out.println("Number of simulations : " + nbsimu);
			WeatherTower weatherTower = new WeatherTower();
			for (String doc : documents) {
				if (doc.equals(documents[0]))
					continue;
				Flyable test = AircraftFactory.newAircraft(doc.split(" ")[0], doc.split(" ")[1],
						Integer.parseInt(doc.split(" ")[2]), Integer.parseInt(doc.split(" ")[3]),
						Integer.parseInt(doc.split(" ")[4]));
				test.registerTower(weatherTower);
			}
		} catch (Exception e) {
			System.out.println("There was an error : " + e);
			return;
		}
		if (printWriter != null)
			printWriter.close();
		System.out.println("The End!");
	}
}
