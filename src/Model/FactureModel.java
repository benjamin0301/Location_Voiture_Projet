package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class FactureModel {
    private int id_client;
    private String id_voiture;
    private String date_facture;
    private String lieu_facture;
    private int id_facture;
    private float prix_voiture;
    private int chiffre = 0;

    public FactureModel() {}

    public String CreerFacture(ClientModel client, VoitureModel voiture, float prix_voiture) {
        String PhraseFinale = "";

        return PhraseFinale;
    }






    // Méthode
    // pour générer un identifiant unique
    public int generateUniqueIdFacture() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        chiffre = 10;
        int newFactureId;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier l'unicité de l'identifiant généré
            String query = "SELECT COUNT(*) FROM facture WHERE id_facture = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            do {
                // Génération d'un nombre aléatoire entre 0 et 999999
                newFactureId = random.nextInt(1000000);

                String formattedId = String.format("%06d", newFactureId);

                int formattedIdInt = Integer.parseInt(formattedId);

                System.out.println(formattedIdInt);

                // Vérification de l'unicité de l'identifiant
                statement.setInt(1, formattedIdInt);
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

            System.out.println("20 identifiants uniques de facture : ");
            for (int i = 0; i < 20; i++) {
                try {
                    int uniqueId = factureModel.generateUniqueIdFacture();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


