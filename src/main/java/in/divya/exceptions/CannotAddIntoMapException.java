
/**
 * @author divy2624
 *
 */
package in.divya.exceptions;

public class CannotAddIntoMapException extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotAddIntoMapException(String errorMessage) {
		super(errorMessage);
	}

}
