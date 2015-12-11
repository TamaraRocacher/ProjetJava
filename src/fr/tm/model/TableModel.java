package fr.tm.model;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import java.io.Serializable;

public class TableModel extends AbstractTableModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Tache[] t;
	private String[] title;
	
	public TableModel(Tache[] t, String[] title) {
		this.t = t;
		this.title = title;
	}
	
	public String getColumnName(int col) {
	     return this.title[col];
	   }
	
	public int getRowCount() {
	      return this.t.length;
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
			return new Boolean(this.t[row].estTerminee());
		}
		else if(col == 1) 			//Intitulé
			return this.t[row].getIntitule();
		else if(col == 2)			//DateDeb
			return this.t[row].getDateDebut();
		else if(col == 3)			//DateFin
			return this.t[row].getDateFin();
		else if(col == 4)			//Categorie
			return this.t[row].getCategorie();
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
	}

	public void removeRow(int position){
	       
		int indice = 0, indice2 = 0;
	    int nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
	    Tache[] temp = new Tache[nbRow];
	    
	    for(Tache value : this.t){
	    	if(indice != position){
	    		temp[indice2++] = value;
	    	}
	    	System.out.println("Indice = " + indice);
	    	indice++;
	    }
	    this.t = temp;
	    temp = null;
	    //Cette méthode permet d'avertir le tableau que les données ont été modifiées
	    this.fireTableDataChanged();
	}
	public void addRow(Tache data){
	      int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
	       
	      Tache[] temp= this.t;
	      //this.data = new Object[nbRow+1][nbCol];
	      this.t = new Tache[nbRow+1];
	      
	       
	      for(Tache value : temp)
	         this.t[indice++] = value;
	       
	          
	      this.t[indice] = data;
	      temp = null;
	      //Cette méthode permet d'avertir le tableau que les données
	      //ont été modifiées, ce qui permet une mise à jour complète du tableau
	      this.fireTableDataChanged();
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i<t.length;i++)
			str += t[i].getIntitule() +"\n";
		return str;
		
	}
}
