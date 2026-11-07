package presentation;
import model.*;

public class presentation {
	
	int scelta=0;
	Parcheggio obj=new Parcheggio();
	
	public void menu() {
		System.out.println("1.Aggiungi un veicolo");
		System.out.println("2.Elimina un veicolo");
		System.out.println("3.Ricerca informazioni di un veicolo");
		System.out.println("4.Ricerca i veicoli aventi un dato numero di posti");
		System.out.println("5.Ottieni quante macchine per marca ci sono");
		System.out.println("6.Esci");

	}
	
	public void eseguimenu() {
		
		while(scelta!=6) {
			
			menu();
			System.out.println("fai una scelta ");
			scelta=Integer.parseInt(IO.readln());
			casi();
			
		}


	}
	
	public void casi() {
		
		switch (scelta) {
		
			case 1:
				
				System.out.println("inserisci la targa ");
				String targa=IO.readln();
				boolean vof=obj.inseriscitarga(targa);
				
				while(vof==false) {
					System.out.println("ce gia una macchina con questa targe reinserisci ");
					targa=IO.readln();
					vof=obj.inseriscitarga(targa);
				}
				
				System.out.println("inserisci la marca ");
				String marca=IO.readln();
				
				System.out.println("inserisci il modello ");
				String modello=IO.readln();
				
				System.out.println("inserisci numero di posti ");
				int numeroposti=Integer.parseInt(IO.readln());

				int x=obj.creaoggetto(targa, marca, modello, numeroposti);
				System.out.println("macchina entrata correttamente il codice assegnato e' "+x);
				
			break;
			
			case 2:
				
				System.out.println("vuoi cercare la macchina per targa(1) o per codice(2)? ");
				int s=Integer.parseInt(IO.readln());
				
				while(s!=1 && s!=2) {
					System.out.println("scegli un opzione disponibile ");
					s=Integer.parseInt(IO.readln());
				}
				
				if(s==1) {
					System.out.println("inserisci la targa");
					String t=IO.readln();
					boolean vofe=obj.eliminapertarga(t);
					
					while(vofe==false) {
						System.out.println("la targa non esiste reinserisci");
						t=IO.readln();
						vofe=obj.eliminapertarga(t);
					}
					
					System.out.println("macchina eliminata");
					
				}else {
					System.out.println("inserisci il codice");
					int c=Integer.parseInt(IO.readln());
					boolean vofe=obj.eliminapercodice(c);
					
					while(vofe==false) {
						System.out.println("il codice non esiste reinserisci");
						c=Integer.parseInt(IO.readln());
						vofe=obj.eliminapercodice(c);
					}
					
					System.out.println("macchina eliminata");
				}
				
				
			break;
			
			case 3:
				
				System.out.println("vuoi cercare la macchina per targa(1) o per codice(2)? ");
				int ss=Integer.parseInt(IO.readln());
				
				while(ss!=1 && ss!=2) {
					System.out.println("scegli un opzione disponibile ");
					ss=Integer.parseInt(IO.readln());
				}
				
				if(ss==1) {
					System.out.println("inserisci la targa");
					String tt=IO.readln();
					String vofe=obj.findpertarga(tt);
					
					while(vofe.equalsIgnoreCase("no")) {
						System.out.println("la targa non esiste reinserisci");
						tt=IO.readln();
						vofe=obj.findpertarga(tt);
					}
					
					System.out.println(vofe);
					
				}else {
					System.out.println("inserisci il codice");
					int cc=Integer.parseInt(IO.readln());
					String vofe=obj.findpercod(cc);
					
					while(vofe.equalsIgnoreCase("no")) {
						System.out.println("il codice non esiste reinserisci");
						cc=Integer.parseInt(IO.readln());
						vofe=obj.findpercod(cc);
					}
					System.out.println(vofe);

					
				}
				
			break;
			
			case 4:
				System.out.println("inserisci il numero di posti che cerchi");
				int input=Integer.parseInt(IO.readln());
				String prova=obj.findposti(input);
				
				if(prova=="no") {
					System.out.println("non ci sono auto con questi posti");
				}else {
					System.out.println(prova);
				}
				
			break;
			
			case 5:
				
				System.out.println("inserisci la marca");
				String marc=IO.readln(); 
				int co=obj.contamarca(marc);
				if(co==0) {
					System.out.println("non ci sono macchine di marca "+marc);
				}else {
					System.out.println("ci sono "+co+" macchine di marca "+marc);
				}
				
			break;
			
			case 6:
				System.out.println("ARRIVEDERCI");
			break;
			
			default:
				System.out.println("inserisci un opzione disponibile");
			break;
		}
	}
}
