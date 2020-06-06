/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents a data structure and runs a menu driven application 
 *which first displays the menu and asks for a command.then it takes user 
 *inputs and saves the data at the end.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class SigmaAirDriver implements Serializable{
	public static void main(String[] args) throws IOException,
	  ClassNotFoundException {
		String command,city,cityFrom,cityTo,fileName,selection;
		
		SigmaAir sigma;
		/**
		 * Opens the sigma_air.obj if it exists.otherwise creates a new object
		 */
		try {
		     FileInputStream file = new FileInputStream("sigma_air.obj");
		     ObjectInputStream fin  = new ObjectInputStream(file);
		     sigma = (SigmaAir) fin.readObject(); 
		     fin.close();
		     System.out.println("Successfully loaded contents of sigma_air.obj."
		       );
		} catch(IOException e){
			System.out.println("sigma_air.obj is not found. New SigmaAir "
			  + "object will be created.");
			sigma=new SigmaAir();
		}
		/**
		 * this is the display menu.
		 */
		System.out.println("");
		System.out.println("(A) Add City");
		System.out.println("(B) Add Connection");
		System.out.println("(C) Load all Cities");
		System.out.println("(D) Load all Connections");
		System.out.println("(E) Print all Cities");
		System.out.println("(F) Print all Connections");
		System.out.println("(G) Remove Connection");
		System.out.println("(H) Find Shortest Path");
		System.out.println("(Q) Quit");
		System.out.println("");
		System.out.print("Enter a selection:");
		Scanner input= new Scanner(System.in);
		command=input.nextLine();
		
		while(!command.equalsIgnoreCase("Q")) {
			/**
			 * adds the city to the sigma object
			 */
			if(command.equalsIgnoreCase("A")) {
				System.out.print("Enter the name of the city: ");
				city=input.nextLine();
				sigma.addCity(city);
			}
			/**
			 * adds connection between two cities
			 */
			else if(command.equalsIgnoreCase("B")) {
				System.out.print("Enter source city: ");
				cityFrom=input.nextLine();
				System.out.print("Enter destination city: ");
				cityTo=input.nextLine();
				sigma.addConnection(cityFrom, cityTo);
			}
			/**
			 * loads files for cities
			 */
			else if(command.equalsIgnoreCase("C")) {
				System.out.print("Enter the file name: ");
				fileName=input.nextLine();
				sigma.loadAllCities(fileName);
			}
			/**
			 * loads file for connections
			 */
			else if(command.equalsIgnoreCase("D")) {
				System.out.print("Enter the file name: ");
				fileName=input.nextLine();
				sigma.loadAllConnections(fileName);
			}
			/**
			 * prints all cities depending on the sorts
			 */
			else if(command.equalsIgnoreCase("E")) {
				System.out.println("(EA) Sort Cities by Name");
				System.out.println("(EB) Sort Cities by Latitude");
				System.out.println("(EC) Sort Cities by Longitude");
				System.out.println("(Q) Quit");
				System.out.println("");
				System.out.print("Enter a selection: ");
				selection=input.nextLine();
				System.out.println("");
				while(!(selection.equalsIgnoreCase("Q"))) {
					if(selection.equalsIgnoreCase("EA")) {
						sigma.printAllCities(new NameComparator());
					}
					else if(selection.equalsIgnoreCase("EB")) {
						sigma.printAllCities(new LatComparator());
					}
					else if(selection.equalsIgnoreCase("EC")) {
						sigma.printAllCities(new LngComparator());
					}
					System.out.println("");
					System.out.println("(EA) Sort Cities by Name");
					System.out.println("(EB) Sort Cities by Latitude");
					System.out.println("(EC) Sort Cities by Longitude");
					System.out.println("(Q) Quit");
					System.out.println("");
					System.out.print("Enter a selection: ");
					selection=input.nextLine();
					System.out.println("");
				}
			}
			/**
			 * prints all connections
			 */
			else if(command.equalsIgnoreCase("F")) {
				sigma.printAllConnections();
			}
			/**
			 * removes a connection
			 */
			else if(command.equalsIgnoreCase("G")) {
				System.out.print("Enter source city: ");
				cityFrom=input.nextLine();
				System.out.print("Enter destination city: ");
				cityTo=input.nextLine();
				sigma.removeConnection(cityFrom, cityTo);
			}
			/**
			 * gives the shortest path between two cities
			 */
			else if(command.equalsIgnoreCase("H")) {
				System.out.print("Enter source city: ");
				cityFrom=input.nextLine();
				System.out.print("Enter destination city: ");
				cityTo=input.nextLine();
				System.out.println(sigma.shortestPath(cityFrom, cityTo));
			}
			System.out.println("");
			System.out.println("(A) Add City");
			System.out.println("(B) Add Connection");
			System.out.println("(C) Load all Cities");
			System.out.println("(D) Load all Connections");
			System.out.println("(E) Print all Cities");
			System.out.println("(F) Print all Connections");
			System.out.println("(G) Remove Connection");
			System.out.println("(H) Find Shortest Path");
			System.out.println("(Q) Quit");
			System.out.println("");
			System.out.print("Enter a selection:");
			command=input.nextLine();
		}
		/**
		 * saves the sigma_air.obj
		 */
		try {
		      FileOutputStream file = new FileOutputStream("sigma_air.obj");
		      ObjectOutputStream fout = new ObjectOutputStream(file);
		      fout.writeObject(sigma); 
		      fout.close();
		      System.out.println("");
		      System.out.println("SigmaAir object saved into file "
		        + "sigma_air.obj.");
		} catch (IOException e){
			
		}
		System.out.println("Program terminating...");
		System.exit(0);
	}
}
