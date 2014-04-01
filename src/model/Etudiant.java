package model;

import java.io.Serializable;

public class Etudiant implements Serializable {

	private String codePermanent;
	private String nom;
	private String prenom;
	private int noProgramme;
	private int credit;
	private double moyenne;
	private int nbCoursInscrit;
	
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
	public int getNbCoursInscrit() {
		return nbCoursInscrit;
	}
	public void setNbCoursInscrit(int nbCoursInscrit) {
		this.nbCoursInscrit = nbCoursInscrit;
	}
	
}
