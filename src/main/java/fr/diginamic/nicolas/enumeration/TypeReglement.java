package fr.diginamic.nicolas.enumeration;

import fr.diginamic.composants.ui.Selectable;

public enum TypeReglement  implements Selectable {

	CB(1L),
	LIQUIDE(2L),
	CHEQUE(3L);
	
	private Long id;
	
	
	/** Constructeur
	 * 
	 */
	private TypeReglement() {
	}

	private TypeReglement(Long id) {
		this.id = id;
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
