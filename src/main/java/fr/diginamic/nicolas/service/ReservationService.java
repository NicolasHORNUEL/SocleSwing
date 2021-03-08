package fr.diginamic.nicolas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.nicolas.dao.AgenceDao;
import fr.diginamic.nicolas.dao.ClientDao;
import fr.diginamic.nicolas.dao.FactureDao;
import fr.diginamic.nicolas.dao.PaiementDao;
import fr.diginamic.nicolas.dao.ReservationDao;
import fr.diginamic.nicolas.dao.VehiculeDao;
import fr.diginamic.nicolas.entite.Agence;
import fr.diginamic.nicolas.entite.Client;
import fr.diginamic.nicolas.entite.Facture;
import fr.diginamic.nicolas.entite.Paiement;
import fr.diginamic.nicolas.entite.Reservation;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.enumeration.StatusFacture;
import fr.diginamic.nicolas.enumeration.StatusReservation;
import fr.diginamic.nicolas.enumeration.StatusVehicule;
import fr.diginamic.nicolas.enumeration.TypeReglement;
import fr.diginamic.nicolas.utils.DateUtils;

public class ReservationService extends MenuService {
	
	@Override
	public void traitement() {
		console.clear();
		List<Reservation> reservations = ReservationDao.findAll();
		console.print("<h1 class='bg-red'><center>Liste des réservations</center></h1>");
		console.print("<h2><a class='btn-red' href='ouvrir()'><img width=25 src='images/plus-green.png'></a>Ouvrir une réservation</h2>");
		console.print(affichage(reservations, StatusReservation.ENCOURS));
		console.print(affichage(reservations, StatusReservation.TERMINEE));
	}
	
	private String affichage(List<Reservation> reservations, StatusReservation statusReservation) {
		if (!reservations.isEmpty()) {
			String html = "<h3>Réservations " + statusReservation.getLibelle() + "</h3>"
					+ "<table cellspacing=0>" 
					+ "<tr class='bg-red'>" 
					+ "<td></td>" 
					+ "<td>Id</td>"
					+ "<td>Date début</td>" 
					+ "<td>Date fin</td>" 
					+ "<td>Commentaire</td>" 
					+ "<td>Km début</td>" 
					+ "<td>Km fin</td>"
					+ "<td>Client</td>"
					+ "<td>Véhicule</td>"
					+ "</tr>";
			for (Reservation r : reservations) {
				if (r.getStatusReservation().equals(statusReservation)) {
					html += "<tr>";
					if (statusReservation.equals(StatusReservation.ENCOURS)) {
						html += "<td><a class='btn-blue' href='cloturer(" + r.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>";
					} else if (statusReservation.equals(StatusReservation.TERMINEE)) {
						html += "<td><a class='btn-blue' href='voir(" + r.getId() + ")'><img width=25 src='images/text-dark-xs.png'></a></td>";
					}
					html +=   " <td width='15px'>" + r.getId() + "</td>" 
							+ " <td width='75px'>" + DateUtils.tronque(r.getDateDebut()) + "</td>" 
							+ " <td width='75px'>" + DateUtils.tronque(r.getDateFin()) + "</td>" 
							+ " <td width='300px'>" + r.getCommentaire() + "</td>" 
							+ " <td width='75px'>" + r.getKmDebut() + "</td>" 
							+ " <td width='75px'>" + r.getKmFin() + "</td>" 
							+ " <td width='125px'>" + r.getClient().getNom() + " " + r.getClient().getPrenom() + "</td>"
							+ " <td width='400px'>" + r.getVehicule().toString() + "</td>"
							+ " </tr>";
				}
			}
			html += "</table>";
			return html;
		}
		return null;
	}
	
	
	public void ouvrir() {
		
		List<Client> clientsDao = ClientDao.findAll();
		List<Selectable> clients = new ArrayList<>();
		clients.addAll(clientsDao);

		List<Vehicule> vehiculesDao = VehiculeDao.findAll();
		List<Selectable> vehicules = new ArrayList<>();
		vehicules.addAll(vehiculesDao);

		Form form = new Form();
		
		form.addInput(new DateField("Date de début :", "champ1"));
		form.addInput(new DateField("Date de fin estimée :", "champ2"));
		form.addInput(new TextField("Commentaire :", "champ3"));
		form.addInput(new ComboBox("Client :", "champ4", clients, clients.get(0)));
		form.addInput(new ComboBox("Vehicule :", "champ5", vehicules, vehicules.get(0)));
		
		boolean valide = console.input("Demande d'informations", form, new ReservationFormValidator());
		
		if (valide) {
			
			Date dateDebut = DateUtils.convert(form.getValue("champ1"));
			Date dateFin = DateUtils.convert(form.getValue("champ2"));
			String commentaire = form.getValue("champ3");
			Client client = form.getValue("champ4");
			Vehicule vehicule = form.getValue("champ5");
			
			Reservation r = new Reservation(dateDebut, dateFin, commentaire, client, vehicule);
			Set<Reservation> rListe = r.getVehicule().getReservation();
			rListe.add(r);
			ReservationDao.create(r);
			
		}
		
		traitement();
		
	}
	
	public void cloturer(Long id) {
		
		Reservation r = ReservationDao.findById(id);

		String dateDebut = DateUtils.tronque(r.getDateDebut());
		String kmDebut = String.valueOf(r.getKmDebut());
		
		Form form = new Form();
		
		form.addInput(new TextField("Pour le client :", "champ1", r.getClient().toString(), false));
		form.addInput(new TextField("Et le véhicule :", "champ2", r.getVehicule().toString(), false));
		form.addInput(new TextField("Date de début :", "champ3", dateDebut, false));
		form.addInput(new DateField("Date de fin réalisée :", "champ4"));
		form.addInput(new TextField("Kilométrage de départ :", "champ5", kmDebut, false));
		form.addInput(new TextField("Kilométrage de retour :", "champ6"));
		
		boolean valide = console.input("Réservation n°" + r.getId(), form, new FactureFormValidator());
		
		if (valide) {
					
			r.setDateFin(DateUtils.convert(form.getValue("champ4")));
			r.setKmFin(Integer.parseInt(form.getValue("champ6")));
			r.setStatusReservation(StatusReservation.TERMINEE);
			r.getVehicule().setStatusVehicule(StatusVehicule.DISPONIBLE);
			
			ReservationDao.update(r);
			
			Long nbJour = DateUtils.difference(r.getDateDebut(), r.getDateFin());
			double tarif = r.getVehicule().getType().getTarifJournalier();
			double coutTotal = tarif * nbJour;
			Facture facture = FactureDao.create(new Facture(coutTotal, r));
			
		}
		
		traitement();
		
	}
	
	public void voir(Long id) {
		
		Facture f = FactureDao.findByResa(id);
		String cout = String.valueOf(f.getCoutFacture());
		List<Selectable> reglements = Arrays.asList(TypeReglement.values());
		Client c = f.getReservation().getClient();
		Agence a = AgenceDao.findById(1L);
		
		if (f.getStatusFacture().equals(StatusFacture.NONPAYE)) {
			
			Form form = new Form();
			form.addInput(new TextField("Pour la facture :", "champ1", f.getNumeroFacture(), false));
			form.addInput(new TextField("D'un montant total de :", "champ2", cout + "\u20AC ", false));
			form.addInput(new TextField("Le client :", "champ3", c.toString(), false));
			form.addInput(new ComboBox("À effectué le réglement par :", "champ4", reglements, reglements.get(0)));		
			boolean valide = console.input("Paiement de la réservation n°" + id, form, new PaiementFormValidator());
			
			if (valide) {
						
				TypeReglement typeReglement = form.getValue("champ4");
				PaiementDao.create(new Paiement(typeReglement,f,a));
	
			}
			
		} else if (f.getStatusFacture().equals(StatusFacture.PAYE)) {
			
			console.alert("Facture déjà payée");
		}
		
		traitement();
		
	}


}
