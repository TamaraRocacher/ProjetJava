package fr.tm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

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
			String inti = view.getIntitule().getText();
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			Date dateDebut;
			Date dateFin;
			
			try {
				dateDebut = sdf.parse(view.getDateDebut().getText());
				dateFin = sdf.parse(view.getDateFin().getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String categorie = view.getCategorie().getSelectedItem().toString();
			System.out.println(categorie);
			Tache t;
			
			if(view.getPonctuel().isSelected()) {
				t = new TachePonctuelle();
			}
			else {
				t = new TacheLongCours();
			}
			
			model.add(t);
			//model.tri(view.getMode());
			view.update(model);
		}
		
	}
	
}
