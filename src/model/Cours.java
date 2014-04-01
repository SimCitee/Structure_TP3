package model;

import java.io.Serializable;

public class Cours implements Serializable {
	private String sigle;
	private String nom;
	private int maxEtudiant;
	private int nbInscription;
	private Inscription premierEtudiant;
	
	public Cours(String sigle, String nom, int maxEtudiant, int nbInscription) {
		this.sigle = sigle;
		this.nom = nom;
		this.maxEtudiant = maxEtudiant;
		this.nbInscription = nbInscription;
	}
	
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMaxEtudiant() {
		return maxEtudiant;
	}
	public void setMaxEtudiant(int maxEtudiant) {
		this.maxEtudiant = maxEtudiant;
	}
	public int getNbInscription() {
		return nbInscription;
	}
	public void setNbInscription(int nbInscription) {
		this.nbInscription = nbInscription;
	}
	public Inscription getPremierEtudiant() {
		return premierEtudiant;
	}
	public void setPremierEtudiant(Inscription premierEtudiant) {
		this.premierEtudiant = premierEtudiant;
	}

}
