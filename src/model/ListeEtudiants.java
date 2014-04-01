package model;

import java.util.ArrayList;

public class ListeEtudiants {
	
	private static ListeEtudiants instance = null;
	private ArrayList<Etudiant> liste;
	
	protected ListeEtudiants() {
		
	}
	
	// Singleton
	public static ListeEtudiants getInstance() {
		if (instance == null) {
			instance = new ListeEtudiants();
		}
		
		return instance;
	}

	public ArrayList<Etudiant> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Etudiant> liste) {
		this.liste = liste;
	}

}
