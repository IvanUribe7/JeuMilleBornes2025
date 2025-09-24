package cartes;

public class Borne extends Carte{
	
	int km;

	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return km + "KM";
	}

	
}
