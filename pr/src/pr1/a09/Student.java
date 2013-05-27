package pr1.a09;

public class Student extends Person {
	protected int matrikel; 
	
	// toString order:
	// nach Konstruktor.
	
	//Vollst??ndiger Konstruktor mit super()-Aufruf
	public Student (String vorname, String nachname, int geburtsjahr, int matrikel) {
		super(vorname,nachname,geburtsjahr);
		this.matrikel=matrikel;
	}
	
	//Kopierkonstruktoren
	public Student (Person person, int matrikel) {
		super(person);
		this.matrikel=matrikel;
	}

	public Student (Student student) {
		this(student.vorname,student.nachname,student.geburtsjahr,student.matrikel);
	}
	
	public int getMatrikelNummer() {
		return matrikel;
	}
	
	
	public String toString()  {
		Integer matrikel=this.matrikel;
		return super.toString() + " " + matrikel.toString();
	}
	

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + matrikel;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikel != other.matrikel)
			return false;
		return true;
	}
}
