package fr.diginamic.nicolas;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name="Nom", length = 255, nullable = false)
	private String nom;
	
	@Column(name="Prenom", length = 255, nullable = false)
	private String prenom;
	
	//////////////////////// RELATION ///////////////////////////

	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="client")
	private Set<Permis> permis  = new HashSet<>();
	
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservation = new HashSet<>();

	/** Constructeur
	 * 
	 */
	public Client() {
		
	}

	/** Constructeur
	 * 
	 */
	public Client(String nom, String prenom, Adresse adresse, Set<Permis> permis) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.permis = permis;
	}

	/** Getter
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the permis
	 */
	public Set<Permis> getPermis() {
		return permis;
	}

	/** Setter
	 * @param permis the permis to set
	 */
	public void setPermis(Set<Permis> permis) {
		this.permis = permis;
	}

	/** Getter
	 * @return the reservation
	 */
	public Set<Reservation> getReservation() {
		return reservation;
	}

	/** Setter
	 * @param reservation the reservation to set
	 */
	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
	

}
