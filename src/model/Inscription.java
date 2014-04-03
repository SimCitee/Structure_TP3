package model;

import java.io.Serializable;

public class Inscription implements Serializable {

	private Etudiant etudiant;			// etudiant suivant un cours
	private Inscription nextEtudiant;	// pointe vers le prochain etudiant pour d'un cours
	private Cours cours;				// cours suivi par un etudiant
	private Inscription nextCours;		// pointe vers le prochain cours d'un etudiant
	
	public Inscription(Etudiant e, Cours c) {
		this.etudiant = e;
		this.cours = c;
		this.nextEtudiant = null;
		this.nextCours = null;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Inscription getNextEtudiant() {
		return nextEtudiant;
	}
	public void setNextEtudiant(Inscription nextEtudiant) {
		this.nextEtudiant = nextEtudiant;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Inscription getNextCours() {
		return nextCours;
	}
	public void setNextCours(Inscription nextCours) {
		this.nextCours = nextCours;
	}
	
	
}
