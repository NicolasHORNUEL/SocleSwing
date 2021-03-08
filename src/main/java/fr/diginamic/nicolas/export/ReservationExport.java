package fr.diginamic.nicolas.export;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.nicolas.dao.ReservationDao;
import fr.diginamic.nicolas.entite.Reservation;

public class ReservationExport extends MenuService {

	@Override
	public void traitement() {

		Path pathCible = Paths.get("csv/reservations.csv");
				
		List<String> liste = new ArrayList<>();
		List<Reservation> reservations = ReservationDao.findAll();
		for (Reservation r : reservations) {
			liste.add(r.toString());
		}
		
		try {
			Files.write(pathCible, liste);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
