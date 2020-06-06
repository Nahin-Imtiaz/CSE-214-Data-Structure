/**
 * This class is used to throw an IllegalArgumentException if the position is
 *  not within the valid range
 *  
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony Brook ID: 111214466
 */
public class InvalidPositionException extends IllegalArgumentException{
	/**
	 * This method is used to give the exception message
	 * @param message
	 * This is the message that indicates the reason of this exception
	 */
	public InvalidPositionException(String message) {
		super(message);
	}
}
