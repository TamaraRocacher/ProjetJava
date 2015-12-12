package fr.tm.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Tache implements Serializable, Comparable {
	private static final long serialVersionUID = 2L;
	
	private String intitule;
	private String categorie;
	private Date dateDebut;
	private Date dateFin;
	private Date dateTerminee; 	//Pour faire le bilan des tâches accomplies en temps et en heure.
	private Boolean terminee = false;
	private int id=-1;
	
	public Tache() {
		intitule = "eee";
		categorie = "eeee";
		dateDebut = new Date();
		dateFin = new Date();
		dateTerminee = null;
		terminee = false;
	}
	
	public boolean estTerminee() {
		//terminee = getDateTerminee() != null;
		return terminee;
	}
	
	public void setTerminee(boolean b) {
		terminee = b;
		if(terminee == true) 
			dateTerminee =  new Date();
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
	public int compareTo(Object o){
		
		Tache t2 = (Tache) o;
		if(this.dateFin.compareTo(t2.dateFin)<0){
			return -1;
		}
		else{
			return 0;
		}
	}
	public String toString() {
		String str ="";
		str+= intitule + " " + terminee+"\n";
		return str;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
