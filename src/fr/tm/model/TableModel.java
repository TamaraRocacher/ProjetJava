package fr.tm.model;

import javax.swing.table.AbstractTableModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TableModel extends AbstractTableModel implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private Tache[] t;
	private Tache[] trie;
	private transient String[] title;
	
	public TableModel(Tache[] t, String[] title) {
		this.t = t;
		trie = null;
		this.title = title;
		
		deserialize();
		trier();
	}
	
	public void serialize() {
		try {
			// création d'une personne
			//Personne p = new Personne("Dupont", "Jean", 36);
			//System.out.println("creation de : " + p);

			// ouverture d'un flux de sortie vers le fichier "personne.serial"
			FileOutputStream fos = new FileOutputStream("TableModel.serial");

			// création d'un "flux objet" avec le flux fichier
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				// sérialisation : écriture de l'objet dans le flux de sortie
				oos.writeObject(t); 
				// on vide le tampon
				oos.flush();
				System.out.println(t + " a ete serialise");
			} finally {
				//fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public void deserialize() {
		try {
			// ouverture d'un flux d'entrée depuis le fichier "personne.serial"
			FileInputStream fis = new FileInputStream("TableModel.serial");
			// création d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// désérialisation : lecture de l'objet depuis le flux d'entrée
				t = (Tache[]) ois.readObject(); 
			} finally {
				// on ferme les flux
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public String getColumnName(int col) {
	     return this.title[col];
	   }
	
	public int getRowCount() {
	      return this.trie.length;
	  }
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.title.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if(col == 0) { 				//Effectué
			String str ="";
			if(trie[row] instanceof TachePonctuelle)
				str = this.trie[row].estTerminee() ? "100" :"0";
			return new String(str);
		}
		else if(col == 1) 			//Intitulé
			return this.trie[row].getIntitule();
		else if(col == 2){			//DateDeb
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			String laDateDeDebut = sdf.format(this.trie[row].getDateDebut());
			return laDateDeDebut;
		}
		else if(col == 3){			//DateFin
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			String laDateDeFin = sdf.format(this.trie[row].getDateFin());
			return laDateDeFin;
		}
		else if(col == 4)			//Categorie
			return this.trie[row].getCategorie();
		else						//BoutonSupprimer
			return "supp";
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        //ici la cellule (1, 2) est non-editable
        if (columnIndex == 0 || columnIndex == 5) return true;        
        
        return false;
    }
	
	public void setValueAt(Object value, int row, int col) {
	      //On interdit la modification sur certaines colonnes !
	      //if(!this.getColumnName(col).equals("ffectuée")
	        // && !this.getColumnName(col).equals("uppression"))
	        System.out.println("TEST");
	        if(col == 0 && row<trie.length){
	        	if(trie[row] instanceof TachePonctuelle && value.equals("100")) {
	        		//trie[row].setTerminee(true);
	        		t[trie[row].getId()].setTerminee(true);
	        		trier();
	        		this.fireTableDataChanged();
	        	}
	        }
	        serialize();
	}

	public void removeRow(int position){
	    position = trie[position].getId();
	    String str="position : "+position;
	    System.out.println(str);
		int indice = 0, indice2 = 0;
	    int nbRow = this.getRowCount()-1; //nbCol = this.getColumnCount();
	    Tache[] temp = new Tache[nbRow];
	    
	    for(Tache value : this.t){
	    	if(indice != position){
	    		//value.setId(value.getId()-1);
	    		temp[indice2++] = value;
	    		
	    	}
	    	System.out.println("Indice = " + indice);
	    	indice++;
	    }
	    
	    this.t = temp;
	    temp = null;
	    for(int i=position; i<t.length;i++){
	    	t[i].setId(t[i].getId()-1);
	    }
	    trier();
	    //Cette méthode permet d'avertir le tableau que les données ont été modifiées
	    serialize();
	    this.fireTableDataChanged();
	}
	public void addRow(Tache data){
	      int indice = 0, nbRow = t.length;//this.getRowCount();//, nbCol = this.getColumnCount();
	       
	      Tache[] temp= this.t;
	      //this.data = new Object[nbRow+1][nbCol];
	      this.t = new Tache[nbRow+1];
	      
	       
	      for(Tache value : temp)
	         this.t[indice++] = value;
	       
	          
	      this.t[indice] = data;
	      temp = null;
	      //Cette méthode permet d'avertir le tableau que les données
	      //ont été modifiées, ce qui permet une mise à jour complète du tableau
	      t[indice].setId(t.length-1);
	      trier();
	      serialize();
	      this.fireTableDataChanged();
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i<t.length;i++)
			str += t[i].getIntitule() +"\n";
		return str;
		
	}
	
	public void trier(){
		int i=0,j,k; 
		int l=t.length;
		//System.out.println(t[0]);
		while(i<t.length){
			System.out.println("boucle 1");
			if(this.t[i].estTerminee()){
				l--;
			}
			i++;	
		}
		i=0;
		Boolean inseree = false;
		trie = new Tache[l];
		int nbT =0;
		//for(i=0;i<t.length){
		while(i<t.length){
			System.out.println("boucle 2");
			if(!this.t[i].estTerminee()){
				
				for(j=0; j<nbT;j++){
					System.out.println("boucle 3");
					if(t[i].compareTo(trie[j])<0){
						for(k=nbT;k>j;k--){
							System.out.println("boucle 4");
							trie[k]=trie[k-1];
						}
						trie[k]=t[i];
						inseree=true;
						break;
					}
				}
				if(!inseree){
					trie[nbT]=t[i];
				}
				inseree = false;
				nbT++;
			}
			i++;
		}
	}
}
