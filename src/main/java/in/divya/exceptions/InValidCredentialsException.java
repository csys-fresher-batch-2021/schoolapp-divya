package in.divya.exceptions;

public class InValidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InValidCredentialsException(String message) {
		super(message);
	}

}
