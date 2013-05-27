package pr1.a07;
import java.util.Comparator;
import lernhilfe2012ws.objectPlay.*;


public class VornameComparator implements Comparator<Person> {

	public int compare(Person persObj1, Person persObj2) {
		String vorName1 = new String (persObj1.getVorname());
		String vorName2 = new String (persObj2.getVorname());
		return (vorName1.compareTo(vorName2));
	}
}


