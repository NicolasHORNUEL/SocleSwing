package fr.diginamic.nicolas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Camion")
public class Camion extends Vehicule {
	
	@Column(name="Volume", length = 10, nullable = false)
	private Double volume;
	
}
