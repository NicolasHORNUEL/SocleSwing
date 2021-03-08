package fr.diginamic.nicolas.enumeration;

import fr.diginamic.composants.ui.Selectable;

public enum StatusFacture implements Selectable {

	PAYE("Payée", 1L),
	NONPAYE("Non payée", 2L);
	
	private String libelle;
	private Long id;
	
	/** Constructeur sans argument
	 * 
	 */
	private StatusFacture() {
	}
	
	/** Constructeur
	 * 
	 */
	private StatusFacture(String libelle, Long id) {
		this.libelle = libelle;
		this.id = id;
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
