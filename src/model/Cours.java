package model;

import java.io.Serializable;

public class Cours implements Serializable {
	private String sigle;
	private String nom;
	private int maxEtudiant;
	private Inscription premierEtudiant;
	
	public Cours(String sigle, String nom, int maxEtudiant) {
		this.sigle = sigle;
		this.nom = nom;
		this.maxEtudiant = maxEtudiant;
	}
	
	public void ajouterEtudiant(Inscription nouvelleInscription) {
		Inscription coursInscription;
		
		coursInscription = this.premierEtudiant;
		
		if(coursInscription != null) {
			while(coursInscription.getNextEtudiant() != null) {
				coursInscription = coursInscription.getNextEtudiant();
			}
			
			coursInscription.setNextEtudiant(nouvelleInscription);
		} else {
			this.premierEtudiant = nouvelleInscription;
		}
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
	public Inscription getPremierEtudiant() {
		return premierEtudiant;
	}
	public void setPremierEtudiant(Inscription premierEtudiant) {
		this.premierEtudiant = premierEtudiant;
	}

}
