/**
 * 
 */
package in.divya.validator;

import in.divya.exceptions.InValidIntegerNumberTypeException;
import in.divya.exceptions.NumberCannotBeNegativeException;

/**
 * @author divy2624
 *
 */
public class MarkValidator {
	private MarkValidator() {
		// Default constructor
	}

	public static boolean isNumberPositive(int number) throws NumberCannotBeNegativeException {
		boolean isValidNumber = false;

		if (number > 0) {
			isValidNumber = true;
		} else {
			throw new NumberCannotBeNegativeException("Number Cannot be Negative");
		}

		return isValidNumber;
	}

	public static int isValidNumberOnly(String number, String errorMessage) throws InValidIntegerNumberTypeException {

		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			throw new InValidIntegerNumberTypeException(errorMessage);
		}

	}

}
