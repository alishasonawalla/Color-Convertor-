package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains a color converter that takes in data from a file.
 * containing the listing of named CSS colors and their hexadecimal values.
 * 
 * This class asks the user to input a color in hex form and produces the
 * corresponding RGB value and name (if applicable).
 * 
 * @author Alisha Sonawalla
 * @version 09/19/2017
 */

public class ColorConverter {

	public static void main(String[] args) throws FileNotFoundException{

		// Verify that there are command line arguments
		if (args.length == 0) {
			System.err.println("Usage Error:the program expects file "
					+ "name as an argument.");
			System.exit(1);
		}

		// File object for input file
		String path = args[0];
		File inputFileName = new File(path);

		// Ensure that file exists
		if (!inputFileName.exists()) {
			System.err.println("ERROR: the file" + path + "does not exist");
			System.exit(1);
		}

		// Scanner object to read file and ensure that the file can be
		// read
		Scanner colorData = null;
		try {
			colorData = new Scanner(inputFileName);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: the file" + path + "cannot be opened");
			System.exit(1);
		}

		// Store data from file color_list.txt into ArrayList colorData
		// Each line in the input file will contain the name of the color
		// followed by a comma, followed by one or more spaces, followed by a
		// hexadecimal color value.
		// There may be additional white space characters (spaces and tabs) at
		// the beginning and end of each line.

		// An instance of ColorList class
		ColorList colorInfoList = new ColorList();

		//Iterate over the lines in the input file
		while (colorData.hasNextLine()) {
			// Read next line
			String textLine = colorData.nextLine();
			// Split the text line at comma
			String[] colorInfo = textLine.split(",");
			// If the file doesn't provide both the name and the hex value i.e.
			// two inputs continue
			if (colorInfo.length != 2)
				continue;
			// Eliminate spaces around color name
			colorInfo[0] = colorInfo[0].trim();
			// Eliminate spaces around color hex value
			colorInfo[1] = colorInfo[1].trim();
			// Add the color name and hex value to the ArrayList
			colorInfoList.add(new Color(colorInfo[1], colorInfo[0]));
		}
		// close the input file
		colorData.close();


		// This part of the program asks the user to enter the hex value of a color
		// It then returns the Hex, RGB and name(if available) of the color

		// Use scanner to get input from System.in
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the color in HEX format (#RRGGBB) or 'quit' to stop:");
		String inputHexValue = userInput.nextLine();

		//Keep asking user for input unless he/she types quit
		while (!inputHexValue.equalsIgnoreCase("quit")) {
			Color tempColorObject;
			// Create color object to verify that the input is valid
			try {
				tempColorObject = new Color(inputHexValue);
			}

			// If the argument passed by the user is invalid then catch
			// exception thrown
			catch (Exception e) {
				System.out.println("Error: This is not a valid color specification\n\n");
				System.out.println("Enter the color in HEX format (#RRGGBB) "
						+ "or 'quit' to stop:");
				inputHexValue = userInput.nextLine();
				continue;
			}

			// Find hex value given by user in ArrayList as a color object
			Color colorValueInList = colorInfoList.getColorByHexValue(inputHexValue);

			// If color object is not in the list format tempColorObj
			if (colorValueInList == null) {
				System.out.println(tempColorObject.toString() + "\n\n");
			}
			// Else format the object found in ArrayList using toString
			else {
				System.out.println(colorValueInList.toString() + "\n\n");
			}

			// Format and print the color hex value, RGB and name if applicable
			System.out.println("Enter the color in HEX format (#RRGGBB) "
					+ "or 'quit' to stop:");
			inputHexValue = userInput.nextLine();
		}

		//Close scanner object
		userInput.close();
	}
}
