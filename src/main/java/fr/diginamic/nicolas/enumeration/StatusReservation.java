package fr.diginamic.nicolas.enumeration;

public enum StatusReservation {
	
	ENCOURS("EN COURS"),
	TERMINEE("TERMINÉE");
	
	private String libelle;

	/** Constructeur
	 * 
	 */
	private StatusReservation(String libelle) {
		this.libelle = libelle;
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
	
}
