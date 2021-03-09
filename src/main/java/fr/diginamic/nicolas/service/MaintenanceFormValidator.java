package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.enumeration.StatusVehicule;
import fr.diginamic.nicolas.utils.DateUtils;

public class MaintenanceFormValidator  extends FormValidator {

	@Override
	public boolean validate(Form form) {

		String action = form.getValue("champ1");
		
		if (action.equals("ENVOI")) {
			Vehicule vehicule  = form.getValue("champ2");
			String dateDebut = form.getValue("champ3");
			if (dateDebut==null) {
				console.alert("La date de début est obligatoire !");
				return false;
			} else if (!DateUtils.supNow(dateDebut)) {
				console.alert("La date de départ doit être supérieure ou égale à la date du jour !");
				return false;
			} else if (!vehicule.getStatusVehicule().equals(StatusVehicule.DISPONIBLE)) {
				console.alert("Le véhicule n'est pas disponible !");
				return false;
			}
			return true;
			
		} else if (action.equals("RETOUR")) {
			String dateDebut = form.getValue("champ7");
			String dateFin = form.getValue("champ8");
			String cout = form.getValue("champ9");
			if (dateFin==null) {
				console.alert("La date de fin est obligatoire !");
				return false;
			} else if (!DateUtils.infNow(dateFin)) {
				console.alert("La date de retour doit être antérieure ou égale à la date du jour !");
				return false;
			} else if (DateUtils.sup(dateFin, dateDebut)) {
				console.alert("La date de retour doit être postérieure ou égale à la date d'envoi !");
				return false;
			} else if (cout.isEmpty()) {
				console.alert("Le cout est obligatoire !");
				return false;
			} else if (Integer.parseInt(cout)<0) {
				console.alert("Le cout doit être strictement positif !");
				return false;
			}
			return true;
		}
		
		return true;

		
	}

}
