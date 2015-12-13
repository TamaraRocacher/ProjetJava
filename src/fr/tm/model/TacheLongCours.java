package fr.tm.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TacheLongCours extends Tache implements Serializable {

	private int avancement;


	private static final long serialVersionUID = 2L;

	public boolean estEnRetard() {
		long debut = this.getDateDebut().getTime();
		long fin = this.getDateFin().getTime();
		long duree = (fin-debut)/(1000*60*60*24);

		Date auj = new Date();
		Calendar today = Calendar.getInstance();
		today.setTime(auj);
		today.set(Calendar.MILLISECOND, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.HOUR, 0);
		today.add(Calendar.DAY_OF_MONTH, -1);
		auj = today.getTime();

		if(avancement<25){
			Date dquart = getDateDebut();
			Calendar quart = Calendar.getInstance();
			quart.setTime(dquart);
			quart.set(Calendar.MILLISECOND, 0);
			quart.set(Calendar.SECOND, 0);
			quart.set(Calendar.MINUTE, 0);
			quart.set(Calendar.HOUR, 0);
			quart.add(Calendar.DAY_OF_MONTH, (int) (duree/4));
			dquart = quart.getTime();

			if(auj.compareTo(dquart)>=0){
				return true;
			}
			else{
				return false;
			}
		}
		
		else if(avancement<50){
			Date dmoitie = getDateDebut();
			Calendar moitie = Calendar.getInstance();
			moitie.setTime(dmoitie);
			moitie.set(Calendar.MILLISECOND, 0);
			moitie.set(Calendar.SECOND, 0);
			moitie.set(Calendar.MINUTE, 0);
			moitie.set(Calendar.HOUR, 0);
			moitie.add(Calendar.DAY_OF_MONTH, (int) (duree/2));
			dmoitie = moitie.getTime();

			if(auj.compareTo(dmoitie)>=0){
				return true;
			}
			else{
				return false;
			}
		}
		
		else if(avancement<75){
			Date dtroisquart = getDateDebut();
			Calendar troisquart = Calendar.getInstance();
			troisquart.setTime(dtroisquart);
			troisquart.set(Calendar.MILLISECOND, 0);
			troisquart.set(Calendar.SECOND, 0);
			troisquart.set(Calendar.MINUTE, 0);
			troisquart.set(Calendar.HOUR, 0);
			troisquart.add(Calendar.DAY_OF_MONTH, (int) (3*duree/4));
			dtroisquart = troisquart.getTime();

			if(auj.compareTo(dtroisquart)>=0){
				return true;
			}
			else{
				return false;
			}
		}
		else if(avancement<100){
			Date dfinal = getDateDebut();
			Calendar cfinal = Calendar.getInstance();
			cfinal.setTime(dfinal);
			cfinal.set(Calendar.MILLISECOND, 0);
			cfinal.set(Calendar.SECOND, 0);
			cfinal.set(Calendar.MINUTE, 0);
			cfinal.set(Calendar.HOUR, 0);
			cfinal.add(Calendar.DAY_OF_MONTH, (int) (duree));
			dfinal = cfinal.getTime();

			if(auj.compareTo(dfinal)>=0){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}

	public int getAvancement() {
		return avancement;
	}

	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

}
