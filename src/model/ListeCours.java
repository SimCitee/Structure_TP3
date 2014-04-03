package model;

import java.util.ArrayList;

public class ListeCours {
	
	private static ListeCours instance = null; 	// Instance de classe ListeCours
	private static ArrayList<Cours> liste;      // Liste des cours
	
	// Constructeur vide de la classe permettant de gérer la liste des cours
	protected ListeCours() {
		
	}
	
	// Methode permettant d'implanter le Singleton
	// Parametre : Aucun
	// Valeur de retour : L'instance de la classe ListeCours
	public static ListeCours getInstance() {
		if (instance == null) {
			instance = new ListeCours();
			liste = new ArrayList<Cours>();
		}
		
		return instance;
	}

	// Methode permettant d'obtenir la liste des cours
	// Parametre : Aucun
	// Valeur de retour : La liste des cours
	public ArrayList<Cours> getListe() {
		return liste;
	}
	
	// Methode permettant d'initialiser la liste des cours
	// Parametre : La liste des cours
	// Valeur de retour : Aucun
	public void setListe(ArrayList<Cours> liste) {
		this.liste = liste;
	}
	
	// Methode permettant de rechercher un cours parmi la liste de cours avec le sigle du cours
	// Parametre : Le sigle d'un cours
	// Valeur de retour : Un cours
	public Cours chercherCours(String sigle) {
		
		for (Cours cours : liste) {
			if (sigle.equalsIgnoreCase(cours.getSigle()))
				return cours;
		}
		return null;
	}
}

