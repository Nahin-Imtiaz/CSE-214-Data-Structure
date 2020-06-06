/**
 * This class represents a baseball card which contains the players name, cards
 * manufacturer, year, price, image size.
 *  
 * @author Nahin Imtiaz
 * 		email: nahin.imtiaz@stonybrook.edu
 * 		Stony brook ID : 111214466
 */
public class BaseballCard {
	
	String name;
	String manufacturer;
	int year;
	double price;
    int[] size = new int[2];
	/**
	 * This is a default constructor used to create a new BaseballCard object
	 */
    public BaseballCard() {
    
    }
    /**
     * This constructor is used to create a new BaseballCard object with parameters
     * @param name
     * The name of the player
     * @param manufacturer
     * the name of the card manufacturer
     * @param year
     * This is the year
     * @param price
     * This is the price
     * @param sizeX
     * The size X of the image 
     * @param sizeY
     * the size Y of the image
     */
    public BaseballCard(String name,String manufacturer,int year,double price,int sizeX,int sizeY){
		this.name= name;
		this.manufacturer=manufacturer;
		this.year=year;
		this.price=price;
		this.size[0]=sizeX;
		this.size[1]=sizeY;
    }
    /**
     * This method returns the player's name
     * @return name
     */
    public String getName() {
		return name;
	}
    /**
     * This method saves the given name of the player
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method returns the manufacturer's name
	 * @return manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * This method saves the given manufacturer's name
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * This method returns year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * This method saves the given year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * This method returns the price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method saves the given price
	 * @param price
	 */
	public void setPrice (double price) throws InvalidPriceException {
		if(price<0) {
			System.out.println("The price is invalid.Give a positive price.");
		}
		else this.price = price;
	}
	/**
	 * This method saves the given size X of the image
	 * @param x
	 */
    public void setSizeX(int x){
    	this.size[0] = x;
    }
    /**
     * This method returns the size X of the image
     * @return sizeX
     */
    public int getSizeX() {
    	return size[0];
    }
    /**
     * This method saves the given size Y of the image
     * @param y
     */
    public void setSizeY(int y){
    	this.size[1] = y;
    }
    /**
     * This method returns the size Y of the image
     * @return
     */
    public int getSizeY() {
    	return size[1];
    }
    /**
     *This method is used to copy the variables of one card object
     *@return a copy of the BaseballCard object
     */
    public BaseballCard clone() {
    	return new BaseballCard(this.name,this.manufacturer,this.year,
    	  this.price,this.getSizeX(),this.getSizeY());
    }
    /**
     * This method is used to compare one BaseballCard object with another 
     * BaseballCard object
     * @param obj
     * This is the BaseballCard object to compare with
     * @return true indicates that obj refers to a BaseballCard object with the
     * same attributes as this BaseballCard.Otherwise,the return value is false
     */
    public boolean equals(Object obj) {
    	if(obj instanceof BaseballCard) {
    		BaseballCard card  = (BaseballCard)obj;
    	    return (this.price==card.price && this.year==card.year && 
    	      this.name.equals(card.name) && 
    	      this.manufacturer.equals(card.manufacturer) && this.getSizeX()==
    	      card.getSizeX() && this.getSizeY()==card.getSizeY());    
    	}
    	else return false;
    }
    /**
     * Gets the String representation of this CardCollection object,which is a 
     * neatly formatted table of each BaseballCard in the CardCollection on its
     *  own line with its position number as shown in the sample output.
     * @return 
     * The String representation of this CardCollection object
     */
    public String toString() {
    	
    	return String.format("%-26s%-20s%-6d%-10.2f%-4dx%-4d%n",this.getName(),
    	  this.getManufacturer(),this.getYear(),this.getPrice(),this.getSizeX()
    	  ,this.getSizeY());
    }
     
}
