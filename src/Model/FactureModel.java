package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class FactureModel {
    private int id_client;
    private String id_voiture;
    private String date_facture;
    private String lieu_facture;
    private int id_facture;
    private float prix_voiture;

    public FactureModel() {}

    public String CreerFacture(ClientModel client, VoitureModel voiture, float prix_voiture) throws SQLException, ClassNotFoundException {

        String PhraseFinale = "";
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer un nouveau client
            String query = "INSERT INTO facture (id_client, id_voiture, date_facture, lieu_facture, id_facture, prix_voiture)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, client.getId_client());
            statement.setString(2, voiture.getId_plaque());
            statement.setString(3, LocalDate.now().toString());
            statement.setString(4, "Paris, Beaugrenelle");
            statement.setInt(5, generateUniqueIdFacture());
            statement.setFloat(6, prix_voiture);

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();
            connexion.closeConnection();
            if (rowsInserted > 0) {
                System.out.println("La facture a été généré avec succès !");
            } else {
                System.out.println("Erreur lors de la création de la facture");
            }
        } catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        return PhraseFinale;
    }



    // Méthode
    // pour générer un identifiant unique
    public int generateUniqueIdFacture() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        int newFactureId;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier l'unicité de l'identifiant généré
            String query = "SELECT COUNT(*) FROM facture WHERE id_facture = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            do {
                // Génération d'un nombre aléatoire entre 0 et 999999
                newFactureId = random.nextInt(1000000);

                if (newFactureId <100000) {
                    newFactureId = Integer.parseInt("0" + newFactureId);
                }

                System.out.println(newFactureId);

                // Vérification de l'unicité de l'identifiant
                statement.setInt(1, newFactureId);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                resultSet.close();

                if (count == 0) {
                    // L'identifiant est unique, on peut le retourner
                    connexion.closeConnection();
                    return newFactureId;
                }

            } while (true);
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
            // En cas d'erreur, retourner une valeur par défaut ou gérer l'exception selon les besoins
            return -1; // Exemple de valeur par défaut
        }
    }






    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(String id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }

    public String getLieu_facture() {
        return lieu_facture;
    }

    public void setLieu_facture(String lieu_facture) {
        this.lieu_facture = lieu_facture;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public float getPrix_voiture() {
        return prix_voiture;
    }

    public void setPrix_voiture(float prix_voiture) {
        this.prix_voiture = prix_voiture;
    }

    public static void main(String[] args) {
            FactureModel factureModel = new FactureModel();

        String dateAujourdhuiString = LocalDate.now().toString();

        // Afficher la date d'aujourd'hui en tant que String
        System.out.println("Date d'aujourd'hui : " + dateAujourdhuiString);

        }
    }


