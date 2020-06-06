public class FileNotFoundException extends IllegalArgumentException{
	/**
	 * This method is used to give the exception message
	 * @param message
	 * This is the message that indicates the reason of this exception
	 */
	public FileNotFoundException(String message) {
		super(message);
	}
}
