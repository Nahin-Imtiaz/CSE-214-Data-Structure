/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class that contains the name of the city , a location , indexPos and 
 *static variable cityCount.
 */
import java.io.Serializable;
import latlng.LatLng;

public class City implements Serializable{
	String name;
	LatLng location;
	int indexPos;
	static int cityCount;
	/**
	 * this is a constructor with parameters to create city objects
	 * @param name
	 * this is the name of the city
	 * @param location
	 * this is the location of the city
	 */
	public City(String name,LatLng location) {
		this.name=name;
		this.location=location;
		this.indexPos=this.cityCount;
		cityCount++;
	}
	/**
	 * this method returns the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method sets the name
	 * @param name
	 * this is the name of the city
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * this method returns the location
	 * @return
	 */
	public LatLng getLocation() {
		return location;
	}
	/**
	 * this method sets the location
	 * @param location
	 * this is the location of the city
	 */
	public void setLocation(LatLng location) {
		this.location = location;
	}
	/**
	 * this method returns the indexPos
	 * @return
	 */
	public int getIndexPos() {
		return indexPos;
	}
	/**
	 * this method sets the indexPos
	 * @param indexPos
	 * this is the indexPos of the city
	 */
	public void setIndexPos(int indexPos) {
		this.indexPos = indexPos;
	}
	/**
	 * this method returns the city count
	 * @return
	 */
	public static int getCityCount() {
		return cityCount;
	}
	/**
	 * this method sets the cityCount
	 * @param cityCount
	 * this is the cityCount
	 */
	public static void setCityCount(int cityCount) {
		City.cityCount = cityCount;
	}
	
}
