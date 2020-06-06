/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents a Book object and has variables for title,author,
 *publisher,and isbn number of the book.this class also has getter and setter
 * methods for the variables and a toString.
 */
import java.io.Serializable;
public class Book implements Serializable{
	public String title;
	public String author;
	public String publisher;
	public String isbn;
	/**
	 * this is a constructor with parameters to create a book object
	 * @param title
	 * this is the title of the book
	 * @param author
	 * this is the author of the book
	 * @param publisher
	 * this is the publisher of the book
	 * @param isbn
	 * this is the isbn number of the book
	 */
	public Book(String title,String author,String publisher,String isbn) {
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.isbn=isbn;
	}
	/**
	 * this method returns the title of the book
	 * @return string
	 * this returns a string for the title of the book
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * this method sets the title of the book
	 * @param title
	 * this is the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * this method returns the author of the book
	 * @return string
	 * this returns a string for the author of the book
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * this method sets the author of the book
	 * @param author
	 * this is the author of the book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * this method returns the publisher of the book
	 * @return string
	 * returns a string of publisher of the book
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * this method sets the publisher of the book
	 * @param publisher
	 * this is the publisher of the book
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * this method returns the isbn of the book
	 * @return string
	 * returns a string of the isbn of the book
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * this method sets the isbn of the book
	 * @param isbn
	 * this is the isbn of the book
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * this method returns a string representation for a book object
	 */
	public String toString() {
		return String.format("%-16s%-35s%-32s%-39s%n",this.getIsbn(),
		  this.getTitle(),this.getAuthor(),this.getPublisher());
	}
}
