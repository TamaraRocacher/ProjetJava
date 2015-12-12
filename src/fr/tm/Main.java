package fr.tm;

import fr.tm.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.tm.controller.*;
import fr.tm.view.*;

/*
 * Architecture MVC selon les conseils de Derek Banas : https://www.youtube.com/watch?v=dTVVa2gfht8
 */
public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Set System L&F
			UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}
		Tache t[]= {};//=new Tache[1];
		//Tache t1= new TachePonctuelle();
		//t[0] = t1;
		
		String title[] = {"Effectuée","Intitulé","Date Début", "Date Fin", "Catégorie", "Suppression"};
		TableModel modele = null;
		View vue = new View();
		
		/*try {
			// ouverture d'un flux d'entrée depuis le fichier "personne.serial"
			FileInputStream fis = new FileInputStream("TableModel.serial");
			// création d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// désérialisation : lecture de l'objet depuis le flux d'entrée
				modele = (TableModel) ois.readObject(); 
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
		}*/
		if(modele != null) {
			System.out.println(modele + " a ete deserialise");
		}
		else {
			modele = new TableModel(t, title);
		}
		
		Controller controller = new Controller(modele, vue);
		
	}

}
