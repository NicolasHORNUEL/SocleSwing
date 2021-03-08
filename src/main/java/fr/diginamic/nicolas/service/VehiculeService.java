package fr.diginamic.nicolas.service;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.nicolas.dao.CamionDao;
import fr.diginamic.nicolas.dao.TypeDao;
import fr.diginamic.nicolas.dao.VehiculeDao;
import fr.diginamic.nicolas.dao.VoitureDao;
import fr.diginamic.nicolas.entite.Camion;
import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.entite.Voiture;
import fr.diginamic.nicolas.enumeration.TypeVehicule;

public class VehiculeService extends MenuService {

	@Override
	public void traitement() {

		console.clear();

		List<Vehicule> vehicules = VehiculeDao.findAll();
		
		console.print("<h1 class='bg-red'><center>Liste des véhicules</center></h1>");
		console.print("<h2><a class='btn-red' href='ajouter()'><img width=25 src='images/plus-green.png'></a>AJOUTER</h2>");

		String html = "<table cellspacing=0>"
				+ "<tr class='bg-red'>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td>Id</td>"
				+ "<td>Marque</td>"
				+ "<td>Modèle</td>"
				+ "<td>Immatriculation</td>"
				+ "<td>Kilométrage</td>"
				+ "<td>Type</td>"
				+ "<td>Status</td>"
				+ "</tr>";
		for (Vehicule v : vehicules) {
			html += "<tr>"
					+ " <td><a class='btn-blue' href='modifier(" + v.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ " <td><a class='btn-blue' href='supprimer(" + v.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a></td>"
					+ " <td width='150px'>" + v.getId() + "</td>"
					+ " <td width='150px'>" + v.getMarque() + "</td>"
					+ " <td width='150px'>" + v.getModele() + "</td>"
					+ " <td width='150px'>" + v.getImmatriculation() + "</td>"
					+ " <td width='150px'>" + v.getKilometrage() + "</td>"
					+ " <td width='150px'>" + v.getType().getTypeVehicule() + "</td>"
					+ " <td width='150px'>" + v.getStatusVehicule() + "</td>"
					+ " </tr>";
		}
		html += "</table>";

		console.print(html);

	}
	
	
	public void ajouter() {

		// On commence par créér le formulaire vide
		Form form = new Form();

		// On ajoute au formulaire 2 champs de type texte.
		form.addInput(new TextField("Marque:", "champ1"));
		form.addInput(new TextField("Modèle:", "champ2"));
		form.addInput(new TextField("Immatriculation:", "champ3", "XX-XXX-XX"));
		form.addInput(new TextField("Kilométrage:", "champ4"));
				
		List<Type> typesDao = TypeDao.findAll();
		List<Selectable> types = new ArrayList<>();
		types.addAll(typesDao);

		form.addInput(new ComboBox("Type du véhicule:", "champ5", types, types.get(0)));
		form.addInput(new TextField("Volume:", "champ6"));
		form.addInput(new TextField("Nombre de place:", "champ7"));
		
		// Création d'un validator qui stocke les règles de gestion
		VehiculeFormValidator validator = new VehiculeFormValidator();
		boolean valide = console.input("Demande d'informations", form, validator);

		// Récupéation des informations saisies
		if (valide) {

			String marque = form.getValue("champ1");
			String modele = form.getValue("champ2");
			String immat = form.getValue("champ3");
			int km = Integer.parseInt(form.getValue("champ4"));
			Type type = form.getValue("champ5");
			
			TypeVehicule typeVehicule = type.getTypeVehicule();
			Type typeDao = TypeDao.findOne(typeVehicule);
			String vehicule = typeVehicule.getLibelle();

			if (vehicule == "Camion") {
				double volume = Double.parseDouble(form.getValue("champ6"));
				Camion c = new Camion(marque, modele, immat, km, typeDao, volume);
				CamionDao.create(c);
			} else if (vehicule == "Voiture") {
				int nbPlace = Integer.parseInt(form.getValue("champ7"));
				Voiture v = new Voiture(marque, modele, immat, km, typeDao, nbPlace);
				VoitureDao.create(v);
			}
			traitement();
		}
	}
	
	
	public void modifier(Long id) {
		
		Vehicule v = VehiculeDao.findById(id);
		
		Form form = new Form();	
		form.addInput(new TextField("Status:", "champ0", v.getStatusVehicule().getLibelle(), false));
		form.addInput(new TextField("Marque:", "champ1", v.getMarque()));
		form.addInput(new TextField("Modèle:", "champ2", v.getModele()));
		if (v.getReservation().isEmpty()) {
			form.addInput(new TextField("Immatriculation:", "champ3", v.getImmatriculation()));
		} else {
			form.addInput(new TextField("Immatriculation:", "champ3", v.getImmatriculation(), false));
		}
		form.addInput(new TextField("Kilométrage:", "champ4", String.valueOf(v.getKilometrage())));
				
		List<Type> typesDao = TypeDao.findAll();
		List<Selectable> types = new ArrayList<>();
		types.addAll(typesDao);	
		int number = 0;
		for (int i = 0; i < types.size(); i++) {
			if (types.get(i).equals(v.getType())) {
				number = i;
			}
		}
		form.addInput(new ComboBox("Type du véhicule:", "champ5", types, types.get(number)));
		
		TypeVehicule typeVehicule = v.getType().getTypeVehicule();
		String vehicule = typeVehicule.getLibelle();		
		if (vehicule == "Camion") {
			Camion cDao = CamionDao.findById(id);
			form.addInput(new TextField("Volume:", "champ6", String.valueOf(cDao.getVolume())));
			form.addInput(new TextField("Nombre de place:", "champ7", null));
		} else if (vehicule == "Voiture") {
			Voiture vDao = VoitureDao.findById(id);
			form.addInput(new TextField("Volume:", "champ6", null));
			form.addInput(new TextField("Nombre de place:", "champ7", String.valueOf(vDao.getNombrePlace())));
		}
		
		// Création d'un validator qui stocke les règles de gestion
		VehiculeFormValidator validator = new VehiculeFormValidator();
		boolean valide = console.input("Demande d'informations", form, validator);

		// Récupéation des informations saisies
		if (valide) {
			v.setImmatriculation(form.getValue("champ3"));
			v.setKilometrage(Integer.parseInt(form.getValue("champ4")));
			v.setMarque(form.getValue("champ1"));
			v.setModele(form.getValue("champ2"));
			v.setType(form.getValue("champ5"));
			VehiculeDao.update(v);
			traitement();		
		}
		
	}
	
	public void supprimer(Long id) {
		Vehicule v = VehiculeDao.findById(id);
		VehiculeDao.delete(v);
		traitement();		
	}
}
