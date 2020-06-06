import java.util.Scanner;
/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class contains a main method and menu options.This class also loads the
 * list of books from a binary file called "library.obj"in the current working
 *  directory and save the data to this file if the user choose option Q(quit),
 *  overwriting it if it exists.if the “library.obj” is not found,it creates a
 *   new hashedLibrary object. 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DatabaseDriver  implements Serializable {
	/**
	 * this main method operates the menu options and takes user inputs and 
	 * completes the tasks given by the user.
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)throws IOException, 
	  ClassNotFoundException {
		HashedLibrary myLibrary;
		/**
		 * this block opens the "library.obj" if it exists,otherwise creates 
		 * a new hashedLibrary
		 */
		try {
		     FileInputStream file = new FileInputStream("library.obj");
		     ObjectInputStream fin  = new ObjectInputStream(file);
		     myLibrary = (HashedLibrary) fin.readObject(); 
		     fin.close();
		     System.out.println("Successfully loaded contents of library.obj."
		       );
		} catch(IOException e){
			System.out.println("library.obj is not found. Using a new "
			  + "HashedLibrary.");
			myLibrary=new HashedLibrary();
		}
		String command,title,author,publisher,fileName,isbn;
		/**
		 * this block is for displaying the menu options and taking a user 
		 * input
		 */
		System.out.println("");
		System.out.println("(D) Displays Books");
		System.out.println("(G) Get Book");
		System.out.println("(L) Load File");
		System.out.println("(R) Record Book");
		System.out.println("(Q) Quit");
		System.out.println("");
		System.out.print("Enter a selection: ");
		Scanner input= new Scanner(System.in);
		command=input.nextLine();
		/**
		 * this while loop continues until the user iputs Q as a command
		 */
		while(!command.equalsIgnoreCase("Q")) {
			/**
			 * this block displays all books in a neat tabular format.
			 */
			if(command.equalsIgnoreCase("D")) {
				System.out.println("");
				System.out.printf("%-16s%-35s%-32s%-39s%n","Book ISBN","Title",
				  "Author","Publisher");
				System.out.printf("%-16s%-35s%-32s%-39s%n","----------------",
				  "-----------------------------------","--------------------"
				  + "------------","---------------------------------------");
				myLibrary.printCatalog();
			}
			/**
			 *this block gets Book by ISBN
			 */
			if(command.equalsIgnoreCase("G")) {
				System.out.println("");
				System.out.print("Enter Book ISBN: ");
				isbn=input.nextLine();
				System.out.println("");
				System.out.printf("%-16s%-35s%-32s%-39s%n","Book ISBN","Title"
				  ,"Author","Publisher");
				System.out.printf("%-16s%-35s%-32s%-39s%n","----------------",
				  "-----------------------------------","---------------------"
				  + "-----------","---------------------------------------");
				System.out.println(myLibrary.getBookByisbn(isbn));
			}
			/**
			 * this block accepts a file name and records all books specified 
			 * in the file.
			 */
			if(command.equalsIgnoreCase("L")) {
				System.out.println("");
				System.out.print("Enter the file to load: ");
				fileName=input.nextLine();
				System.out.println("");
				myLibrary.addAllBookInfo(fileName);
			}
			/**
			 * this block prompts the user for book information, and record 
			 * this book.
			 */
			if(command.equalsIgnoreCase("R")) {
				System.out.println("");
				System.out.print("Enter book title: ");
				title=input.nextLine();
				System.out.print("Enter book author: ");
				author=input.nextLine();
				System.out.print("Enter book publisher: ");
				publisher=input.nextLine();
				System.out.print("Enter book ISBN: ");
				isbn=input.nextLine();
				System.out.println("");
				myLibrary.addBook(title, author, publisher, isbn);
			}
			
			System.out.println("");
			System.out.println("(D) Displays Books");
			System.out.println("(G) Get Book");
			System.out.println("(L) Load File");
			System.out.println("(R) Record Book");
			System.out.println("(Q) Quit");
			System.out.println("");
			System.out.print("Enter a selection: ");
			command = input.nextLine();
		}
		/**
		 * this block saves the hashedLibrary and terminates the program when
		 *  Q is given as input
		 */
		try {
		      FileOutputStream file = new FileOutputStream("library.obj");
		      ObjectOutputStream fout = new ObjectOutputStream(file);
		      fout.writeObject(myLibrary); 
		      fout.close();
		      System.out.println("");
		      System.out.println("HashedLibrary is saved into file library"
		        + ".obj");
		} catch (IOException e){
			
		}
		System.out.println("Program terminating normally...");
		System.exit(0);
	}

}
