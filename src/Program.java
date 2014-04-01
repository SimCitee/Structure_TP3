import model.ListeCours;
import model.ListeEtudiants;
import util.FileManip;
import util.Interface;

public class Program {

	public static void main(String[] args) {
		
		Interface layout = new Interface();
		
		FileManip.chargerFichierDonnees();
		
		int countEtudiants = ListeEtudiants.getInstance().getListe().size();
		int countCours = ListeCours.getInstance().getListe().size();
		
		System.out.println(String.valueOf(countEtudiants));
		System.out.println(String.valueOf(countCours));
		
		//layout.menuPrincipal();
		
	}

}