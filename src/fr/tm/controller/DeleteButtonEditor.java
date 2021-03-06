package fr.tm.controller;

import fr.tm.model.*;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.TableCellEditor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

public class DeleteButtonEditor extends DefaultCellEditor implements TableCellEditor, Serializable {
	protected JButton button;
	private DeleteButtonListener bListener = new DeleteButtonListener();

	public DeleteButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		// TODO Auto-generated constructor stub
		button = new JButton();
	       button.setOpaque(true);
	       //On lui attribue un listener
	       button.addActionListener(bListener);
	}
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	      //On définit le numéro de ligne à notre listener
	      bListener.setRow(row);
	      //On passe aussi en paramètre le tableau pour des actions potentielles
	      bListener.setTable(table);
	      //On réaffecte le libellé au bouton
	      button.setText( (value ==null) ? "" : value.toString() );
	      //On renvoie le bouton
	       return button;
	   }
	    
	private static final long serialVersionUID = -6913274537793975350L;
	
	class DeleteButtonListener implements ActionListener, Serializable {
        
      
		private static final long serialVersionUID = 1702751555572877322L;
		private int row;
        private JTable table;
         
        public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}
         
        public void actionPerformed(ActionEvent event) {
         if(table.getRowCount() > 0){
            //On affiche un message mais vous pourriez faire ce que vous voulez
            System.out.println("coucou du bouton : "+ ((JButton)event.getSource()).getText() );
            //On affecte un nouveau libellé à une celulle de la ligne
            ((TableModel)table.getModel()).removeRow(this.row);
            //trier
             table.setModel(table.getModel());
         }
      }
   } 
}
