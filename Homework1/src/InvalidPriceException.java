/**
 * This class is used to throw an IllegalArgumentException if the price is 
 * negative
 * 
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 */
public class InvalidPriceException extends IllegalArgumentException{
	/**
	 * This method is used to give the exception message
	 * @param message
	 * This is the message that indicates the reason of this exception
	 */
	public InvalidPriceException(String message) {
		super(message);
	}
}
