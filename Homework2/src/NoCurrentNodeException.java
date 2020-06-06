/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *This class is used to throw an IllegalArgumentException if there is no 
 *node in the list.
 */
public class NoCurrentNodeException extends IllegalArgumentException{
	/**
	 * This method is used to give the exception message
	 * @param message
	 * This is the message that indicates the reason of this exception
	 */
	public NoCurrentNodeException(String message) {
		super(message);
	}
}
