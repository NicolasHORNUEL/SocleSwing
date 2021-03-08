package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.enumeration.TypeReglement;

public class PaiementFormValidator  extends FormValidator {

	@Override
	public boolean validate(Form form) {

		TypeReglement typeReglement  = form.getValue("champ4");
		
		if (typeReglement==null) {
			console.alert("Le type de réglement est obligatoire !");
			return false;
		}
		return true;
	}

}

