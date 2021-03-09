package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.dao.TypeDao;
import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.enumeration.TypeVehicule;

/** validateur associé au formulaire
 *
 */
public class TypeFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String tarifJ = form.getValue("champ1");
		String caution = form.getValue("champ2");
		TypeVehicule typeVehicule = form.getValue("champ3");

		if (tarifJ.trim().isEmpty()) {
			console.alert("Le tarif journalier est obligatoire !");
			return false;
		} else if (Double.parseDouble(tarifJ)<0) {
			console.alert("Le tarif journalier doit être strictement positif !");
			return false;
		}
		else if (caution.trim().isEmpty()) {
			console.alert("Le montant de la caution est obligatoire !");
			return false;
		} else if (Integer.parseInt(caution)<0) {
			console.alert("La caution doit être strictement positif !");
			return false;
		}
		else if (typeVehicule==null) {
			console.alert("Le type est obligatoire !");
			return false;
		} else if (TypeDao.exist(new Type(typeVehicule))) {
			console.alert("Le type de véhicule est déjà enregistrée");
			return false;
		}
		return true;
	}

}
