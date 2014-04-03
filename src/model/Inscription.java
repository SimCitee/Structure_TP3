package model;

import java.io.Serializable;

public class Inscription implements Serializable {

	private Etudiant etudiant;			// etudiant suivant un cours
	private Inscription nextEtudiant;	// pointe vers le prochain etudiant pour d'un cours
	private Cours cours;				// cours suivi par un etudiant
	private Inscription nextCours;		// pointe vers le prochain cours d'un etudiant
	
	// Constructeur de la classe inscription
	public Inscription(Etudiant e, Cours c) {
		this.etudiant = e;
		this.cours = c;
		this.nextEtudiant = null;
		this.nextCours = null;
	}
	
	// Methode permettant d'obtenir l'etudiant figurant sur l'inscription
	// Parametre : Aucun
	// Valeur de retour : L'etudiant figurant sur l'inscription
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	// Methode permettant d'initialiser l'etudiant figurant sur l'inscription
	// Parametre : L'etudiant
	// Valeur de retour : Aucun
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	// Methode permettant d'obtenir la prochaine inscription d'un cours
	// Parametre : Aucun
	// Valeur de retour : La prochaine inscription d'un cours
	public Inscription getNextEtudiant() {
		return nextEtudiant;
	}
	
	// Methode permettant d'initialiser le pointeur vers la prochaine inscription d'un cours
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	public void setNextEtudiant(Inscription nextEtudiant) {
		this.nextEtudiant = nextEtudiant;
	}
	
	// Methode permettant d'obtenir le cours figurant sur l'inscription
	// Parametre : Aucun
	// Valeur de retour : Le cours figurant sur l'inscription
	public Cours getCours() {
		return cours;
	}
	
	// Methode permettant d'initialiser le cours figurant sur l'inscription
	// Parametre : Un cours
	// Valeur de retour : Aucun
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	// Methode permettant d'obtenir la prochaine inscription d'un etudiant
	// Parametre : Aucun
	// Valeur de retour : La prochaine inscription d'un etudiant
	public Inscription getNextCours() {
		return nextCours;
	}
	
	// Methode permettant d'initialiser le pointeur vers la prochaine inscription d'un etudiant
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	public void setNextCours(Inscription nextCours) {
		this.nextCours = nextCours;
	}
	
	
}
