package cartes;

public class JeuDeCartes {

	private Configuration[] configuration  = new Configuration[]{
        		new Configuration(new Borne(25), 10),
                new Configuration(new Borne(50), 10),
                new Configuration(new Borne(75), 10),
                new Configuration(new Borne(100), 12),
                new Configuration(new Borne(200), 4),
                new Configuration(new Attaque(Type.FEU), 5),
                new Configuration(new Parade(Type.FEU), 14),
                new Configuration(new Botte(Type.FEU), 1),
                new Configuration(new Attaque(Type.ESSENCE), 3),
                new Configuration(new Parade(Type.ESSENCE), 6),
                new Configuration(new Botte(Type.ESSENCE), 1),
                new Configuration(new Attaque(Type.CREVAISON), 3),
                new Configuration(new Parade(Type.CREVAISON), 6),
                new Configuration(new Botte(Type.CREVAISON), 1),
                new Configuration(new Attaque(Type.ACCIDENT), 3),
                new Configuration(new Parade(Type.ACCIDENT), 6),
                new Configuration(new Botte(Type.ACCIDENT), 1),
                new Configuration(new DebutLimite(), 4),
                new Configuration(new FinLimite(), 6)
        };
	
	public String affichageJeuCartes() {
		
		StringBuilder sb = new StringBuilder();

	    for (Configuration config : this.configuration) {
	    	
	        Object carte = config.getCarte(); 
	        
	        int nbExemplaires = config.getNbExemplaires(); 

	        sb.append(nbExemplaires + " " + carte.toString() + "\n");
	        	
	      }
	    
	    return sb.toString() + "\n";

	}	
	
	private static class Configuration {

		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte,int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
	}
	
    public Carte[] donnerCartes() {
    	int nbExemplaires = 0;   
    	JeuDeCartes jDC = new JeuDeCartes();
    	
    	for (Configuration config : jDC.configuration) {
            nbExemplaires += config.getNbExemplaires();
    	}
    	
    	Carte[] cartes = new Carte[nbExemplaires];
     	
    	for (Configuration config : jDC.configuration) {
            
            for (int j = 0; j < config.getNbExemplaires();j++) {
            	
            	cartes[j] = config.getCarte();
            	
            }    		
            
    	}
    	
    	return cartes;
    	
    }

	public boolean checkCount() {
		for (Configuration config : this.configuration) {
			Carte carteConfig = config.getCarte();
			int nbAttendu = config.getNbExemplaires();
			int nbTrouve = 0;
			for (Carte carte : donnerCartes()) {
				if (carte == carteConfig) {
					nbTrouve++;
				}
			}
			if (nbTrouve != nbAttendu) {
				return false;
			}
		}
		return true;
	}
	
}
