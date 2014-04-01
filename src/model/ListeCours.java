package model;

import java.util.ArrayList;

public class ListeCours {
	
	private static ListeCours instance = null;
	private static ArrayList<Cours> liste;
	
	protected ListeCours() {
		
	}
	
	// Singleton
	public static ListeCours getInstance() {
		if (instance == null) {
			instance = new ListeCours();
			liste = new ArrayList<Cours>();
		}
		
		return instance;
	}

	public ArrayList<Cours> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Cours> liste) {
		this.liste = liste;
	}

}

