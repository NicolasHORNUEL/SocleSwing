package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.enumeration.TypeVehicule;
import fr.diginamic.nicolas.utils.CharUtils;

/** validateur associé au formulaire
 *
 */
public class VehiculeFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {

		String marque = form.getValue("champ1");
		String modele = form.getValue("champ2");
		String immat = form.getValue("champ3");
		String km = form.getValue("champ4");
		Type type = form.getValue("champ5");
		TypeVehicule typeVehicule = type.getTypeVehicule();
		String vehicule = typeVehicule.getLibelle();
		String volume = form.getValue("champ6");
		String nbPlace = form.getValue("champ7");
				
		if (marque.trim().isEmpty()) {
			console.alert("La marque est obligatoire !");
			return false;
		}
		else if (modele.trim().isEmpty()) {
			console.alert("Le modèle est obligatoire !");
			return false;
		}
		else if (immat==null || immat.trim().isEmpty()) {
			console.alert("L'immatriculation est obligatoire !");
			return false;
		}
		else if (!CharUtils.immat(immat)) {
			console.alert("L'immatriculation n'est pas correcte !");
			return false;
		}
		else if (km.trim().isEmpty()) {
			console.alert("Le kilometrage est obligatoire !");
			return false;
		}
		else if (vehicule == "Camion" && volume.trim().isEmpty()) {
			console.alert("Le volume est obligatoire !");
			return false;
		}
		else if (vehicule == "Voiture" && nbPlace.trim().isEmpty()) {
			console.alert("Le nombre de place est obligatoire !");
			return false;
		}
		return true;
	}

}
