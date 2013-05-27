package pr1.a09;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import pr1.qad.DirtyFileReader;

public class Persons {
	public static void main (String args[]) {
		// Personen lesen
		Collection<Person> personList = new ArrayList<Person>();
		DirtyFileReader personReader = new DirtyFileReader ("Persons.txt");
		Scanner personIn = new Scanner (personReader);
		while (personIn.hasNext()) {
			personList.add(new Person(Factory.createPerson(personIn)));
		}
		personIn.close();
		personReader.close();
		// Einwohner lesen
		Collection<Einwohner> einwohnerList = new ArrayList<Einwohner>();
		DirtyFileReader einwohnerReader = new DirtyFileReader ("Einwohner.txt");
		Scanner einwohnerIn = new Scanner (einwohnerReader);
		while (einwohnerIn.hasNext()) {
			einwohnerList.add(Factory.createEinwohner(einwohnerIn));
		}
		einwohnerIn.close();
		einwohnerReader.close();
		// Studenten lesen
		Collection<Student> studentList = new ArrayList<Student>();
		DirtyFileReader studentReader = new DirtyFileReader ("Studenten.txt");
		Scanner studentIn = new Scanner (studentReader);
		while (studentIn.hasNext()) {
			studentList.add(Factory.createStudent(studentIn));
		}
		studentIn.close();
		studentReader.close();
		// Listen ausgeben
		PrintWriter out = new PrintWriter(System.out,true);
		printAll(personList,out);
		out.println();
		printAllEinwohner(einwohnerList,out);
		out.println();
		printAllStudents(studentList,out);
	}

	public static void printAll(Collection <Person> c, PrintWriter out) {
		out.println("Printing List of Persons");
		Person [] cList = new Person[c.size()];
		c.toArray(cList);
		for (int i=0;i<cList.length;i++) {
			out.println(cList[i].toString());
		}
	}	
	
	public static void printAllEinwohner(Collection <Einwohner> c, PrintWriter out) {
		out.println("Printing List of Einwohner");
		Einwohner [] cList = new Einwohner[c.size()];
		c.toArray(cList);
		for (int i=0;i<cList.length;i++) {
			out.println(cList[i].toString());
		}
	}	
	
	public static void printAllStudents(Collection <Student> c, PrintWriter out) {
		out.println("Printing List of Students");
		Student [] cList = new Student[c.size()];
		c.toArray(cList);
		for (int i=0;i<cList.length;i++) {
			out.println(cList[i].toString());
		}
	}	
}
