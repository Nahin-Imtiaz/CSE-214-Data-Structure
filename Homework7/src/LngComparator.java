/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class compares the list of cities by their longitude
 */
import java.util.Comparator;

public class LngComparator implements Comparator<City>{
	/**
	 * this is a compare method to compare two city objects
	 */
	public int compare(City o1, City o2) {
		City c1= (City) o1;
		City c2= (City) o2;
		if(c1.getLocation().getLng()==c2.getLocation().getLng()) return 0;
		else if(c1.getLocation().getLng()>c2.getLocation().getLng()) return 1;
		else return -1;
	}

}
