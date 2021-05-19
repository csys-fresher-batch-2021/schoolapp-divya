/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InvalidNumberException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberException(String errorMessage) 
	{
		super(errorMessage);
	}

}
