package fr.diginamic.nicolas.utils;


public class CharUtils {
	
	
	/**
	 * @param chaine
	 * @return boolean vrai si chaine au format immatriculation xx-xxx-xx
	 */
	public static boolean immat(String chaine) {
		
		CharSequence delimiter = "-";
		int nbOccurence = chaine.length() - chaine.replace(delimiter, "").length();		
		String[] morceaux = chaine.split("-");
		int nbG = morceaux[0].length();
		int nbM = morceaux[1].length();
		int nbD = morceaux[2].length();
		
		if (chaine.indexOf("-") == -1) {
			return false;
		} else if (nbOccurence != 2) {
			return false;
		} else if (nbG != 2 && nbM != 3 && nbD != 2) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * @param chaine de caractère
	 * @return boolean vrai si au format email xx@xx.xx
	 */
	public static boolean mail(String chaine) {
		
		char ch1 = '@';
		char ch2 = '.';
		int po1 = chaine.indexOf(ch1);
		int po2 = chaine.indexOf(ch2);
		
		if (po1 == -1 || po2 == -1) {
			return false;
		} else if (po1 > po2) {
			return false;
		} else if (po2 - po1 < 2) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param chaine
	 * @return boolean vrai si au format tél 0xxxxxxxxx
	 */
	public static boolean tel(String chaine) {
		
		int nbChar = chaine.length();
		char oneChar = chaine.charAt(0);
		int debut = Integer.parseInt(chaine.substring(0, 2));
		
		if (nbChar != 10) {
			return false;
		} else if (oneChar != '0') {
			return false;
		} else if (debut >= 10) {
			return false;
		}
		return true;
	}


}
