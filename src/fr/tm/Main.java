package fr.tm;

import fr.tm.model.*;

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

		
		Taches modele = new Taches();
		View vue = new View();
		
		Controller controller = new Controller(modele, vue);
		
		System.out.print(ImageIO.getReaderFileSuffixes());
	}

}
