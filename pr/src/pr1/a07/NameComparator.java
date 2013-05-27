package pr1.a07;
import java.util.Comparator;
import lernhilfe2012ws.objectPlay.*;


public class NameComparator implements Comparator<Person> {

	public int compare(Person persObj1, Person persObj2) {
		String name1 = new String (persObj1.getNachname());
		String name2 = new String (persObj2.getNachname());
		return (name1.compareTo(name2));
	}
}


