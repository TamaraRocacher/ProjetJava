package fr.tm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import fr.tm.model.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MonTableRenderer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Override
	/**
	 * On va coloré la ligne en rouge si la valeur du dessus est inférieur
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		//JLabel c = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		// Si bession tu peut cast le Compoment en JLabel.

		if(row >= 0 ){
			boolean retard = ((TableModel)table.getModel()).getTrie()[row].estEnRetard();

			if(retard){
				c.setForeground(Color.red);
				if(((TableModel)table.getModel()).getTrie()[row] instanceof TacheLongCours) {
					c.setFont(new Font("Sans Serif", Font.ITALIC | Font.BOLD, 13));

				}
				else
					c.setFont(new Font("Sans Serif", Font.BOLD, 13));
			}
			else{
				//KO
				if(((TableModel)table.getModel()).getTrie()[row] instanceof TacheLongCours)
					c.setFont(new Font("Sans Serif", Font.ITALIC, 13));
				else
					c.setFont(new Font("Sans Serif", Font.PLAIN, 13));
				c.setForeground(Color.black); 
			}
		}else{
			c.setForeground(Color.black);
		}
		return c ;
	}
}