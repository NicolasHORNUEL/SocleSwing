package fr.diginamic;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.composants.AbstractApplication;
import fr.diginamic.nicolas.export.ReservationExport;
import fr.diginamic.nicolas.service.ClientService;
import fr.diginamic.nicolas.service.DatabaseService;
import fr.diginamic.nicolas.service.MaintenanceService;
import fr.diginamic.nicolas.service.ReservationService;
import fr.diginamic.nicolas.service.TypeService;
import fr.diginamic.nicolas.service.VehiculeService;
import fr.diginamic.services.exemples.Exemple2Service;
import fr.diginamic.services.exemples.Exemple3Service;
import fr.diginamic.services.exemples.Exemple4Service;
import fr.diginamic.services.exemples.Exemple6Service;

/**
 * Fenêtre principale qui porte les principaux composants graphiques de
 * l'application:<br>
 * - les boutons du menu,<br>
 * - le panneau d'affichage des résultats<br>
 * 
 * @author RichardBONNAMY
 *
 */
public class Application extends AbstractApplication {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("agence-vip-location");

	/** serialVersionUID */
	private static final long serialVersionUID = 6755835482616236832L;
	
	/** Constructeur
	 * @param title titre
	 */
	public Application(String title) {
		super(title);
	}

	/**
	 * Code principal
	 * 
	 */
	public void main() {
		addMenu(1, "File");
		addMenu(2, "Vehicules");
		addMenu(3, "Clients");
		addMenu(4, "Réservations");
		addMenu(5, "Exemples");
		addMenu(6, "Database");
		
		
		addMenuOption(1, "Export CSV de la liste réservation", new ReservationExport());
		addMenuOption(2, "Liste des types de véhicule", new TypeService());
		addMenuOption(2, "Liste des véhicules", new VehiculeService());
		addMenuOption(2, "Gestion maintenance", new MaintenanceService());
		addMenuOption(3, "Liste des clients", new ClientService());
		addMenuOption(4, "Liste des réservations", new ReservationService());
		addMenuOption(5, "Exemple 2 - Textes de couleur", new Exemple2Service());
		addMenuOption(5, "Exemple 3 - Table", new Exemple3Service());
		addMenuOption(5, "Exemple 4 - Table avec liens vers méthodes", new Exemple4Service());
		addMenuOption(5, "Exemple 6 - Formulaire", new Exemple6Service());
		addMenuOption(6, "Initialisation", new DatabaseService());
	}

}