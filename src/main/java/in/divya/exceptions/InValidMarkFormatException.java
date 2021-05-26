/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidMarkFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param errorMessage
	 */
	public InValidMarkFormatException(String errorMessage) {
		super(errorMessage);
	}
}
