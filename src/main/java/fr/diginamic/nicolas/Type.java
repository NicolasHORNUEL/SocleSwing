package fr.diginamic.nicolas;

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
@Table(name = "Type")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Nom", length = 255, nullable = false)
	private String nom;
	
	@Column(name="Tarif_Journalier", length = 100, nullable = false)
	private int tarifJournalier;
	
	@Column(name="Caution", length = 100, nullable = false)
	private int caution;
	
	//////////////////////// RELATION ///////////////////////////

	@OneToMany(mappedBy="type")
	private Set<Vehicule> vehicule = new HashSet<>();
}
