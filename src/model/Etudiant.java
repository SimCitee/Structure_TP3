package model;

import java.io.Serializable;

public class Etudiant implements Serializable {

	private String codePermanent;
	private String nom;
	private String prenom;
	private int noProgramme;
	private int credit;
	private double moyenne;
	private Inscription premierCours;
	
	public Etudiant(String codePermanent, String nom, String prenom, int noProgramme, int credit, double moyenne) {
		this.codePermanent = codePermanent;
		this.nom = nom;
		this.prenom = prenom;
		this.noProgramme = noProgramme;
		this.credit = credit;
		this.moyenne = moyenne;
	}
	
	public void ajouterCours(Inscription nouvelleInscription) {
		Inscription etudiantInscription;
		
		etudiantInscription = this.premierCours;
		
		if(etudiantInscription != null) {
			while(etudiantInscription != null) {
				etudiantInscription = etudiantInscription.getNextCours();
			}
			etudiantInscription.setNextCours(nouvelleInscription);
		} else {
			this.premierCours = nouvelleInscription;
		}
	}
	
	public String getCodePermanent() {
		return codePermanent;
	}
	public void setCodePermanent(String codePermanent) {
		this.codePermanent = codePermanent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNoProgramme() {
		return noProgramme;
	}
	public void setNoProgramme(int noProgramme) {
		this.noProgramme = noProgramme;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	public Inscription getPremierCours() {
		return premierCours;
	}

	public void setPremierCours(Inscription premierCours) {
		this.premierCours = premierCours;
	}
	
}
