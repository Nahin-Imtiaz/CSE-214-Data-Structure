/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents a adjacency matrix and some methods to utilize this 
 *matrix
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.cse214.geocoder.GeocodeResponse;
import com.cse214.geocoder.Geocoder;
import latlng.LatLng; 

public class SigmaAir implements Serializable{
	private ArrayList<City> cities ;
	public static final int MAX_CITIES=100;
	private double[][] connections=new double[MAX_CITIES][MAX_CITIES];
	/**
	 * this is a constructor to declare the adjacency matrix values and city 
	 * values and to create a sigmaAir object
	 */
	public SigmaAir() {
		cities = new ArrayList<City>(MAX_CITIES);
		for(int i=0;i<MAX_CITIES;i++) {
			for(int j=0;j<MAX_CITIES;j++) {
				if(i==j) {
					connections[i][j]=0;
				}
				else connections[i][j]=Double.POSITIVE_INFINITY;
			}
		}
	}
	/**
	 * this method adds the city
	 * @param city
	 * this is the city name
	 */
	public void addCity(String city) {
		try {
		    Geocoder geocoder = new Geocoder();
		    GeocodeResponse geocodeResponse;
		    String addr;
		    double lat;
		    double lng;
		 
		    geocodeResponse = geocoder.geocode(city);
		    addr = geocodeResponse.getFormattedAddress();
		    lat = geocodeResponse.getLat();
		    lng = geocodeResponse.getLng();
		    
		    LatLng newLatLng = new LatLng(lat,lng);
		    City newCity= new City(city,newLatLng);
		    cities.add(newCity);
		
		    System.out.println(city+" has been added: (" + lat + ", " + lng+
		      ")");
		} catch (Exception e) {
		    // error handling goes here
		}
	}
	/**
	 * this method adds connection between two cities
	 * @param cityFrom
	 * this is the source city
	 * @param cityTo
	 * this is the destination city
	 */
	public void addConnection(String cityFrom, String cityTo) {
		LatLng new1 = null;
		LatLng new2 = null;
		int index1 = 0;
		int index2 = 0;
		for(int i=0;i<cities.size();i++) {
			if(cities.get(i).getName().equalsIgnoreCase(cityFrom)) {
				new1 = cities.get(i).getLocation();
				index1=cities.get(i).getIndexPos();
			}
			else if(cities.get(i).getName().equalsIgnoreCase(cityTo)){
				new2 = cities.get(i).getLocation();
				index2=cities.get(i).getIndexPos();
			}
			else if (i==cities.size()-1&&(new1==null||new2==null)) {
				System.out.println("Error adding connection: "+cityFrom+" --> "
			      +cityTo);
				return;
			}
		}
		if(index1!=index2) {
			double distance =LatLng.calculateDistance(new1,new2);
			connections[index1][index2]=distance;
			System.out.println(cityFrom+" --> "+cityTo+" added: "+distance);
		}
	}
	/**
	 * this method removes the connection between two cities
	 * @param cityFrom
	 * this is the source city
	 * @param cityTo
	 * this is the destination city
	 */
	public void removeConnection(String cityFrom, String cityTo) {
		int index1 = 0;
		int index2 = 0;
		LatLng new1 = null;
		LatLng new2 = null;
		for(int i=0;i<cities.size();i++) {
			if(cities.get(i).getName().equalsIgnoreCase(cityFrom)) {
				index1=cities.get(i).getIndexPos();
				new1 = cities.get(i).getLocation();
			}
			else if(cities.get(i).getName().equalsIgnoreCase(cityTo)){
				new2 = cities.get(i).getLocation();
				index2=cities.get(i).getIndexPos();
			}
			else if (i==cities.size()-1&&(new1==null||new2==null)) {
				System.out.println("Error removing connection: "+cityFrom
				  +" --> "+cityTo);
				return;
			}
		}
		connections[index1][index2]=Double.POSITIVE_INFINITY;
		System.out.println("connection from "+cityFrom+" to "+cityTo+" has been"
		  + " removed!");
		System.out.println("");
	}
	/**
	 * this method finds the shortest path between two cities and returns the 
	 * distance and shortest path.
	 * @param cityFrom
	 * this is the source city
	 * @param cityTo
	 * this is the destination city
	 * @return
	 */
	public String shortestPath(String cityFrom, String cityTo) {
		int index1 = 0;
		int index2 = 0;
		LatLng new1 = null;
		LatLng new2 = null;
		double dist[][]= new double[MAX_CITIES][MAX_CITIES];
		int next[][]= new int[MAX_CITIES][MAX_CITIES];
		for(int i=0;i<MAX_CITIES;i++) {
			for(int j=0;j<MAX_CITIES;j++) {
				dist[i][j]=connections[i][j];
				next[i][j]=j;
			}
		}
		for(int i=0;i<cities.size();i++) {
			if(cities.get(i).getName().equalsIgnoreCase(cityFrom)) {
				index1=cities.get(i).getIndexPos();
				new1 = cities.get(i).getLocation();
			}
			else if(cities.get(i).getName().equalsIgnoreCase(cityTo)){
				new2 = cities.get(i).getLocation();
				index2=cities.get(i).getIndexPos();
			}
			else if (i==cities.size()-1&&(new1==null||new2==null)) {
				String str="Shortest path from "+cityFrom+" to "+cityTo+" does"
				  + " not exist!";
				return str;
			}
		}
		for(int k=0;k<MAX_CITIES;k++) {
			for(int i=0;i<MAX_CITIES;i++) {
				for(int j=0;j<MAX_CITIES;j++) {
					if((dist[i][k]+dist[k][j])<dist[i][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
						next[i][j]=next[i][k];
					}
				}
			}
		}
		double newDist=dist[index1][index2];
		String path="";
		if(next[index1][index2]==0 && next[index1][index2]==Double
		  .POSITIVE_INFINITY) {
			System.out.println("Shortest path from"+cities.get(index1)
			  .getName()+" to "+cities.get(index2).getName()+" does not "
			  + "exist!");
			return path;
		}
		path=cities.get(index1).getName();
		while(index1!=index2) {
			index1=next[index1][index2];
			path=path+" --> "+ cities.get(index1).getName();
		}
		return path +" : "+newDist;
	}
	/**
	 * this method compares and sorts and prints the cities accordingly
	 * @param comp
	 * this is the comparator used
	 */
	public void printAllCities(Comparator comp) {
		Collections.sort(cities,comp);
		System.out.println("Cities:");
		System.out.printf("%-28s%-16s%-17s%n","City Name","Latitude",
		  "Longitude");
		System.out.println("--------------------------------------------------"
		  + "-----------");
		for(int i=0;i<cities.size();i++) {
			System.out.printf("%-28s%-16f%-17f%n",cities.get(i).getName(),
			  cities.get(i).getLocation().getLat(),cities.get(i).getLocation()
			  .getLng());
		}
	}
	/**
	 * this method prints all connections between cities
	 */
	public void printAllConnections() {	
		System.out.println("Connections:");
		System.out.printf("%-36s%-22s%n","Route","Distance");
		System.out.println("-------------------------------------------------"
		  + "---------");
		for(int i=0;i<MAX_CITIES;i++) {
			for(int j=0;j<MAX_CITIES;j++) {
				if(connections[i][j]!=0 && connections[i][j]!=Double
				  .POSITIVE_INFINITY) {
					System.out.printf("%-36s",cities.get(i).getName()+" --> "+
				    cities.get(j).getName());
					System.out.println(connections[i][j]);
				}	
			}	
		}		
	}
	/**
	 * this method loads all cities in the city array from the given file
	 * @param filename
	 * this is the filename of cities
	 * @throws IOException
	 * throws exception if filename is not found
	 */
	public void loadAllCities(String filename) throws IOException {
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(filename);
		}
		catch(Exception e) {
			System.out.println("No such file '"+filename+"'.");
			return;
		}
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
	
		String data ;
		while((data =reader.readLine())!=null) {
			addCity(data);
		}	
	}
	/**
	 * this method loads all the connections in the adjacency matrix 
	 * @param filename
	 * this is the filename for connections
	 * @throws IOException
	 * throws exception if file is not found
	 */
	public void loadAllConnections(String filename) throws IOException {
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(filename);
		}
		catch(Exception e) {
			System.out.println("No such file '"+filename+"'.");
			return;
		}
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
	
		String data ;
		System.out.println("");
		while((data =reader.readLine())!=null) {
			String[] str = data.split(",");
			addConnection(str[0],str[1]);
		}	
	}
}
