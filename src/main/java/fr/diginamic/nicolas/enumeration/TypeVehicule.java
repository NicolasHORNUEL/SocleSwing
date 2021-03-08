package fr.diginamic.nicolas.enumeration;

import fr.diginamic.composants.ui.Selectable;

public enum TypeVehicule implements Selectable {

	SPORT("Voiture", 1L),
	BERLINE("Voiture", 2L),
	CABRIOLET("Voiture", 3L),
	DEMENAGEMENT("Camion", 4L),
	FRIGORIFIQUE("Camion", 5L);
	
	private String libelle;
	private Long id;
	
	
	/** Constructeur
	 * 
	 */
	private TypeVehicule() {
	}

	private TypeVehicule(String libelle, Long id) {
		this.libelle = libelle;
		this.id = id;
	}

	public static TypeVehicule getInstance(Long id) {
		for (TypeVehicule string : TypeVehicule.values()) {
			if (string.getId().equals(id)) {
				return string;
			}
		};
		return null;	
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}

