package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import model.Cours;
import model.Etudiant;
import model.Inscription;
import model.ListeCours;
import model.ListeEtudiants;
import util.Comparateur;

// Classe permettant la manipulation des fichiers
public class FileManip {
	
	// Constructeur vide de la classe FileManip
	public FileManip() {
		
	}
	// Methode permettant la lecture des donnees dans les fichiers
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void chargerFichierDonnees() {
		// Lecture des donnees des etudiants
		try {

			FileInputStream fstream = new FileInputStream("etudiants.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String ligne;
			  
			while ((ligne = br.readLine()) != null)   {
				String[] donnees = ligne.split("\\|");

				Etudiant e = new Etudiant(donnees[0], donnees[1], donnees[2], Integer.parseInt(donnees[3]), Integer.parseInt(donnees[4]), Double.parseDouble(donnees[5]));
				ListeEtudiants.getInstance().getListe().add(e);
			}

			in.close();
		} catch (Exception e) {
			  System.err.println("Error: " + e.getMessage());
		}
		
		// Lecture des donnees des cours
		try {

			FileInputStream fstream = new FileInputStream("cours.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String ligne;
			  
			while ((ligne = br.readLine()) != null)   {
				String[] donnees = ligne.split("\\|");
				Cours c = new Cours(donnees[0], donnees[1], Integer.parseInt(donnees[2]));
				ListeCours.getInstance().getListe().add(c);
			}

			in.close();
		} catch (Exception e) {
			  System.err.println("Error: " + e.getMessage());
		}
		
		// Lecture des donnees des inscriptions
		try {

			FileInputStream fstream = new FileInputStream("inscriptions.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String ligne;
			  
			while ((ligne = br.readLine()) != null)   {
				String[] donnees = ligne.split("\\|");
				
				Etudiant e = ListeEtudiants.getInstance().chercherEtudiant(donnees[0]);
				Cours c = ListeCours.getInstance().chercherCours(donnees[1]);
				
				Inscription i = new Inscription(e, c);
				
				e.ajouterCours(i);
				c.ajouterEtudiant(i);
			}

			in.close();
		} catch (Exception e) {
			  System.err.println("Error: " + e.getMessage());
		}
		  
	}
	
	// Methode permettant de sauvegarder les donnees dans les fichiers
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void sauvegarder() {
		// Verification si la liste d'etudiants contient des donnees
		if(ListeEtudiants.getInstance().getListe().size() > 0)
			sauvegarderEtudiants();
		
		// Verification si la liste des cours contient des donnees
		if(ListeCours.getInstance().getListe().size() > 0)
			sauvegarderCours();
		
		sauvegarderInscription();
		
		System.out.println("Les donnees ont ete enregistrees dans les fichiers.");
		Interface.lecture();
	}
	
	// Methode permettant de charger les donnees des fichiers
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void charger() {
		chargerEtudiants(); // Chargement des etudiants
		chargerCours();     // Chargement des cours
		
		System.out.println("Les donnees ont ete chargees.");
		Interface.lecture();
	}
	
	// Methode permettant de charger les donnees des etudiants
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void chargerEtudiants() {
		try(
	      InputStream fichier = new FileInputStream("etudiants.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
			ArrayList<Etudiant> liste = (ArrayList<Etudiant>)input.readObject(); // Liste des etudiants
			ListeEtudiants.getInstance().setListe(liste); // Initialisation de la liste des etudiants
			
			Comparateur c = new Comparateur();
			
			// Trier en ordre de code permanent les etudiants
			Collections.sort(ListeEtudiants.getInstance().getListe(), c.getComprateurEtudiant());
	    }
		catch(ClassNotFoundException e){
			System.out.print("Erreur : " + e.getClass() + "\n");
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}
	
	// Methode permettant de charger les donnees des cours
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void chargerCours() {
		try(
	      InputStream fichier = new FileInputStream("cours.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
			ArrayList<Cours> liste = (ArrayList<Cours>)input.readObject(); // Liste des cours
			ListeCours.getInstance().setListe(liste); // Initialisation de la liste des cours
			
			Comparateur c = new Comparateur();
			
			// Trier en ordre de sigle les cours
			Collections.sort(ListeCours.getInstance().getListe(), c.getComparateurCours());
				      
	    }
		catch(ClassNotFoundException e){
			System.out.print("Erreur : " + e.getClass() + "\n");
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}
	
	// Methode permettant de charger les donnees des inscriptions
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void chargerInscription() {
		try(
	      InputStream fichier = new FileInputStream("inscriptions.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
			ArrayList<Inscription> liste = (ArrayList<Inscription>)input.readObject(); // Liste des inscriptions
			
			for(Inscription i : liste) {
				Etudiant e = i.getEtudiant();
				e.ajouterCours(i); // Ajout de l'inscription d'un cours a un etudiant
			}
			
	    }
		catch(ClassNotFoundException e){
			System.out.print("Erreur : " + e.getClass() + "\n");
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}
	
	// Methode permettant la serialisation de la liste des etudiants
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void sauvegarderEtudiants() {
		try {
			OutputStream fichier = new FileOutputStream("etudiants.ser");
			OutputStream buffer = new BufferedOutputStream(fichier);
			ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
			try{
	    	  sortie.writeObject(ListeEtudiants.getInstance().getListe()); // Serialisation
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
	}
	
	// Methode permettant la serialisation de la liste des cours
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void sauvegarderCours() {
		try {
			OutputStream fichier = new FileOutputStream("cours.ser");
			OutputStream buffer = new BufferedOutputStream(fichier);
			ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
			try{
	    	  sortie.writeObject(ListeCours.getInstance().getListe()); // Serialisation
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
	}
	
	// Methode permettant la serialisation de la liste des inscriptions
	// Parametre : Aucun
	// Valeur de retour : Aucun
	private static void sauvegarderInscription() {
	
		ArrayList<Inscription> listeTempo = new ArrayList<Inscription>(); // Liste temporaires des inscriptions
		
		// Parcourir toute les inscriptions de chaque etudiant pour remplir la liste temporaire des inscriptions
		for(Etudiant e : ListeEtudiants.getInstance().getListe()) {
			Inscription inscription = e.getPremierCours();
			
			do {
				if (inscription != null) {
					listeTempo.add(inscription);
					inscription = inscription.getNextCours();
				}
			} while (inscription != null);
			
		}
		
		try {
			OutputStream fichier = new FileOutputStream("inscription.ser");
			OutputStream buffer = new BufferedOutputStream(fichier);
			ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
			try{
	    	  sortie.writeObject(listeTempo); // Serialisation
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
		
		
	}

}
