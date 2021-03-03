package fr.diginamic.nicolas;

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
	private int id;
	
	@Column(name="Date_Debut", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="Date_Fin", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@Column(name="Cout_Maintenance", length = 50, nullable = false)
	private int coutMaintenance;
	
	//////////////////////// RELATION ///////////////////////////

	@ManyToOne
	@JoinColumn(name="Vehicule_ID")
	private Vehicule vehicule;
	
}
