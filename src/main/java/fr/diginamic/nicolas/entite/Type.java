package fr.diginamic.nicolas.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.nicolas.enumeration.TypeVehicule;

@Entity
@Table(name = "Type")
public class Type implements Selectable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type_Vehicule", length = 20, nullable = false)
    private TypeVehicule typeVehicule;
	
	@Column(name="Tarif_Journalier", length = 10, nullable = false)
	private double tarifJournalier;
	
	@Column(name="Caution", length = 10, nullable = false)
	private int caution;
	
	//////////////////////// RELATION ///////////////////////////

	@OneToMany(mappedBy="type")
	private Set<Vehicule> vehicule = new HashSet<>();

	/** Constructeur
	 * 
	 */
	public Type() {
		
	}
	
	/** Constructeur
	 * 
	 */
	public Type(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	
	/** Constructeur
	 * 
	 */
	public Type(TypeVehicule typeVehicule, double tarifJournalier, int caution) {
		this.typeVehicule = typeVehicule;
		this.tarifJournalier = tarifJournalier;
		this.caution = caution;
	}

	
	@Override
	public String toString() {
		return typeVehicule.toString() ;
	}


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the typeVehicule
	 */
	public TypeVehicule getTypeVehicule() {
		return typeVehicule;
	}

	/** Setter
	 * @param typeVehicule the typeVehicule to set
	 */
	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	/** Getter
	 * @return the tarifJournalier
	 */
	public double getTarifJournalier() {
		return tarifJournalier;
	}

	/** Setter
	 * @param tarifJournalier the tarifJournalier to set
	 */
	public void setTarifJournalier(double tarifJournalier) {
		this.tarifJournalier = tarifJournalier;
	}

	/** Getter
	 * @return the caution
	 */
	public int getCaution() {
		return caution;
	}

	/** Setter
	 * @param caution the caution to set
	 */
	public void setCaution(int caution) {
		this.caution = caution;
	}

	/** Getter
	 * @return the vehicule
	 */
	public Set<Vehicule> getVehicule() {
		return vehicule;
	}

	/** Setter
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Set<Vehicule> vehicule) {
		this.vehicule = vehicule;
	}

}
