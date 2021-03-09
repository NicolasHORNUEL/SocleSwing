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

		console.print("<h1 class='bg-red'><center>Liste des types de véhicules</center></h1>");
		console.print("<h2><center><a class='btn-red' href='ajouter()'><img width=25 src='images/plus-green.png'></a>AJOUTER</center></h2>");
		
		if (!types.isEmpty()) {
			String html = "<table cellspacing=0 align=center>"
					+ "<tr class='bg-red'>"
					+ "<td></td>"
					+ "<td>Tarif Journalier</td>"
					+ "<td>Caution</td>"
					+ "<td>Catégorie</td>"
					+ "</tr>";
			for (Type t : types) {
				html += "<tr>"
						+ " <td><a class='btn-blue' href='modifier(" + t.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
						+ " <td width='150px'>" + t.getTarifJournalier() + "\u20AC " + "</td>"
						+ " <td width='150px'>" + t.getCaution() + "\u20AC " + "</td>"
						+ " <td width='150px'>" + t.getTypeVehicule() + "</td>"
						+ " </tr>";
			}
			html += "</table>";
			console.print(html);
		}
	}

	public void ajouter() {

		List<Selectable> typeVehicules = Arrays.asList(TypeVehicule.values());
		
		Form form = new Form();

		form.addInput(new TextField("Tarif journalier:", "champ1"));
		form.addInput(new TextField("Caution:", "champ2"));
		form.addInput(new ComboBox("Type du véhicule:", "champ3", typeVehicules, typeVehicules.get(0)));

		boolean valide = console.input("Demande d'informations", form, new TypeFormValidator());

		if (valide) {
			double tarifJ = Double.parseDouble(form.getValue("champ1"));
			int caution = Integer.parseInt(form.getValue("champ2"));
			TypeVehicule typeVehicule = form.getValue("champ3");
			TypeDao.create(new Type(typeVehicule, tarifJ, caution));
			traitement();
			
		}

		traitement();
	}
	
	public void modifier(Long id) {
		
		Type type = TypeDao.findById(id);
		
		TypeVehicule typeVehicule = type.getTypeVehicule();
		String typeVehiculeStr = typeVehicule.toString();
		String tarifJourStr = String.valueOf(type.getTarifJournalier());
		String cautionStr = String.valueOf(type.getCaution());
				
		Form form = new Form();

		form.addInput(new TextField("Tarif journalier:", "champ1", tarifJourStr));
		form.addInput(new TextField("Caution:", "champ2", cautionStr));
		form.addInput(new TextField("Type du véhicule:", "champ3", typeVehiculeStr, false));

		boolean valide = console.input("Demande d'informations", form, null);

		if (valide) {
			
			double tarifJ = Double.parseDouble(form.getValue("champ1"));
			int caution = Integer.parseInt(form.getValue("champ2"));
			type.setTarifJournalier(tarifJ);
			type.setCaution(caution);
			TypeDao.update(type);

		}

		traitement();
	}
	
	

	
	
}
