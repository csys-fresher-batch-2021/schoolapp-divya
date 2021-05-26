package in.divya.exceptions;

public class InValidNumberLengthException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */

	public InValidNumberLengthException(String message) {
		super(message);
	}
}
