package cartes;

public abstract class Probleme extends Carte {
	
	Type type; 

	protected Probleme(Type type) {
		
		this.type = type;
		
	}
	
	public Type getType() {
		return type;
	}
	
	
	
}
