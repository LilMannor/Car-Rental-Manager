package model;

public class Parcheggio {

	private Auto posti[] = new Auto[1000];
	int pos=0;			//lo uso come indice 
	int cod=1;			//lo uso per il codice
	
	
	public int creaoggetto(String targa,String marca,String modello,int numeroposti) {
		
		if (pos >= posti.length) {
            System.out.println("Parcheggio pieno");
        }else {
        	
        	try {
    			
    			posti[pos] = new Auto(cod, targa, marca, modello, numeroposti);
    			int codvecchio=cod;
    			cod=cod+1;
    			pos=pos+1;
    			return codvecchio;

    			
    		}catch (IllegalArgumentException e) {
    			System.out.println(e.getMessage());
    		}
    		
    	}
		return 0;
    }
	
	public boolean inseriscitarga(String input) {
		
		for(int i=0;i<pos;i++) {								//SCORRO da 0 a fino alle posizioni che esistono
			
			if(posti[i].getTarga().equalsIgnoreCase(input)) {	//se tra quelle posizioni esistenti la trovo torno false
	            return false; 
	        }
			
		}
		return true;											//altrimenti torno vero

	}
	
	public boolean eliminapercodice(int codice) {
		
		for(int i=0;i<pos;i++) {
			
			if(posti[i].getCodice()==codice) {
				
				for(int j = i; j < pos - 1; j++) { 				// parto dal buco
					posti[j] = posti[j + 1];					//e sposto tutto a sinistra cosi sovrascrivo anche il valore attuale
				}
				
				posti[pos - 1] = null;							//ora all ultimo posto io ho un doppione quindi lo metto a nul
				pos--; 											// e decremento pos cosi finisce dove sta lultimo numero
				
				return true;
			}
		}
		return false;
		
	}
	
	public boolean eliminapertarga(String input) {
		for(int i = 0; i < pos; i++) {
			if(posti[i].getTarga().equalsIgnoreCase(input)) {
				
				for(int j = i; j < pos - 1; j++) { 				// parto dal buco
					posti[j] = posti[j + 1];					//e sposto tutto a sinistra cosi sovrascrivo anche il valore attuale
				}
				
				posti[pos - 1] = null;							//ora all ultimo posto io ho un doppione quindi lo metto a nul
				pos--; 											// e decremento pos cosi finisce dove sta lultimo numero
				
				return true;
			}
		}
		return false;
	}
	
	public String findpertarga(String input) {
		
		for(int i = 0; i < pos; i++) {
			
			if(posti[i].getTarga().equalsIgnoreCase(input)) {
				return posti[i].toString();
			}
			
		}
		return "no";
	}
	
	public String findpercod(int codice) {
		
		for(int i = 0; i < pos; i++) {
			
			if(posti[i].getCodice()==codice) {
				return posti[i].toString();
			}
			
		}
		return "no";
	}
	
	public String findposti(int input) {
		
		if(input>=10 || input<=1) {
			return "no";
		}
		
		boolean trovato=false;
		String elenco="";
		
		for(int i = 0; i < pos; i++) {
			
			if(input==posti[i].getNumeroposti()) {
				
				elenco+=posti[i].toString()+"\n";				//cosi sto concatenando la stringa quindi il += prende la stringa elenco e mette accanto posti[i].toString()
				trovato=true;
				
			}
		}
		
		if(trovato==true) {
			return elenco;
		} else {
			return "no";
		}
		
	}
	
	public int contamarca(String marca) {
		
		int contatore=0;
		
		for(int i = 0; i < pos; i++) {
			
			if(posti[i].getMarca().equalsIgnoreCase(marca)) {
				contatore=contatore+1;
			}
		}
		return contatore;
	}
	
	
	
	
	
	
}
