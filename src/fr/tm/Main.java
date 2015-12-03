package fr.tm;

import fr.tm.model.*;
import fr.tm.controller.*;
import fr.tm.view.*;

/*
 * Architecture MVC selon les conseils de Derek Banas : https://www.youtube.com/watch?v=dTVVa2gfht8
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractModel modele = new Taches();
		AbstractView vue = new View();
	}

}
