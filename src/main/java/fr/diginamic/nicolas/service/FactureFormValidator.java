package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.utils.DateUtils;

public class FactureFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {

		String dateDebut = form.getValue("champ3");
		String dateFin = form.getValue("champ4");
		String kmFin = form.getValue("champ6");

		if (dateFin==null) {
			console.alert("La date de fin est obligatoire !");
			return false;
		} else if (DateUtils.sup(dateFin, dateDebut)) {
			console.alert("La date de retour doit être supérieure ou égale à la date de départ !");
			return false;
		} else if (kmFin.trim().isEmpty()) {
			console.alert("Le kilométrage de retour est obligatoire !");
			return false;
		}
		return true;
	}
}
