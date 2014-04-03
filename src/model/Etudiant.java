package model;

import java.io.Serializable;

public class Etudiant implements Serializable {

	private String codePermanent;          // Code permanent de l'etudiant
	private String nom;                    // Nom de l'etudiant
	private String prenom;                 // Prenom de l'etudiant
	private int noProgramme;               // Numero du programme de l'etudiant
	private int credit;                    // Nombre de credit acquis par l'etudiant
	private double moyenne;                // Moyenne generale de l'etudiant
	private Inscription premierCours;      // Premier cours auquel l'etudiant est inscrit
	
	// Constructeur de la classe Etudiant
	public Etudiant(String codePermanent, String nom, String prenom, int noProgramme, int credit, double moyenne) {
		this.codePermanent = codePermanent;
		this.nom = nom;
		this.prenom = prenom;
		this.noProgramme = noProgramme;
		this.credit = credit;
		this.moyenne = moyenne;
	}
	
	// Methode permettant d'ajouter une inscription a la liste chainee des cours d'un etudiant
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	public void ajouterCours(Inscription nouvelleInscription) {
		Inscription etudiantInscription;
		
		etudiantInscription = this.premierCours;
		
		if(etudiantInscription != null) {
			// Parcours de la liste chainee jusqu'a la fin
			while(etudiantInscription.getNextCours() != null) {
				etudiantInscription = etudiantInscription.getNextCours();
			}
			etudiantInscription.setNextCours(nouvelleInscription); // On ajoute l'inscription a la fin de la liste
		} else {
			this.premierCours = nouvelleInscription; // Il s'agit de la premiere inscription de l'etudiant
		}
	}
	
	// Methode permettant d'obtenir le code permanent d'un etudiant
	// Parametre : Aucun
	// Valeur de retour : Le code permanent de l'etudiant
	public String getCodePermanent() {
		return codePermanent;
	}
	
	// Methode permettant d'initialiser le code permanent de l'etudiant
	// Parametre : Le code permanent de l'etudiant
	// Valeur de retour : Aucun
	public void setCodePermanent(String codePermanent) {
		this.codePermanent = codePermanent;
	}
	
	// Methode permettant d'obtenir le nom de l'etudiant
	// Parametre : Aucun
	// Valeur de retour : Le nom de l'etudiant
	public String getNom() {
		return nom;
	}
	
	// Methode permettant d'initialiser le nom de l'etudiant
	// Parametre : Le nom de de l'etudiant
	// Valeur de retour : Aucun
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Methode permettant d'obtenir le prenom de l'etudiant
	// Parametre : Aucun
	// Valeur de retour : Le prenom de l'etudiant
	public String getPrenom() {
		return prenom;
	}
	
	// Methode permettant d'initialiser le prenom de l'etudiant
	// Parametre : Le prenom de l'etudiant
	// Valeur de retour : Aucun
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// Methode permettant d'obtenir le numero de programme de l'etudiant
	// Parametre : Aucun
	// Valeur de retour : Le numero de programme de l'etudiant
	public int getNoProgramme() {
		return noProgramme;
	}
	
	// Methode permettant d'initialiser le numero de programme de l'etudiant
	// Parametre : Le numero de programme de l'etudiant
	// Valeur de retour : Aucun
	public void setNoProgramme(int noProgramme) {
		this.noProgramme = noProgramme;
	}
	
	// Methode permettant d'obtenir le nombre de credit acquis par l'etudiant
	// Parametre : Aucun
	// Valeur de retour : Le nombre de credit acquis par l'etudiant
	public int getCredit() {
		return credit;
	}
	
	// Methode permettant d'initialiser le nombre de credit acquis par l'etudiant
	// Parametre : Le nombre de credit acquis par l'etudiant
	// Valeur de retour : Aucun
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	// Methode permettant d'obtenir la moyenne generale d'un etudiant
	// Parametre : Aucun
	// Valeur de retour : La moyenne generale d'un etudiant
	public double getMoyenne() {
		return moyenne;
	}
	
	// Methode permettant d'initialiser la moyenne generale d'un etudiant
	// Parametre : La moyenne generale d'un etudiant
	// Valeur de retour : Aucun
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	
	// Methode permettant d'obtenir l'inscription du premier cours auquel l'etudiant est inscrit
	// Parametre : Aucun
	// Valeur de retour : L'inscription du premier cours auquel l'etudiant est inscrit
	public Inscription getPremierCours() {
		return premierCours;
	}

	// Methode permettant d'initialiser l'inscription du premier cours auquel l'etudiant est inscrit
	// Parametre : L'inscription du premier cours auquel l'etudiant est inscrit
	// Valeur de retour : Aucun
	public void setPremierCours(Inscription premierCours) {
		this.premierCours = premierCours;
	}
	
}
