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
    private int prix_voiture;

    public FactureModel() {
    }


    public FactureModel CreerFacture(ClientModel client, VoitureModel voiture, int prix_voiture, String mail, String num_tel, String ville, String adresse, String num_vol, String nom, String prenom) throws SQLException, ClassNotFoundException {
        String PhraseFinale = "";
        Connexion connexion = new Connexion("location_voiture", "root", "");
        FactureModel facture = new FactureModel();
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Générer l'ID unique pour la facture
            int idFacture = generateUniqueIdFacture();

            // Exécuter la requête SQL pour insérer une nouvelle facture
            String query = "INSERT INTO facture (id_client, id_voiture, date_facture, lieu_facture, id_facture, prix_voiture)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, client.getId_client());
            statement.setString(2, voiture.getId_plaque());
            statement.setString(3, LocalDate.now().toString());
            statement.setString(4, "Paris, Beaugrenelle");
            statement.setInt(5, idFacture);
            statement.setFloat(6, prix_voiture);

            facture.id_facture = idFacture;
            facture.date_facture = LocalDate.now().toString();
            facture.lieu_facture = "Paris, Beaugrenelle";
            facture.prix_voiture = prix_voiture;
            facture.id_voiture = voiture.getId_plaque();
            facture.id_client = client.getId_client();
            client.setId_facture(idFacture);
            client.setId_vehicule_loue(voiture.getId_plaque());
            voiture.setId_facture(idFacture);

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            // Mettre à jour le champ id_facture dans la table client
            boolean success = updateClientIdFacture(client.getId_client(), idFacture);
            boolean success2 = updateVoitureIdFacture(voiture.getId_plaque(), idFacture);

            connexion.closeConnection();

            if (rowsInserted > 0) {
                System.out.println("La facture a été générée avec succès !");
                return facture;
            } else {
                System.out.println("Erreur lors de la création de la facture");
                return null;
            }
        } catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
                return null;
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        return null;
    }

    public boolean updateClientIdFacture(int clientId, int idFacture) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            String query = "UPDATE client SET id_facture = ? WHERE id_client = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, idFacture);
            statement.setInt(2, clientId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Champ id_facture mis à jour pour le client avec succès !");

                return true;
            } else {
                System.out.println("Erreur lors de la mise à jour du champ id_facture pour le client");
                return false;
            }
        }catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
                return false;
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        return false;
    }


    public boolean updateVoitureIdFacture(String id_plaque, int idFacture) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            String query = "UPDATE voiture SET id_facture = ? WHERE id_plaque = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, idFacture);
            statement.setString(2, id_plaque);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Champ id_facture mis à jour pour la voiture avec succès !");
                return true;
            } else {
                System.out.println("Erreur lors de la mise à jour du champ id_facture pour la voiture");
                return false;
            }
        }catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
                return false;
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            } finally {
                connexion.closeConnection();
            }
        }
        return false;
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

                if (newFactureId < 100000) {
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


    public FactureModel getFacture(int idFacture) throws SQLException, ClassNotFoundException {
        FactureModel facture = null;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            String query = "SELECT * FROM facture WHERE id_facture = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, idFacture);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                facture = new FactureModel();
                facture.setId_facture(resultSet.getInt("id_facture"));
                facture.setId_client(resultSet.getInt("id_client"));
                facture.setId_voiture(resultSet.getString("id_voiture"));
                facture.setDate_facture(resultSet.getString("date_facture"));
                facture.setLieu_facture(resultSet.getString("lieu_facture"));
                facture.setPrix_voiture(resultSet.getInt("prix_voiture"));
            }
        } finally {
            connexion.closeConnection();
        }
        return facture;
    }

    public boolean supprimerFacture(int id_facture) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour supprimer la facture avec l'ID spécifié
            String query = "DELETE FROM facture WHERE id_facture = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, id_facture);

            int rowsDeleted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsDeleted > 0) {
                System.out.println("La facture a été supprimée avec succès !");
                return true;
            } else {
                System.out.println("Aucune facture trouvée avec l'ID spécifié.");
                return false;
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
            return false;
        }
    }


    public int getId_client() {
        return id_client;
    }

    public String MajPartielBdd(String id_plaque, String champ, Object Value) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);


            // Exécuter la requête SQL pour mettre à jour le champ spécifié
            String query = "UPDATE voiture SET " + champ + " = ? WHERE id_plaque = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            System.out.println("test2");
            // Selon le type de valeur, définir le bon type de paramètre
            if (Value instanceof String) {
                statement.setString(1, (String) Value);
            } else if (Value instanceof Integer) {
                statement.setInt(1, (int) Value);
            } else if (Value instanceof Float) {
                statement.setFloat(1, (float) Value);
            } else if (Value instanceof Boolean) {
                statement.setBoolean(1, (Boolean) Value);
            } // Ajoutez d'autres cas selon les types de données que vous souhaitez gérer

            System.out.println("test3");
            statement.setString(2, id_plaque);

            int rowsUpdated = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsUpdated > 0) {
                System.out.println("Le champ " + champ + " a été mis à jour avec succès !");
                return "Mise à jour réussie !";
            } else {
                System.out.println("Aucun champ mis à jour.");
                return "Aucun champ mis à jour.";
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
        return "Echec de la mise à jour";
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

    public void setPrix_voiture(int prix_voiture) {
        this.prix_voiture = prix_voiture;
    }
}


