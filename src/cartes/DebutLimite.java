package cartes;

public class DebutLimite extends Limite {

	@Override
	public String toString() {
		return "Limite 50";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DebutLimite dL) {
			return toString().equals(dL.toString());
		}
		return false;
	}
	
}
