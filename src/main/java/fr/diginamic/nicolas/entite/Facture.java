package fr.diginamic.nicolas.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.diginamic.nicolas.enumeration.StatusFacture;
import fr.diginamic.nicolas.enumeration.StatusReservation;
import fr.diginamic.nicolas.enumeration.TypeReglement;
import fr.diginamic.nicolas.utils.DateUtils;

@Entity
@Table(name = "Facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Numero_Facture", length = 50, nullable = false)
	private String numeroFacture;
	
	@Column(name="Cout_Facture", length = 50, nullable = false)
	private double coutFacture;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status_Facture", length = 50, nullable = false)
	private StatusFacture statusFacture;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type_Reglement", length = 50, nullable = false)
	private TypeReglement typeReglement;
	

	//////////////////////// RELATION ///////////////////////////
	
	@OneToOne
	@JoinColumn(name="Reservation_ID")
	private Reservation reservation;

	/** Constructeur SANS argument
	 * 
	 */
	public Facture() {
	}
	
	/** Constructeur
	 * 
	 */
	public Facture(double coutFacture, Reservation reservation) {
		this.numeroFacture = "FAC" + DateUtils.getFacture();
		this.coutFacture = coutFacture;
		this.statusFacture = StatusFacture.NONPAYE;
		this.typeReglement = TypeReglement.A_DEFINIR;
		this.reservation = reservation;
		this.reservation.setStatusReservation(StatusReservation.TERMINEE);
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Facture [id=");
		builder.append(id);
		builder.append(", numeroFacture=");
		builder.append(numeroFacture);
		builder.append(", coutFacture=");
		builder.append(coutFacture);
		builder.append(", statusFacture=");
		builder.append(statusFacture);
		builder.append(", typeReglement=");
		builder.append(typeReglement);
		builder.append(", reservation=");
		builder.append(reservation);
		builder.append("]");
		return builder.toString();
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
	 * @return the numeroFacture
	 */
	public String getNumeroFacture() {
		return numeroFacture;
	}

	/** Setter
	 * @param numeroFacture the numeroFacture to set
	 */
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	/** Getter
	 * @return the coutFacture
	 */
	public double getCoutFacture() {
		return coutFacture;
	}

	/** Setter
	 * @param coutFacture the coutFacture to set
	 */
	public void setCoutFacture(double coutFacture) {
		this.coutFacture = coutFacture;
	}

	/** Getter
	 * @return the statusFacture
	 */
	public StatusFacture getStatusFacture() {
		return statusFacture;
	}

	/** Setter
	 * @param statusFacture the statusFacture to set
	 */
	public void setStatusFacture(StatusFacture statusFacture) {
		this.statusFacture = statusFacture;
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
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/** Setter
	 * @param reservation the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}	


}
