package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	
	int nbCartes;
	Carte[] pioche;
	private int modCount = 0;
	
	public Sabot(Carte[] cartes) {
		pioche = cartes;
		nbCartes = cartes.length;
	}
	
	@Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }
    
    private class SabotIterator implements Iterator<Carte> {
        private int index;
        private int expectedModCount = modCount; 

        @Override
        public boolean hasNext() {
            return index < nbCartes;
        }

        @Override 
        public Carte next() throws ConcurrentModificationException,NoSuchElementException{
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Le sabot a été modifié pendant l'itération.");
            }
            
            return pioche[index++];
        }


		@Override
        public void remove() throws ConcurrentModificationException,IllegalStateException{
        	
        	if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Le sabot a été modifié pendant l'itération.");
            }
            if (index == 0) {
                throw new IllegalStateException("Impossible de retirer la carte.");
            }
       
            int removeIndex = index - 1;   
            for (int i = removeIndex; i < nbCartes - 1; i++) {
            	pioche[i] = pioche[i + 1];
            }
            nbCartes--;
            index--;     
            pioche[nbCartes] = null; 
        }
    }

	
	public boolean estVide() {
		return this.nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) throws Exception {
		
		if(this.nbCartes >= this.pioche.length) {
		
			throw new Exception("Depassement capacité");
		
		}else {
			
			pioche[nbCartes] = carte;
			nbCartes ++;
		
		}
	}
	
	public Carte piocher() {
		
		Iterator<Carte> it = this.iterator();
		if (!it.hasNext()) {
        	System.out.println("Le sabot est vide");
            return null;
        }
		Carte cartePiocher = it.next();
		it.remove();
		return cartePiocher;
	}
	
	
}
