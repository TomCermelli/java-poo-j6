package fr.diginamic.recensement.entites;

/**
 * Représente une ville
 * 
 * @author DIGINAMIC
 *
 */
public class Ville implements EnsemblePop {

	/** codeRegion : code de la région */
	private String codeRegion;
	/** nomRegion : nom de la région */
	private String nomRegion;
	/** codeDepartement : code du département */
	private String codeDepartement;
	/** code INSEE de la ville */
	private String codeVille;
	/** nom de la ville */
	private String nom;
	/** population totale */
	private int population;

	/**
	 * Constructeur
	 * 
	 * @param codeRegion code de la région
	 * @param nomRegion nom de la région
	 * @param codeDepartement code du département
	 * @param codeVille code INSEE de la ville
	 * @param nom nom de la ville
	 * @param population population totale
	 */
	public Ville(String codeRegion, String codeDepartement, String nom,
			int population) {
		super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.codeDepartement = codeDepartement;
		this.codeVille = codeVille;
		this.nom = nom;
		this.population = population;
	}

	@Override
	public String toString() {
		return "Département n°" + codeDepartement + " - Ville : " + nom + " - " + population + " hab.";
	}

	/**
	 * Getter
	 * 
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/**
	 * Setter
	 * 
	 * @param codeRegion the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	/**
	 * Getter
	 * 
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/**
	 * Setter
	 * 
	 * @param nomRegion the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/**
	 * Getter
	 * 
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * Setter
	 * 
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * Getter
	 * 
	 * @return the codeVille
	 */
	public String getCodeVille() {
		return codeVille;
	}

	/**
	 * Setter
	 * 
	 * @param codeVille the codeVille to set
	 */
	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the population
	 */
	@Override
	public int getPopulation() {
		return population;
	}

	/**
	 * Setter
	 * 
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

}
