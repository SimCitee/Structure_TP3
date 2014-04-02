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
				
				annulerInscription();
				break;
				
			/*case "2" :
				clearConsole();
				clearConsole();
				
				modificationInscription();
				break;
				
			case "3" : 
				clearConsole();
				clearConsole();
				break;*/
				
			default :
				clearConsole();
				menuPrincipal();
			
		}
		
	}

	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}

	private static void inscrireEtudiant() {
		String noEtudiant;
		String noCours;
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		Etudiant etudiant;
		Cours cours;
		Inscription nouvelleInscription;
		int itNoCours = 0;
		int itNoEtudiant = 0;
		
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
	
	private static void annulerInscription() {
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe();
		int itNoEtudiant = 0;
		String noEtudiant;
		
		for (Etudiant e : listeEtudiant) {
			System.out.println(itNoEtudiant++ + ". " + e.getCodePermanent() + " " + e.getPrenom() + " " + e.getNom());
		}
		
		System.out.print("Entrez numero de l'etudiant : ");
		noEtudiant = lecture();
	}
	
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
}
