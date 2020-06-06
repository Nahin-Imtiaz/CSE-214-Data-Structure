/**
 * This class is used to throw an IllegalArgumentException if there is no more
 *  room inside of the CardCollection to store the new BaseballCard object
 * 
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 */
public class FullCollectionException extends IllegalArgumentException{
	/**
	 * This method is used to give the exception message
	 * @param message
	 * This is the message that indicates the reason of this exception
	 */
	public FullCollectionException(String message) {
		super(message);
	}

}
