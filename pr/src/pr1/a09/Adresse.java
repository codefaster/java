package pr1.a09;

public class Adresse  {
	
	// implizit: extends java.lang.Object
	protected int hausNr;
	protected String ort;
	protected int plz;
	protected String strasse;

	// toString order:
	// nach Konstruktor.
	
	// Vollst??ndiger Konstruktor
	public Adresse(int plz, String ort, String strasse, int hausNr) {
		this.plz=plz;
		this.ort=ort;
		this.hausNr=hausNr;
		this.strasse=strasse;
	}
	
	// Kopierkonstruktor
	public Adresse(Adresse inputObject){
		this(inputObject.plz,inputObject.ort,inputObject.strasse,inputObject.hausNr);
	}
	
	public int getHausNr() {
		return hausNr;
	}
	
	public String getOrt() {
		return ort;
	}
	                   
	public int getPlz() {
		return plz;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public String toString() {
		Integer hausNrConv=hausNr;
		Integer plzConv=plz;
		return plzConv.toString()+" "+ort+" "+strasse+" "+hausNrConv.toString();
	}
	
	public int compareTo(Adresse inputAdresse) {
		int hirachyNumber = inputAdresse.ort.compareTo(ort);
		if (hirachyNumber == 0 ) {
			hirachyNumber = inputAdresse.strasse.compareTo(strasse);
		}
		if (hirachyNumber == 0) {
			Integer inputPlz = inputAdresse.plz;
			hirachyNumber = inputPlz.compareTo(plz);
		}
		return hirachyNumber;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hausNr;
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		if (hausNr != other.hausNr)
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}
}
