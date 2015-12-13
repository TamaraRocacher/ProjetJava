package fr.tm.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TachePonctuelle extends Tache implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public boolean estEnRetard() {
		Date auj = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(auj);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        
        auj = calendar.getTime();
		if(auj.compareTo(this.getDateFin()) >= 0)
			return true;
		else
			return false;
	}

}
