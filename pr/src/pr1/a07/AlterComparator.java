package pr1.a07;
import java.util.Comparator;
import lernhilfe2012ws.objectPlay.*;


public class AlterComparator implements Comparator<Person> {

	public int compare(Person persObj1, Person persObj2) {
		Integer gebJahr1 = new Integer (persObj1.getGeburtsjahr());
		Integer gebJahr2 = new Integer (persObj2.getGeburtsjahr());
		return (gebJahr1.compareTo(gebJahr2));
	}
}


