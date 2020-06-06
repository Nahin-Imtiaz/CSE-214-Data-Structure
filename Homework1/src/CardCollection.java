/**
 * This class stores an ordered list of BaseballCard objects in an array and 
 * provides an interface to interact with this list
 * 
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony Brook ID : 111214466
 */
public class CardCollection extends BaseballCard{
	BaseballCard[] list ;
	int MAX_CARDS = 100;
	int counter = 0;
	/**
	 *Construct an instance of the CardCollection class with no BaseballCard objects in it.
	 *<dt><b>Postconditions:</b><dd>
	 *This CardCollection has been initialized to an empty list of BaseballCards.
	 */
    public CardCollection() {
    	list = new BaseballCard[MAX_CARDS] ;
    }
    /**
     * Determines the number of items currently in this collection.
     * <dt><b>Preconditions:</b><dd>
     * This CardCollection object has been instantiated.
     * @return 
     * The number of BaseballCards in this CardCollection.
     */
    public int size () {
    	return this.counter;
    }
    /**
     *This method is used to add a new card in a given position of a collection
     * @param newCard
     *  the new BaseballCard object to add to this collection
     * @param position
     * the position in this CardCollection where newCard will be inserted
     * <dt><b>Preconditions:</b><dd>
     * This CardCollection object has been instantiated and 1 < position 
     * < items_currently_in_list + 1. The number of BaseballCard objects 
     * in this Menu is less than MAX_CARDS.
     * <dt><b>Postconditions:</b><dd>
     * The new BaseballCard is now stored at the desired position in the 
     * CardCollection. All cards that were originally in positions greater
     *  than or equal to position are moved back one position.
     *  @throws IllegalArgumentException
     *  Indicates that position is not within the valid range.
     *  @throws FullCollectionException
     *  Indicates that there is no more room inside of the CardCollection 
     *  to store the new card
     */
    public void addCard(BaseballCard newCard, int position) throws 
      InvalidPositionException,FullCollectionException{
    	
    	if(this instanceof CardCollection && 1<=position &&
    	  position<= counter+1 && this.counter< MAX_CARDS) {
    	 
    	for(int i =this.counter;i>position-1;i-- ) {
    		list[i]=list[i+1];
    		
    	}
    	list[position -1] = newCard;
    	this.counter++;
    	}
    	else if(position-1>this.counter || position<=0 || position> MAX_CARDS){
    		throw new InvalidPositionException ("Position is not within the"
    		  + " valid range.");
    	}
    	else if(this.counter == MAX_CARDS) {
    		throw new FullCollectionException("There is no more room inside of "
    		  + "the CardCollection.");
    	}
    }
    /**
     * This method adds a new card to the end of the list
     * @param newCard
     *  the new BaseballCard object to add to this collection
     */
    public void addCard(BaseballCard newCard) {
    	this.addCard(newCard,this.size()+1);
    }
    /**
     * This method is used to remove a card from a card collection
     * @param position
     * the position in the CardCollection where the BaseballCard will be 
     * removed from.
     * <dt><b>Preconditions:</b><dd>
     * This CardCollection object has been instantiated and 1 < position 
     * < items_currently_in_list. 
     * <dt><b>Postconditions:</b><dd>
     * The card at the desired position in the collection has been removed.
     *  All acrds that were originally in positions greater than or equal to 
     *  position are moved forward one position.
     *  @throws IllegalArgumentException
     *  Indicates that position is not within the valid range.
     */
    public void removeCard(int position) {
    	if(this instanceof CardCollection && 1<=position && position<=counter){
    		for(int i= position-1;i<this.counter;i++) {
    			list[i]=list[i+1];
    			list[i+1]=null;
    		}counter--;
    	}else {
    		throw new InvalidPositionException ("Position is not within the "
    		  + "valid range.");
    	}
    }
    /**
     * Get the BaseballCard at the given position in this CardCollection object.
     * @param position
     * position of the card to retrieve
     *  <dt><b>Preconditions:</b><dd>
     *  This CardCollection object has been instantiated and 1 < position 
     *  < items_currently_in_list.
     * @return 
     * The card at the specified position in this Menu object.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     */
    public BaseballCard getCard(int position) {
    	if(!(this instanceof CardCollection && 1<=position && position<=counter
    	  &&position<100)) {
    		throw new InvalidPositionException ("Position is not within the "
    		  + "valid range.");
    	}
    	return this.list[position-1];
    		
    }
    /**
     * Exchange a card from this collection for a card from another collection.
     * @param other
     * the CardCollection we will be trading with
     * @param myPosition
     *  the position within this collection of the card to trade
     * @param theirPosition
     * the position within the other collection of the card to trade
     * <dt><b>Preconditions:</b><dd>
     * Both CardCollection objects have been instantiated and 1 < myPosition 
     * < items_currently_in_this_list and 1 < theirPosition 
     * < items_currently_in_other_list.
     * @throws IllegalArgumentException
     * Indicates that either position is not within the valid range.
     */
    public void trade(CardCollection other,int myPosition, int theirPosition) {
    	if(this instanceof CardCollection && other instanceof CardCollection 
    	  && 1<=myPosition && myPosition<=counter && 1<=theirPosition 
    	  && theirPosition<=counter) {
    		BaseballCard temp = new BaseballCard();
    			temp=this.list[myPosition-1];
    		this.list[myPosition-1]= other.list[theirPosition-1];
    		other.list[theirPosition-1] = temp;
    	}else {
    		throw new InvalidPositionException ("Position is not within the "
    		  + "valid range.");
    	}
    }
    /**
     * Check whether this collection contains the given card
     * @param card
     * the BaseballCard we are looking for
     * <dt><b>Preconditions:</b><dd>
     * This CardCollection and the BaseballCard object have both been instantiated
     * @return
     * True, if this CardCollection contains the card, false otherwise.
     */
    public boolean exists(BaseballCard card) {
    	if(!(this instanceof CardCollection && card instanceof BaseballCard))
    	  return false;
    	for(int i = 0; i<this.counter;i++) {
    		if(this.list[i].equals(card))return true;
    	}
    	return false;
    	
    }
    /**
     * Prints a neatly formatted table of each item in the collection on its 
     * own line with its position number as shown in the sample output.
     * <dt><b>Preconditions:</b><dd>
     * This CardCollection object has been instantiated.
     * <dt><b>Postconditions:</b><dd>
     * A neatly formatted table of each card in the collection on its own line 
     * with its position number has been displayed to the user.
     */
    public void printAllCards() {
    	if(this instanceof CardCollection) {
    		System.out.printf("%-4s%-26s%-20s%-6s%-10s%-9s%n","#","Name",
    		  "Manufacturer","Year","Price","Size");
    		System.out.printf("%-4s%-26s%-20s%-6s%-10s%-9s%n","--","----",
    		  "------------","----","-----","----");
    		for(int i=0;i<this.counter;i++) {	
    			System.out.printf("%-4d",i+1);
    			System.out.println(this.list[i]);
    		}
    	}
    }

}
