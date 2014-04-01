package model;

public class Inscription {

	private Etudiant etudiant;
	private Inscription nextEtudiant;
	private Cours cours;
	private Inscription nextCours;
	
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
