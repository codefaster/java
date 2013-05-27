package pr1.a09;

public class Person {
	// implizit: extends java.lang.Object
	protected String vorname;
	protected String nachname;
	protected int geburtsjahr;
	
	// toString order:
	// nach Konstruktor.
	
	// Vollst??ndiger Konstruktor 
	public Person (String vorname, String nachname, int geburtsjahr) {
		this.vorname=vorname;
		this.nachname=nachname;
		this.geburtsjahr=geburtsjahr;
	}
	
	// Kopierkonstruktor
	public Person(Person other){
		this(other.vorname,other.nachname,other.geburtsjahr);
	}
	
	public int getGeburtsjahr() {
		return geburtsjahr; 	
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String toString() {
		Integer geburtsjahr=this.geburtsjahr;
		return vorname+" "+nachname+" "+geburtsjahr.toString();
	}
	
	public void heiraten(Person spouse) {
		this.nachname = spouse.nachname;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
}
