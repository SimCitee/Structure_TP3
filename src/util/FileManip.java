package util;

public class FileManip {
	
	// serialisation de la liste de transactions
	/*public void sauvegarder() {
		try{
	      OutputStream fichier = new FileOutputStream("transactions.ser");
	      OutputStream buffer = new BufferedOutputStream(fichier);
	      ObjectOutput sortie = new ObjectOutputStream(buffer);
	      	      
	      try{
	    	  sortie.writeObject(this.transactions);
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
	public void charger() {
		try(
	      InputStream fichier = new FileInputStream("transactions.ser");
	      InputStream buffer = new BufferedInputStream(fichier);
	      ObjectInput input = new ObjectInputStream (buffer);
	    ){
	      this.transactions = (ArrayList<Transaction>)input.readObject();	      
	    }
		catch(ClassNotFoundException e){
			System.out.print("Erreur : " + e.getClass() + "\n");
	    }
		catch(IOException e){
		    System.out.print("Erreur : " + e.getClass() + "\n");
		}
	}*/

}
