package fr.diginamic.nicolas.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.diginamic.composants.ui.Selectable;

@Entity
@Table(name = "Voiture")
public class Voiture extends Vehicule implements Selectable {
	
	@Column(name="nombre_Place", length = 10, nullable = false)
	private int nombrePlace;
	
	/** Constructeur
	 * 
	 */
	public Voiture() {
	}

	/** Constructeur
	 * 
	 */
	public Voiture(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	/** Constructeur
	 * 
	 */
	public Voiture(String marque, String modele, String immatriculation, int kilometrage, Type type,
			int nombrePlace) {
		super(marque, modele, immatriculation, kilometrage, type);
		this.nombrePlace = nombrePlace;
	}

	/** Getter
	 * @return the nombrePlace
	 */
	public int getNombrePlace() {
		return nombrePlace;
	}

	/** Setter
	 * @param nombrePlace the nombrePlace to set
	 */
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	
	
}
