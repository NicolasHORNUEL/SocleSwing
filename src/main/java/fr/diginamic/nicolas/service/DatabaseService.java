package fr.diginamic.nicolas.service;

import java.util.Date;

import fr.diginamic.composants.MenuService;
import fr.diginamic.nicolas.dao.AgenceDao;
import fr.diginamic.nicolas.dao.CamionDao;
import fr.diginamic.nicolas.dao.ClientDao;
import fr.diginamic.nicolas.dao.FactureDao;
import fr.diginamic.nicolas.dao.MaintenanceDao;
import fr.diginamic.nicolas.dao.PaiementDao;
import fr.diginamic.nicolas.dao.ReservationDao;
import fr.diginamic.nicolas.dao.TypeDao;
import fr.diginamic.nicolas.dao.VoitureDao;
import fr.diginamic.nicolas.entite.Adresse;
import fr.diginamic.nicolas.entite.Agence;
import fr.diginamic.nicolas.entite.Camion;
import fr.diginamic.nicolas.entite.Client;
import fr.diginamic.nicolas.entite.Facture;
import fr.diginamic.nicolas.entite.Maintenance;
import fr.diginamic.nicolas.entite.Paiement;
import fr.diginamic.nicolas.entite.Permis;
import fr.diginamic.nicolas.entite.Reservation;
import fr.diginamic.nicolas.entite.Type;
import fr.diginamic.nicolas.entite.Vehicule;
import fr.diginamic.nicolas.entite.Voiture;
import fr.diginamic.nicolas.enumeration.TypeReglement;
import fr.diginamic.nicolas.enumeration.TypeVehicule;
import fr.diginamic.nicolas.utils.DateUtils;

public class DatabaseService extends MenuService {

	private void initDatabase() {

		Agence agence = AgenceDao.create(new Agence());

		Type type1 = TypeDao.create(new Type(TypeVehicule.BERLINE, 30D, 300));
		Type type2 = TypeDao.create(new Type(TypeVehicule.CABRIOLET, 40D, 300));
		Type type3 = TypeDao.create(new Type(TypeVehicule.DEMENAGEMENT, 45D, 500));
		Type type4 = TypeDao.create(new Type(TypeVehicule.FRIGORIFIQUE, 60D, 600));
		Type type5 = TypeDao.create(new Type(TypeVehicule.SPORT, 50D, 600));

		Vehicule v1 = VoitureDao.create(new Voiture("VW", "POLO", "HG-579-IK", 10000, type1, 5));
		Vehicule v2 = VoitureDao.create(new Voiture("PEUGEOT", "3008", "BB-555-DD",  50000, type2, 5));
		Vehicule v3 = CamionDao.create(new Camion("VW", "KRAFTER", "HH-999-TT", 10000, type3, 9.0));
		Vehicule v4 = CamionDao.create(new Camion("PEUGEOT", "EXPERT", "AA-777-MM", 8000, type4, 2.8));
		Vehicule v5 = VoitureDao.create(new Voiture("RENAULT", "MEGANE-GT", "RM-141-VV", 5000, type5, 2));
		Vehicule v6 = VoitureDao.create(new Voiture("FORD", "ESCORT RS COSWORTH", "FE-992-RS", 5000, type5, 5));
		Vehicule v7 = VoitureDao.create(new Voiture("LAMBORGHINI", "DIABLO SV", "LD-997-SV", 1000, type5, 2));


		Adresse adr1 = new Adresse(1, "Place de l'étoile", 34190, "MONTPELLIER", "0467977838", "francis@hotmail.fr");
		Adresse adr2 = new Adresse(158, "Avenue de la mer", 34300, "PALAVAS-LES-FLOTS", "0467999003", "vivelaflotte@yahoo.fr");
		Adresse adr3 = new Adresse(13, "rue de l'Espoir", 13013, "MARSEILLE", "0359111333", "rayon2soleil@gmail.com");
		Adresse adr4 = new Adresse(48, "boulevard Kleber", 11100, "NARBONNE", "0459111111", "albert11@msn.com");
		Adresse adr5 = new Adresse(2, "rue notre dame des champs", 91100, "GIF-SUR-YVETTE", "0459111111", "fernand@minitel.fr");



		Date date1 = DateUtils.convert("23/10/1980");
		Date date2 = DateUtils.convert("05/01/1949");
		Date date3 = DateUtils.convert("13/01/1953");
		Date date4 = DateUtils.convert("15/04/1963");
		Date date5 = DateUtils.convert("04/02/1881");
		Permis permis1 = new Permis("C", "77-77777777-33", date1);
		Permis permis2 = new Permis("B", "54789-56783-45", date2);
		Permis permis3 = new Permis("B", "54513-56793-13", date3);
		Permis permis4 = new Permis("B", "54778-57865-11", date4);
		Permis permis5 = new Permis("C", "66-66666666-91", date5);
		Client c1 = ClientDao.create(new Client("DUPONT", "Francis", adr1, permis1));
		Client c2 = ClientDao.create(new Client("CAPITAINE", "Haddock", adr2, permis2));
		Client c3 = ClientDao.create(new Client("HOULLA", "Micheline", adr3, permis3));
		Client c4 = ClientDao.create(new Client("DUBOUT", "Albert", adr4, permis4));
		Client c5 = ClientDao.create(new Client("LEGER", "Fernand", adr5, permis5));


		// OUVRIR UNE RESERVATION = create
		Date dateDebut = DateUtils.getNow();
		Date dateFin1 = DateUtils.set(2021, 5, 19);
		Date dateFin2 = DateUtils.set(2021, 4, 26);
		Date dateDebut3 = DateUtils.set(2020, 10, 10);
		Date dateFin3 = DateUtils.set(2020, 10, 12);
		Date dateDebut4 = DateUtils.set(2020, 5, 10);
		Reservation resa1 = ReservationDao.create(new Reservation(dateDebut, dateFin1, c1, v3));
		Reservation resa2 = ReservationDao.create(new Reservation(dateDebut, dateFin2, "Le petit chien est accepté à bord du véhicule", c3, v1));
		Reservation resa3 = ReservationDao.create(new Reservation(dateDebut3, dateFin3, "Pour une première !", c2, v4));
		Reservation resa4 = ReservationDao.create(new Reservation(dateDebut4, dateDebut, "Longue durée", c5, v7));

		
		// FERMER UNE RESERVATION + EDITER UNE FACTURE
		resa3.setKmFin(v4.getKilometrage()+3000);
		Long nbJour = DateUtils.difference(dateDebut3, dateFin3);
		double tarif = resa3.getVehicule().getType().getTarifJournalier();
		double coutTotal = tarif * nbJour;
		Facture facture = new Facture(coutTotal, resa3);
		FactureDao.create(facture);
	
		// EFFECTUER LE PAIEMENT DE LA FACTURE
		Paiement paiement = new Paiement(TypeReglement.LIQUIDE, facture, agence);
		PaiementDao.create(paiement);
		
		// ENVOI EN MAINTENANCE
		Maintenance m2 = new Maintenance(DateUtils.getNow(), v4, agence);
		Maintenance m2Dao = MaintenanceDao.create(m2);
		Maintenance m1 = new Maintenance(DateUtils.getNow(), v1, agence);
		Maintenance m1Dao = MaintenanceDao.create(m1);
		
		// RETOUR DE MAINTENANCE
		m1Dao.setDateFin(DateUtils.getNow());
		m1Dao.setCoutMaintenance(56.0);
		agence.setBilan(-56.0);
		MaintenanceDao.update(m1Dao);

		

	}

	@Override
	public void traitement() {
		console.clear();
		initDatabase();
		console.print("<h1><center>Initialisation OK<img width=25 src='images/check-square-green.png'></center></h1>");

	}

}
