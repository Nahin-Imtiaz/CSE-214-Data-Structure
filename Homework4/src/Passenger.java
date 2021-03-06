/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *This class represents a Group of Passenger which contains size,arrivaltime 
 *and destination
 */
public class Passenger {
	int size;
	int arrivalTime;
	int destination;
	int waitTime;
	/**
	 * this is a default constructor to create an object of passenger
	 */
	public Passenger() {	
	}
	/**
	 * this method returns the size of the passenger
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * this method sets the size of the passenger
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * this method returns the arrival time of the passenger
	 * @return arrivaltime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * this method sets the arrival time of the passenger
	 * @param arrivalTime
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * this method returns the destination
	 * @return destination
	 */
	public int getDestination() {
		return destination;
	}
	/**
	 * this method sets the destination of the passengers
	 * @param destination
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime=waitTime;
	}
	public int getWaitTime() {
		return this.waitTime;
	}
}
