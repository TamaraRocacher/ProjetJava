package fr.tm.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame implements AbstractView {
	private static final long serialVersionUID = 1L;
	JPanel pan = new JPanel();
	JButton boutonMaJ = new JButton("Mettre à jour");
	
	public View() {
		this.setSize(800,600);
		this.setTitle("TodoList");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pan.add(boutonMaJ);
		this.add(pan);
		this.setVisible(true);
	}
}
