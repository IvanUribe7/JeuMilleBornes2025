package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		Attaque fR1 = new Attaque(Type.FEU);
		Attaque fR2 = new Attaque(Type.FEU);
		Parade fV = new Parade(Type.FEU);
		
		System.out.println("Deux cartes de 25km sont identiques ?"
				 + borne1.equals(borne2) + "\n");
		System.out.println("Deux cartes de feux rouge sont identiques ?"
				 + fR1.equals(fR2) + "\n");
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ?"
				 + fR1.equals(fV) + "\n");
		
	}

}
