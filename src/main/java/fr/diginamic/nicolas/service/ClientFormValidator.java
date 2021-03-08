package fr.diginamic.nicolas.service;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.nicolas.utils.CharUtils;

public class ClientFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {

		String nom = form.getValue("champ1");
		String prenom = form.getValue("champ2");
		String numeroRue = form.getValue("champ3");
		String libelleRue = form.getValue("champ4");
		String CodePostale = form.getValue("champ5");
		String ville = form.getValue("champ6");
		String numeroTel = form.getValue("champ7");
		String email = form.getValue("champ8");
		String typePermis = form.getValue("champ9");
		String numeroPermis = form.getValue("champ10");
		String dateObtention = form.getValue("champ11");

		if (nom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		} else if (prenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		} else if (numeroRue.trim().isEmpty()) {
			console.alert("Le numéro de rue est obligatoire !");
			return false;
		} else if (libelleRue.trim().isEmpty()) {
			console.alert("Le libellé de rue est obligatoire !");
			return false;
		} else if (CodePostale.trim().isEmpty()) {
			console.alert("Le code postale est obligatoire !");
			return false;
		} else if (ville.trim().isEmpty()) {
			console.alert("Le nom de la ville est obligatoire !");
			return false;
		} else if (numeroTel.trim().isEmpty()) {
			console.alert("Le numéro de téléphone est obligatoire !");
			return false;
		} else if (!CharUtils.tel(numeroTel)) {
			console.alert("Le numéro de téléphone est incorrect !");
			return false;
		} else if (email.trim().isEmpty()) {
			console.alert("L'adresse mail est obligatoire !");
			return false;
		} else if (!CharUtils.mail(email)) {
			console.alert("L'adresse mail est incorrect !");
			return false;
		} else if (typePermis.trim().isEmpty()) {
			console.alert("Le type de permis est obligatoire !");
			return false;
		} else if (numeroPermis.trim().isEmpty()) {
			console.alert("Le numéro de permis est obligatoire !");
			return false;
		} else if (dateObtention==null) {
			console.alert("La date d'obtention du permis est obligatoire !");
			return false;
		}
		return true;
	}
}
