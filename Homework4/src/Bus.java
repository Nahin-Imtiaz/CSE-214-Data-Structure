/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *This class represents a Bus which contains capacity,route,nextStop,toNextStop
 *,and timeToRest.this class creates a passengerQueue and stores passengers in
 * them
 */
public class Bus {
	static int CAPACITY;
	int route,nextStop,timeToRest;
	int toNextStop=1;
	
	PassengerQueue busQueue;
	/**
	 * this constructor is used to create parameterized object of buss class
	 * @param capacity
	 * @param timeToRest
	 * @param route
	 */
	public Bus(int capacity,int timeToRest,int route) {
		this.route=route;
		this.timeToRest=timeToRest;
		Bus.CAPACITY=capacity;
		busQueue = new PassengerQueue();
	}
	/**
	 * this method sets the Nextstop value
	 */
	public void setNextStop() {
		this.nextStop++;
	}
	/**
	 * this method returns the nextStop value
	 * @return
	 */
	public int getNextStop() {
		return nextStop;
	}
	/**
	 * this method sets the NextStop to zero
	 * @param n
	 */
	public void setNextStopToZero(int n) {
		this.nextStop=0;
	}
	/**this method sets the value for timeToRest
	 * 
	 * @param timeToRest
	 */
	public void setTimeToRest(int timeToRest) {
		this.timeToRest=timeToRest-1;
	}
	/**
	 * this method returns the value for timeToRest
	 * @return
	 */
	public int getTimeToRest() {
		return this.timeToRest;
	}
	/**
	 * this method checks if the timeToRest is zero or not
	 * @return
	 */
	public boolean isTimeToRestZero() {
		return (timeToRest==0);
	}
	/**
	 * this method checks if toNextStop is zero or not
	 * @return
	 */
	public boolean isToNextStopZero() {
		return (toNextStop==1);
	}
	/**
	 * this method reduces 1 from timeToReset
	 */
	public void reduceTimeToRest() {
		timeToRest--;
	}
	/**
	 * this method reduces 1 from toNextStop
	 */
	public void reduceToNextStop() {
		toNextStop--;
	}
	/**
	 * this method sets the toNextStop to 20
	 */
	public void setToNextStop() {
		toNextStop=20;
	}
	/**
	 * this method returns the value from toNextStop
	 * @return
	 */
	public int getToNextStop() {
		return this.toNextStop;
	}
	/**
	 * this methos adds passenger in the queue
	 * @param p
	 */
	public void addPassenger(Passenger p) {
		busQueue.enqueue(p);
	}
	/**
	 * this method peeks the bus queue
	 * @return
	 */
	public Passenger peek() {
		return busQueue.peek();
	}
	/**
	 * this method removes the passenger from the bus
	 */
	public void removePassenger() {
		busQueue.dequeue();
	}
	/**
	 * this method returns the amount of passengers in the bus
	 * @return
	 */
	public int busSize() {
		int size=0;
		PassengerQueue tempBusQueue = new PassengerQueue();
		for(int i=0;i<busQueue.QueueSize();i++) {
			size=size+busQueue.peek().getSize();
			tempBusQueue.enqueue(busQueue.dequeue());
		}
		for(int i=0;i<tempBusQueue.size();i++) {
			busQueue.enqueue(tempBusQueue.dequeue());
		}		
		return size;
	}
	/**
	 * this method is used to unload all the passengers that has arrived the
	 *  destination and return the number of group of passengers unloaded
	 * @param destination
	 * @return
	 */
	public int unload(int destination) {
		
		int passenger=0;
		
		
				PassengerQueue tempBusQueue = new PassengerQueue();
				for(int i=0;i<busQueue.QueueSize();i++) {
					if(busQueue.peek().getDestination()==destination) {
						
						passenger++;
						busQueue.dequeue();
					}
					else tempBusQueue.enqueue(busQueue.dequeue());
				}
				for(int i=0;i<tempBusQueue.QueueSize();i++) {
					busQueue.enqueue(tempBusQueue.dequeue());
				}
						
			
	
		return passenger;
	}
	
}