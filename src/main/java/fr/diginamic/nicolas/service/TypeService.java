package fr.diginamic.nicolas.service;

import java.util.Arrays;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.nicolas.dao.TypeDao;
import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.enumeration.TypeVehicule;

public class TypeService extends MenuService {
	
	@Override
	public void traitement() {
	
		console.clear();

		List<Type> types = TypeDao.findAll();

		console.print("<h1 class='bg-green'><center>Liste des types de véhicules</center></h1>");
		console.print("<h2><a class='btn-blue' href='ajouter()'><img width=25 src='images/plus-green.png'></a>AJOUTER</h2>");

		String html = "<table cellspacing=0>"
				+ "<tr class='bg-green'>"
				+ "<td></td>"
				+ "<td>Tarif Journalier</td>"
				+ "<td>Caution</td>"
				+ "<td>Catégorie</td>"
				+ "</tr>";
		for (Type t : types) {
			html += "<tr>"
					+ " <td><a class='btn-blue' href='modifier()'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ " <td width='150px'>" + t.getTarifJournalier() + "\u20AC " + "</td>"
					+ " <td width='150px'>" + t.getCaution() + "\u20AC " + "</td>"
					+ " <td width='150px'>" + t.getTypeVehicule() + "</td>"
					+ " </tr>";
		}
		html += "</table>";

		console.print(html);

	}

	public void ajouter() {

		// On commence par créér le formulaire vide
		Form form = new Form();

		// On ajoute au formulaire 2 champs de type texte.
		form.addInput(new TextField("Tarif journalier:", "champ1"));
		form.addInput(new TextField("Caution:", "champ2"));

		// Champ de type liste de sélection
		List<Selectable> types = Arrays.asList(TypeVehicule.values());
		form.addInput(new ComboBox("Type du véhicule:", "champ3", types, types.get(0)));

		// Création d'un validator qui stocke les règles de gestion
		TypeFormValidator validator = new TypeFormValidator();

		// La méthode suivante permet d’afficher le formulaire.
		// La méthode retourne false si l’utilisateur a cliqué sur Annuler, sinon
		// retourne true
		boolean valide = console.input("Demande d'informations", form, validator);

		// Récupéation des informations saisies
		if (valide) {
			double tarifJ = Double.parseDouble(form.getValue("champ1"));
			int caution = Integer.parseInt(form.getValue("champ2"));
			long typeString = Long.parseLong(form.getValue("champ3"));
			TypeVehicule typeV = TypeVehicule.getInstance(typeString);
			Type t = TypeDao.create(new Type(typeV, tarifJ, caution));
			traitement();
		}
	}

}
