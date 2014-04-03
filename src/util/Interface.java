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
	
	// Methode permettant d'effectuer une lecture au clavier
	// Parametre : Aucun
	// Valeur de retour : La chaine de caractere lue au clavier
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
	
	// Methode permettant d'effacer tout le texte se trouvant dans la console
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void clearConsole()
	{
		System.out.print("\n\n\n\n");
	}
	
	// Methode permettant de valider un entier et s'il se trouve dans un intervalle donnee
	// Parametre : Un nombre potentiel, Debut de l'intervalle, Fin de l'interface
	// Valeur de retour : Valeur boolenne representant si le nombre est valide et s'il respecte l'intervalle donnee
	public static boolean validerEntier(String valeur, int plageDebut, int plageFin)
	{
		int choixUtilisateur;
		
		// Test pour valider si la chaine de caractere correspond a un nombre entier
		try { 
			choixUtilisateur = Integer.parseInt(valeur); 
	    } 
		catch(NumberFormatException e) { 
	        return false; 
	    }
		
		// Test pour valider si le nombre se trouve dans l'intervalle donnee
		if((choixUtilisateur >= plageDebut) && (choixUtilisateur <= plageFin))
			return true;

		return false;
	}
	
	// Methode permettant d'afficher le menu principal
	// Parametre : Aucun
	// Valeur de retour : Aucun
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
				
				inscrireEtudiant(); // Inscrire un etudiant a un cours
				break;
				
			case "2" :
				clearConsole();
				clearConsole();
				
				annulerInscription(); // Annuler une inscription
				System.out.println("L'inscription a ete annulee.");
				lecture();
				menuPrincipal();
				break;
				
			case "3" : 
				clearConsole();
				clearConsole();
				
				modifierInscripton(); // Modifier une inscription
				break;
			case "4" : 
				clearConsole();
				clearConsole();
				afficherCoursEtudiant(); // Afficher tous les cours d'un etudiant donne
				break;
			case "5" : 
				clearConsole();
				clearConsole();
				afficherEtudiantCours(); // Affciher tous les etudiants inscrit a un cours
				break;
			case "6" : 
				clearConsole();
				clearConsole();
				FileManip.sauvegarder(); // Sauvegarder toutes les donnees dans des fichiers
				menuPrincipal();
				break;
			case "7" : 
				clearConsole();
				clearConsole();
				FileManip.charger(); // Lire les donnees dans les fichiers
				menuPrincipal();
				break;
				
			default :
				clearConsole();
				menuPrincipal();
			
		}
		
	}
	
	// Methode permettant de valider si une chaine de caractere correspond a un nombre reel
	// Parametre : Une chaine de caractere
	// Valeur de retour : Retourne vrai si la chaine de caractere est un nombre reel, sinon faux
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	// Methode permettant de valider s'il y a au moins un etudiant et un cours dans chacune des listes
	// Parametre : Aucun
	// Valeur de retour : Retourne vrai s'il y a au moins un etudiant et un cours dans chacune des liste, sinon faux
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
	
	// Methode permettant d'inscrire un etudiant a un cours
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void inscrireEtudiant() {
		String noEtudiant;    // Numero d'un etudiant
		String noCours;       // Numero d'un cours
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe();           // Liste des cours
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe(); // Liste des etudiants
		Etudiant etudiant;                 // Un etudiant
		Cours cours;                       // Un cours
		Inscription nouvelleInscription;   // La nouvelle inscription
		int itNoCours = 1;                 // Compteur pour l'affichage des cours
		int itNoEtudiant = 1;              // Compteur pour l'affichage des etudiants
		int nbEtudiant = 0;                // Numero de l'etudiant saisi au clavier
		int nbCours = 0;                   // Numero du cours saisi au clavier
		
		// Validation si les listes de cours et d'etudiants ne sont pas vides
		if (validerEtudiantsEtCours()) {
			// Parcours de la liste des etudiants
			for (Etudiant e : listeEtudiant) {
				System.out.println(itNoEtudiant++ + ". " + e.getCodePermanent() + " " + e.getPrenom() + " " + e.getNom());
				nbEtudiant++;
			}
			
			do {
				System.out.print("\nEntrez numero de l'etudiant : ");
				noEtudiant = lecture(); // Saisi du numero de l'etudiant par l'utilisateur
			} while(Integer.parseInt(noEtudiant) < 1 || Integer.parseInt(noEtudiant) > nbEtudiant);
			
			// Parcours de la liste des cours
			for (Cours c : listeCours) {
				System.out.println(itNoCours++ + ". " + c.getSigle() + " " + c.getNom());
				nbCours++;
			}
			
			do {
				System.out.print("\nEntrez numero du cours : ");
				noCours = lecture(); // Saisi du numéro de cours par l'utilisateur
			} while(Integer.parseInt(noCours) < 1 || Integer.parseInt(noCours) > nbCours);
			
			etudiant = listeEtudiant.get(Integer.parseInt(noEtudiant) - 1);
			cours = listeCours.get(Integer.parseInt(noCours) - 1);
			
			nouvelleInscription = new Inscription(etudiant, cours);
			
			etudiant.ajouterCours(nouvelleInscription); // Permet d'ajouter une inscription a la liste chainee des inscriptions (Volet etudiant)
			cours.ajouterEtudiant(nouvelleInscription); // Permet d'ajouter une inscription a la liste chainee des inscriptions (Volet cours)
			
			System.out.println("Inscription reussie");
			lecture();
		}
		
		menuPrincipal(); // Affichage du menu principal
	}
	
	// Methode permettant d'annuler une inscription
	// Parametre : Aucun
	// Valeur de retour : Un etudiant
	private static Etudiant annulerInscription() {
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe(); // Liste des etudiants
		int itNoCours = 1;             // Compteur pour l'affichage des cours
		int itNoEtudiant = 1;          // Compteur pour l'affichage des etudiants
		int nbEtudiant = 0;            // Numero de l'etudiant saisi au clavier
		int nbCours = 0;               // Numero du cours saisi au clavier
		String noEtudiant;             // Chaine de caractere du numero de l'etudiant lue au clavier
		String noCours;                // Chaine de caractere du numero de cours lue au clavier
		Etudiant etudiant;             // Un etudiant
		Cours cours;                   // Un cours
		Inscription etudiantInscription;  // L'inscription de l'etudiant au cours
		
		// Validation si les listes de cours et d'etudiants ne sont pas vides
		if (validerEtudiantsEtCours()) {
			// Parcours de la liste des etudiants
			for (Etudiant e : listeEtudiant) {
				System.out.println(itNoEtudiant++ + ". " + e.getCodePermanent() + " " + e.getPrenom() + " " + e.getNom());
				nbEtudiant++;
			}
			
			do {
				System.out.print("Entrez numero de l'etudiant : ");
				noEtudiant = lecture(); // Saisi du numero de l'etudiant par l'utilisateur
			} while(Integer.parseInt(noEtudiant) < 1 || Integer.parseInt(noEtudiant) > nbEtudiant);
			
			etudiant = listeEtudiant.get(Integer.parseInt(noEtudiant) - 1);
			
			etudiantInscription = etudiant.getPremierCours(); // Premier cours auquel l'etudiant est inscrit
			
			// Parcours de la liste des cours auxquels l'etudiant est inscrit
			while(etudiantInscription != null) {
				cours = etudiantInscription.getCours();
				System.out.println(itNoCours++ + ". " + cours.getSigle() + " " + cours.getNom());
				etudiantInscription = etudiantInscription.getNextCours();
				nbCours++;
			}
			
			do {
				System.out.print("Entrez numero du cours : ");
				noCours = lecture(); // Saisi du numero du cours au clavier
			} while(Integer.parseInt(noCours) < 1 || Integer.parseInt(noCours) > nbCours);
			
			// Recherche de l'inscription de l'etudiant
			int i = 1;
			etudiantInscription = etudiant.getPremierCours();
			while(i != Integer.parseInt(noCours)) {
				etudiantInscription = etudiantInscription.getNextCours();
				i++;
			}
			
			cours = etudiantInscription.getCours();
			
			supprimerCours(etudiant, cours); // Suppression de l'inscription
			
			return etudiant;
		
		}
		
		return null; // Si une des liste (Cours/Etudiant) est vide, on retourne la valeur null
	}
	
	// Methode permettant de supprimer le maillon d'une inscription
	// Parametre : Un etudiant, un cours
	// Valeur de retour : Aucun
	private static void supprimerCours(Etudiant etudiant, Cours cours) {
		Inscription etudiantInscription;       // L'inscription d'un etudiant
		Inscription tempEtudiantInscription;   // Variable temporaire de l'inscription d'un etudiant
		Inscription coursInscription;          // L'inscription a un cours
		Inscription tempCoursInscription;      // Variable temporaire de l'inscription a un cours
		
		etudiantInscription = etudiant.getPremierCours();
		tempEtudiantInscription = etudiantInscription;
		
		// Parcours des cours auxquels l'etudiant est inscrit
		if(etudiantInscription != null) {
			do {
				// Si le cours de l'inscription correspond au cours que l'on veut supprimer, on sort de la boucle
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
		
		// Parcours des etudiants inscrit a un cours
		if(etudiantInscription != null) {
			do {
				// Si l'etudiant de l'inscription correspond a l'etudiant que l'on veut supprimer, on sort de la boucle
				if(coursInscription.equals(etudiantInscription)) {
					tempCoursInscription.setNextEtudiant(coursInscription.getNextEtudiant());
					break;
				}
				
				tempCoursInscription = coursInscription;
				coursInscription = coursInscription.getNextEtudiant();
				
			} while(coursInscription != null);
		}
	}
	
	// Methode permettant de modifier une inscription
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void modifierInscripton() {
		Etudiant etudiant;      // Un etudiant
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe(); // Liste des cours
		int itNoCours = 1;      // Compteur pour l'affichage des cours
		int nbCours = 0;        // Compteur du nombre de cours
		String noCours;         // Chaine de caractere du numero de cours lue au clavier
		Cours cours;            // Un cours
		Inscription nouvelleInscription; // Nouvelle inscription qui sera créer
		
		// Validation si les listes de cours et d'etudiants ne sont pas vides
		if (validerEtudiantsEtCours()) {
			etudiant = annulerInscription(); // On utilise la methode permettant d'annuler une inscription
			
			// Parcours de la liste des cours
			for (Cours c : listeCours) {
				System.out.println(itNoCours++ + ". " + c.getSigle() + " " + c.getNom());
				nbCours++;
			}
			
			do {
				System.out.print("Entrez numero du cours : ");
				noCours = lecture(); // Saisi du numero de cours au clavier
			} while(Integer.parseInt(noCours) < 1 || Integer.parseInt(noCours) > nbCours);
			
			cours = listeCours.get(Integer.parseInt(noCours) - 1);
			
			nouvelleInscription = new Inscription(etudiant, cours);
			
			etudiant.ajouterCours(nouvelleInscription); // Permet d'ajouter une inscription a la liste chainee des inscriptions (Volet etudiant)
			cours.ajouterEtudiant(nouvelleInscription); // Permet d'ajouter une inscription a la liste chainee des inscriptions (Volet cours)
		
		}
		
		menuPrincipal(); // Affichage du menu principal
	}

	// Methode permettant de faire afficher les cours d'un etudiant (Methode de depart)
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void afficherCoursEtudiant() {
		
		ArrayList<Etudiant> listeEtudiant = ListeEtudiants.getInstance().getListe(); // Liste des etudiants
		int i = 0;                // Compteur
		int element;              // Nombre lu au clavier representant le numero d'un etudiant
		Etudiant choix = null;    // Etudiant dont on veut faire afficher les cours
		String choixEtudiant;     // Chaine de caractere lue au clavier representant un numero d'etudiant
		
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
		menuPrincipal(); // Affichage du menu principal
	}
	
	// Methode recursive permettant de faire afficher les cours d'un etudiant
	// Parametre : Une inscription
	// Valeur de retour
	private static void afficherCours(Inscription inscription) {
		System.out.println(inscription.getCours().getSigle() + " | " + inscription.getCours().getNom());
		
		// Si l'etudiant est inscrit a un autre cours
		if (inscription.getNextCours() != null)
			afficherCours(inscription.getNextCours());
	}
	
	// Methode permettant de faire afficher les etudiants inscrit a un cours (Methode de depart)
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void afficherEtudiantCours() {
		
		ArrayList<Cours> listeCours = ListeCours.getInstance().getListe(); // Liste des cours
		int i = 0;                // Compteur
		int element;              // Nombre lu au clavier representant le numero d'un cours
		Cours choix = null;       // Cours dont on veut afficher les etudiants
		String choixCours;        // Chaine de caractere lue au clavier representant un numero de cours
		
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
		menuPrincipal(); // Affichage du menu principal
	}
	
	// Methode recursive permettant de faire afficher les etudiants inscrit a un cours 
	// Parametre : Une inscription
	// Valeur de retour : Aucun
	private static void afficherEtudiant(Inscription inscription) {
		System.out.println(inscription.getEtudiant().getNom() + ", " + inscription.getEtudiant().getPrenom() + " (" + inscription.getEtudiant().getCodePermanent() + ")");
		
		// S'il y a un autre etudiant inscrit au cours
		if (inscription.getNextEtudiant() != null)
			afficherEtudiant(inscription.getNextEtudiant());
	}
}
