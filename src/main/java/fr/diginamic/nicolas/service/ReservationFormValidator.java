package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.entite.Client;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.enumeration.StatusVehicule;
import fr.diginamic.nicolas.utils.DateUtils;

public class ReservationFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {

		String dateDebut = form.getValue("champ1");
		String dateFin = form.getValue("champ2");
		Client client = form.getValue("champ4");
		Vehicule vehicule = form.getValue("champ5");
		
		if (dateDebut==null) {
			console.alert("La date de début est obligatoire !");
			return false;
		} else if (!DateUtils.supNow(dateDebut)) {
			console.alert("La date de départ doit être supérieure ou égale à la date du jour !");
			return false;
		} else if (dateFin==null) {
			console.alert("La date de fin est obligatoire !");
			return false;
		} else if (DateUtils.sup(dateFin, dateDebut)) {
			console.alert("La date de retour doit être supérieure ou égale à la date de départ !");
			return false;
		} else if (dateFin.trim().isEmpty()) {
			console.alert("La date de fin est obligatoire !");
			return false;
		} else if (client==null) {
			console.alert("Le client est obligatoire !");
			return false;
		} else if (vehicule==null) {
			console.alert("Le véhicule est obligatoire !");
			return false;
		} else if (!vehicule.getStatusVehicule().equals(StatusVehicule.DISPONIBLE)) {
			console.alert("Le véhicule n'est pas disponible !");
			return false;
		}
		return true;
	}
}
