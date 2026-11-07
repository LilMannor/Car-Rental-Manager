package model;

public class Auto {
	
	private final int codice;
	private final String targa;
	private final String marca;
	private final String modello;
	private final int numeroposti;
	
	
	public Auto(int codice,String targa,String marca,String modello,int numeroposti) {
		
		this.targa=targa;
		this.marca=marca;
		this.modello=modello;
		this.codice=codice;
		
		if(numeroposti<=1 || numeroposti>=10) {
			throw new IllegalArgumentException ("I posti devono essere tra 2 e 9 la macchina non e stata inserita");
		}else {
			this.numeroposti=numeroposti;
		}
		
	}


	
	public int getCodice() {
		return codice;
	}



	public String getTarga() {
		return targa;
	}



	public String getMarca() {
		return marca;
	}



	public String getModello() {
		return modello;
	}



	public int getNumeroposti() {
		return numeroposti;
	}



	public String toString() {
		return "codice=" + codice + ", targa=" + targa + ", marca=" + marca + ", modello=" + modello ;
	}
	
	
	

}
