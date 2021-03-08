package fr.diginamic.nicolas.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.diginamic.nicolas.enumeration.StatusReservation;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="Status_Res", length = 20, nullable = true)
    private StatusReservation statusReservation;
	
	@Column(name = "Date_Debut", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Column(name = "Date_Fin", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@Column(name = "Commentaire", length = 255, nullable = true)
	private String commentaire;

	@Column(name = "Km_Debut", length = 50, nullable = false)
	private int kmDebut;
	
	@Column(name = "Km_Fin", length = 50, nullable = true)
	private int kmFin;

	//////////////////////// RELATION ///////////////////////////

	@ManyToOne
	@JoinColumn(name = "Client_ID")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "Vehicule_ID")
	private Vehicule vehicule;

	/**
	 * Constructeur sans argument
	 * 
	 */
	public Reservation() {
	}

	/**
	 * Constructeur SANS argument commentaire
	 * 
	 */
	public Reservation(Date dateDebut, Date dateFin, Client client, Vehicule vehicule) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.commentaire = "";
		this.kmDebut = vehicule.getKilometrage();
		this.client = client;
		this.vehicule = vehicule;
		this.statusReservation = StatusReservation.ENCOURS;
	}
	
	/**
	 * Constructeur AVEC argument commentaire
	 * 
	 */
	public Reservation(Date dateDebut, Date dateFin, String commentaire, Client client, Vehicule vehicule) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.commentaire = commentaire;
		this.kmDebut = vehicule.getKilometrage();
		this.client = client;
		this.vehicule = vehicule;
		this.statusReservation = StatusReservation.ENCOURS;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(";");
		builder.append(statusReservation);
		builder.append(";");
		builder.append(dateDebut);
		builder.append(";");
		builder.append(dateFin);
		builder.append(";");
		builder.append(commentaire);
		builder.append(";");
		builder.append(kmDebut);
		builder.append(";");
		builder.append(kmFin);
		builder.append(";");
		builder.append(this.getClient().getId());
		builder.append(";");
		builder.append(this.getVehicule().getId());
		builder.append(";");
		return builder.toString();
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Setter
	 * 
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * Getter
	 * 
	 * @return the kmDebut
	 */
	public int getKmDebut() {
		return kmDebut;
	}

	/**
	 * Setter
	 * 
	 * @param kmDebut the kmDebut to set
	 */
	public void setKmDebut(int kmDebut) {
		this.kmDebut = kmDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the kmFin
	 */
	public int getKmFin() {
		return kmFin;
	}

	/**
	 * Setter
	 * 
	 * @param kmFin the kmFin to set
	 */
	public void setKmFin(int kmFin) {
		this.vehicule.setKilometrage(kmFin);
		this.kmFin = kmFin;
	}

	/**
	 * Getter
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter
	 * 
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter
	 * 
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * Setter
	 * 
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	/** Getter
	 * @return the statusReservation
	 */
	public StatusReservation getStatusReservation() {
		return statusReservation;
	}

	/** Setter
	 * @param statusReservation the statusReservation to set
	 */
	public void setStatusReservation(StatusReservation statusReservation) {
		this.statusReservation = statusReservation;
	}

}
