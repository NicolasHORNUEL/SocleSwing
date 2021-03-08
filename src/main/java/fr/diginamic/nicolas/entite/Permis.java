package fr.diginamic.nicolas.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class Permis {
	
	@Column(name="Type_Permis", length = 50, nullable = false)
	private String typePermis;
	
	@Column(name="Numero_Permis", length = 50, nullable = false)
	private String numeroPermis;
	
	@Column(name="Date_Obtention", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateObtention;
	
	
	/** Constructeur sans argument
	 * 
	 */
	public Permis() {
	}


	/** Constructeur
	 * 
	 */
	public Permis(String typePermis, String numeroPermis, Date dateObtention) {
		this.typePermis = typePermis;
		this.numeroPermis = numeroPermis;
		this.dateObtention = dateObtention;
	}

	
	/** Getter
	 * @return the typePermis
	 */
	public String getTypePermis() {
		return typePermis;
	}


	/** Setter
	 * @param typePermis the typePermis to set
	 */
	public void setTypePermis(String typePermis) {
		this.typePermis = typePermis;
	}


	/** Getter
	 * @return the numeroPermis
	 */
	public String getNumeroPermis() {
		return numeroPermis;
	}


	/** Setter
	 * @param numeroPermis the numeroPermis to set
	 */
	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}


	/** Getter
	 * @return the dateObtention
	 */
	public Date getDateObtention() {
		return dateObtention;
	}


	/** Setter
	 * @param dateObtention the dateObtention to set
	 */
	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}



}
