package fr.diginamic.nicolas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Voiture")
public class Voiture extends Vehicule {
	
	@Column(name="nombre_Place", length = 10, nullable = false)
	private int nombrePlace;
	
}
