/**
[ * This imports all the predefined scanner classes.
 */
import java.util.Scanner;
/**
 * The CollectionManager Java application tests the data structure 
 * classes designed above and the operations defined on them.
 *
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony Brook ID: 111214466
 */
public class CollectionManager {
	/**
	 * The main method runs a menu driven application which first creates two
	 *  empty CardCollections (referred to by the user as A and B), and then 
	 *  prompts the user for a command selecting the operation. Once an 
	 *  operation is selected, the program prompts for any additional 
	 *  information required to perform the operation, and then actually 
	 *  performs the operation.
	 */
	public static void main(String[] args) {
		CardCollection collectionA = new CardCollection();
		CardCollection collectionB = new CardCollection();
		Scanner input1,input2;
		int y=1;
		String operation,collection,name,manufacturer,toCollection,
		  fromCollection;
		int year,sizeX,sizeY,position,positionA,positionB;
		double price,valueA,valueB;

		/**
		 * Runs the program until operation "Q" is not chosen.
		 */
		do{
			/**
			 * prints all the Main menu commands
			 */
			System.out.println("Main menu :");
			System.out.println(" ");
			System.out.println("A) Add Card");
			System.out.println("C) Copy");
			System.out.println("E) Update price");
			System.out.println("G) Get Card");
			System.out.println("L) Locate Card");
			System.out.println("N) Update Name");
			System.out.println("P) Print All Cards");
			System.out.println("R) Remove Card");
			System.out.println("S) Size");
			System.out.println("T) Trade");
			System.out.println("V) Value of collections");
			System.out.println("Q) Quit");
			System.out.println(" ");
			System.out.print("Select an operation: ");
			input1 = new Scanner(System.in);
			
			operation = input1.nextLine();
			System.out.println(" ");

			try {
					
			/**
		     * Construct and add the card to the indicated collection at the 
			 * indicated position)
			 */
			if(operation.equalsIgnoreCase("A")) {
				BaseballCard newCard = new BaseballCard();
			
				System.out.print("Enter the collection: ");
				collection = input1.nextLine();
				
				System.out.print("Enter the name: ");
				name = input1.nextLine();
				newCard.setName(name);
				
				System.out.print("Enter the manufacturer: ");
				manufacturer = input1.nextLine();
				newCard.setManufacturer(manufacturer);
				
				System.out.print("Enter the year: ");
				year = input1.nextInt();
				newCard.setYear(year);
				
				System.out.print("Enter the Size: ");
				sizeX = input1.nextInt();
				newCard.setSizeX(sizeX);
				sizeY = input1.nextInt();
			    newCard.setSizeY(sizeY);
			    
				System.out.print("Enter the price: ");
				price = input1.nextDouble();
				newCard.setPrice(price);
				
				System.out.print("Enter the position: ");
				position = input1.nextInt();
				
				System.out.println(" ");
				
				if(collection.equalsIgnoreCase("A")) {
					collectionA.addCard(newCard, position);
					System.out.println("Added "+name+","+manufacturer+year+","
					  +sizeX+"x"+sizeY+", $"+price+" at position "+position
					  +" of collection A");
				}
				else if (collection.equalsIgnoreCase("B")){
					collectionB.addCard(newCard, position);
					System.out.println("Added "+name+","+manufacturer+year+","
					  +sizeX+"x"+sizeY+", $"+price+" at position "+position
					  +" of collection B");
				}
				System.out.println(" ");
			}
			/**
			 * Print out the name, manufacturer, year, and price of the card at
			 *  the specified position in the indicated collection
			 */
			else if(operation.equalsIgnoreCase("G")) {
				System.out.print("Enter the collection: ");
				collection = input1.nextLine();
				
				System.out.print("Enter ther Position: ");
				position = input1.nextInt();
				
				System.out.println(" ");
			
				if(collection.equalsIgnoreCase("A")) {	
		    		System.out.printf("%-4s%-26s%-20s%-6s%-10s%-9s%n","#",
		    		  "Name","Manufacturer","Year","Price","Size");
		    		System.out.printf("%-4s%-26s%-20s%-6s%-10s%-9s%n","--",
		    		  "----","------------","----","-----","----");
		    		System.out.printf("%-4d",position);
		    		System.out.println(collectionA.list[position-1]);
					
				}	
				else if (collection.equalsIgnoreCase("B")){
					System.out.printf("%-4s%-26s%-20s%-6s%-10s%+9s%n","#",
					  "Name","Manufacturer","Year","Price","Size");
					System.out.printf("%-4s%-26s%-20s%-6s%-10s%+9s%n","--",
					  "----","------------","----","-----","----");
					System.out.printf("%-4d",position);
					System.out.println(collectionB.list[position-1]);
				}
			}
			/**
			 *Remove the card at the specified position in the indicated
			 * collection) 
			 */
			else if (operation.equalsIgnoreCase("R")) {
				System.out.print("Enter the collection to remove from: ");
				collection = input1.nextLine();
				
				System.out.print("Enter the position to remove: ");
				position = input1.nextInt();
				
				if(collection.equalsIgnoreCase("A")) {
					System.out.println("Removed "+collectionA.list[position-1].
					  getName()+","+collectionA.list[position-1].
					  getManufacturer()+collectionA.list[position-1].getYear()
					  +","+collectionA.list[position-1].getSizeX()+"x"
					  +collectionA.list[position-1].getSizeY()+", $"
					  +collectionA.list[position-1].getPrice()
					  +" from collection "+collection);
					collectionA.removeCard(position);
				}
				else if (collection.equalsIgnoreCase("B")){
					System.out.println("Removed "+collectionB.list[position-1].
					  getName()+","+collectionB.list[position-1].
					  getManufacturer()+collectionB.list[position-1].getYear()
					  +","+collectionB.list[position-1].getSizeX()+"x"
					  +collectionB.list[position-1].getSizeY()+", $"
					  +collectionB.list[position-1].getPrice()
					  +" from collection "+collection);
					collectionB.removeCard(position);
				}
			}
			/**
			 * Print the list of all cards in each collection
			 */
			else if(operation.equalsIgnoreCase("P")) {
				System.out.println("Collection A:");
				System.out.println(" ");
				collectionA.printAllCards();
				System.out.println("Collection B:");
				System.out.println(" ");
				collectionB.printAllCards();
			}
			/**
			 * Construct the card from the input, and print out whether or not 
			 * it exists in either collection. You must use the Card's 
			 * equals() method for comparison.
			 */
			else if(operation.equalsIgnoreCase("L")) {
				BaseballCard newCard = new BaseballCard();
				
				System.out.print("Enter the name: ");
				name = input1.nextLine();
				newCard.setName(name);
				
				System.out.print("Enter the manufacturer: ");
				manufacturer = input1.nextLine();
				newCard.setManufacturer(manufacturer);
				
				System.out.print("Enter the year: ");
				year = input1.nextInt();
				newCard.setYear(year);
				
				System.out.print("Enter the Size: ");
				sizeX = input1.nextInt();
				sizeY = input1.nextInt();
			    newCard.setSizeX(sizeX);
			    newCard.setSizeY(sizeY);
			    
				System.out.print("Enter the price: ");
				price = input1.nextDouble();
				newCard.setPrice(price);
				
				System.out.println(" ");
				
				if(collectionA.exists(newCard)) {
					System.out.print("The card is in collection A. ");
				}
				else System.out.print("The card is not in collection A.");
				if(collectionB.exists(newCard)) {
					System.out.println("The card is in collection B. ");
				}
				else System.out.println("The card is not in collection B. ");
				
				System.out.println(" ");
			}
			/**
			 * Print the number of cards in each collection
			 */
			else if(operation.equalsIgnoreCase("S")) {
				System.out.println("Collection A has "+collectionA.size()
				  +" cards. Collection B has "+collectionB.size()+" cards.");
				System.out.println(" ");
			}
			/**
			 * Print the total value of each collection
			 */
			else if(operation.equalsIgnoreCase("V")) {
				valueA = 0.00;
				valueB = 0.00;
				for(int i=0;i<collectionA.size();i++) {
		            valueA +=collectionA.list[i].getPrice();
				}	
				for(int i=0;i<collectionB.size();i++) {
		            valueB +=collectionB.list[i].getPrice();
				}
				System.out.println("The total value of collection A is $"
				  +Math.round(valueA*100.0)/100.0+". The total value of "
				  + "collection B is $"+Math.round(valueB*100.0)/100.0+".");
				System.out.println(" ");
			}
			/**
			 * Update the name of the card in the indicated position in the 
			 * indicated collection
			 */
			else if(operation.equalsIgnoreCase("N")) {
				System.out.print("Enter the collection: ");
				collection = input1.next();
				
				System.out.print("Enter the position: ");
				position = input1.nextInt();
			    input2= new Scanner(System.in);
				System.out.print("Enter the new name: ");
				name = input2.nextLine();
				
				System.out.println(" ");
				
				if(collection.equalsIgnoreCase("A")) {
					System.out.println("Changed name of collection A position "
				      +position+" from "+collectionA.list[position-1].getName()
				      +" to "+name);
					collectionA.list[position-1].setName(name);
				}
				else if (collection.equalsIgnoreCase("B")) {
					System.out.println("Changed name of collection B position "
				      +position+" from "+collectionB.list[position-1].getName()
				      +" to "+name);
					collectionB.list[position-1].setName(name);
				}
				System.out.println(" ");
			}
			/**
			 * Update the price of the card in the indicated position in the 
			 * indicated collection
			 */
			else if(operation.equalsIgnoreCase("E")) {
				System.out.print("Enter the collection: ");
				collection = input1.nextLine();
				
				System.out.print("Enter the position: ");
				position = input1.nextInt();
				
				System.out.print("Enter the new price: ");
				price = input1.nextDouble();
				
				if(collection.equalsIgnoreCase("A")) {
					collectionA.list[position-1].setPrice(price);
				}
				else if (collection.equalsIgnoreCase("B")) {
					collectionB.list[position-1].setPrice(price);
				}
			}
			/**
			 * Copy the card at the specified position in <From collection> to 
			 * the end of <To collection>, using the card’s clone() method. 
			 */
			else if(operation.equalsIgnoreCase("C")) {
				System.out.print("Enter the collection to copy from: ");
				fromCollection = input1.nextLine();
				
				System.out.print("Enter the position of the card to copy: ");
				position = input1.nextInt();
				
				System.out.print("Enter the collection to copy to: ");
				toCollection = input1.next();
				
				BaseballCard newCard = new BaseballCard();
				
				if(fromCollection.equalsIgnoreCase("A")) {
					newCard = collectionA.list[position-1].clone();
					if(toCollection.equalsIgnoreCase("A")) {
						collectionA.addCard(newCard);
					}
					else if(toCollection.equalsIgnoreCase("B")) {
						collectionB.addCard(newCard);
					}
				}
				if(fromCollection.equalsIgnoreCase("B")) {
					newCard = collectionB.list[position-1].clone();
					if(toCollection.equalsIgnoreCase("A")) {
						collectionA.addCard(newCard);
					}
					else if(toCollection.equalsIgnoreCase("B")) {
						collectionB.addCard(newCard);
					}
				}
				System.out.println(" ");
				System.out.println("Copied "+newCard.getName()+", "+newCard.
				  getManufacturer()+" "+newCard.getYear()+", "+newCard.
				  getSizeX()+"x"+newCard.getSizeY()+", $"+newCard.price
				  +" into position "+position+" of collection "+toCollection);
				System.out.println(" ");
			}
			/**
			 * Exchange the card at position A in collection A with the card at
			 *  position B in collection B
			 */
			else if(operation.equalsIgnoreCase("T")){
				System.out.print("Enter the position of the card to trade from"
				  + " collection A: ");
				positionA = input1.nextInt();
				
				System.out.print("Enter the position of the card to trade from"
				  + " collection B: ");
				positionB = input1.nextInt();
				
				System.out.println("Traded "+collectionB.list[positionB-1]
				  .getName()+", "+collectionB.list[positionB-1]
				  .getManufacturer()+" "+collectionB.list[positionB-1]
				  .getYear()+", "+collectionB.list[positionB-1].getSizeX()+"x"
				  +collectionB.list[positionB-1].getSizeY()+", $"+collectionB
				  .list[positionB-1].getPrice()+" for "+collectionA
				  .list[positionA-1].getName()+", "+collectionA
				  .list[positionA-1].getManufacturer()+" "+collectionA
				  .list[positionA-1].getYear()+", "+collectionA
				  .list[positionA-1].getSizeX()+"x"+collectionA
				  .list[positionA-1].getSizeY()+", $"+collectionA
				  .list[positionA-1].getPrice());
				collectionA.trade(collectionB, positionA, positionB);
			}
			else if(operation.equalsIgnoreCase("Q")) {
				
				System.out.println("Quitting.");
				/**
				 * Terminate the program gracefully
				 */
				System.exit(0);

			}
			}
			catch(InvalidPositionException e) {
				System.out.println(e);
			}
			catch(FullCollectionException e) {
				System.out.println(e);
			}
			catch(InvalidPriceException e) {
				System.out.println(e);
			}	
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		while(y==1);


	}

}
