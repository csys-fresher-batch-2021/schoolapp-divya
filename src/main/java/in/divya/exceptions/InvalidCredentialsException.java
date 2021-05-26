package in.divya.exceptions;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InvalidCredentialsException(String message) {
		super(message);
	}

}
