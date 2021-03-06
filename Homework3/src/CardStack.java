/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *This class is used to store objects of Card into a CardStack
 */
import java.util.Stack;

public class CardStack {
	char ch;
	
	Stack<Card> stack ;
	/**
	 * this is a default constructor which is used to create a stack of cards
	 */
	public CardStack() {
		stack = new Stack<Card>();
	}
	/**
	 * this constructor creates a new cardStack and saves the character value 
	 * of the stack
	 * @param ch
	 */
	public CardStack(char ch) {
		stack = new Stack<Card>();
		this.ch=ch;
	}
	/**
	 * this method adds a card in the top of the stack
	 * @param newCard
	 */
	public void push(Card newCard) {
		stack.push(newCard);
	}
	/**
	 * this method removes a card from the top of the stack
	 * @return
	 */
	public Card pop() {
		return stack.pop();
	}
	/**
	 * this method peeks at the top of the stack
	 * @return card
	 */
	public Card peek() {
		return stack.peek();
	}
	/**
	 * this method checks if the stack is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	/**
	 * this method returns the size of the stack
	 * @return size
	 */
	public int size() {
		return stack.size();
	}
	/**
	 * this method prints the specified stack depending on the char value of 
	 * the stack
	 * @param type
	 */
	public void printStack(char type) {
		if(type=='s') {
			if(stack.isEmpty()) {
				System.out.print("[  ]");
			}
			else {
				stack.peek().setFaceUp(false);
				System.out.print("["+stack.peek()+"]");
			}	
		}
		else if (type=='w') {
			stack.peek().setFaceUp(true);
			System.out.print("W1 ["+stack.peek()+"]");
		}
		else if (type=='f') {
			stack.peek().setFaceUp(true);
			System.out.print("["+stack.peek()+"]");
		}
		else if (type=='t') {
			if(stack.isEmpty()) {
				System.out.println("[  ]");
			}
			else {
				Card tempCard= new Card();
				stack.peek().setFaceUp(true);
			
				Stack<Card> tempStack = new Stack<Card>();
			
				while(stack.size()>0) {
					tempStack.push(stack.pop());
				}
				while(tempStack.size()>0) {
					stack.push(tempStack.peek());
					System.out.print("["+tempStack.pop()+"]");
				}
				System.out.println("");
			}	
		}
	}
}
