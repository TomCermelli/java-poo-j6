package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exception.ExceptionFormat;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ExceptionFormat {
		boolean verif = false;
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		// On test si on trouve bien un département correspondant au choix de
		// l'utilisateur
		for (int i = 0; i < rec.getVilles().size(); i++) {
			if (rec.getVilles().get(i).getCodeDepartement().equalsIgnoreCase(choix)) {
				verif = true;

			}
		}
		// Si nous n'avons rien trouvé on envoie une erreur
		if (verif == false) {
			throw new ExceptionFormat("Le code département est inconnue");
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		// On test si c'est un nombre ou non pour le Minimum
		if (!scanner.hasNextInt()) {
			throw new ExceptionFormat("Vous n'avez pas rentré de nombre");
		}
		String saisieMin = scanner.nextLine();

		// On test si le minimum est inférieur à 0
		if (Integer.parseInt(saisieMin) < 0) {
			System.out.println("salut");
			throw new ExceptionFormat("Votre minimum doit être au dessus de 0");
		}

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		// On test si c'est un nombre ou non pour le Maximum
		if (!scanner.hasNextInt()) {
			throw new ExceptionFormat("Vous n'avez pas rentré de nombre");
		}
		String saisieMax = scanner.nextLine();

		// On test si le maximum est inférieur à 0
		if (Integer.parseInt(saisieMax) < 0) {
			throw new ExceptionFormat("Votre maximum doit être au dessus de 0");
		}

		// On test si le Maximum est supérieur au Minimum
		if (Integer.parseInt(saisieMin) > Integer.parseInt(saisieMax)) {
			throw new ExceptionFormat("Votre maximum doit être au dessus de votre minimum");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
 
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {

				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}

			}
		}
	}

}
