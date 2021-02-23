package fr.diginamic.recensement.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.Alimentation;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {

		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();

		try {
			Connection connection = Alimentation.getConnection();

			Statement statement = connection.createStatement();
			ResultSet curseur = statement.executeQuery("SELECT nom, population FROM ville WHERE nom = '" + choix + "' ");

			if (curseur.next()) {
				String nom = curseur.getString("nom");
				int population = curseur.getInt("population");
				System.out.println(nom + " population: " + population);
			} else {
				System.out.println("Cette ville n'existe pas");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}