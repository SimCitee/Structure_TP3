package model;

public class Inscription {

	private Etudiant etudiant;
	private Etudiant nextEtudiant;
	private Cours cours;
	private Cours nextCours;
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Etudiant getNextEtudiant() {
		return nextEtudiant;
	}
	public void setNextEtudiant(Etudiant nextEtudiant) {
		this.nextEtudiant = nextEtudiant;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Cours getNextCours() {
		return nextCours;
	}
	public void setNextCours(Cours nextCours) {
		this.nextCours = nextCours;
	}
	
}
