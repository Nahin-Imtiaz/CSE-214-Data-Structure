/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents a hashed data structure with HashTable API where 
 *objects of book class are stored and the isbn of the books are used as the
 * key and books are used as the value.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Hashtable;
import big.data.DataSource;


public class HashedLibrary extends Hashtable<String,Book> implements 
  Serializable{
	/**
	 * this is a default constructor to create an object of HashedLibrary
	 */
	public HashedLibrary() {
	}
	/**
	 * this method adds a book object into the hashTable and throws an 
	 * exception if the book is already recorded
	 * @param title
	 * this is the title of the book
	 * @param author
	 * this is the author of the book
	 * @param publisher
	 * this is the publisher of the book
	 * @param isbn
	 * this is the isbn of the book
	 * @throws IllegalArgumentException
	 * this throws an exception if invalid input is given
	 */
	public void addBook(String title, String author, String publisher, String 
	  isbn) throws IllegalArgumentException{
		Book newBook = new Book(title,author,publisher,isbn);
		if(containsKey(isbn)) {
			System.out.println(isbn+": "+"Book already recorded.");
		}
		else {
			put(isbn,newBook);
			System.out.println(isbn+": "+title+" by "+author+" recorded");
		}
	}
	/**
	 * this method opens a text file and adds all book information found from 
	 * xml files listed in the text file
	 * @param file
	 * this is the text file from where xml files are extracted
	 * @throws IllegalArgumentException
	 * this throws an exception if the file is not valid
	 * @throws IOException
	 * this throws an exception if the reader is null
	 */
	public void addAllBookInfo(String file) throws  IllegalArgumentException,
	  IOException {
		
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(file);
		}
		catch(Exception e) {
			System.out.println("No such file '"+file+"'.");
			return;
		}
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
	
		String data ;
		while((data =reader.readLine())!=null) {
			
			String fileName = data;
			DataSource ds =null;
			try {
				ds = DataSource.connect("https://www3.cs.stonybrook.edu"
				  + "/~cse214/hw/hw6/" + fileName + ".xml").load();
			}catch(Exception e) {
				System.out.println("File doesnt exist.");		
			}
			try{
				String title=ds.fetchString("title");
				String author=ds.fetchString("author");
				String publisher=ds.fetchString("publisher");
				String isbn=ds.fetchString("isbn");
				
				addBook(title,author,publisher,isbn);
			}catch(Exception e){		
			}
		}	
	}
	/**
	 * this method returns the Book object from the hashTable
	 * @param isbn
	 * this is the isbn of the book
	 * @return book
	 * this returns the book object
	 */
	public Book getBookByisbn(String isbn) {
		return get(isbn);
	}
	/**
	 * this method prints out all of the elements of the hashTable
	 */
	public void printCatalog() {
		for(String i: this.keySet()) {
			System.out.print(get(i));
		}
	}
}