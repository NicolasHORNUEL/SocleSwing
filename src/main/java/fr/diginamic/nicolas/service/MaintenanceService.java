package fr.diginamic.nicolas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.nicolas.dao.AgenceDao;
import fr.diginamic.nicolas.dao.MaintenanceDao;
import fr.diginamic.nicolas.dao.VehiculeDao;
import fr.diginamic.nicolas.entite.Agence;
import fr.diginamic.nicolas.entite.Maintenance;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.utils.DateUtils;

public class MaintenanceService extends MenuService  {

	@Override
	public void traitement() {
		console.clear();
		List<Maintenance> maintenances = MaintenanceDao.findAll();
		console.print("<h1 class='bg-red'><center>Listes des maintenances</center></h1>");
		console.print("<h2><center><a class='btn-red' href='ajouter()'><img width=25 src='images/plus-green.png'></a>AJOUTER</center></h2>");
		if (!maintenances.isEmpty()) {
			console.print(affichage(maintenances));
		}
	}

	
	private String affichage(List<Maintenance> maintenances) {
		if (!maintenances.isEmpty()) {
			String html = "<table cellspacing=0 align=center>"
					+ "<tr class='bg-red'>"
					+ "<td>Id</td>"
					+ "<td>Date début</td>"
					+ "<td>Date fin</td>"
					+ "<td>Cout</td>"
					+ "<td>Marque</td>"
					+ "<td>Modèle</td>"
					+ "<td>Immatricluation</td>"
					+ "<td>Kilométrage</td>"
					+ "<td>Catégorie</td>"
					+ "<td>Type</td>"
					+ "</tr>";
			for (Maintenance m : maintenances) {
				html += "<tr>"
						+ " <td width='15px'>" + m.getId() + "</td>"
						+ " <td width='150px'>" + DateUtils.tronque(m.getDateDebut()) + "</td>";
				if (m.getDateFin()==null && m.getCoutMaintenance()==0.0) {
					html += " <td><center><a class='btn-blue' href='retour(" + m.getId() + ")'><img width=25 src='images/calendar-alt-green-xs.png'></a></center></td>"
							+ " <td width='150px'></td>";
				} else  {
					html += " <td width='150px'>" + DateUtils.tronque(m.getDateFin()) + "</td>"
							+ " <td width='150px'>" + m.getCoutMaintenance() + "\u20AC " + "</td>";
				}
				html +=  " <td width='150px'>" + m.getVehicule().getMarque() + "</td>"
						+ " <td width='150px'>" + m.getVehicule().getModele() + "</td>"
						+ " <td width='150px'>" + m.getVehicule().getImmatriculation() + "</td>"
						+ " <td width='150px'>" + m.getVehicule().getKilometrage() + "</td>"
						+ " <td width='150px'>" + m.getVehicule().getType().getTypeVehicule().getLibelle() + "</td>"
						+ " <td width='150px'>" + m.getVehicule().getType().getTypeVehicule() + "</td>"
						+ " </tr>";
				}
			html += "</table>";
			return html;
		}
		return null;
	}
		
	
	
	public void ajouter() {

		Agence a = AgenceDao.findById(1L);
		List<Vehicule> vehiculesDao = VehiculeDao.findAll();
		List<Selectable> vehicules = new ArrayList<>();
		vehicules.addAll(vehiculesDao);
		
		Form form = new Form();
		
		form.addInput(new TextField("Action :", "champ1", "ENVOI", false));
		form.addInput(new ComboBox("Vehicule :", "champ2", vehicules, vehicules.get(0)));
		form.addInput(new DateField("Date d'envoi :", "champ3"));
		
		boolean valide = console.input("Envoi en Maintenance", form, new MaintenanceFormValidator());

		if (valide) {
			
			Vehicule v = form.getValue("champ2");
			Date dateDebut = DateUtils.convert(form.getValue("champ3"));
			MaintenanceDao.create(new Maintenance(dateDebut, v, a));
			
		}
		
		traitement();

	}
	
	
	public void retour(Long id) {

		Maintenance m = MaintenanceDao.findById(id);
		Vehicule v = m.getVehicule();
		Agence a = AgenceDao.findById(1L);
		String dateDebutStr = DateUtils.tronque(m.getDateDebut());

		Form form = new Form();
		
		form.addInput(new TextField("Action :", "champ1", "RETOUR", false));
		form.addInput(new TextField("Véhicule :", "champ2", v.getType().getTypeVehicule().getLibelle(), false));
		form.addInput(new TextField("De type :", "champ3", v.getType().getTypeVehicule().toString(), false));
		form.addInput(new TextField("Modèle :", "champ4", v.getMarque() + " " + v.getModele(), false));
		form.addInput(new TextField("Immatriculation :", "champ5", v.getImmatriculation(), false));
		form.addInput(new TextField("Statut :", "champ6", v.getStatusVehicule().toString(), false));
		form.addInput(new TextField("Date d'envoi :", "champ7", dateDebutStr, false));
		form.addInput(new DateField("Date de retour :", "champ8"));
		form.addInput(new TextField("Cout :", "champ9"));
		
		boolean valide = console.input("Envoi en Maintenance", form, new MaintenanceFormValidator());

		if (valide) {
			
			Date dateFin = DateUtils.convert(form.getValue("champ8"));
			double cout = Double.parseDouble(form.getValue("champ9"));
			m.setDateFin(dateFin);
			m.setCoutMaintenance(cout);
			MaintenanceDao.update(m);
			a.setBilan(-cout);
			AgenceDao.update(a);

		}
		
		traitement();
		
	}

}
