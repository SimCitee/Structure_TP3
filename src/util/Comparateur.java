package util;

import java.util.Comparator;

import model.Etudiant;
import model.Cours;

// Classe permettant de comparer deux elements dans les tableaux de cours et d'etudiants pour les trier
public class Comparateur {
   
   private ComparateurEtudiant comparateurEtudiant; // Comparateur d'etudiant
   private ComparateurCours comparateurCours;       // Comparateur de cours

   // Constructeur de la classe Comparateur
   public Comparateur() {
	   this.comparateurEtudiant = new ComparateurEtudiant();
	   this.comparateurCours = new ComparateurCours();
   }

   // Methode permettant d'obtenir le comparateur d'etudiants
   // Parametre : Aucun
   // Valeur de retour : Le comparateur d'etudiants
   public ComparateurEtudiant getComprateurEtudiant() {
	  return comparateurEtudiant;
   }

   // Methode permettant d'obtenir le comparateur de cours
   // Parametre : Aucun
   // Valeur de retour : Le comparateur de cours
   public ComparateurCours getComparateurCours() {
	  return comparateurCours;
   }

   // Classe permettant de comparer deux etudiants
   public class ComparateurEtudiant implements Comparator<Etudiant> {
		@Override
		// Methode permettant de comparer deux etudiants avec le code permanent
		// Parametre : Un etudiant, un autre etudiant
		// Valeur de retour : Entier representant quel etudiant vient avant l'autre
		public int compare(Etudiant etudiant1, Etudiant etudiant2) {
			return (etudiant1.getCodePermanent().compareToIgnoreCase(etudiant2.getCodePermanent()));
		}
   }
   
   // Classe permettant de comparer deux cours
   public class ComparateurCours implements Comparator<Cours> {
		@Override
		// Methode permettant de comparer deux cours avec le sigle du cours
		// Parametre : Un cours, un autre cours
		// Valeur de retour : Entier representant quel cours vient avant l'autre
		public int compare(Cours cours1, Cours cours2) {
			return (cours1.getSigle().compareToIgnoreCase(cours2.getSigle()));
		}
  }
}