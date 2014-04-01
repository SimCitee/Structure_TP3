package model;

import java.util.ArrayList;

public class ListeEtudiants {
	
	private static ListeEtudiants instance = null;
	private static ArrayList<Etudiant> liste;
	
	protected ListeEtudiants() {
		
	}
	
	// Singleton
	public static ListeEtudiants getInstance() {
		if (instance == null) {
			instance = new ListeEtudiants();
			liste = new ArrayList<Etudiant>();
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
