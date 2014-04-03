package model;

import java.io.Serializable;

public class Cours implements Serializable {
	private String sigle;                  // Sigle du cours
	private String nom;                    // Nom du cours
	private int maxEtudiant;               // Nombre maximum d'etudiant dans le cours
	private Inscription premierEtudiant;   // Inscription du premier etudiant au cours
	
	// Constructeur de la classe Cours
	public Cours(String sigle, String nom, int maxEtudiant) {
		this.sigle = sigle;        
		this.nom = nom;                 
		this.maxEtudiant = maxEtudiant;
	}
	
	// Methode permettant d'ajouter une inscription a la liste chainee des etudiants inscrit a un cours
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	public void ajouterEtudiant(Inscription nouvelleInscription) {
		Inscription coursInscription;
		
		coursInscription = this.premierEtudiant;
		
		if(coursInscription != null) {
			// Parcours de la liste chainee jusqu'a la fin
			while(coursInscription.getNextEtudiant() != null) {
				coursInscription = coursInscription.getNextEtudiant();
			}
			
			coursInscription.setNextEtudiant(nouvelleInscription); // On ajoute l'inscription a la fin de la liste
		} else {
			this.premierEtudiant = nouvelleInscription; // Il s'agit de la premiere inscription d'un cours
		}
	}
	// Methode permettant d'obtenir le sigle d'un cours
	// Paramètre : Aucun
	// Valeur de retour : Le sigle du cours
	public String getSigle() {
		return sigle;
	}
	
	// Methode permettant d'initialiser le sigle d'un cours
	// Paramètre : La valeur du sigle
	// Valeur de retour : Aucun
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	
	// Methode permettant d'obtenir le nom d'un cours
	// Paramètre : Aucun
	// Valeur de retour : Le nom du cours
	public String getNom() {
		return nom;
	}
	
	// Methode permettant d'initialiser le nom d'un cours
	// Parametre : Le nom du cours
	// Valeur de retour : Aucun
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Methode permettant d'obtenir le nombre maximum d'etudiant d'un cours
	// Parametre : Aucun
	// Valeur de retour : Le nombre maximum d'etudiant d'un cours
	public int getMaxEtudiant() {
		return maxEtudiant;
	}
	
	// Methode permettant d'initialiser le nombre maximum d'etudiant d'un cours
	// Parametre : Le nombre maximum d'etudiant d'un cours
	// Valeur de retour : Aucun
	public void setMaxEtudiant(int maxEtudiant) {
		this.maxEtudiant = maxEtudiant;
	}
	
	// Methode permettant d'obtenir l'inscription du premier etudiant d'un cours
	// Parametre : Aucun
	// Valeur de retour : L'inscription du premier etudiant d'un cours
	public Inscription getPremierEtudiant() {
		return premierEtudiant;
	}
	
	// Methode permettant d'initialiser l'inscription du premier etudiant d'un cours
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	public void setPremierEtudiant(Inscription premierEtudiant) {
		this.premierEtudiant = premierEtudiant;
	}

}
