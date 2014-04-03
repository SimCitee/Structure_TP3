import model.ListeCours;
import model.ListeEtudiants;
import util.FileManip;
import util.Interface;

public class Program {

	// Programme principal
	public static void main(String[] args) {
		
		Interface layout = new Interface();
		
		//FileManip.chargerFichierDonnees(); // Instruction permettant de faire le chargement initial des donnees
		
		layout.menuPrincipal(); // Lancement de l'application
		
	}

}