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
@Table(name="Permis")
public class Permis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Type_Permis", length = 50, nullable = false)
	private String typePermis;
	
	@Column(name="Numero_Permis", length = 50, nullable = false)
	private String numeroPermis;
	
	@Column(name="Date_Obtention", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateObtention;
	
	//////////////////////// RELATION ///////////////////////////

	@ManyToOne
	@JoinColumn(name="Client_ID")
	private Client client;

}
