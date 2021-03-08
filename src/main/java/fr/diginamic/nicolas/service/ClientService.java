package fr.diginamic.nicolas.service;

import java.util.Date;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.nicolas.dao.ClientDao;
import fr.diginamic.nicolas.entite.Adresse;
import fr.diginamic.nicolas.entite.Client;
import fr.diginamic.nicolas.entite.Permis;
import fr.diginamic.nicolas.utils.DateUtils;

public class ClientService extends MenuService {

	
	
	@Override
	public void traitement() {

		console.clear();

		List<Client> clients = ClientDao.findAll();

		console.print("<h1 class='bg-red'><center>Liste des clients</center></h1>");
		console.print("<h2><a class='btn-red' href='ajouter()'><img width=25 src='images/plus-green.png'></a>AJOUTER</h2>");

		String html = "<table cellspacing=0>" + "<tr class='bg-red'>" + "<td></td>" + "<td></td>" + "<td>Id</td>"
				+ "<td>NOM Prénom</td>" + "<td>Adresse postale</td>" + "<td>Téléphone</td>" + "<td>Email</td>" + "<td>Permis</td>"
				+ "</tr>";
		for (Client c : clients) {
			html += "<tr>" + " <td><a class='btn-blue' href='modifier(" + c.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>" + " <td><a class='btn-blue' href='supprimer("
					+ c.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + " <td width='15px'>" + c.getId()
					+ "</td>" + " <td width='150px'>" + c.getNom() + " " + c.getPrenom() + "</td>" + " <td width='300px'>"
					+ c.getAdresse().getNumeroRue() + ", " + c.getAdresse().getLibelleRue() + " - "
					+ c.getAdresse().getCodePostale() + " " + c.getAdresse().getVille() + "</td>" + " <td width='150px'>"
					+ c.getAdresse().getNumeroTel() + "</td>" + " <td width='150px'>" + c.getAdresse().getEmail() + "</td>"
					+ " <td width='15px'>" + c.getPermis().getTypePermis() + "</td>" + " </tr>";
		}
		html += "</table>";

		console.print(html);
	}

	
	
	public void ajouter() {

		String[] infoClient = new String[11];
		for (int i = 0; i < 11; i++) {
			infoClient[i] = null;
		}

		Client cNew = loadForm(infoClient);

		if (cNew != null) {
			ClientDao.create(cNew);
		}

		traitement();
	}

	
	
	
	public void modifier(Long id) {

		Client c = ClientDao.findById(id);
		String[] infoClient = { c.getNom(), c.getPrenom(), String.valueOf(c.getAdresse().getNumeroRue()),
				c.getAdresse().getLibelleRue(), String.valueOf(c.getAdresse().getCodePostale()), c.getAdresse().getVille(),
				c.getAdresse().getNumeroTel(), c.getAdresse().getEmail(), c.getPermis().getTypePermis(),
				c.getPermis().getNumeroPermis(), DateUtils.tronque(c.getPermis().getDateObtention())};

		Client cNew = loadForm(infoClient);
		
		if (cNew != null) {
			cNew.setId(id);
			ClientDao.update(cNew);
		}
		
		traitement();
	}

	
	
	
	public void supprimer(Long id) {
		Client c = ClientDao.findById(id);
		if (c.getReservation().isEmpty()){
			ClientDao.delete(c);
		} else {
			console.alert("Interdit");
		}

		traitement();
	}

	
	
	public Client loadForm(String[] info) {
		Form form = new Form();
		form.addInput(new TextField("Nom:", "champ1", info[0]));
		form.addInput(new TextField("Prenom:", "champ2", info[1]));
		form.addInput(new TextField("Numéro de rue:", "champ3", info[2]));
		form.addInput(new TextField("Libellé de rue:", "champ4", info[3]));
		form.addInput(new TextField("Code postale:", "champ5", info[4]));
		form.addInput(new TextField("Ville:", "champ6", info[5]));
		form.addInput(new TextField("Numéro de téléphone:", "champ7", info[6]));
		form.addInput(new TextField("Email:", "champ8", info[7]));
		form.addInput(new TextField("Type de permis:", "champ9", info[8]));
		form.addInput(new TextField("Numéro de permis:", "champ10", info[9]));
		form.addInput(new DateField("Date d'obtention :", "champ11", info[10]));
		boolean valide = console.input("Demande d'informations", form, new ClientFormValidator());
		if (valide) {
			String nom = form.getValue("champ1");
			String prenom = form.getValue("champ2");
			int numeroRue = Integer.parseInt(form.getValue("champ3"));
			String libelleRue = form.getValue("champ4");
			int CodePostale = Integer.parseInt(form.getValue("champ5"));
			String ville = form.getValue("champ6");
			String numeroTel = form.getValue("champ7");
			String email = form.getValue("champ8");
			String typePermis = form.getValue("champ9");
			String numeroPermis = form.getValue("champ10");
			Date dateObtention = DateUtils.convert(form.getValue("champ11"));
			Permis permis = new Permis(typePermis, numeroPermis, dateObtention);
			Adresse adresse = new Adresse(numeroRue, libelleRue, CodePostale, ville, numeroTel, email);
			return new Client(nom, prenom, adresse, permis);
		}
		return null;
	}

}
