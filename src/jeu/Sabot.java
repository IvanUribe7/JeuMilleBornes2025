package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	
	int nbCartes;
	Carte[] pioche;
	private int modCount = 0;
	private boolean nextEffectue = false;
	
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
        public Carte next() throws NoSuchElementException{
        	verificationConcurrence();
        	if (hasNext()) {
        		 Carte carte = pioche[index];
        		 index++;
        		 nextEffectue = true;
        		 return carte;
        		 } else {
        			 throw new NoSuchElementException();
        	}

        }


		@Override
        public void remove() throws IllegalStateException{
        	
			verificationConcurrence();
			
            if (index == 0) {
                throw new IllegalStateException("Impossible de retirer la carte.");
            }
       
            int removeIndex = index - 1;   
            for (int i = removeIndex; i < nbCartes - 1; i++) {
            	pioche[i] = pioche[i + 1];
            }
            
            
            nextEffectue = false;
            nbCartes--;
            index--;     
            pioche[nbCartes] = null; 
        }
		
		private void verificationConcurrence() throws ConcurrentModificationException{
			 if (modCount != expectedModCount) {
				 throw new ConcurrentModificationException();
			}
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
		
		modCount++;
	}
	
	public Carte piocher() {
		
		Iterator<Carte> it = this.iterator();
		if (!it.hasNext()) {
        	System.out.println("Le sabot est vide");
            return null;
        }
		Carte cartePiocher = it.next();
		it.remove();
		modCount++;
		return cartePiocher;
	}
	
	
}
