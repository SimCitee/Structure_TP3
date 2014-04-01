package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import model.Etudiant;
import model.Inscription;
import model.ListeCours;
import model.ListeEtudiants;

public class FileManip {
	
	public FileManip() {
		
	}
	
	
	public static void sauvegarder() {
		sauvegarderEtudiants();
		sauvegarderCours();
		sauvegarderInscription();
	}
	
	public static void charger() {
		chargerEtudiants();
	}
	
	private static void chargerEtudiants() {
		try(
	      InputStream fichier = new FileInputStream("etudiants.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
			ArrayList<Etudiant> liste = (ArrayList<Etudiant>)input.readObject();
			ListeEtudiants.getInstance().setListe(liste);
				      
	    }
		catch(ClassNotFoundException e){
			System.out.print("Erreur : " + e.getClass() + "\n");
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}
	
	// serialisation de la liste des etudiants
	private static void sauvegarderEtudiants() {
		try {
			OutputStream fichier = new FileOutputStream("etudiants.ser");
			OutputStream buffer = new BufferedOutputStream(fichier);
			ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
			try{
	    	  sortie.writeObject(ListeEtudiants.getInstance().getListe());
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
	}
	
	// serialisation de la liste des cours
	private static void sauvegarderCours() {
		try {
			OutputStream fichier = new FileOutputStream("cours.ser");
			OutputStream buffer = new BufferedOutputStream(fichier);
			ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
			try{
	    	  sortie.writeObject(ListeCours.getInstance().getListe());
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
	}
	
	// serialisation de la liste des inscriptions
	private static void sauvegarderInscription() {
	
		ArrayList<Inscription> listeTempo = new ArrayList<Inscription>();
		
		// parcourir toute les inscriptions de chaque etudiant
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
	    	  sortie.writeObject(listeTempo);
			}
			finally{
	    	  sortie.close();
			}
	    }  
	    	catch(IOException e){
	    	System.out.print("Erreur : " + e.getClass());
	    }
		
		
	}
	
	
	// deserialisation de la liste de transactions
	public void charger2() {
		try(
	      InputStream fichier = new FileInputStream("transactions.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}

}
