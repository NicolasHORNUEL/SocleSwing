package fr.diginamic.nicolas;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(name="Numero_Rue", length = 10, nullable = false)
	private int numeroRue;
	
	@Column(name="Libelle_Rue", length = 50, nullable = false)
	private String libelleRue;
	
	@Column(name="Code_Postale", length = 10, nullable = false)
	private int codePostale;
	
	@Column(name="Ville", length = 50, nullable = false)
	private String ville;
	
	@Column(name="Numero_Tel", length = 10, nullable = false)
	private int numeroTel;
	
	@Column(name="Email", length = 50, nullable = false, unique =true)
	private String email;
	
	/** Constructeur sans argument
	 * 
	 */
	public Adresse() {
		
	}

	/** Constructeur
	 * 
	 */
	public Adresse(int numeroRue, String libelleRue, int codePostale, String ville, int numeroTel, String email) {
		this.numeroRue = numeroRue;
		this.libelleRue = libelleRue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.numeroTel = numeroTel;
		this.email = email;
	}
	
	/** Getter
	 * @return the numeroRue
	 */
	public int getNumeroRue() {
		return numeroRue;
	}

	/** Setter
	 * @param numeroRue the numeroRue to set
	 */
	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}

	/** Getter
	 * @return the libelleRue
	 */
	public String getLibelleRue() {
		return libelleRue;
	}

	/** Setter
	 * @param libelleRue the libelleRue to set
	 */
	public void setLibelleRue(String libelleRue) {
		this.libelleRue = libelleRue;
	}

	/** Getter
	 * @return the codePostale
	 */
	public int getCodePostale() {
		return codePostale;
	}

	/** Setter
	 * @param codePostale the codePostale to set
	 */
	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Getter
	 * @return the numeroTel
	 */
	public int getNumeroTel() {
		return numeroTel;
	}

	/** Setter
	 * @param numeroTel the numeroTel to set
	 */
	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}

	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

}
