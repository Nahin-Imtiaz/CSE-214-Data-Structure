/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class compares the list of cities by their latitudes
 */
import java.util.Comparator;

public class LatComparator implements Comparator<City>{
	/**
	 * this is a compare method to compare two city objects
	 */
	public int compare(City o1, City o2) {
		City c1= (City) o1;
		City c2= (City) o2;
		if(c1.getLocation().getLat()==c2.getLocation().getLat()) return 0;
		else if(c1.getLocation().getLat()>c2.getLocation().getLat()) return 1;
		else return -1;
	}

}
