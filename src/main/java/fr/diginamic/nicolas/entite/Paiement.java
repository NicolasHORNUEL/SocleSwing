package fr.diginamic.nicolas.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.diginamic.nicolas.enumeration.StatusFacture;
import fr.diginamic.nicolas.enumeration.TypeReglement;

@Entity
@Table(name = "Paiement")
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "Type_Reglement", length = 20, nullable = false)
	private TypeReglement typeReglement;

	////////////////////////RELATION ///////////////////////////

	@OneToOne
	@JoinColumn(name = "Facture_ID")
	private Facture facture;

	@ManyToOne
	@JoinColumn(name = "Agence_ID")
	private Agence agence;

	/** Constructeur SANS argument
	 * 
	 */
	public Paiement() {
	}
	
	/** Constructeur
	 * 
	 */
	public Paiement(TypeReglement typeReglement, Facture facture, Agence agence) {
		if (facture.getStatusFacture().equals(StatusFacture.NONPAYE)) {
			this.typeReglement = typeReglement;
			this.facture = facture;
			this.agence = agence;
			agence.setBilan(facture.getCoutFacture());
			facture.setStatusFacture(StatusFacture.PAYE);
		}
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

	/** Getter
	 * @return the typeReglement
	 */
	public TypeReglement getTypeReglement() {
		return typeReglement;
	}

	/** Setter
	 * @param typeReglement the typeReglement to set
	 */
	public void setTypeReglement(TypeReglement typeReglement) {
		this.typeReglement = typeReglement;
	}

	/** Getter
	 * @return the facture
	 */
	public Facture getFacture() {
		return facture;
	}

	/** Setter
	 * @param facture the facture to set
	 */
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	/** Getter
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/** Setter
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
}
