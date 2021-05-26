/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidEmailIDException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */

	public InValidEmailIDException(String message) {
		super(message);
	}
}
