/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 */
/**
 * 
			// program should suggest the "best" move and show the changes on
			// move program has selected. 
			else if(command1.equalsIgnoreCase("Best")) {
				boolean movedCard = false;
				int x=1;
				//goes through all codes once and then loop ends
				while(x>0) {
					
					 // removes card from the top of wasteList and places on 
					 // top of tableauList.tableauList can range from 1-7
					 
					for(int i=0;i<7;i++) {
						if(tableauList[i].isEmpty()==true && wasteList[0].
						  isEmpty()==false && wasteList[0].peek()
						  .getValue()==13) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been 
							  selected.");
							System.out.println(" ");
							winningBoard();
						}
						else if(wasteList[0].isEmpty()==false && tableauList[i]
						  .isEmpty()==false && wasteList[0].peek().isRed()!=
						  tableauList[i].peek().isRed() && wasteList[0].peek()
						  .getValue()+1==tableauList[i].peek().getValue()) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been 
							  selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					
					 // removes card from the top of wasteList and places on 
					 //top of foundationList.foundationList can range from 1-4
					 
					for(int i=0;i<4;i++) {
						if(foundationList[i].isEmpty()==true&& wasteList[0]
						  .isEmpty()==false && wasteList[0].peek()
						  .getValue()==1) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been 
							  selected.");
							System.out.println(" ");
							winningBoard();
						}	
						else if(wasteList[0].isEmpty()==false && 
						  foundationList[i].isEmpty()==false && wasteList[0].
						  peek().getSuit()==foundationList[i].peek().getSuit()
						  && wasteList[0].peek().getValue()==foundationList[i]
						  .peek().getValue()+1 ) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been 
							  selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					
					//  moves n cards from one tableauList to another 
					//  tableauList.TableauList can range from 1-7
					 
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
							if(i!=j) {
								int count=0;
								boolean tester= true;
								
								 // moves n cards from tableauList[i] to
								 // tableauList[j].
								  //if tableau is empty ,then only king is 
								  //placed first and all cards after that.if 
								  //first stack has king and no card before 
								  //king,then no move is taken.
								 
								if(tableauList[j].isEmpty()==true && 
								  tableauList[i].isEmpty()==false) {
									Stack<Card> tempCardStack=new 
									  Stack<Card>();
									while(tableauList[i].peek().isFaceUp()==
									  true) {
										tempCardStack.push(tableauList[i]
										  .pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false && 
									  tester) {
										if(tempCardStack.peek().getValue()==13 
										  ) {
											if(tableauList[i].isEmpty()==false)
											   {
												while(tempCardStack.isEmpty()==
												  false) {
													tableauList[j].push(
													  tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+
												  (i+1)+" T"+(j+1)+" "+count+" 
												  has been selected.");
												System.out.println(" ");
												winningBoard();
											}
											else {
												while(tempCardStack.isEmpty
												  ()==false) {
													tableauList[i].push
													(tempCardStack.pop());
												}
												tester=true;
											}
										}
										if(movedCard==true) break;
									}
								}
								
								//  moves n cards from one tableau to another 
								// if the condition is met.
								 
								else if(tableauList[i].isEmpty()==false && 
								  tableauList[j].isEmpty()==false ) {
								
									Stack<Card> tempCardStack=new Stack<Card>
									  ();
									
									while(tableauList[i].peek().isFaceUp()==
									  true) {
										tempCardStack.push(tableauList[i]
										  .pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false 
									  &&tester) {
										if(tempCardStack.peek().isRed()!=
										  tableauList[j].peek().isRed() && 
										  tempCardStack.peek().getValue()+1==
										  tableauList[j].peek().getValue()) {
											if(tableauList[i].isEmpty()==false
											   ) {	
												while(tempCardStack.isEmpty()==
												  false) {
													tableauList[j].push(
													  tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+
												  (i+1)+" T"+(j+1)+" "+count+" 
												  has been selected.");
												System.out.println(" ");
												  winningBoard();
											}	
										}
										else {
											while(tempCardStack.isEmpty()==
											  false) {
												tableauList[i].push(
												  tempCardStack.pop());
											}
											tester=true;
										}
									}
									if(movedCard==true) break;
								}
								if(movedCard==true) break;
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
				
					//moves one card from one tableauList to another 
					 //tableauList.TableauList can range from 1-7
					 
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
						
							//ignores the move if card is moved to the same 
							//stack where the card came from
							 
							if(i!=j) {
								
								// if tableau is empty ,then only king is moved
								 
								if(tableauList[j].isEmpty()==true && 
								  tableauList[i].isEmpty()==false && 
								    tableauList[i].peek().getValue()==13 ) {
									Stack<Card> tempCardStack=new 
									  Stack<Card>();
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {
										if(tableauList[i].peek().isFaceUp()==
										  false) {
											tableauList[i].push(tempCardStack
											  .pop());
											tableauList[j].push(tableauList[i]
											  .pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+
											  " T"+(j+1)+" has been selected.")
											  ;
											System.out.println(" ");
											winningBoard();
										}
									}	
									else tableauList[i].push(tempCardStack.
									  pop());
								}
								
							 	//moves one tableau to another
								 
								else if(tableauList[i].isEmpty()==false &&
								   tableauList[j].isEmpty()==false && 
								   tableauList[i].peek().isRed()!=
								   tableauList[j].peek().isRed() && tableauList
								   [i].peek().getValue()+1==tableauList[j]
								   .peek().getValue() ) {
									Stack<Card> tempCardStack=new Stack<Card>()
									  ;
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {	
										if(tableauList[i].peek().isFaceUp()==
										  false) {
											tableauList[i].push(tempCardStack.
											  pop());
											tableauList[j].push(tableauList[i]
											  .pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+
											  " T"+(j+1)+" has been selected.");
											System.out.println(" ");
											winningBoard();
										}	
									}
									else {
										tableauList[j].push(tempCardStack
										  .pop());
									}
								}
								if(movedCard==true) break;
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}	
					if(movedCard==true) break;
					
					//moves one card from tableaulist to foundationList.
					//tableauList can range from 1-7 and foundationList 
					//can range from 1-4
					 
					for(int i=0;i<7;i++) {
						for(int j=0;j<4;j++) {
							
						//if foundation is empty,only Ace card can be placed
							 
							if(foundationList[j].isEmpty()==true&& 
							  tableauList[i].isEmpty()==false && tableauList[i]
							  .peek().getValue()==1 ) {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==false)
									   {
										tableauList[i].push(tempCardStack
										  .pop());
										foundationList[j].push(tableauList
										  [i].pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+
										  " F"+(j+1)+" has been selected.");
										System.out.println(" ");
										winningBoard();
									}	
								}
								else tableauList[i].push(tempCardStack.pop());
							}
							
							//cards will be moved in ascending order from 
							//tableau to foundation
							 
							else if(tableauList[i].isEmpty()==false && 
							foundationList[j].isEmpty()==false && foundation
							List[j].peek().getSuit()==tableauList[i].peek().
							getSuit() && foundationList[j].peek().getValue()
							+1==tableauList[i].peek().getValue()) {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==
									  false) {
										tableauList[i].push(tempCardStack
										  .pop());
										foundationList[j].push(tableauList[i]
										  .pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+" F"+
										  (j+1)+" has been selected.");
										System.out.println(" ");
										winningBoard();
									}	
								}
								else tableauList[i].push(tempCardStack.pop());
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					
					//draws a card from stockList and places it on top of 
					 //wasteList		
					 
					if(stockList[0].isEmpty()) {
						
						//if the stocklist is empty,move all card from 
						//wastelist to stocklist
						 
						while(wasteList[0].size()>0) {
							stockList[0].push(wasteList[0].pop());
						}
						wasteList[0].push(stockList[0].pop());
						movedCard=true;
						display();
						System.out.println("Draw has been selected.");
						System.out.println(" ");
						winningBoard();
					}
					else{
						
						//draws a card from stockList and places it on top
						// of wasteList
						
						wasteList[0].push(stockList[0].pop());
						movedCard=true;
						display();
						System.out.println("Draw has been selected.");
						System.out.println(" ");
						winningBoard();
					}
					x=0;
				}
			}
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
/**
*The main method runs a menu driven application which first creates stacks 
*tableauList,wastestack,stockList,FoundationList and then prompts the user 
*for a command selecting the operation. Once an operation is selected, the 
*program prompts for any additional information required to perform the 
*operation, and then actually performs the operation.
*@param args
*/
public class Stacktoire {
    //creating CardStacks
	public static CardStack[] tableauList ;
	public static CardStack[] foundationList ;
	public static CardStack[] stockList ;
	public static CardStack[] wasteList ;
	public static ArrayList<Card> deck;
	public static CardStack mainStack;

	public static void main(String[] args) {
		initialize();
		display();
		Scanner input;
		input = new Scanner(System.in);
		String command,command1,command2,command3;
		String str1,str2;
		int number1,number2;
		int nCards;
		
		System.out.print("Enter a command: ");
		command1=input.next();
		/**
		 * terminates the program if quit is chosen.
		 */
		while(!command1.equalsIgnoreCase("quit")) {
			/**
			 * Removes the top card from the stock pile and places it face 
			 * up in the waste pile. 
			 */
			if(command1.equalsIgnoreCase("draw")) {
				if(stockList[0].isEmpty()) {
					while(wasteList[0].size()>0) {
						stockList[0].push(wasteList[0].pop());
					}
					wasteList[0].push(stockList[0].pop());
				}
				else{
					wasteList[0].push(stockList[0].pop());
				}
				display();
				winningBoard();
			}
			/**
			 * Removes cards from one stack to another depending on the command
			 */
			else if(command1.equalsIgnoreCase("move")) {
			
				command2=input.next();
				command3=input.next();
				str1=Character.toString(command2.charAt(0));
				str2=Character.toString(command3.charAt(0));
				number1=Character.getNumericValue(command2.charAt(1));
				number2=Character.getNumericValue(command3.charAt(1));
				/**
				 * Removes the top card from the waste pile, and places it on 
				 * top of tableau pile #2. The third argument of this command 
				 * can range from T1-T7, and F1-F4.
				 */
				if(str1.equalsIgnoreCase("w")) {	
					if(str2.equalsIgnoreCase("t")) {
						if(tableauList[number2-1].isEmpty()==true && 
						  wasteList[0].isEmpty()==false && wasteList[0].peek()
						  .getValue()==13 && number2<=7 && number2>0) {
							tableauList[number2-1].push(wasteList[0].pop());
							display();
							winningBoard();
						}
						else if(wasteList[0].isEmpty()==false && tableauList
						  [number2-1].isEmpty()==false && wasteList[0].peek()
						  .isRed()!=tableauList[number2-1].peek().isRed() && 
						  wasteList[0].peek().getValue()+1==tableauList
						  [number2-1].peek().getValue() && number2<=7 && 
						  number2>0) {
							tableauList[number2-1].push(wasteList[0].pop());
							display();
							winningBoard();
						}
						else System.out.println("This move is not allowed.");
					}
					else if(str2.equalsIgnoreCase("f")) {
						if(foundationList[number2-1].isEmpty()==true&& 
						  wasteList[0].isEmpty()==false && wasteList[0]
						  .peek().getValue()==1 && number2<=4 &&
						  number2>0) {
							foundationList[number2-1].push(wasteList[0].pop());
							display();
							winningBoard();
						}	
						else if(wasteList[0].isEmpty()==false && foundationList
						  [number2-1].isEmpty()==false && wasteList[0].peek().
						  getSuit()==foundationList[number2-1].peek().getSuit()
						  && wasteList[0].peek().getValue()==foundationList
						  [number2-1].peek().getValue()+1 &&  number2<=4 && 
						  number2>0) {
							foundationList[number2-1].push(wasteList[0].pop());
							display();
							winningBoard();
						}
						else System.out.println("This move is not allowed.");
					}
				}
				/**
				 * Removes the top card from foundation pile #1, and places it
				 *  on top of tableau pile #5. The second argument of this 
				 *  command can range from F1-F4. The third argument of this 
				 *  command can range from T1-T7.
				 */
				else if(str1.equalsIgnoreCase("f")) {	
					if(str2.equalsIgnoreCase("t")) {
						if(tableauList[number2-1].isEmpty()==true && 
						  foundationList[number1-1].isEmpty()==false && 
						  foundationList[number1-1].peek().getValue()==13 
						  &&  number2<=7 && number2>0 &&  number1<=4 && 
						  number1>0) {
							tableauList[number2-1].push(foundationList
							  [number1-1].pop());
							display();
							winningBoard();
						}
					    else if(foundationList[number1-1].isEmpty()==false 
					      && tableauList[number2-1].isEmpty()==false &&
					      foundationList[number1-1].peek().isRed()!=tableauList
					      [number2-1].peek().isRed() && foundationList
					      [number1-1].peek().getValue()+1==tableauList
					      [number2-1].peek().getValue() &&  number2<=7
					      && number2>0 &&  number1<=4 && number1>0 ) {
							tableauList[number2-1].push(foundationList
							  [number1-1].pop());
							display();
							winningBoard();
						}
						else System.out.println("This move is not allowed.");
					}
				}
				/**
				 * Removes the top card from the tableau pile #1, and places 
				 * it on top of foundation pile #1. The second argument of this
				 *  command can range from T1-T7. The third argument of this 
				 *  command can range from F1-F4 or T1-T7.
				 */
				else if(str1.equalsIgnoreCase("t")) {	
					if(str2.equalsIgnoreCase("t")) {
						if(tableauList[number2-1].isEmpty()==true && 
						  tableauList[number1-1].isEmpty()==false && 
						  tableauList[number1-1].peek().getValue()==
						  13 && number2<=7 && number2>0 &&  number1<=7
						  && number1>0) {
							tableauList[number2-1].push(tableauList
							  [number1-1].pop());
							display();
							winningBoard();
						}
						else if(tableauList[number1-1].isEmpty()==false && 
						  tableauList[number2-1].isEmpty()==false && 
						  tableauList[number1-1].peek().isRed()!=tableauList
						  [number2-1].peek().isRed() && tableauList[number1-1]
						  .peek().getValue()+1==tableauList[number2-1]
						  .peek().getValue() && number2<=7 && 
						  number2>0 &&  number1<=7 && number1>0) {
							tableauList[number2-1].push(tableauList[number1-1]
							  .pop());
							display();
							winningBoard();
						}
						else System.out.println("This move is not allowed.");
					}
					else if(str2.equalsIgnoreCase("f")) {
						if(foundationList[number2-1].isEmpty()==true&& 
						  tableauList[number1-1].isEmpty()==false && 
						  tableauList[number1-1].peek().getValue()==1 
						  && number2<=4 && number2>0 &&  number1<=7 &&
						  number1>0 ) {
							foundationList[number2-1].push(tableauList
							  [number1-1].pop());
							display();
							winningBoard();
						}
						else if(tableauList[number1-1].isEmpty()==false && 
						  foundationList[number2-1].isEmpty()==false && 
						  foundationList[number2-1].peek().getSuit()==
						  tableauList[number1-1].peek().getSuit() && 
						  foundationList[number2-1].peek().getValue()+1==
						  tableauList[number1-1].peek().getValue() && number2
						  <=4 && number2>0 &&  number1<=7 && number1>0) {
							foundationList[number2-1].push(tableauList
							  [number1-1].pop());
							display();
							winningBoard();
						}
						else System.out.println("This move is not allowed.");
					}
				}
			}
			/**
			 * Removes the top n cards, where n is the value of the fourth
			 *  argument, from the tableau pile #3, and places them on top 
			 *  of tableau pile #2. The second and third arguments of this
			 *   command can range from T1-T7.
			 */
			else if(command1.equalsIgnoreCase("moveN")) {
			
				command2=input.next();
				command3=input.next();
				nCards = input.nextInt();
				
				str1=Character.toString(command2.charAt(0));
				str2=Character.toString(command3.charAt(0));
				number1=Character.getNumericValue(command2.charAt(1));
				number2=Character.getNumericValue(command3.charAt(1));
				
				Stack<Card> tempStack = new Stack<Card>();
				if(str1.equalsIgnoreCase("t")) {
					if(str2.equalsIgnoreCase("t")) {
						if(tableauList[number1-1].size()>=nCards &&tableauList
						  [number2-1].isEmpty()==true && tableauList[number1-1]
						  .isEmpty()==false && number2<=7 && number2>0 &&  
						  number1<=7 && number1>0) {
							for(int i=0;i<nCards;i++) {
								tempStack.push(tableauList[number1-1].pop());
							}
							if(tempStack.peek().getValue()==13) {
								for(int i=0;i<nCards;i++) {
									tableauList[number2-1].push(tempStack
									.pop());
								}
								display();
								winningBoard();
							}
							else {
								for(int i=0;i<nCards;i++) {
									tableauList[number1-1].push(tempStack
									.pop());
								}
								System.out.println("This move is not allowed."
								  );
							}
						}
						else if(tableauList[number1-1].size()>=nCards && 
						  tableauList[number2-1].isEmpty()==false &&tableauList
						  [number1-1].isEmpty()==false && number2<=7 && 
						  number2>0 &&  number1<=7 && number1>0) {
							for(int i=0;i<nCards;i++) {
								tempStack.push(tableauList[number1-1].pop());
							}
							if(tempStack.peek().getValue()+1==tableauList
							  [number2-1].peek().getValue() && tempStack.
							  peek().isRed()!=tableauList[number2-1].peek()
							  .isRed()) {
								for(int i=0;i<nCards;i++) {
									tableauList[number2-1].push(tempStack
									  .pop());
								}
								display();
								winningBoard();
							}
							else {
								for(int i=0;i<nCards;i++) {
									tableauList[number1-1].push(tempStack
									  .pop());
								}
								System.out.println("This move is not "
								  + "allowed.");
							}
						}
						else System.out.println("This move is not allowed.");
					}
				}	
			}
			/**
			 * Prompts the player to end the game and start a new one. If the 
			 * player chooses yes, initialize a new game board, else, continue
			 *  with the current.
			 */
			else if(command1.equalsIgnoreCase("restart")) {
				System.out.print("Do you want to start a new game? (Y/N): ");
				command=input.next();
				if(command.equalsIgnoreCase("Y")) {
					initialize();
					display();
				}
			}
			/**
			 * program should suggest the "best" move and show the changes on
			 *  the screen after the move. Also display a message to show what 
			 *  move program has selected. 
			 */
			else if(command1.equalsIgnoreCase("Best")) {
				boolean movedCard = false;
				int x=1;
				//goes through all codes once and then loop ends
				while(x>0) {
					/**
					 * removes card from the top of wasteList and places on top
					 *  of tableauList.tableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						if(tableauList[i].isEmpty()==true && wasteList[0]
						  .isEmpty()==false && wasteList[0].peek().
						  getValue()==13) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been"
							  + " selected.");
							System.out.println(" ");
							winningBoard();
						}
						else if(wasteList[0].isEmpty()==false && tableauList[i]
						  .isEmpty()==false && wasteList[0].peek().isRed()!=
						  tableauList[i].peek().isRed() && wasteList[0].peek()
						  .getValue()+1==tableauList[i].peek().getValue()) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been "
							  + "selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * removes card from the top of wasteList and places on 
					 * top of foundationList.foundationList can range from 1-4
					 */
					for(int i=0;i<4;i++) {
						if(foundationList[i].isEmpty()==true&& wasteList[0]
								.isEmpty()==false && wasteList[0].peek()
								.getValue()==1) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been "
							  + "selected.");
							System.out.println(" ");
							winningBoard();
						}	
						else if(wasteList[0].isEmpty()==false && foundationList
						  [i].isEmpty()==false && wasteList[0].peek().getSuit()
						  ==foundationList[i].peek().getSuit() && wasteList[0]
						  .peek().getValue()==foundationList[i].peek()
						  .getValue()+1 ) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been"
							  + " selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * moves n cards from one tableauList to another 
					 * tableauList.TableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
							if(i!=j) {
								int count=0;
								boolean tester= true;
								/**
								 * moves n cards from tableauList[i] to 
								 * tableauList[j].
								 * if tableau is empty ,then only king is 
								 * placed first and all cards after that.if 
								 * first stack has king and no card before 
								 * king,then no move is taken.
								 */
								if(tableauList[j].isEmpty()==true && 
								  tableauList[i].isEmpty()==false) {
									Stack<Card> tempCardStack=new Stack<Card>()
									  ;
									while(tableauList[i].peek().isFaceUp()==
									  true) {
										tempCardStack.push(tableauList[i]
												.pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false && 
									  tester) {
										if(tempCardStack.peek().getValue()
										  ==13 ) {
											if(tableauList[i].isEmpty()==
											false) {
												while(tempCardStack.isEmpty()
												  ==false) {
													tableauList[j].push
													(tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+
												  (i+1)+" T"+(j+1)+" "+count+""
												  + " has been selected.");
												System.out.println(" ");
												winningBoard();
											}
											else {
												while(tempCardStack.isEmpty()
												  ==false) {
													tableauList[i].push
													(tempCardStack.pop());
												}
												tester=true;
											}
										}
										if(movedCard==true) break;
									}
								}
								/**
								 * moves n cards from one tableau to another
								 *  if the condition is met.
								 */
								else if(tableauList[i].isEmpty()==false && 
								  tableauList[j].isEmpty()==false ) {
								
									Stack<Card> tempCardStack=new Stack<Card>
									  ();
									
									while(tableauList[i].peek().isFaceUp()==
									  true) {
										tempCardStack.push(tableauList[i]
										  .pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false &&
									  tester) {
										if(tempCardStack.peek().isRed()!=
										  tableauList[j].peek().isRed() && 
										  tempCardStack.peek().getValue()+1
										  ==tableauList[j].peek().getValue())
										  {
											if(tableauList[i].isEmpty()==false)
											  {	
												while(tempCardStack.isEmpty()==
											      false) {
													tableauList[j].push
													  (tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+
												  (i+1)+" T"+(j+1)+" "+count+
												  " has been selected.");
												System.out.println(" ");
												winningBoard();
											}	
										}
										else {
											while(tempCardStack.isEmpty()==
											  false) {
												tableauList[i].push
												  (tempCardStack.pop());
											}
											tester=true;
										}
									}
									if(movedCard==true) break;
								}
								if(movedCard==true) break;
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * moves one card from one tableauList to another 
					 * tableauList.TableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
							/**
							 * ignores the move if card is moved to the same
							 *  stack where the card came from
							 */
							if(i!=j) {
								/**
								 * if tableau is empty ,then only king is moved
								 */
								if(tableauList[j].isEmpty()==true &&tableauList
								  [i].isEmpty()==false && tableauList[i].peek()
								  .getValue()==13 ) {
									Stack<Card> tempCardStack=new Stack<Card>
									  ();
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {
										if(tableauList[i].peek().isFaceUp()==
										  false) {
											tableauList[i].push(tempCardStack.
											  pop());
											tableauList[j].push(tableauList[i]
											  .pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+
											  " T"+(j+1)+" has been selected.")
											  ;
											System.out.println(" ");
											winningBoard();
										}
									}	
									else tableauList[i].push(tempCardStack
									  .pop());
								}
								/**
								 * moves one tableau to another
								 */
								else if(tableauList[i].isEmpty()==false && 
								  tableauList[j].isEmpty()==false && 
								  tableauList[i].peek().isRed()!=tableauList
								  [j].peek().isRed() && tableauList[i].peek()
								  .getValue()+1==tableauList[j].peek()
								  .getValue() ) {
									Stack<Card> tempCardStack=new Stack<Card>
									  ();
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {	
										if(tableauList[i].peek().isFaceUp()==
										  false) {
											tableauList[i].push(tempCardStack
											  .pop());
											tableauList[j].push(tableauList[i]
											  .pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+
											  " T"+(j+1)+" has been selected.")
											  ;
											System.out.println(" ");
											winningBoard();
										}	
									}
									else {
										tableauList[j].push(tempCardStack
										  .pop());
									}
								}
								if(movedCard==true) break;
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}	
					if(movedCard==true) break;
					/**
					 * moves one card from tableaulist to foundationList.
					 * tableauList can range from 1-7 and foundationList 
					 * can range from 1-4
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<4;j++) {
							/**
							 * if foundation is empty,only Ace card can be 
							 * placed
							 */
							if(foundationList[j].isEmpty()==true&& 
							  tableauList[i].isEmpty()==false && tableauList[i]
							  .peek().getValue()==1 ) {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==
									  false) {
										tableauList[i].push(tempCardStack
										  .pop());
										foundationList[j].push(tableauList[i]
										  .pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+" F"
										+(j+1)+" has been selected.");
										System.out.println(" ");
										winningBoard();
									}	
								}
								else tableauList[i].push(tempCardStack.pop());
							}
							/**
							 * cards will be moved in ascending order from 
							 * tableau to foundation
							 */
							else if(tableauList[i].isEmpty()==false && 
							  foundationList[j].isEmpty()==false && 
							  foundationList[j].peek().getSuit()==tableauList
							  [i].peek().getSuit() && foundationList[j].peek()
							  .getValue()+1==tableauList[i].peek().getValue())
							  {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==
									  false) {
										tableauList[i].push(tempCardStack
										  .pop());
										foundationList[j].push(tableauList[i]
										  .pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+" F"
										+(j+1)+" has been selected.");
										System.out.println(" ");
										winningBoard();
									}	
								}
								else tableauList[i].push(tempCardStack.pop());
							}
							if(movedCard==true) break;
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * draws a card from stockList and places it on top of 
					 * wasteList		
					 */
					if(stockList[0].isEmpty()) {
						/**
						 * if the stocklist is empty,move all card from 
						 * wastelist to stocklist
						 */
						while(wasteList[0].size()>0) {
							stockList[0].push(wasteList[0].pop());
						}
						wasteList[0].push(stockList[0].pop());
						movedCard=true;
						display();
						System.out.println("Draw has been selected.");
						System.out.println(" ");
						winningBoard();
					}
					else{
						/**
						 *  draws a card from stockList and places it on 
						 *  top of wasteList
						 */
						wasteList[0].push(stockList[0].pop());
						movedCard=true;
						display();
						System.out.println("Draw has been selected.");
						System.out.println(" ");
						winningBoard();
					}
					x=0;
				}
			}
			
			System.out.print("Enter a command: ");
			command1=input.next();
		}
		/**
		 * terminates the program if quit is chosen
		 */
		System.out.println("Sorry, you lose.");
		System.out.println("  ");
		System.out.println("Program terminating...");
		
		System.exit(0);
	}
	/**
	 * Initializes the game by distributing all cards into the proper stacks.
	 *  First, move all 52 cards from the game stacks into the deck stack. 
	 *  Then, shuffle the deck by using the static method shuffle() in the 
	 *  Collections class. Finally, distribute the correct number of cards 
	 *  into the tableau and stock piles. 
	 */
	public static void initialize() {
		tableauList = new CardStack[7];
		for(int i=0; i<7;i++) {
			tableauList[i]= new CardStack('t');
		}
		foundationList = new CardStack[4];
		for(int i=0;i<4;i++) {
			foundationList[i]=new CardStack('f');
		}
		
		wasteList = new CardStack[1];
		wasteList[0]=new CardStack('w');
		
		stockList = new CardStack[1];
		stockList[0]= new CardStack('s');
		
		deck= new ArrayList<Card>();
		
		mainStack= new CardStack();
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				Card newCard=  new Card(i+1,j+1);
				mainStack.push(newCard);
			}
		}
		
		int index = 0;
		while(index<mainStack.size()) {
			deck.add(mainStack.pop());
		}
		Collections.shuffle(deck);
		int element = 0;
		for(int i=1;i<=7;i++) {
			tableauList[i-1]= new CardStack('t');
			for(int j=1;j<=i;j++) {
				tableauList[i-1].push(deck.get(element));
				element++;
			}
		}
		for(int i=0;i<24;i++) {
			
			stockList[0].push(deck.get(element));
			element++;
		}
	}
	/**
	 * Renders all stacks to produce an image of the game board.
	 */
	public static void display() {
		for(int i=0;i<4;i++) {
			if(foundationList[i].isEmpty()) {
				System.out.print("[F"+(i+1)+"]");
			}
			else foundationList[i].printStack('f');
		}
		System.out.print("     ");
		if(wasteList[0].isEmpty()) {
			System.out.print("W1 [  ]");
		}
		else wasteList[0].printStack('w');
		System.out.print("    ");
		stockList[0].printStack('s');
		System.out.println(" "+stockList[0].size());
		System.out.println("");
		for(int i=6;i>=0;i--) {
			System.out.print("T"+(i+1)+" ");
			tableauList[i].printStack('t');
		}
		System.out.println("");
	}
	/**
	 * check winning board
	 *If all cards are faced up in the board, the player has the ability to 
	 *manually move all cards to the foundation stacks. In other words, this
	 * is a guaranteed win. Iterate through the games stacks to determine the
	 *  face value of all the cards. If all cards are faced up, display a win
	 *   message, and prompt the user to play again.
	 */
	public static void winningBoard() {
		boolean isFaceUp=true;
		for(int i=0;i<52;i++) {
			if(deck.get(i).isFaceUp()==false) {
				isFaceUp=false;
			}
		}
		if(isFaceUp==true) {
			System.out.println("You Win....Initializing a new game.");
			initialize();
			display();
		}
	}
}