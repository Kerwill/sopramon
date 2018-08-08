package fr.sopra;

import java.util.Calendar;
import java.util.Date;


import fr.sopra.model.game.Signe;

public class SigneGeneratorNew {



public static Signe getAstrologicalSign(Date d) {
	Calendar cal = Calendar.getInstance();
	
	cal.setTime(d);
	
int month = cal.get(Calendar.MONTH) + 1;
int day = cal.get(Calendar.DAY_OF_MONTH);
	
	if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19))
	
	return Signe.CAPRICORNE;

	else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17))
	
	return Signe.VERSEAU;

	else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19))
	
	return Signe.POISSON;
	else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19))

	return Signe.BELIER;
	else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20))

	return Signe.TAUREAU;
	else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20))
	
	return Signe.GEMEAUX;
	else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22))
	
	return Signe.CANCER;
	else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22))
		
	return Signe.LION;
	else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22))
	return Signe.VIERGE;
	else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
	return Signe.BALANCE;
	else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
	return Signe.SCORPION;
	else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
	return Signe.SAGITTAIRE;
	}
	return Signe.UNKNOWN;
}
}
