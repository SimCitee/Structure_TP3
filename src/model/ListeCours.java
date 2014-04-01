package model;

import java.util.ArrayList;

public class ListeCours {
	
	private static ListeCours instance = null;
	private ArrayList<Cours> liste;
	
	protected ListeCours() {
		
	}
	
	// Singleton
	public static ListeCours getInstance() {
		if (instance == null) {
			instance = new ListeCours();
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

