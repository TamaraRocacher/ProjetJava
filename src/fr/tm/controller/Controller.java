package fr.tm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;
import fr.tm.model.*;
import fr.tm.view.*;

public class Controller implements Serializable{
	private TableModel model;
	private View view;
	
	public Controller(TableModel model, View view)  {
		this.model = model;
		this.view = view;
		
		Tache data = new TachePonctuelle();
		data.setTerminee(false);
		
		model.addRow(data);
		view.getTable().setModel(model);
		view.update();
		
		view.getTable().getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
		view.addListener(new MaJListener());
	}
	
	class MaJListener implements ActionListener, Serializable{
		/*
		 * Recuperer tache entrée dans la vue
		 * Creer objet Tache à partir de celui ci
		 * update la vue à partir du modele modifié
		 * serialiser l'objet "Taches"
		 */
		public void actionPerformed(ActionEvent e) {
			String inti = view.getIntitule().getText();
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
			Date dateDebut = new Date();
			Date dateFin = new Date();
			System.out.println("action");
			
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
			
			t.setIntitule(inti);
			t.setCategorie(categorie);
			t.setDateDebut(dateDebut);
			t.setDateFin(dateFin);
			
			model.addRow(t);
			//model.tri(view.getMode());
			view.getTable().setModel(model);
			
			view.update();
			System.out.println(model.toString());
			
			/*try {
				// création d'une personne
				//Personne p = new Personne("Dupont", "Jean", 36);
				//System.out.println("creation de : " + p);

				// ouverture d'un flux de sortie vers le fichier "personne.serial"
				FileOutputStream fos = new FileOutputStream("TableModel.serial");

				// création d'un "flux objet" avec le flux fichier
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				try {
					// sérialisation : écriture de l'objet dans le flux de sortie
					oos.writeObject(model); 
					// on vide le tampon
					oos.flush();
					System.out.println(model + " a ete serialise");
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
			}*/
		}
		
	}
	
}
