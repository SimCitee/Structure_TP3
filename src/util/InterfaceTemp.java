package util;

import java.util.ArrayList;

import model.Cours;
import model.Etudiant;
import model.Inscription;
import model.ListeCours;
import model.ListeEtudiants;


public class InterfaceTemp {

	private void afficherCoursEtudiant() {
		
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		int i = 1;
		int element;
		Etudiant choix;
		String choixEtudiant;
		
		for (Etudiant etudiant : listeEtudiant) {
			if (i % 3 == 0)
				System.out.println(i + ". " + etudiant.getCodePermanent() + "\t");
			else
				System.out.println(i + ". " + etudiant.getCodePermanent());
			i++;
		}
		System.out.println("Choisissez l'etudiant dont vous voulez afficher les cours : ");
		choixEtudiant = Interface.lecture();
		
		element = Integer.parseInt(choixEtudiant);
		
		choix = listeEtudiant.get(element-1);
		
		if (choix.getPremierCours() != null) {
			System.out.println("Liste des cours de l'étudiant : ");
			afficherCours(choix.getPremierCours());
		}
		else
			System.out.println("L'etudiant choisit n'est inscrit à aucun cours!");
	}
	private void afficherCours(Inscription inscription) {
		System.out.println(inscription.getCours().getSigle() + " | " + inscription.getCours().getNom());
		
		if (inscription.getNextCours() != null)
			afficherCours(inscription.getNextCours());
	}
	
	private void afficherEtudiantCours() {
		
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		int i = 1;
		int element;
		Cours choix;
		String choixCours;
		
		for (Cours cours : listeCours) {
			if (i % 3 == 0)
				System.out.println(i + ". " + cours.getSigle() + "\t");
			else
				System.out.println(i + ". " + cours.getSigle());
			i++;
		}
		System.out.println("Choisissez le cours dont vous voulez afficher les etudiants : ");
		choixCours = Interface.lecture();
		
		element = Integer.parseInt(choixCours);
		
		choix = listeCours.get(element-1);
		
		if (choix.getPremierEtudiant() != null) {
			System.out.println("Liste des etudiants du cours : ");
			afficherEtudiant(choix.getPremierEtudiant());
		}
		else
			System.out.println("Il n'y a aucun etudiant inscrit au cours choisit!");
	}
	private void afficherEtudiant(Inscription inscription) {
		System.out.println(inscription.getEtudiant().getNom() + ", " + inscription.getEtudiant().getPrenom() + " (" + inscription.getEtudiant().getCodePermanent() + ")");
		
		if (inscription.getNextEtudiant() != null)
			afficherEtudiant(inscription.getNextEtudiant());
	}
	private Etudiant findEtudiant(String codePermanent) {
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		
		for (Etudiant etudiant : listeEtudiant) {
			if (codePermanent.equalsIgnoreCase(etudiant.getCodePermanent()))
				return etudiant;
		}
		return null;
	}
	
	private Cours findCours(String sigle) {
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		
		for (Cours cours : listeCours) {
			if (sigle.equalsIgnoreCase(cours.getSigle()))
				return cours;
		}
		return null;
	}
}
