package pr1.a09;

public class Einwohner extends Person {
	
	protected Adresse adresse;
	
	// toString order:
	// nach Konstruktor.
	// Kopierkonstruktoren
	
	public Einwohner (Person person, Adresse adresse) {
		super(person);
		this.adresse=adresse;
	}
	
	public Einwohner (Einwohner einwohner) {
		this(einwohner.getPerson(), einwohner.adresse);
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public Person getPerson() {
		return new Person(vorname,nachname,geburtsjahr);
	}

	public String toString() {
		return super.toString()+" "+adresse.toString();
	}

	public int compareTo (Einwohner inputEinwohner) {
		return inputEinwohner.adresse.compareTo(this.adresse);
	}
	
	public Einwohner umziehenNach(Adresse adresse) {
		this.adresse = adresse;
		return new Einwohner(getPerson(),adresse);
	}
}
