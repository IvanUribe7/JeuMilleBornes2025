package cartes;

public class FinLimite extends Limite{

	@Override
	public String toString() {
		return "FinLimite";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FinLimite fL) {
			return toString().equals(fL.toString());
		}
		return false;
	}
	
}
