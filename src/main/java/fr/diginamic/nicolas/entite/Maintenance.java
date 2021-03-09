package fr.diginamic.nicolas.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Maintenance")
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Date_Debut", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="Date_Fin", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@Column(name="Cout_Maintenance", length = 50, nullable = true)
	private double coutMaintenance;
	
	//////////////////////// RELATION ///////////////////////////

	@ManyToOne
	@JoinColumn(name="Vehicule_ID")
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="Agence_ID")
	private Agence agence;

	/** Constructeur SANS arguments
	 * 
	 */
	public Maintenance() {
	}
	
	/** Constructeur
	 * 
	 */
	public Maintenance(Date dateDebut, Vehicule vehicule, Agence agence) {
		this.dateDebut = dateDebut;
		this.vehicule = vehicule;
		this.agence = agence;
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
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the coutMaintenance
	 */
	public double getCoutMaintenance() {
		return coutMaintenance;
	}

	/** Setter
	 * @param coutMaintenance the coutMaintenance to set
	 */
	public void setCoutMaintenance(double coutMaintenance) {
		this.coutMaintenance = coutMaintenance;
	}

	/** Getter
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/** Setter
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
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
