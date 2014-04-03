package model;

import java.util.ArrayList;

public class ListeEtudiants {
	
	private static ListeEtudiants instance = null; // Instance de la classe ListeEtudiants
	private static ArrayList<Etudiant> liste;      // Liste des etudiants
	
	// Constructeur vide de la classe permettant de gérer la liste des etudiants
	protected ListeEtudiants() {
		
	}
	
	// Methode permettant d'implanter le Singleton
	// Parametre : Aucun
	// Valeur de retour : L'instance de la classe ListeEtudiants
	public static ListeEtudiants getInstance() {
		if (instance == null) {
			instance = new ListeEtudiants();
			liste = new ArrayList<Etudiant>();
		}
		
		return instance;
	}
	
	// Methode permettant d'obtenir la liste des etudiants
	// Parametre : Aucun
	// Valeur de retour : La liste des etudiants
	public ArrayList<Etudiant> getListe() {
		return liste;
	}
	
	// Methode permettant d'initialiser la liste des etudiants
	// Parametre : La liste des etudiants
	// Valeur de retour : Aucun
	public void setListe(ArrayList<Etudiant> liste) {
		this.liste = liste;
	}
	
	// Methode permettant de rechercher un etudiant parmi la liste des etudiants avec son code permanent
	// Parametre : Le code permanent
	// Valeur de retour : Un etudiant
	public Etudiant chercherEtudiant(String codePermanent) {
		
		for (Etudiant etudiant : liste) {
			if (codePermanent.equalsIgnoreCase(etudiant.getCodePermanent()))
				return etudiant;
		}
		return null;
	}

}
