package fr.tm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.tm.model.*;
import fr.tm.view.*;

public class Controller {
	private Taches model;
	private View view;
	
	public Controller(Taches model, View view) {
		this.model = model;
		this.view = view;
	}
	
	class MaJListener implements ActionListener {
		/*
		 * Recuperer tache entrée dans la vue
		 * Creer objet Tache à partir de celui ci
		 * update la vue à partir du modele modifié
		 * serialiser l'objet "Taches"
		 */
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
}
