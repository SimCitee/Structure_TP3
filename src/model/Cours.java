package model;

import java.io.Serializable;

public class Cours implements Serializable {
	private String sigle;
	private String nom;
	private int maxEtudiant;
	private int nbInscription;
	
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

}
