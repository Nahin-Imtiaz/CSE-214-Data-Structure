/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *This class represents Card which contains suit,value and boolean isFaceUp
 */
public class Card {
	int suit;
	int value;
	boolean isFaceUp=false;
	/**
	 * This is a default constructor for a new empty card.
	 */
	public Card() {
	}
	/**
	 * This constructor is used to create Card with parameter
	 * @param suit
	 * this is the suit value of the car
	 * @param value
	 * this is the int value of the car
	 */
	public Card(int suit,int value) {
		this.suit= suit;
		this.value=value;
	}
	/**
	 * this method returns suit value
	 * @return
	 */
	public int getSuit() {
		return suit;
	}
	/**
	 * this method set the suit value
	 * @param suit
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
	/**
	 * this method returns int value of the card
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * this method sets the int value of the card
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * this method returns true if the card is faced up and false otherwise
	 * @return
	 */
	public boolean isFaceUp(){
		if(this.isFaceUp) return true;
		return false;
	}
	/**
	 * this method sets the isfaceUp value of the card
	 * @param faceUp
	 */
	public void setFaceUp(boolean faceUp) {
		this.isFaceUp=faceUp;
	}
	/**
	 * returns true if the card is red and false otherwise
	 * @return
	 */
	public boolean isRed() {
		if(this.suit%2!=0)return true;
		return false;
	}
	
	String values[] = {" ","A","2","3","4","5","6","7","8","9","10","J",
	  "Q","K"};
    char suits[]    = {' ', '\u2666', '\u2663','\u2665', '\u2660'};
	/**
	 * formats the card objects into a string
	 * @return String
	 * returns a neatly formatted String containing all the data of this 
	 * PerformanceNode
	 */
    public String toString() {
		if (this.isFaceUp) {
			String str = values[this.getValue()]+suits[this.getSuit()];
			return str;
		}
		else return "XX";
	}
	
}
