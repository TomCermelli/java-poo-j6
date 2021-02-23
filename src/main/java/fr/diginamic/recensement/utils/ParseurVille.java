package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Permet de constituer notre recensement progressivement é partir des lignes du fichier
 * @author DIGINAMIC
 *
 */
public class ParseurVille {
	
	/** Ajoute une ligne représentant une ville au recensement
	 * @param recensement recensement é compléter
	 * @param ligne ligne de laquelle on extrait une ville
	 */
	public static void ajoutLigne(Recensement recensement, String ligne){
		
		String[] morceaux = ligne.split(";");
		String codeRegion = morceaux[0];
		String nomRegion = morceaux[1];
		String codeDepartement = morceaux[2];
		String codeCommune = morceaux[5];
		String nomCommune = morceaux[6];
		String population = morceaux[7];
		int populationTotale = Integer.parseInt(population.replace(" ", "").trim());
		
		// On cree maintenant la ville avec toutes ses données
		Ville ville = new Ville(codeRegion, codeDepartement, nomCommune, populationTotale);
		
		// On ajoute la ville é la liste des villes du recensement
		recensement.getVilles().add(ville);
		
	}

}
