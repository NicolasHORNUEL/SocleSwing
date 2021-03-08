package fr.diginamic.nicolas.enumeration;

public enum StatusVehicule {

	EN_MAINTENANCE("En maintenance"),
	DISPONIBLE("Disponible"),
	LOUE("Loué");

	private String libelle;


	/** Constructeur
	 * 
	 */
	private StatusVehicule(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
