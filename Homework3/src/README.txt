
/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 */
/**
			 * program should suggest the "best" move and show the changes on the screen after the move. Also display a message to show what move program has selected. 
			 */
			else if(command1.equalsIgnoreCase("Best")) {
				boolean movedCard = false;
				int x=1;
				//goes through all codes once and then loop ends
				while(x>0) {
					/**
					 * removes card from the top of wasteList and places on top of tableauList.tableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						if(tableauList[i].isEmpty()==true && wasteList[0].isEmpty()==false && wasteList[0].peek().getValue()==13) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been selected.");
							System.out.println(" ");
							winningBoard();
						}
						else if(wasteList[0].isEmpty()==false && tableauList[i].isEmpty()==false && wasteList[0].peek().isRed()!=tableauList[i].peek().isRed() && wasteList[0].peek().getValue()+1==tableauList[i].peek().getValue()) {
							tableauList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 T"+(i+1)+" has been selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * removes card from the top of wasteList and places on top of foundationList.foundationList can range from 1-4
					 */
					for(int i=0;i<4;i++) {
						if(foundationList[i].isEmpty()==true&& wasteList[0].isEmpty()==false && wasteList[0].peek().getValue()==1) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been selected.");
							System.out.println(" ");
							winningBoard();
						}	
						else if(wasteList[0].isEmpty()==false && foundationList[i].isEmpty()==false && wasteList[0].peek().getSuit()==foundationList[i].peek().getSuit() && wasteList[0].peek().getValue()==foundationList[i].peek().getValue()+1 ) {
							foundationList[i].push(wasteList[0].pop());
							movedCard=true;
							display();
							System.out.println("Move W1 F"+(i+1)+" has been selected.");
							System.out.println(" ");
							winningBoard();
						}
						if(movedCard==true) break;
					}
					if(movedCard==true) break;
					/**
					 * moves n cards from one tableauList to another tableauList.TableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
							if(i!=j) {
								int count=0;
								boolean tester= true;
								/**
								 * moves n cards from tableauList[i] to tableauList[j].
								 * if tableau is empty ,then only king is placed first and all cards after that.if first stack has king and no card before king,then no move is taken.
								 */
								if(tableauList[j].isEmpty()==true && tableauList[i].isEmpty()==false) {
									Stack<Card> tempCardStack=new Stack<Card>();
									while(tableauList[i].peek().isFaceUp()==true) {
										tempCardStack.push(tableauList[i].pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false && tester) {
										if(tempCardStack.peek().getValue()==13 ) {
											if(tableauList[i].isEmpty()==false) {
												while(tempCardStack.isEmpty()==false) {
													tableauList[j].push(tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+(i+1)+" T"+(j+1)+" "+count+" has been selected.");
												System.out.println(" ");
												winningBoard();
											}
											else {
												while(tempCardStack.isEmpty()==false) {
													tableauList[i].push(tempCardStack.pop());
												}
												tester=true;
											}
										}
										if(movedCard==true) break;
									}
								}
								/**
								 * moves n cards from one tableau to another if the condition is met.
								 */
								else if(tableauList[i].isEmpty()==false && tableauList[j].isEmpty()==false ) {
								
									Stack<Card> tempCardStack=new Stack<Card>();
									
									while(tableauList[i].peek().isFaceUp()==true) {
										tempCardStack.push(tableauList[i].pop());
										count++;
										if(tableauList[i].isEmpty()) break;
									}
									while(tempCardStack.isEmpty()==false &&tester) {
										if(tempCardStack.peek().isRed()!=tableauList[j].peek().isRed() && tempCardStack.peek().getValue()+1==tableauList[j].peek().getValue()) {
											if(tableauList[i].isEmpty()==false ) {	
												while(tempCardStack.isEmpty()==false) {
													tableauList[j].push(tempCardStack.pop());
												}
												movedCard=true;
												display();
												System.out.println("MoveN T"+(i+1)+" T"+(j+1)+" "+count+" has been selected.");
												System.out.println(" ");
												winningBoard();
											}	
										}
										else {
											while(tempCardStack.isEmpty()==false) {
												tableauList[i].push(tempCardStack.pop());
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
					 * moves one card from one tableauList to another tableauList.TableauList can range from 1-7
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<7;j++) {
							/**
							 * ignores the move if card is moved to the same stack where the card came from
							 */
							if(i!=j) {
								/**
								 * if tableau is empty ,then only king is moved
								 */
								if(tableauList[j].isEmpty()==true && tableauList[i].isEmpty()==false && tableauList[i].peek().getValue()==13 ) {
									Stack<Card> tempCardStack=new Stack<Card>();
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {
										if(tableauList[i].peek().isFaceUp()==false) {
											tableauList[i].push(tempCardStack.pop());
											tableauList[j].push(tableauList[i].pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+" T"+(j+1)+" has been selected.");
											System.out.println(" ");
											winningBoard();
										}
									}	
									else tableauList[i].push(tempCardStack.pop());
								}
								/**
								 * moves one tableau to another
								 */
								else if(tableauList[i].isEmpty()==false && tableauList[j].isEmpty()==false && tableauList[i].peek().isRed()!=tableauList[j].peek().isRed() && tableauList[i].peek().getValue()+1==tableauList[j].peek().getValue() ) {
									Stack<Card> tempCardStack=new Stack<Card>();
									tempCardStack.push(tableauList[i].pop());
									if(tableauList[i].isEmpty()==false) {	
										if(tableauList[i].peek().isFaceUp()==false) {
											tableauList[i].push(tempCardStack.pop());
											tableauList[j].push(tableauList[i].pop());
											movedCard=true;
											display();
											System.out.println("Move T"+(i+1)+" T"+(j+1)+" has been selected.");
											System.out.println(" ");
											winningBoard();
										}	
									}
									else {
										tableauList[j].push(tempCardStack.pop());
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
					 * moves one card from tableaulist to foundationList.tableauList can range from 1-7 and foundationList can range from 1-4
					 */
					for(int i=0;i<7;i++) {
						for(int j=0;j<4;j++) {
							/**
							 * if foundation is empty,only Ace card can be placed
							 */
							if(foundationList[j].isEmpty()==true&& tableauList[i].isEmpty()==false && tableauList[i].peek().getValue()==1 ) {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==false) {
										tableauList[i].push(tempCardStack.pop());
										foundationList[j].push(tableauList[i].pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+" F"+(j+1)+" has been selected.");
										System.out.println(" ");
										winningBoard();
									}	
								}
								else tableauList[i].push(tempCardStack.pop());
							}
							/**
							 * cards will be moved in ascending order from tableau to foundation
							 */
							else if(tableauList[i].isEmpty()==false && foundationList[j].isEmpty()==false && foundationList[j].peek().getSuit()==tableauList[i].peek().getSuit() && foundationList[j].peek().getValue()+1==tableauList[i].peek().getValue()) {
								Stack<Card> tempCardStack=new Stack<Card>();
								tempCardStack.push(tableauList[i].pop());
								if(tableauList[i].isEmpty()==false) {	
									if(tableauList[i].peek().isFaceUp()==false) {
										tableauList[i].push(tempCardStack.pop());
										foundationList[j].push(tableauList[i].pop());
										movedCard=true;
										display();
										System.out.println("Move T"+(i+1)+" F"+(j+1)+" has been selected.");
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
					 * draws a card from stockList and places it on top of wasteList		
					 */
					if(stockList[0].isEmpty()) {
						/**
						 * if the stocklist is empty,move all card from wastelist to stocklist
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
						 *  draws a card from stockList and places it on top of wasteList
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