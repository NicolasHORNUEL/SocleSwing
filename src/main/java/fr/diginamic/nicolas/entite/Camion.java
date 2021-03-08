package fr.diginamic.nicolas.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.diginamic.composants.ui.Selectable;

@Entity
@Table(name = "Camion")
public class Camion extends Vehicule implements Selectable {
	
	@Column(name="Volume", length = 10, nullable = false)
	private double volume;

	/** Constructeur
	 * 
	 */
	public Camion() {
	}

	/** Constructeur
	 * 
	 */
	public Camion(double volume) {
		this.volume = volume;
	}

	/** Constructeur
	 * 
	 */
	public Camion(String marque, String modele, String immatriculation, int kilometrage, Type type,
			double volume) {
		super(marque, modele, immatriculation, kilometrage, type);
		this.volume = volume;
	}

	/** Getter
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}

	/** Setter
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
	
}
