
import java.util.ArrayList;

/**
 * The ColorList class is being used to store all the Color objects whose
 * hexadecimal value and name are provided in the input file.
 * It creates an empty ArrayList when an object is created.
 * 
 * This class also provides methods to access color objects in 
 * the ArrayList by color name or hex value .
 * 
 *@author Alisha Sonawalla
 *@version 09/19/2017
 */

public class ColorList extends ArrayList<Color> {

	/**
	 *The method iterates over all the objects in the ArrayList
	 *till the matching object is found using the color name if its exists.
	 *
	 *@param colorName name of the color 
	 *@return color object whose name matches color name parameter
	 */
	public Color getColorByName(String colorName) {
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i).getName().equalsIgnoreCase(colorName)) {
				return super.get(i);
			}
		}
		return null;
	}
	/**
	 *The method iterates over all the objects in the ArrayList
	 *till the matching object is found using the hex value.
	 *
	 *@param colorHexValue hex value of the color 
	 *@return color object whose hex value matches hex value in parameter
	 */
	// Create Method getColorByHexValue
	// This method iterates over all the values in the list
	// Till the matching object by hex value is found if it exists
	public Color getColorByHexValue(String colorHexValue) {
		for (int i = 0; i < super.size(); i++) {
			if (super.get(i).getHexValue().equalsIgnoreCase(colorHexValue)) {
				return super.get(i);
			}
		}
		return null;
	}

}
