
/**
 * @author divy2624
 *
 */
package in.divya.exceptions;

public class CannotRegisterStudentException extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotRegisterStudentException(String errorMessage) {
		super(errorMessage);
	}

}
