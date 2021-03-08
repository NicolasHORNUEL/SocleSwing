package fr.diginamic.nicolas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	private static SimpleDateFormat formatage = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
	private static SimpleDateFormat formatFacture = new SimpleDateFormat("yyyyMMdd.HHmm", Locale.FRANCE);

	
	/**
	 * @param String
	 * @return Date
	 */
	public static Date convert(String valeur) {
		Date date = null;
		try {
			date = formatage.parse(valeur);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * @param Date
	 * @return String au format global dd/MM/yyyy
	 */
	public static String tronque(Date date) {
		String str = formatage.format(date);
		return str;
	}
	
	
	/**
	 * @param annee en int
	 * @param mois en int
	 * @param jour en int
	 * @return une date
	 */
	public static Date set(int annee, int mois, int jour) {
		Calendar cal = Calendar.getInstance();
		cal.set(annee, mois, jour);
		return cal.getTime();
	}
	
	
	/**
	 * @return la date actuelle
	 */
	public static Date getNow() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	
	/**
	 * @param String du formulaire DataField
	 * @return boolean de comparaison avec la date actuelle
	 */
	public static boolean supNow(String valeur) {
		Date dateNow = getNow();
		String stringNow = formatage.format(dateNow);
		Date formatNow = convert(stringNow);
		if (convert(valeur).after(formatNow) || valeur.equals(stringNow)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param String v2 du formulaire DataField
	 * @param String v1
	 * @return boolean de comparaison entre les deux dates
	 */
	public static boolean sup(String v2, String v1) {
		if (convert(v2).before(convert(v1))) {
			return true;
		}
		return false;
	}
	
	///////////////////////////////////////////////
	///           POUR LA FACTURATION           ///
	///////////////////////////////////////////////

	/**
	 * @return une date au format string pour classer les factures
	 */
	public static String getFacture() {
		return formatFacture.format(getNow());
	}
	
	/**
	 * @param dateAvant au format Date
	 * @param dateApres au format Date
	 * @return le nombre de jour de différence
	 */
	public static Long difference(Date dateAvant, Date dateApres) {
		Long diff = dateApres.getTime() - dateAvant.getTime();
		Long resultat = (diff / (1000*60*60*24)) + 1L;
		return resultat;
	}

}
