package fr.diginamic.nicolas.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.nicolas.enumeration.StatusVehicule;
import fr.diginamic.nicolas.utils.DateUtils;

@Entity
@Table(name = "Vehicule")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule implements Selectable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Marque", length = 255, nullable = false)
	private String marque;
	
	@Column(name="Modele", length = 255, nullable = false)
	private String modele;
	
	@Column(name="Immatriculation", length = 255, nullable = false, unique =true)
	private String immatriculation;

	@Transient
	private StatusVehicule statusVehicule;
	
	@Column(name="Kilometrage", length = 50, nullable = false)
	private int kilometrage;
	
	//////////////////////// RELATION ///////////////////////////

	@OneToMany(mappedBy="vehicule")
	private Set<Reservation> reservations = new HashSet<>();
	
	@OneToMany(mappedBy="vehicule")
	private Set<Maintenance> maintenances = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="Type_ID")
	private Type type;

	/** Constructeur sans argument
	 * 
	 */
	public Vehicule() {
		
	}

	/** Constructeur
	 * 
	 */
	public Vehicule(String marque, String modele, String immatriculation, int kilometrage, Type type) {
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.statusVehicule = StatusVehicule.DISPONIBLE;
		this.kilometrage = kilometrage;
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(type.getTypeVehicule().getLibelle());
		builder.append(" de type ");
		builder.append(type.getTypeVehicule());
		builder.append(" : ");
		builder.append(marque);
		builder.append(" ");
		builder.append(modele);
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
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/** Setter
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/** Getter
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/** Setter
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/** Getter
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/** Setter
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/** Getter
	 * @return the statusVehicule
	 */
	public StatusVehicule getStatusVehicule() {
		this.statusVehicule = StatusVehicule.DISPONIBLE;
		if (!reservations.isEmpty()) {
			for (Reservation r : reservations) {
				if (r.getDateDebut().before(DateUtils.getNow()) && r.getDateFin().after(DateUtils.getNow())) {
					this.setStatusVehicule(StatusVehicule.LOUE);
				}
			}
		}
		return statusVehicule;
	}

	/** Setter
	 * @param statusVehicule the statusVehicule to set
	 */
	public void setStatusVehicule(StatusVehicule statusVehicule) {
		this.statusVehicule = statusVehicule;
	}

	/** Getter
	 * @return the kilometrage
	 */
	public int getKilometrage() {
		return kilometrage;
	}

	/** Setter
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	/** Getter
	 * @return the reservation
	 */
	public Set<Reservation> getReservation() {
		return reservations;
	}

	/** Setter
	 * @param reservation the reservation to set
	 */
	public void setReservation(Set<Reservation> reservation) {
		this.reservations = reservation;
	}

	/** Getter
	 * @return the maintenance
	 */
	public Set<Maintenance> getMaintenance() {
		return maintenances;
	}

	/** Setter
	 * @param maintenance the maintenance to set
	 */
	public void setMaintenance(Set<Maintenance> maintenance) {
		this.maintenances = maintenance;
	}

	/** Getter
	 * @return the typeVehicule
	 */
	public Type getType() {
		return type;
	}

	/** Setter
	 * @param typeVehicule the typeVehicule to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	
	
}
