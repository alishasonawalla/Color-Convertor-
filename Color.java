
/**
 * This class stores information about color.
 * 
 * It provides three types of constructors to create the color object.
 * 
 * The class contains different accessing methods (getters)
 * to get various data fields, formatting methods, hex to RGB and 
 * RGB to hex converter methods and comparison/equals methods.
 * 
 *@author Alisha Sonawalla
 *@version 09/19/2017
 */

public class Color implements Comparable<Color> {

	// Create data fields
	private int redValue = 0;
	private int blueValue = 0;
	private int greenValue = 0;
	private String colorCurrentName = " ";
	private String hexValue = "";


	// Constructor to take in hex value and color name as strings
	//Validates the hex value and throws IllegalArgumentException 
	//if the hex input is invalid 
	//Updates the name and hexvalue of the color 
	//Calls the hexToRGB function to update RGB values
	public Color(String colorHexValue, String colorName) throws IllegalArgumentException {

		String validInput = "#[a-fA-F0-9]{6}";
		// If the hex value input is invalid then throw exception
		if (!colorHexValue.startsWith("#") || (colorHexValue.length() != 7)) {
			throw new IllegalArgumentException("Error: This is not a valid "
					+ "color specification");
		}
		// If the hex value input is invalid then throw exception
		else if (!colorHexValue.matches(validInput)) {
			throw new IllegalArgumentException("Error: This is not a valid "
					+ "color specification");
		}

		else {
			// Update color name and hex value data fields
			colorCurrentName = colorName;
			hexValue = colorHexValue;

			// Update RGB values based on hex input
			hexToRGB();
		}

	}

	// Constructor to take in well formatted hex value as string
	//Calls the two parameter constructor above to valid input and update RGB values
	public Color(String colorHexValue) {

		//Call the other constructor Color(String colorhexValue,String colorName)
		//Pass null name value
		this(colorHexValue, "");
	}

	// Constructor to take in RGB values between 0 and 255
	//Constructor throws IllegalArgumentException  if RGB 
	//is not between 0 and 255 inclusive
	public Color(int red, int green, int blue) throws IllegalArgumentException{

		// Throw exception if RGB input isn't between 0 and 255 (inclusive)
		if (red > 255 || red < 0) {
			throw new IllegalArgumentException("Error: This is not a valid "
					+ "color specification");
		}

		else if (green > 255 || green < 0) {
			throw new IllegalArgumentException("Error: This is not a valid "
					+ "color specification");
		}

		else if (blue > 255 || blue < 0) {
			throw new IllegalArgumentException("Error: This is not a valid "
					+ "color specification");
		}

		else {
			// Set RGB values
			redValue = red;
			greenValue = green;
			blueValue = blue;

			// Update hex values based on RGB input
			RGBToHex(redValue, greenValue, blueValue);
		}
	}

	/**
	 *This method returns the red component of the RGB value of color.
	 * @return redValue the red component which is an integer
	 */
	public int getRed() {
		return this.redValue;
	}

	/**
	 *This method returns the green component of the RGB value of color
	 * @return greenValue the green component which is an integer
	 */
	public int getGreen() {
		return this.greenValue;
	}

	/**
	 *This method returns the blue component of the RGB value of color.
	 * @return blueValue the blue component which is an integer
	 */
	public int getBlue() {
		return this.blueValue;
	}

	/**
	 *This method returns the name of the color, if it exists in the input file.
	 * @return colorCurrentname the name of the color
	 */
	public String getName() {
		return this.colorCurrentName;
	}

	/**
	 *This method returns the hexvalue of the color in the format #XXXXXX.
	 * @return hexValue the hexadecimal of the color
	 */
	public String getHexValue() {
		return this.hexValue;
	}
	/**
	 *This method overrides the equals method. 
	 *It checks if the object passed is an instance of Color.
	 *If it is, then compares hex values ignoring case.
	 *
	 *@param o color object 
	 *
	 * @return true/false based on comparison of hex values
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Color) {
			Color colorobj = (Color) o;
			String colorObjHexValue = colorobj.getHexValue();
			return this.getHexValue().equalsIgnoreCase(colorObjHexValue);
		}

		else {
			return false;
		}
	}

	/**
	 *This method overrides the compareTo method. 
	 *It compares hex values ignoring case.
	 *
	 *@param colorObj color object 
	 *
	 * @return 0 if equal, 1 if colorObj is smaller, or -1 if colorObj is greater
	 */
	@Override
	public int compareTo(Color colorObj) {
		String colorObjHexValue = colorObj.getHexValue();
		return this.getHexValue().compareToIgnoreCase(colorObjHexValue);
	}

	/**
	 *This method overrides the toString method. 
	 *It formats the output of hex value, RGB and color name 
	 *
	 * @return formatted string
	 */
	@Override
	public String toString() {
		return String.format("%7s%s%2s%3d%s%3d%s%3d%s%-2s%10s", hexValue, ",", "(",
				redValue,",", greenValue, ",",blueValue, ")", ",", colorCurrentName);
	}

	/**
	 *This method converts RGB value to hex. 
	 *It updates the redValue, greenValue and blueValue data fields.
	 */
	private void hexToRGB() {
		this.hexValue = hexValue.toUpperCase();
		this.redValue = Integer.valueOf(hexValue.substring(1, 3), 16);
		this.greenValue = Integer.valueOf(hexValue.substring(3, 5), 16);
		this.blueValue = Integer.valueOf(hexValue.substring(5, 7), 16);
	}

	/**
	 *This method converts hex to RGB. 
	 *It updates the hexValue data field after conversion.
	 *
	 *@param red, green, blue the individual RGB components of the color
	 */
	private void RGBToHex(int red, int green, int blue) {
		hexValue = String.format("#%02x%02x%02x", red, green, blue).toUpperCase();
	}
}
