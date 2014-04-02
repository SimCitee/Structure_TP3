package util;

import java.util.Comparator;

import model.Etudiant;
import model.Cours;

public class Comparateur {
   
   private ComparateurEtudiant comparateurEtudiant; 
   private ComparateurCours comparateurCours;
	
   public Comparateur() {
	   this.comparateurEtudiant = new ComparateurEtudiant();
	   this.comparateurCours = new ComparateurCours();
   }
	
   public ComparateurEtudiant getComprateurEtudiant() {
	  return comparateurEtudiant;
   }

   public ComparateurCours getComparateurCours() {
	  return comparateurCours;
   }

   public class ComparateurEtudiant implements Comparator<Etudiant> {
		@Override
		public int compare(Etudiant etudiant1, Etudiant etudiant2) {
			return (etudiant1.getCodePermanent().compareToIgnoreCase(etudiant2.getCodePermanent()));
		}
   }
   
   public class ComparateurCours implements Comparator<Cours> {
		@Override
		public int compare(Cours cours1, Cours cours2) {
			return (cours1.getSigle().compareToIgnoreCase(cours2.getSigle()));
		}
  }
}