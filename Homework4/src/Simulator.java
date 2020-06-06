/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *
 *Simulator class has a main method that instantiates an object of the class 
 *,takes inputs from the user and inserts it intu thr object.then it 
 *initiates simulate and at the end of the program,closes the program if user
 * chooses to close it
 */
import java.util.Scanner;

public class Simulator {
	static int numInBusses;
	static int numOutBusses;
	static int minGroupSize;
	static int maxGroupSize;
	static int capacity;
	static double arrivalProb;
	static int groupsServed;
	static int totalTimeWaited;
	/**
	 * this main method takes inputs from user and instantiates an object and 
	 * inserts them into it and runs the simultion until user says N
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);
		int i=1;
		while(i!=0) {
			try {
				int duration;
				/**
				 * takes input from the user
				 */
				System.out.print("Enter the number of In Route busses: ");
				numInBusses=input.nextInt();
				if(numInBusses<0) {
					System.out.print("Enter the correct number of In Route "
					  + "busses: ");
					numInBusses=input.nextInt();
				}
				System.out.print("Enter the number of Out Route busses: ");
				numOutBusses=input.nextInt();
				if(numOutBusses<0) {
					System.out.print("Enter the correct number of Out Route "
					  + "busses: ");
					numOutBusses=input.nextInt();
				}
				System.out.print("Enter the minimum group size of passengers:"
				  + " ");
				minGroupSize=input.nextInt();
				System.out.print("Enter the maximum group size of passengers: "
				  + "");
				maxGroupSize=input.nextInt();
				if(maxGroupSize<minGroupSize) {
					System.out.print("Enter the correct minimum group size of "
					  + "passengers: ");
					minGroupSize=input.nextInt();
					System.out.print("Enter the correct maximum group size of "
					  + "passengers: ");
					maxGroupSize=input.nextInt();
				}
				System.out.print("Enter the capacity of a bus: ");
				capacity=input.nextInt();
				if(capacity<0) {
					System.out.print("Enter the correct capacity of a bus: ");
					capacity=input.nextInt();
				}
				System.out.print("Enter the arrival probability: ");
				arrivalProb=input.nextDouble();
				if(arrivalProb<0||arrivalProb>1) {
					System.out.print("Enter the correct arrival probability:"
					  + " ");
					arrivalProb=input.nextDouble();
				}
				System.out.print("Enter the duration of the simulation: ");
				duration=input.nextInt();
				if(duration<0) {
					System.out.print("Enter a correct duration of the "
					  + "simulation: ");
					duration=input.nextInt();
				}
				System.out.println("");
				/**
				 * instantiates an object of simulator class
				 */
				Simulator simulator = new Simulator(numInBusses,numOutBusses,
				  minGroupSize,maxGroupSize,capacity,arrivalProb);
				double[] values = new double[2];
				values = simulate(duration);
				System.out.println("");
				System.out.println(values[0]+" group of passengers served."
				  + "Average wait time is "+values[1]);
				System.out.println("");
				System.out.print("Perform another simulation(Y/N): ");
				String ans;
				ans=input.next();
				/**
				 * if user says N,program terminates 
				 */
				if(ans.equalsIgnoreCase("N")){
					i=0;
					System.out.println("Program terminating...");
				}
				
			}catch(Exception e) {
				System.out.println(e);
				
			}
		}
		
		System.exit(0);
	}
	/**
	 * this is an constructor used to create an object of this class
	 * @param numInBusses
	 * number of In Route busses
	 * @param numOutBusses
	 *  number of Out Route busses
	 * @param minGroupSize
	 * the minimum amount of passengers in a group
	 * @param maxGroupSize
	 * the maximum amount of passengers in a group
	 * @param capacity
	 * the maximum number of passengers a Bus can hold
	 * @param arrivalProb
	 * the probability of a group of passengers lining up for a particular 
	 * bus stop
	 */
	public Simulator(int numInBusses,int numOutBusses,int minGroupSize,int
	  maxGroupSize,int capacity,double arrivalProb) {
		this.numInBusses= numInBusses;
		this.numOutBusses= numOutBusses;
		this.minGroupSize= minGroupSize;
		this.maxGroupSize= maxGroupSize;
		this.capacity= capacity;
		this.arrivalProb= arrivalProb;
	}
	/**
	 *  runs a simulation with this Simulatorís parameters for the given 
	 *  duration of time.
	 * @param duration
	 * duration for the amount of time the program will run
	 * @return
	 */
	public static double[] simulate(int duration) {		
		int NUM_BUS_STOPS = 8;
		PassengerQueue[] busStops = new PassengerQueue[NUM_BUS_STOPS];
		/**
		 * creates BusStops
		 */
		for(int i = 0; i < NUM_BUS_STOPS; i++) {
		    busStops[i] = new PassengerQueue();
		}
		
		String inRoute[]  = {"South P", "West", "SAC", "Chapin"};
		String outRoute[] = {"South P", "PathMart", "Walmart", "Target"};
		/**
		 * creates given number of inBus and given number of outBus
		 */
		Bus[] inBus = new Bus[numInBusses];
		Bus[] outBus = new Bus[numOutBusses];
		/**
		 * sets the timeToRest for each bus in an interval of 30 min
		 */
		int timeIn=0;
		for(int i = 0; i < numInBusses; i++) {
			if(i==0) {
				inBus[i] = new Bus(capacity,1,1);
			}
			else{
				timeIn=timeIn+30;
				inBus[i] = new Bus(capacity,timeIn,0);
			}
		}
		int timeOut=0;
		for(int i = 0; i < numOutBusses; i++) {
			if(i==0) {
				outBus[i] = new Bus(capacity,1,1);
			}
			else{
				timeOut=timeOut+30;
				outBus[i] = new Bus(capacity,timeOut,1);
			}
		}
		/**
		 * runs for Duration amount of time
		 */
		for(int j=0;j<duration;j++) {
			System.out.println("");
			System.out.println("Minute "+(j+1));
			for(int i = 0; i < NUM_BUS_STOPS; i++) {
				if(occurs()) {
					/**
					 * 
					 * passenger arrived.creates a random destination and group
					 *  size for it and enters it into the corresponding bus 
					 *  stop
					 */
					Passenger newPassenger = new Passenger();
					newPassenger.setSize(randInt());
					newPassenger.setArrivalTime(j);
					
					/**
					 * passenger came for inRoute stops
					 */
					if (i < inRoute.length) {
						if(i<inRoute.length-1) {
							newPassenger.setDestination((int)(Math.random()*
							  (((inRoute.length-1)-(i+1))+1)+(i+1)) );
							if(newPassenger.getDestination()>i){
								busStops[i].add(newPassenger);
								System.out.println("A group of "+busStops[i]
								  .peek().getSize()+" passengers arrived at "
								  +inRoute[i]+" heading to "+inRoute
								  [busStops[i].peek().getDestination()]+".");
							}
						}
						else {
							newPassenger.setDestination(0);
							busStops[i].add(newPassenger);
							System.out.println("A group of "+busStops[i].peek()
							  .getSize()+" passengers arrived at "+inRoute[i]+""
							  + " heading to "+inRoute[0]+".");
						}
					}	
					else {
						/**
						 * passenger came for outRoute bus stops
						 */
						if(i<NUM_BUS_STOPS-1) {
							newPassenger.setDestination((int)(Math.random()*(((
							  ((inRoute.length+outRoute.length)-1)-(i+1))+1)+
							  (i+1)) ));
							if(newPassenger.getDestination()>i) {
								busStops[i].add(newPassenger);
								System.out.println("A group of "+busStops[i].
								  peek().getSize()+" passengers arrived at "+
								  outRoute[i-4]+" heading to "+outRoute
								  [busStops[i].peek().getDestination()-4]+".");
							}
						}
						else {
							newPassenger.setDestination(inRoute.length);
							busStops[i].add(newPassenger);
							System.out.println("A group of "+busStops[i].peek()
							  .getSize()+" passengers arrived at "+outRoute
							  [i-4]+" heading to "+outRoute[0]+".");
						}
					}
				}
			}
			/**
			 * for every bus,checks if the bus is in rest,if not then checks 
			 * the time for toNextStop.if its zero,unloads all passengers and
			 *  pick ups passengers if their is enough capacity
			 */
			for(int k=0;k<inBus.length;k++) {
				if(j==0) {
					inBus[k].reduceTimeToRest();
				}
				if(inBus[k].isTimeToRestZero()) {
					if(inBus[k].getNextStop()<4) {
						if(inBus[k].isToNextStopZero()) {
							/**
							 * bus arrived in the stop.unload passengers and 
							 * picks passengers if their is capacity
							 */
							System.out.print("In Route Bus "+(k+1)+" arrives "
							  + "at "+inRoute[inBus[k].getNextStop()]+".");
							
							
							int passengerDropped = inBus[k].unload(inBus[k]
							  .getNextStop());
							
							int passengerPicked = 0;
							if(passengerDropped!=0) {
								
								System.out.print(" Drops off "+passengerDropped
								  +" passengers.");
							}
							PassengerQueue tempQueue = new PassengerQueue();
							/**
							 * calculates total time waited and amount of 
							 * passengers picked 
							 */
							while(!busStops[inBus[k].getNextStop()].
							  isQueueEmpty()) {
								
								if((inBus[k].busSize()+busStops[inBus[k]
								  .getNextStop()].peek().getSize())<=capacity){
									
									passengerPicked= busStops
									  [inBus[k].getNextStop()].peek().getSize();
									groupsServed =groupsServed + passengerPicked;
			
									totalTimeWaited= totalTimeWaited+(j-
									  busStops[inBus[k].getNextStop()].peek()
									  .getArrivalTime());
									inBus[k].addPassenger(busStops[inBus[k]
									  .getNextStop()].dequeue());
								}
								else {
									tempQueue.enqueue(busStops[inBus[k]
									  .getNextStop()].dequeue());
								}
							}
							if(passengerPicked!=0) {
								System.out.println(" Picks up "+passengerPicked
								  +" passengers.");
							}
							else {
								System.out.println("");
							}
							while(!tempQueue.isQueueEmpty()) {
								busStops[inBus[k].getNextStop()].enqueue
								  (tempQueue.dequeue());
							}
							/**
							 * goes to the next stop after doing everything
							 */
							inBus[k].setToNextStop();
							inBus[k].setNextStop();
						}
						else {
							/**
							 * reduces the toNextStop 
							 */
							inBus[k].reduceToNextStop();
							
							System.out.println("In Route Bus "+(k+1)+" moving "
							  + "toward "+inRoute[inBus[k].getNextStop()]+". "
							  + "Arrive in "+inBus[k].getToNextStop()+" minutes"
							  + ".");
						}
					}
					/**
					 * the bus is in the last stop.only unloads passengers and 
					 * sets timetorest to 30
					 */
					else if (inBus[k].getNextStop()==4) {
						if(inBus[k].isToNextStopZero()) {
							System.out.print("In Route Bus "+(k+1)+" arrives "
							  + "at "+inRoute[0]+".");
							int passengerDropped = inBus[k].unload(0);
							
							if(passengerDropped!=0) {
								
								System.out.println(" Drops off "+
								  passengerDropped+" passengers.");
							}
							else {
								System.out.println("");
							}
							inBus[k].setTimeToRest(30);
							inBus[k].setNextStopToZero(0);
							inBus[k].setToNextStop();
							inBus[k].setNextStop();
						}
						else {
							inBus[k].reduceToNextStop();
							System.out.println("In Route Bus "+(k+1)+" moving"
							  + " toward "+inRoute[0]+". Arrive in "+inBus[k]
							  .getToNextStop()+" minutes.");
						}
					}
				}
				else {
					System.out.println("In Route Bus "+(k+1)+" is resting at "
					  + "South P for "+inBus[k].getTimeToRest()+" minutes.");
					inBus[k].reduceTimeToRest();

				}
			}	
			/**
			 * does the same thing as inBus.if bus arrives at the stop,unload 
			 * all passengers and picks passenger if theri is space left
			 */
			for(int k=0;k<outBus.length;k++) {
				if(j==0) {
					outBus[k].reduceTimeToRest();
				}
				if(outBus[k].isTimeToRestZero()) {
					if(outBus[k].getNextStop()<4) {
						if(outBus[k].isToNextStopZero()) {
							
							System.out.print("Out Route Bus "+(k+1)+" arrives "
							  + "at "+outRoute[outBus[k].getNextStop()]+".");
							int passengerDropped = outBus[k].unload(outBus[k]
							  .getNextStop()+4);
							
							int passengerPicked = 0;
							if(passengerDropped!=0) {
								
								System.out.print(" Drops off "+passengerDropped
								  +" passengers.");
							}
							PassengerQueue tempQueue = new PassengerQueue();
							while(!busStops[outBus[k].getNextStop()+4]
							  .isQueueEmpty()) {
								if((outBus[k].busSize()+busStops[outBus[k]
								  .getNextStop()+4].peek().getSize())<=capacity
								  ) {
									
									passengerPicked= busStops
									  [outBus[k].getNextStop()+4].peek()
									  .getSize();
									groupsServed =groupsServed + passengerPicked;
									totalTimeWaited= totalTimeWaited+(j-
									  busStops[outBus[k].getNextStop()+4].peek()
									  .getArrivalTime());
									outBus[k].addPassenger(busStops[outBus[k]
									  .getNextStop()+4].dequeue());
								}
								else {
									tempQueue.enqueue(busStops[outBus[k]
									  .getNextStop()+4].dequeue());
								}
							}
							if(passengerPicked!=0) {
								System.out.println(" Picks up "+passengerPicked
								  +" passengers.");
							}
							else {
								System.out.println("");
							}
							while(!tempQueue.isQueueEmpty()) {
								busStops[outBus[k].getNextStop()+4].enqueue
								  (tempQueue.dequeue());
							}
						
							outBus[k].setToNextStop();
							outBus[k].setNextStop();
						}
						else {
							outBus[k].reduceToNextStop();
							System.out.println("Out Route Bus "+(k+1)+" moving"
							  + " toward "+outRoute[outBus[k].getNextStop()]+""
							  + ". Arrive in "+outBus[k].getToNextStop()+" "
							  + "minutes.");
						}
					}
					/**
					 * bus is at the last stop.only unloads passenger
					 */
					else if (outBus[k].getNextStop()==4) {
						if(outBus[k].isToNextStopZero()) {
							System.out.print("Out Route Bus "+(k+1)+" arrives"
							  + " at "+outRoute[0]+".");
							int passengerDropped = outBus[k].unload(4);
							
							if(passengerDropped!=0) {
								
								System.out.println(" Drops off "+
								  passengerDropped+" passengers.");
							}
							else {
								System.out.println("");
							}
							outBus[k].setTimeToRest(30);
							outBus[k].setNextStopToZero(0);
							outBus[k].setToNextStop();
							outBus[k].setNextStop();
						}
						else {
							outBus[k].reduceToNextStop();
							System.out.println("Out Route Bus "+(k+1)+" moving "
							  + "toward "+outRoute[0]+". Arrive in "+outBus[k]
							  .getToNextStop()+" minutes.");
						}
					}
				}
				else {
					System.out.println("Out Route Bus "+(k+1)+" is resting at "
					  + "South P for "+outBus[k].getTimeToRest()+" minutes.");
					outBus[k].reduceTimeToRest();
					
				}
			}
			for (int i = 0; i < NUM_BUS_STOPS; i++) {
			    System.out.print(i + " (" + ((i < inRoute.length) ? inRoute[i] 
			      : outRoute[i - inRoute.length]) + ") : ");
			    print(busStops[i]);
			    System.out.println("");
			}
			
		}
		/**
		 * creates a double array variable to save and return groupsServed and
		 *  average time for waiting
		 */
		double[] returnArray = new double[2];
		double average=0;
		if(groupsServed!=0) {
			average = (totalTimeWaited/groupsServed);
		}
		returnArray[0]=groupsServed;
		returnArray[1]=average;
		System.out.println("");
		
		return returnArray;
	}
	/**
	 * creates a random int number from minGroupSize to maxGroupSize
	 * @return
	 */
	private static int randInt() {
		int rand= (int)(Math.random()*((Simulator.maxGroupSize-Simulator
		  .minGroupSize)+1)+Simulator.minGroupSize);
		return rand;
	}
	/**
	 * probability of any passenger arriving
	 * @return
	 */
	public static boolean occurs() {
		return (Math.random()<arrivalProb);
	}
	/**
	 * this method prints the elements of a queue
	 * @param queue
	 * 
	 */
	public static void print(PassengerQueue queue) {
		String Route[]  = {"South P", "West", "SAC", "Chapin","South P", 
		  "PathMart", "Walmart", "Target"};
		
		PassengerQueue tempQueue = new PassengerQueue(); 
		if(!queue.isQueueEmpty()) {
			while(!queue.isQueueEmpty()) {
				
					System.out.print("["+queue.peek().getSize()+", "+queue.
					  peek().getDestination()+" "+"("+Route[queue.peek().
					    getDestination()]+"), "+queue.peek().getArrivalTime()
					    +"]");
					tempQueue.enqueue(queue.dequeue());
		
			}
			while(!tempQueue.isQueueEmpty()) {
				queue.enqueue(tempQueue.dequeue());
			}	
		}
	}	
}
