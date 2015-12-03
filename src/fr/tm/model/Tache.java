package fr.tm.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Tache implements Serializable {
	private String intitule;
	private String categorie;
	private Date dateDebut;
	private Date dateFin;
	private Date dateTerminee; 	//Pour faire le bilan des tâches accomplies en temps et en heure.
	
	public Tache() {
		intitule = "";
		categorie = "";
		dateDebut = new Date();
		dateFin = new Date();
		dateTerminee = new Date();
	}
	
	public abstract boolean estReussie();
	
	public abstract boolean estEnRetard();
	
	
}
