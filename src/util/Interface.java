package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.Iterator;

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
			/*case "1" :
				clearConsole();
				clearConsole();
				break;
				
			case "2" :
				clearConsole();
				clearConsole();
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

}
