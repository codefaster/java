package pr1.a09;

import java.util.Scanner;

public class Factory {
	
	public static Person createPerson(Scanner in) {
		String vorname = "";
		String nachname = "";
		int geburtsjahr = 0;
		
		if (in.hasNext()) {
			vorname=in.next();
			}
		if (in.hasNext()){
			nachname=in.next();
		}
		if (in.hasNextInt()) {
			geburtsjahr = in.nextInt();
		}
		return new Person(vorname,nachname,geburtsjahr);
	}
	
	public static Student createStudent(Scanner in) {
		String vorname = "";
		String nachname = "";
		int geburtsjahr = 0;
		int matrikelnummer = 0;
	
		if (in.hasNext()) {
			vorname=in.next();
			}
		if (in.hasNext()){
			nachname=in.next();
		}
		if (in.hasNextInt()) {
			geburtsjahr = in.nextInt();
		}
		if (in.hasNextInt()) {
			matrikelnummer = in.nextInt();
		}
		return new Student(vorname,nachname,geburtsjahr,matrikelnummer);
	}
	
	public static Einwohner createEinwohner(Scanner in) {
		String vorname = "";
		String nachname = "";
		int geburtsjahr = 0;
		int hausnummer = 0;
		String ort ="";
		int plz = 0;
		String strasse = "";
		
		if (in.hasNext()) {
			vorname=in.next();
			}
		
		if (in.hasNext()){
			nachname=in.next();
		}
		if (in.hasNextInt()) {
			geburtsjahr = in.nextInt();
		}
		
		if (in.hasNextInt()) {
			plz = in.nextInt();
		}
		if (in.hasNext()) {
			ort = in.next();
		}
	
		if (in.hasNext()) {
			strasse = in.next();
		}
		if (in.hasNextInt()) {
			hausnummer = in.nextInt();
		}
		
		return new Einwohner(new Person(vorname,nachname,geburtsjahr),new Adresse(plz,ort,strasse,hausnummer));
	}
	

}
