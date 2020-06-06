/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class compares the list of cities by their names
 */
import java.util.Comparator;

public class NameComparator implements Comparator<City>{
	/**
	 * this is a compare method to compare two city objects
	 */
	public int compare(City o1, City o2) {
		City c1= (City) o1;
		City c2= (City) o2;
		return (c1.getName().compareTo(c2.getName()));
	}
}
