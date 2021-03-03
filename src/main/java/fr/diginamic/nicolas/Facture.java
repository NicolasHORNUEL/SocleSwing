package fr.diginamic.nicolas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Numero_Facture", length = 50, nullable = false)
	private int numeroFacture;
	
	@Column(name="Cout_Facture", length = 50, nullable = false)
	private int coutFacture;
	
	@Column(name="Status_Facture", length = 50, nullable = false)
	private String statusFacture;
	
	@Column(name="Type_Reglement", length = 50, nullable = false)
	private String typeReglement;
	
	@Column(name="Date_Fin_Reel", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinReel;
	
	
	//////////////////////// RELATION ///////////////////////////
	
	@OneToOne
	@JoinColumn(name="ID_Res")
	private Reservation reservation;

	


}
