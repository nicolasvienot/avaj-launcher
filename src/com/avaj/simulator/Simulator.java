package com.avaj.simulator;
import java.io.PrintWriter;
import java.io.*;

import java.io.PrintWriter;
import java.io.File;

// public class Simulator {

//   public static void main(String[] args) throws IOException {

//     File file = new File ("file.txt");
//     PrintWriter printWriter = new PrintWriter ("file.txt");
//     printWriter.println ("hello");
//     printWriter.close ();       
//   }
// }

public class Simulator {
	public static void main(String args[])
	{
		PrintWriter printWriter;
		if (args.length < 1)
		{
			System.out.println("Please provide a scenario file!");
			return;
		}
		// String str_scen = args[0];
		File file_simu = new File("simulation.txt");
		try {
			printWriter = new PrintWriter ("simulation.txt");
		} catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
		printWriter.println("hello");
		printWriter.println(str_scen);
		printWriter.close();
	}
}
