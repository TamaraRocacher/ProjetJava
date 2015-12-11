package fr.tm.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Tache implements Serializable {
	private String intitule;
	private String categorie;
	private Date dateDebut;
	private Date dateFin;
	private Date dateTerminee; 	//Pour faire le bilan des tâches accomplies en temps et en heure.
	private Boolean terminee = false;
	
	public Tache() {
		intitule = "eee";
		categorie = "eeee";
		dateDebut = new Date();
		dateFin = new Date();
		dateTerminee = new Date();
	}
	
	public boolean estTerminee() {
		terminee = getDateTerminee() != null;
		return terminee;
	}
	
	public void setTerminee(boolean b) {
		terminee = b;
	}
	
	public abstract boolean estEnRetard();
	
	
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateTerminee() {
		return dateTerminee;
	}

	public void setDateTerminee(Date dateTerminee) {
		this.dateTerminee = dateTerminee;
	}
}
