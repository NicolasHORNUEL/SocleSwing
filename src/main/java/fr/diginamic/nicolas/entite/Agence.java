package fr.diginamic.nicolas.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agence")
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Bilan", length = 50, nullable = false)
	private double bilan;
	
	//////////////////////// RELATION ///////////////////////////
	
	@OneToMany(mappedBy="agence")
	private Set<Paiement> paiement  = new HashSet<>();
	
	@OneToMany(mappedBy="agence")
	private Set<Maintenance> maintenance = new HashSet<>();

	/** Constructeur sans argument
	 * 
	 */
	public Agence() {
		this.bilan = 0; 
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
	 * @return the bilan
	 */
	public double getBilan() {
		return bilan;
	}

	/** Setter
	 * @param bilan the bilan to set
	 */
	public void setBilan(double bilan) {
		this.bilan += bilan;
	}

	/** Getter
	 * @return the paiement
	 */
	public Set<Paiement> getPaiement() {
		return paiement;
	}

	/** Setter
	 * @param facture the paiement to set
	 */
	public void setPaiement(Set<Paiement> paiement) {
		this.paiement = paiement;
	}

	/** Getter
	 * @return the maintenance
	 */
	public Set<Maintenance> getMaintenance() {
		return maintenance;
	}

	/** Setter
	 * @param maintenance the maintenance to set
	 */
	public void setMaintenance(Set<Maintenance> maintenance) {
		this.maintenance = maintenance;
	}
	
	
	
}
