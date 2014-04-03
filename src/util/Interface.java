package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.ArrayList;
import java.util.Iterator;

import model.Cours;
import model.Etudiant;
import model.Inscription;
import model.ListeCours;
import model.ListeEtudiants;

public class Interface {
	
	public static String lecture ()
	{
		String str = "";
		
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    str = bufferRead.readLine(); 
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	public static void clearConsole()
	{
		System.out.print("\n\n\n\n");
	}
	
	// valider si chiffre entree est un entier
	public static boolean validerEntier(String valeur, int plageDebut, int plageFin)
	{
		int choixUtilisateur;

		try { 
			choixUtilisateur = Integer.parseInt(valeur); 
	    } 
		catch(NumberFormatException e) { 
	        return false; 
	    }
		
		if((choixUtilisateur >= plageDebut) && (choixUtilisateur <= plageFin))
			return true;

		return false;
	}
	
	//Interface principale
	public static void menuPrincipal()
	{
		
		String choixUtilisateur;
		
		do
		{
			System.out.println("Menu principal");
			
			System.out.print("\nVeuillez choisir une des options suivantes:");
			System.out.print("\n1. Inscrire un etudiant a un cours");
			System.out.print("\n2. Annuler l'inscription d'un etudiant a un cours");
			System.out.print("\n3. Modifier l'inscription d'un etudiant a un cours");
			System.out.print("\n4. Obtenir la liste des cours d'un etudiant");
			System.out.print("\n5. Obtenir la liste des etudiant a un cours donne");
			System.out.print("\n6. Sauvegarder les informations dans un fichier");
			System.out.print("\n7. Charger les informations depuis un fichier");
			System.out.print("\n0. Quitter");
			
			choixUtilisateur = lecture();
			
		    if (validerEntier(choixUtilisateur, 0, 7))
		    {
		    	//Le choix est valide, on sort de la validation
		    	break;
		    }
		    
		    clearConsole();
		} while (true);
	
		switch(choixUtilisateur)
		{
		
			case "0" :
				System.exit(0);
				break;
			case "1" :
				clearConsole();
				clearConsole();
				
				inscrireEtudiant();
				break;
				
			case "2" :
				clearConsole();
				clearConsole();
				
				annulerInscription();
				menuPrincipal();
				break;
				
			case "3" : 
				clearConsole();
				clearConsole();
				
				modifierInscripton();
				break;
			case "4" : 
				clearConsole();
				clearConsole();
				afficherCoursEtudiant();
				break;
			case "5" : 
				clearConsole();
				clearConsole();
				afficherEtudiantCours();
				break;
			case "6" : 
				clearConsole();
				clearConsole();
				FileManip.sauvegarder();
				menuPrincipal();
				break;
			case "7" : 
				clearConsole();
				clearConsole();
				FileManip.charger();
				menuPrincipal();
				break;
				
			default :
				clearConsole();
				menuPrincipal();
			
		}
		
	}

	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	private static boolean validerEtudiantsEtCours() {
		if (ListeEtudiants.getInstance().getListe().size() > 0 && ListeCours.getInstance().getListe().size() > 0)
			return true;
		else {
			if (ListeEtudiants.getInstance().getListe().size() == 0)
				System.out.print("Il n'y a aucun etudiant existant.");
			else
				System.out.print("Il n'y a aucun cours existant.");
			lecture();
			clearConsole();
		}
		return false;
	}

	private static void inscrireEtudiant() {
		String noEtudiant;
		String noCours;
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		Etudiant etudiant;
		Cours cours;
		Inscription nouvelleInscription;
		int itNoCours = 1;
		int itNoEtudiant = 1;
		
		if (validerEtudiantsEtCours()) {
			for (Etudiant e : listeEtudiant) {
				System.out.println(itNoEtudiant++ + ". " + e.getCodePermanent() + " " + e.getPrenom() + " " + e.getNom());
			}
			
			System.out.print("Entrez numero de l'etudiant : ");
			noEtudiant = lecture();
			
			for (Cours c : listeCours) {
				System.out.println(itNoCours++ + ". " + c.getSigle() + " " + c.getNom());
			}
			
			System.out.print("Entrez numero du cours : ");
			noCours = lecture();
			
			etudiant = listeEtudiant.get(Integer.parseInt(noEtudiant) - 1);
			cours = listeCours.get(Integer.parseInt(noCours) - 1);
			
			nouvelleInscription = new Inscription(etudiant, cours);
			
			etudiant.ajouterCours(nouvelleInscription);
			cours.ajouterEtudiant(nouvelleInscription);
		}
		
		menuPrincipal();
	}
	
	private static Etudiant annulerInscription() {
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		int itNoCours = 1;
		int itNoEtudiant = 1;
		String noEtudiant;
		String noCours;
		Etudiant etudiant;
		Cours cours;
		Inscription etudiantInscription;
		
		if (validerEtudiantsEtCours()) {
			for (Etudiant e : listeEtudiant) {
				System.out.println(itNoEtudiant++ + ". " + e.getCodePermanent() + " " + e.getPrenom() + " " + e.getNom());
			}
			
			System.out.print("Entrez numero de l'etudiant : ");
			noEtudiant = lecture();
			
			etudiant = listeEtudiant.get(Integer.parseInt(noEtudiant) - 1);
			
			etudiantInscription = etudiant.getPremierCours();
			
			while(etudiantInscription != null) {
				cours = etudiantInscription.getCours();
				System.out.println(itNoCours++ + ". " + cours.getSigle() + " " + cours.getNom());
				etudiantInscription = etudiantInscription.getNextCours();
			}
			
			System.out.print("Entrez numero du cours : ");
			noCours = lecture();
			
			int i = 1;
			etudiantInscription = etudiant.getPremierCours();
			while(i != Integer.parseInt(noCours)) {
				etudiantInscription = etudiantInscription.getNextCours();
				i++;
			}
			
			cours = etudiantInscription.getCours();
			
			supprimerCours(etudiant, cours);
			
			System.out.println("L'inscription a ete annulee.");
			lecture();
			return etudiant;
		
		}
		
		return null;
	}
	
	private static void supprimerCours(Etudiant etudiant, Cours cours) {
		Inscription etudiantInscription;
		Inscription tempEtudiantInscription;
		Inscription coursInscription;
		Inscription tempCoursInscription;
		
		etudiantInscription = etudiant.getPremierCours();
		tempEtudiantInscription = etudiantInscription;
		
		if(etudiantInscription != null) {
			do {
				if(etudiantInscription.getCours().equals(cours)) {
					tempEtudiantInscription.setNextCours(etudiantInscription.getNextCours());
					break;
				}
				
				tempEtudiantInscription = etudiantInscription;
				etudiantInscription = etudiantInscription.getNextCours();
				
			} while(etudiantInscription != null);
		}
		
		coursInscription = cours.getPremierEtudiant();
		tempCoursInscription = coursInscription;
		
		if(etudiantInscription != null) {
			do {
				if(coursInscription.equals(etudiantInscription)) {
					tempCoursInscription.setNextEtudiant(coursInscription.getNextEtudiant());
					break;
				}
				
				tempCoursInscription = coursInscription;
				coursInscription = coursInscription.getNextEtudiant();
				
			} while(coursInscription != null);
		}
	}
	
	private static void modifierInscripton() {
		Etudiant etudiant;
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		int itNoCours = 1;
		String noCours;
		Cours cours;
		Inscription nouvelleInscription;
		
		if (validerEtudiantsEtCours()) {
			etudiant = annulerInscription();
			
			for (Cours c : listeCours) {
				System.out.println(itNoCours++ + ". " + c.getSigle() + " " + c.getNom());
			}
			
			System.out.print("Entrez numero du cours : ");
			noCours = lecture();
			
			cours = listeCours.get(Integer.parseInt(noCours) - 1);
			
			nouvelleInscription = new Inscription(etudiant, cours);
			
			etudiant.ajouterCours(nouvelleInscription);
			cours.ajouterEtudiant(nouvelleInscription);
		}
		
		menuPrincipal();
	}

	private static void afficherCoursEtudiant() {
		
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		int i = 0;
		int element;
		Etudiant choix = null;
		String choixEtudiant;
		
		for (Etudiant etudiant : listeEtudiant) {
			if (i % 3 == 0)
				System.out.println((i+1) + ". " + etudiant.getCodePermanent() + "\t");
			else
				System.out.println((i+1) + ". " + etudiant.getCodePermanent());
			i++;
		}
				
		if (i > 1) {
			
			do {
				System.out.println("Choisissez l'etudiant dont vous voulez afficher les cours : ");
				choixEtudiant = Interface.lecture();
				
				element = isNumeric(choixEtudiant) ? Integer.parseInt(choixEtudiant) : -1;
				
				if(element > 0 && element <= i)
					choix = listeEtudiant.get(element-1);
			} while( (element < 1 || element > i));
			
			if (choix.getPremierCours() != null) {
				System.out.println("\nListe des cours de " + choix.getPrenom() + " " + choix.getNom());
				System.out.println("================================================");
				afficherCours(choix.getPremierCours());
			}
			else
				System.out.println("L'etudiant choisit n'est inscrit a aucun cours!");
		} else
			System.out.println("Il n'y a pas d'etudiants");
		
		lecture();
		menuPrincipal();
	}

	private static void afficherCours(Inscription inscription) {
		System.out.println(inscription.getCours().getSigle() + " | " + inscription.getCours().getNom());
		
		if (inscription.getNextCours() != null)
			afficherCours(inscription.getNextCours());
	}
	
	private static void afficherEtudiantCours() {
		
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		int i = 0;
		int element;
		Cours choix = null;
		String choixCours;
		
		for (Cours cours : listeCours) {
			if (i % 3 == 0)
				System.out.println((i+1) + ". " + cours.getSigle() + "\t");
			else
				System.out.println((i+1) + ". " + cours.getSigle());
			i++;
		}
		
		if (i > 1) {
			
			do {
				System.out.println("Choisissez le cours dont vous voulez afficher les etudiants : ");
				choixCours = Interface.lecture();
				
				element = isNumeric(choixCours) ? Integer.parseInt(choixCours) : -1;
				
				if(element > 0 && element <= i)
					choix = listeCours.get(element-1);
			} while( (element < 1 || element > i));
			
			if (choix.getPremierEtudiant() != null) {
				System.out.println("\nListe des etudiants du cours " + choix.getNom());
				System.out.println("================================================");
				afficherEtudiant(choix.getPremierEtudiant());
			}
			else
				System.out.println("Il n'y a aucun etudiant inscrit au cours choisit!");
		} else
			System.out.println("Il n'y a pas de cours");
		
		lecture();
		menuPrincipal();
	}
	
	private static void afficherEtudiant(Inscription inscription) {
		System.out.println(inscription.getEtudiant().getNom() + ", " + inscription.getEtudiant().getPrenom() + " (" + inscription.getEtudiant().getCodePermanent() + ")");
		
		if (inscription.getNextEtudiant() != null)
			afficherEtudiant(inscription.getNextEtudiant());
	}
}
