/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents a main method to interect with the user and get user
 * input.it provides a main menu to the user and depending on the input, it 
 * performs different tasks
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WebCrawler {
	/**
	 * this main method provides the user a menu and asks for command.after 
	 * getting the command,it goes through a while loop and performs the task 
	 * until user inputs Q.and terminates the program if input is Q.
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IllegalArgumentException, 
	  IOException {

		String command,fileName,keyWord;
		int i=1;
		WebTree webTree = new WebTree();;
		
		System.out.println("[L] : Load HTML file");
		System.out.println("[P] : Print tree");
		System.out.println("[D] : Print dead links");
		System.out.println("[S] : Search for a page with a specified title "
		  + "within the tree");
		System.out.println("[R] : Reset tree structure");
		System.out.println("[Q] : Quit");
		System.out.println("");
		System.out.print("Enter Selection: ");
		Scanner input = new Scanner(System.in);
		command = input.nextLine();
		try {
		while(!command.equalsIgnoreCase("Q")) {
			if(command.equalsIgnoreCase("L")) {
				System.out.print("Enter HTML file: ");
				fileName=input.nextLine();
				webTree.resetTreeStructure();
				webTree.crawlHTML(fileName);
			}
			if(command.equalsIgnoreCase("P")) {
				webTree.printWebTree();
			}
			if(command.equalsIgnoreCase("D")) {
				String[] d= new String[100];
				webTree.printDeadLink(webTree.getRoot(),d,0);
			}
			if(command.equalsIgnoreCase("S")) {
				System.out.print("Enter keyword of title to search for: ");
				keyWord = input.nextLine();
				
				String[] d= new String[100];
				webTree.search(keyWord,webTree.getRoot(),d,0);
				
			}
			if(command.equalsIgnoreCase("R")) {
				System.out.println("Information reset.");
				webTree.resetTreeStructure();
			}
			System.out.println("");
			System.out.println("[L] : Load HTML file");
			System.out.println("[P] : Print tree");
			System.out.println("[D] : Print dead links");
			System.out.println("[S] : Search for a page with a specified title"
			  + " within the tree");
			System.out.println("[R] : Reset tree structure");
			System.out.println("[Q] : Quit");
			System.out.println("");
			System.out.print("Enter Selection: ");
			command = input.nextLine();
		}
		System.out.println("Program terminating successfully...");
		System.exit(0);
		}catch(IllegalArgumentException e) {
		}
	}
}
