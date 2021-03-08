package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

/** validateur associé au formulaire
 *
 */
public class TypeFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String tarifJ = form.getValue("champ1");
		String caution = form.getValue("champ2");
		String type = form.getValue("champ3");
		
		if (tarifJ.trim().isEmpty()) {
			console.alert("Le tarif journalier est obligatoire !");
			return false;
		}
		else if (caution.trim().isEmpty()) {
			console.alert("Le montant de la caution est obligatoire !");
			return false;
		}
		else if (type.trim().isEmpty()) {
			console.alert("Le type est obligatoire !");
			return false;
		}
		return true;
	}

}
