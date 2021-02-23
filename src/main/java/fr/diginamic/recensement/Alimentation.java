package fr.diginamic.recensement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Driver;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.RecensementUtils;

public class Alimentation {
	// Lire le ficher de recensement
	// Insérer toutes les villes en base de données

	// Charger le driver
	static {
		try {
			// Etape 1) Charger le driver qui est une classe fournit par la librairie
			DriverManager.registerDriver(new Driver());
			System.out.println("Driver chargé");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de charger le driver");
		}
	}

	// La connexion
	public static Connection getConnection() {
		try {
			ResourceBundle props = ResourceBundle.getBundle("properties");
			String driver = props.getString("database.driver");
			String url = props.getString("database.url");
			String login = props.getString("database.log");
			String pass = props.getString("database.pass");

			Connection connection = DriverManager.getConnection(url, login, pass);
			return connection;
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à l'application");
			return null;
		}
	}

	// Insert Ville
	public static void insertVille() throws IOException {
		try {
			Connection connection = getConnection();

			Path pathOrigine = Paths.get("C:/ProjetJava/recensement.csv");
			List<String> lines = Files.readAllLines(pathOrigine, StandardCharsets.UTF_8);
			lines.remove(0);

			// Stockage de valeur dans recensement afin d'avoir toute les villes du csv
			for (int i = 0; i < lines.size(); i++) {
				String[] infoVille = lines.get(i).split(";");
				String nomCommune = infoVille[6];
				int popTotal = Integer.parseInt(infoVille[9].replace(" ", ""));

				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO ville (nom, population) VALUES (?,?)");

				stmt.setString(1, nomCommune);
				stmt.setInt(2, popTotal);

				stmt.executeUpdate();
			}
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	// Insert region
	public static void insertRegion() throws IOException {
		try {
			Connection connection = getConnection();

			Path pathOrigine = Paths.get("C:/ProjetJava/recensement.csv");
			List<String> lines = Files.readAllLines(pathOrigine, StandardCharsets.UTF_8);
			lines.remove(0);

			// Stockage de valeur dans recensement afin d'avoir toute les villes du csv
			for (int i = 0; i < lines.size(); i++) {
				Statement statement = connection.createStatement();;
				String[] infoVille = lines.get(i).split(";");
				int codeRegion = Integer.parseInt(infoVille[0]);
				String nomRegion = infoVille[1];
				

				PreparedStatement stmt = connection.prepareStatement(
						" INSERT INTO region (nom, code) VALUES (?, ?)");
				
				stmt.setString(1, nomRegion);
				stmt.setInt(2, codeRegion);
			//
				stmt.executeUpdate();
			}
			System.out.println("Requete réussi");
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
