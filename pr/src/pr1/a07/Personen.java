// SIMON LISCHKA, 797307 Aufgabe 7
package pr1.a07;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lernhilfe2012ws.objectPlay.Factory;
import lernhilfe2012ws.objectPlay.Person;

public class Personen extends pr1.a07.PersonenTools {

	public static void main(String args[]) {
		sortTest();
	}
	
	
	public static void sortTest() {
		List<Person> allChaoticPersons = new LinkedList<Person>();
		allChaoticPersons = Factory.createTestPersonliste();
		printList(allChaoticPersons, "Unsortierte Liste.");
		Collections.sort(allChaoticPersons, new NameComparator());
		printList(allChaoticPersons, "Nach NAME sortiert.");
		Collections.sort(allChaoticPersons, new VornameComparator());
		printList(allChaoticPersons, "Nach VORNAME sortiert.");
		Collections.sort(allChaoticPersons, new AlterComparator());
		printList(allChaoticPersons, "Nach ALTER sortiert.");
	}
}
