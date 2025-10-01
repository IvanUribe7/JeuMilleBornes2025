package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.*;

public class GestionCartes {

	public static void extraire1(List<Carte> liste) {
		Random randomNumbers = new Random();
		int rand = randomNumbers.nextInt(liste.size()+1);
		liste.remove(rand);
	}
	
	public static void extraire2(List<Carte> liste) {
		Random randomNumbers = new Random();
		int rand = randomNumbers.nextInt(liste.size()+1);
		System.out.println(rand);
		ListIterator<Carte> it = liste.listIterator();
		for(;it.hasNext() && it.nextIndex() != rand+1;)it.next();	
		it.remove();
	}
	
	public static List<Carte> melanger(List<Carte> liste) {
		List<Carte> newL = new ArrayList<Carte>();
		for(ListIterator<Carte> it = liste.listIterator();it.hasNext();) { newL.add(it.next()); it.remove();}
		return newL;
	}
	
	public static void main(String[] args) {
		List<Carte> l = new ArrayList<>();
		l.add(new Parade(Type.FEU));
		l.add(new Attaque(Type.FEU));
		l.add(new Attaque(Type.CREVAISON));
		l.add(new Borne(25));
		System.out.println(l);
		GestionCartes.extraire2(l);
		System.out.println(l);
	}

}
