package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class Simulator {

	private static String readAllLines(BufferedReader reader) throws IOException {
		StringBuilder content = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			content.append(line);
			content.append("\n");
		}
		return content.toString();
	}

	// private static String[][] getAviation(String[] documents, int size) throws
	// IOException {
	// String docAviation[size];
	// int i = 1;
	// int j = 0;
	// while (documents[i] != null) {
	// docAviation[j][0] = documents[i];
	// docAviation[j][1] = documents[i + 1];
	// docAviation[j][2] = documents[i + 2];
	// docAviation[j][3] = documents[i + 3];
	// docAviation[j][4] = documents[i + 4];
	// i += 5;
	// }
	// return docAviation;
	// }

	public static void main(String args[]) throws IOException {
		PrintWriter printWriter;
		if (args.length < 1) {
			System.out.println("Please provide a scenario file!");
			return;
		}
		// Reading file

		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String document;
		String documents[];
		document = readAllLines(reader);
		documents = document.split("\n");
		int nbsimu = Integer.parseInt(documents[0]);
		System.out.println("Number of simulations : " + nbsimu);
		// System.out.println(documents[1].split(" ")[0]);
		// System.out.println(documents[1].split(" ")[1]);
		// System.out.println(documents[1].split(" ")[2]);
		// System.out.println(documents[1].split(" ")[3]);
		// System.out.println(documents[1].split(" ")[4]);

		Flyable test = AircraftFactory.newAircraft(documents[1].split(" ")[0], documents[1].split(" ")[1],
				Integer.parseInt(documents[1].split(" ")[2]), Integer.parseInt(documents[1].split(" ")[3]),
				Integer.parseInt(documents[1].split(" ")[4]));
		Flyable test2 = AircraftFactory.newAircraft(documents[2].split(" ")[0], documents[2].split(" ")[1],
				Integer.parseInt(documents[2].split(" ")[2]), Integer.parseInt(documents[2].split(" ")[3]),
				Integer.parseInt(documents[2].split(" ")[4]));
		Flyable test3 = AircraftFactory.newAircraft(documents[3].split(" ")[0], documents[3].split(" ")[1],
				Integer.parseInt(documents[3].split(" ")[2]), Integer.parseInt(documents[3].split(" ")[3]),
				Integer.parseInt(documents[1].split(" ")[4]));
		Flyable test4 = AircraftFactory.newAircraft(documents[4].split(" ")[0], documents[4].split(" ")[1],
				Integer.parseInt(documents[4].split(" ")[2]), Integer.parseInt(documents[4].split(" ")[3]),
				Integer.parseInt(documents[1].split(" ")[4]));
		WeatherTower weatherTower = new WeatherTower();
		test.registerTower(weatherTower);
		test2.registerTower(weatherTower);
		test3.registerTower(weatherTower);
		test4.registerTower(weatherTower);
		// Creating file
		File file_simu = new File("simulation.txt");
		// optionnel?
		// Writing file
		try {
			printWriter = new PrintWriter(file_simu);
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		printWriter.println(document);
		printWriter.close();
	}
}
