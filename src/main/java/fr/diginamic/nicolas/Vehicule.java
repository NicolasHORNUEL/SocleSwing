package fr.diginamic.nicolas;

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

@Entity
@Table(name = "Vehicule")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Marque", length = 255, nullable = false)
	private String marque;
	
	@Column(name="Modele", length = 255, nullable = false)
	private String modele;
	
	@Column(name="Immatriculation", length = 255, nullable = false, unique =true)
	private String immatriculation;

	@Column(name="Status", length = 255, nullable = false)
	private String status;
	
	@Column(name="Kilometrage", length = 100, nullable = false)
	private int kilometrage;
	
	//////////////////////// RELATION ///////////////////////////

	@OneToMany(mappedBy="vehicule")
	private Set<Reservation> reservation = new HashSet<>();
	
	@OneToMany(mappedBy="vehicule")
	private Set<Maintenance> maintenance = new HashSet<>();
	
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
	public Vehicule(long id, String marque, String modele, String immatriculation) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
	}
	
	
	
}
