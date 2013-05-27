// SIMON LISCHKA, 797307 Aufgabe 5
package pr1.a05;

import java.io.PrintWriter;
import pr1.qad.DirtyFileReader;
import pr1.qad.DirtyFileWriter;
import java.util.Scanner;
import lernhilfe2012ws.objectPlay.*;

public class Personen {
	//	Dateinamen und Personen f???r alle Beispielaufgaben anlegen 
	private static final String KOM_FILENAME = "kommilitonen.txt";
	private static final String SPORT_FILENAME = "sportsfreunde.txt";
	private static final String VERW_FILENAME = "verwandte.txt";
	private static Person Ralph = new Person ("Ralf","Zackalevskyson",1986);	
	private static Person Bjoerk = new Person ("Bjoerk","Svenselstrom",1914);
	private static Person Lopez = new Person ("Mario", "Lopez",1982);
	private static Person Sumba = new Person ("Rodrigo", "Sumba",1981);
	private static Person Schonensee = new Person ("Mark", "Schonensee",1999);


	public static void main ( String args [] ) {
		//		5b.1) und 5b.2)	
		//		Adressen und Einwohner anlegen. Kompatibilit???t zw. Einw/Pers. experimentieren.
		adressTest();
		//		5b.3) 5cde) 
		listenActionTest();
	}
	public static void adressTest() {
		//		Deklaration Adressen.
		Adresse RalphsWay = new Adresse (10711,"Berlin","Samureiter Str",22);
		Adresse BjoerksWay = new Adresse(11112,"Ulmsondau","Philharmonie Weg",33);
		Adresse LopezsWay = new Adresse (8088,"CD de Mexico","Canitas",122);
		//		Deklaration Einwohner
		Einwohner RalphAlsEinwohner = new Einwohner ( Ralph, RalphsWay);
		Einwohner BjoerkAlsEinwohner = new Einwohner ( Bjoerk, BjoerksWay);
		Einwohner LopezAlsEinwohner = new Einwohner ( Lopez, RalphsWay);
		//		Ausgabe Personendaten
		printPersonenDaten(Ralph,"Ralph");
		printPersonenDaten(Bjoerk,"Bjoerk");
		//		Ausgabe Einwohneraten
		printEinwohnerDaten(RalphAlsEinwohner,"Ralph");
		printEinwohnerDaten(BjoerkAlsEinwohner,"Bjoerk");
		printEinwohnerDaten(LopezAlsEinwohner,"Lopez");
		//		Ausgabe Adressdaten
		printAdressDaten(RalphsWay,"Ralph");
		printAdressDaten(BjoerksWay,"Bjoerk");
		//		5b.2) Einwohnerobjekt kann als Personenobjekt verw. werden? JA.
		//		Adressobjekt als Personenobjekt? Nein.
		Person LopezGoesBeserk = new Einwohner (Lopez, LopezsWay);
		Person BjoerkGoesBeserk = new Einwohner (Bjoerk, BjoerksWay);
		//	Adr. als Pers. geht nicht: (Compilerfehler)
		//	Person BjoerkComitsError = new Adresse (11112,"Ulmsondau","Philharmonie Weg",33);
		//	Person LopezComitsError = new Adresse(RalphsWay.getPlz(),RalphsWay.getOrt(),RalphsWay.getStrasse(),RalphsWay.getHausNr());
		//  	Ausgabe Lopez Goes Beserk+BjoerkgoesBeserk: 
		printPersonenDaten(LopezGoesBeserk,"Lopez Goes Beserk (Person mit new Einwohner deklariert. )");
		printPersonenDaten(BjoerkGoesBeserk,"BjoerkGoes Beserk (Person mit new Einwohner deklariert. )");
	}

	public static void listenActionTest() {
		//		5b.3) Factory.createTestPersonenListe benutzen um Liste zu erstellen
		//		Doppelte Eintr???ge werden gefiltert, Liste mit 5 weiteren Eintr???gen erg???nzt.
		PersonList allPersons = new PersonList();
		PersonList yellowPages = new PersonList();
		allPersons= Factory.createTestPersonliste();
		printList(allPersons,"Verzeichnisausgabe, TestPersonliste");
		yellowPages=killDoppelGaenger(allPersons);
		//		Zus???tzliche Personen hinzuf???gen
		yellowPages.add(Ralph);
		yellowPages.add(Bjoerk);
		yellowPages.add(Lopez);
		yellowPages.add(Sumba);
		yellowPages.add(Schonensee);
		//		Ausgabe d. Eintr???ge
		printList(yellowPages,"Ausgabe yellowPages ( Modifizierung TestListe) ");
		//		
		//	    5c.)
		//		-------------------------------------------------------------------
		PersonList SportFreunde = new PersonList();
		PersonList Verwandten = new PersonList ();
		PersonList Komilitonen = new PersonList();
		PersonList VerwandteSF = new PersonList();
		for (int i=5;i<15;i++){
			SportFreunde.add(yellowPages.get(i));
		}
		for (int i=10;i<20;i++){
			Verwandten.add(yellowPages.get(i));
		}
		Komilitonen.addAll(yellowPages);
		Komilitonen.removeAll(Verwandten);
		//		Zum Testen der retainAll Fuktion: Herausfinden, welche Verwandten
		//		auch SportFreunde sind.
		VerwandteSF.addAll(SportFreunde);
		VerwandteSF.retainAll(Verwandten);
		printList(VerwandteSF,"Test mit retain: Alle sportFreunde, die Verwandte sind.");
		//		
		//		5d. Objekte Ausgeben (Bildschirm/Datei)
		//		-------------------------------------------------------------------
		printList(Komilitonen, "Komilitonenliste, f???r Dateiausgabe");
		printList(SportFreunde, "Sportfreundeliste, f???r Dateiausgabe");
		printList(Verwandten, "Verwandtenliste, f???r Dateiaustgabe");
		writeListToFile(Komilitonen,KOM_FILENAME);
		writeListToFile(SportFreunde,SPORT_FILENAME);
		writeListToFile(Verwandten,VERW_FILENAME);
		//		
		//		5e) Von Dateien lesen...
		//		-------------------------------------------------------------------
		printListFromFile(KOM_FILENAME);
		printListFromFile(SPORT_FILENAME);
		printListFromFile(VERW_FILENAME);
	}




	public static PersonList readList(String filename) {
		DirtyFileReader listReader = new DirtyFileReader (filename);
		Scanner listIn = new Scanner (listReader);
		PersonList reList = new PersonList(readAll(listIn));
		listReader.close();
		listIn.close();
		return reList;
	}

	public static void printAll(PersonList pl, PrintWriter printAllOut) {
		for (int i=0;i<pl.size();i++) {
			Person aktualPerson=pl.get(i);
			printAllOut.print(aktualPerson.getVorname()+" "+aktualPerson.getNachname()+" "+
					aktualPerson.getGeburtsjahr());
			printAllOut.println();
		}
	}

	public static void printPersonenDaten(Person inputPerson, String persName){
		toOut("+++ | Personendaten "+persName+": ");
		toOut(personFormatiert(inputPerson));
		toOut();
	}

	public static void printEinwohnerDaten(Einwohner inputEinwohner, String einwName){
		toOut("+++ | Einwohnerdaten "+einwName+": ");
		toOut(einwohnerFormatiert(inputEinwohner));
		toOut();
	}

	public static void printAdressDaten(Adresse inputAdresse, String einwName){
		toOut("+++ | Adressdaten "+einwName+": ");
		toOut(adresseFormatiert(inputAdresse));
		toOut();
	}

	public static void printListFromFile(String filename) {
		printList(readList(filename),"Liste aus Datei "+filename);
	}

	public static void printList (PersonList inputList, String description){
		toOut("++++++ || "+description+" || Anzahl d. Eintr???ge: "+inputList.size()+" +++++++");
		for (int i=0;i<inputList.size();i++) {
			toOut(personFormatiert(inputList.get(i)));
		}
		toOut();
	}

	public static void writeListToFile(PersonList inputList, String filename) {
		PrintWriter fOut = new PrintWriter (new DirtyFileWriter(filename));
		for (int i=0;i<inputList.size();i++) {
			fOut.println(personFormatiert(inputList.get(i)));
		}
		fOut.flush();
		fOut.close();
		toOut("--> "+filename+" geschrieben.");
		toOut();
	}

	public static PersonList readAll(Scanner s) {
		PersonList ReadingList = new PersonList();
		String ReadingVorname="";
		String ReadingNachname="";
		int ReadingGeburtsJahr=0;
		while (s.hasNext()) {
			ReadingVorname=s.next();
			ReadingNachname=s.next();
			if (s.hasNextInt()){
				ReadingGeburtsJahr=s.nextInt();
			}
			Person ReadingPerson = new Person(ReadingVorname,ReadingNachname,ReadingGeburtsJahr);
			ReadingList.add(ReadingPerson);
		}
		return ReadingList;
	}

	public static PersonList killDoppelGaenger(PersonList personInput) {
		PersonList outputList = new PersonList();
		for (int i=0;i<=personInput.size()-1;i++) {
			Person verglPerson1 = personInput.get(i);
			Person verglPerson2 = null;
			if (i+1<=personInput.size()-1) {
				verglPerson2=personInput.get(i+1);
			} else {
				outputList.add(verglPerson1);
				break;
			}
			String verglVorname1=verglPerson1.getVorname();
			String verglVorname2=verglPerson2.getVorname();
			if (verglVorname1.equals(verglVorname2)==false) {
				outputList.add(verglPerson1);
			}
		}
		return outputList;
	}

	public static String personFormatiert (Person input) {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append(input.getVorname());
		outputBuffer.append(" ");
		outputBuffer.append(input.getNachname());
		outputBuffer.append(" ");
		outputBuffer.append(input.getGeburtsjahr());
		String output=outputBuffer.toString();
		return output;
	}

	public static String adresseFormatiert (Adresse input) {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append(input.getPlz());
		outputBuffer.append(" ");
		outputBuffer.append(input.getOrt());
		outputBuffer.append(" ");
		outputBuffer.append(input.getStrasse());
		outputBuffer.append(" ");
		outputBuffer.append(input.getHausNr());
		String output=outputBuffer.toString();
		return output;
	}

	public static String einwohnerFormatiert (Einwohner input) {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append(input.getVorname());
		outputBuffer.append(" ");
		outputBuffer.append(input.getNachname());
		outputBuffer.append(" ");
		outputBuffer.append(input.getGeburtsjahr());
		outputBuffer.append(" ");
		outputBuffer.append(input.getAdresse());
		String output=outputBuffer.toString();
		return output;
	}


	public static void toOut() {
		PrintWriter out = new PrintWriter (System.out, true);
		toOut("",out);
	}

	public static void toOut(String input) {
		PrintWriter out = new PrintWriter (System.out, true);
		toOut(input,out);
	}

	public static void toOut(String inputDoIt, PrintWriter outDoIt) {
		outDoIt.println(inputDoIt);
	}

} 
