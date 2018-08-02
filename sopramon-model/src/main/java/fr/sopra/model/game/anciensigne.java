package fr.sopra.model.game;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class anciensigne
{
	private int id;
	private String nom;
	private Type type;


	public String getAstrologicalSign(Date d) {
		Calendar cal = new GregorianCalendar();
        cal.setTime(d);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		
		
		if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19))
			return "Capricorne";

		else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17))
			return "Verseau";

		else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19))
			return "Poisson";
		else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19))
			return "B�lier";
		else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20))
			return "Taureau";
		else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20))
			return "G�meaux";
		else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22))
			return "Cancer";
		else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22))
			return "Lion";
		else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22))
			return "Vierge";
		else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
			return "Balance";
		else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
			return "Scorpion";
		else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
			return "Sagittaire";
		else {
			System.out.println("OUPS");
		}
			return null;
	}

	@Override
	public String toString() {
		return "Signe [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}

}

