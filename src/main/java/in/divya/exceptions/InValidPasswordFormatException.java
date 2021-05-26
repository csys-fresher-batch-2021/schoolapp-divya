/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidPasswordFormatException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */

	public InValidPasswordFormatException(String message) {
		super(message);
	}
}
