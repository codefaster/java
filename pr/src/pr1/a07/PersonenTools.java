package pr1.a07;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lernhilfe2012ws.objectPlay.Adresse;
import lernhilfe2012ws.objectPlay.Einwohner;
import lernhilfe2012ws.objectPlay.Person;
import pr1.qad.DirtyFileReader;
import pr1.qad.DirtyFileWriter;

public class PersonenTools {
	public static ArrayList<Person> readList(String filename) {
		DirtyFileReader listReader = new DirtyFileReader (filename);
		Scanner listIn = new Scanner (listReader);
		ArrayList<Person> reList = new ArrayList<Person>(readAll(listIn));
		listReader.close();
		listIn.close();
		return reList;
	}

	public static void printAll(List<Person> pl, PrintWriter printAllOut) {
		for (int i=0;i<pl.size();i++) {
			Person aktualPerson=(Person)pl.get(i);
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

	public static void printList (List<Person> inputList, String description){
		toOut("++++++ || "+description+" || Anzahl d. Eintraege: "+inputList.size()+" +++++++");
		for (int i=0;i<inputList.size();i++) {
			toOut(personFormatiert((Person)inputList.get(i)));
		}
		toOut();
	}

	public static void writeListToFile(ArrayList<Person> inputList, String filename) {
		PrintWriter fOut = new PrintWriter (new DirtyFileWriter(filename));
		for (int i=0;i<inputList.size();i++) {
			fOut.println(personFormatiert((Person)inputList.get(i)));
		}
		fOut.flush();
		fOut.close();
		toOut("--> "+filename+" geschrieben.");
		toOut();
	}

	public static ArrayList<Person> readAll(Scanner s) {
		ArrayList<Person> ReadingList = new ArrayList<Person>();
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

	public static ArrayList<Person> killDoppelGaenger(ArrayList<Person> personInput) {
		ArrayList<Person> outputList = new ArrayList<Person>();
		for (int i=0;i<=personInput.size()-1;i++) {
			Person verglPerson1 = (Person)personInput.get(i);
			Person verglPerson2 = null;
			if (i+1<=personInput.size()-1) {
				verglPerson2=(Person)personInput.get(i+1);
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
		outDoIt.println("+"+inputDoIt);
	}

}
