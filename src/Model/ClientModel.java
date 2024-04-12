package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ClientModel {

    private String prenom;
    private String nom;
    private int id_client;
    private String mot_de_passe;
    private String mail;
    private boolean fidelite;
    private String date_naissance;
    private String id_vehicule_loue;

    private int id_facture;
    private String date_debut_loc;

    private String date_fin_loc;

    // Autres attributs et méthodes de la classe ClientModel

    public ClientModel() throws SQLException, ClassNotFoundException {
    }

    public ClientModel( String prenom, String nom, String motDePasse, String mail, String dateNaissance) throws SQLException, ClassNotFoundException {
        this.prenom = prenom;
        this.nom = nom;
        this.mot_de_passe = motDePasse;
        this.mail = mail;
        this.date_naissance = dateNaissance;
        this.fidelite = false;
        this.id_vehicule_loue = null;
        this.date_debut_loc = null;
        this.date_fin_loc = null;
        this.id_facture = 0;
    }

    public void ajouterClient(ClientModel client, int id_client) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer un nouveau client
            String query = "INSERT INTO client (prenom, nom, mot_de_passe, mail, date_naissance, id_client)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, client.prenom);
            statement.setString(2, client.nom);
            statement.setString(3, client.mot_de_passe);
            statement.setString(4, client.mail);
            statement.setString(5, client.date_naissance);
            statement.setInt(6, id_client);


            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();
            connexion.closeConnection();
            if (rowsInserted > 0) {
                System.out.println("Le nouveau client a été ajouté avec succès !");
            } else {
                System.out.println("Aucun client ajouté.");
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
    }

    public boolean supprimerClient() throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour supprimer le client avec l'ID spécifié
            String query = "DELETE FROM client WHERE id_client = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, this.id_client);

            int rowsDeleted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsDeleted > 0) {
                System.out.println("Le client a été supprimé avec succès !");
                return true;
            } else {
                System.out.println("Aucun client trouvé avec l'ID spécifié.");
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int idClient) {
        this.id_client = idClient;
    }

    public String getMotDePasse() {
        return mot_de_passe;
    }

    public void setMotDePasse(String motDePasse) {
        this.mot_de_passe = motDePasse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isFidelite() {
        return fidelite;
    }

    public void setFidelite(boolean fidelite) {
        this.fidelite = fidelite;
    }

    public String getDateNaissance() {
        return date_naissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.date_naissance = dateNaissance;
    }

    public String getId_vehicule_loue() {
        return id_vehicule_loue;
    }

    public void setId_vehicule_loue(String id_vehicule_loue) {
        this.id_vehicule_loue = id_vehicule_loue;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public String getDate_debut_loc() {
        return date_debut_loc;
    }

    public void setDate_debut_loc(String date_debut_loc) {
        this.date_debut_loc = date_debut_loc;
    }

    public String getDate_fin_loc() {
        return date_fin_loc;
    }

    public void setDate_fin_loc(String date_fin_loc) {
        this.date_fin_loc = date_fin_loc;
    }

    public int verif_connexion_client(String login, String password) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier les identifiants
            String query = "SELECT * FROM client WHERE mail = ? AND mot_de_passe = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            // Si une ligne est retournée, cela signifie que les identifiants sont valides

            if (resultSet.next()) {
                System.out.println("Identifiants valides.");
                connexion.closeConnection();
                return 0; // Tout est correct
            } else {
                // Vérifier si le mail existe
                query = "SELECT * FROM client WHERE mail = ?";
                statement = connexion.conn.prepareStatement(query);
                statement.setString(1, login);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Mot de passe incorrect.");
                    connexion.closeConnection();
                    return 1; // Mot de passe incorrect
                } else {
                    System.out.println("Mail incorrect.");
                    connexion.closeConnection();
                    return 2; // Mail incorrect
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
        }
        System.out.println("Erreur lors de la vérification des identifiants.");
        return -1; // Erreur de connexion à la base de données
    }

    public String MajPartielBdd(int id_client, String champ, Object Value) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour mettre à jour le champ spécifié
            String query = "UPDATE client SET "+champ+" = ? WHERE id_client = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

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

            statement.setInt(2, id_client);

            int rowsUpdated = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsUpdated > 0) {
                System.out.println("Mise à jour réussie !");
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
        }return "Echec de la mise à jour";
    }

    // Méthode pour générer un identifiant unique
    public int generateUniqueClientId() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        int newClientId;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier l'unicité de l'identifiant généré
            String query = "SELECT COUNT(*) FROM client WHERE id_client = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            do {
                // Génération d'un nombre aléatoire entre 0 et 999999
                newClientId = random.nextInt(1000000);

                // Formatage du nouvel identifiant pour avoir toujours 6 chiffres
                String formattedId = String.format("%06d", newClientId);

                // Vérification de l'unicité de l'identifiant
                statement.setInt(1, newClientId);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                resultSet.close();

                if (count == 0) {
                    // L'identifiant est unique, on peut le retourner
                    connexion.closeConnection();
                    return newClientId;
                }

            } while (true);
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
            // En cas d'erreur, retourner une valeur par défaut ou gérer l'exception selon les besoins
            return -1; // Exemple de valeur par défaut
        }
    }

    public boolean UniciteMail(String mail) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");

        // Requête SQL pour vérifier l'unicité de le mail
        String query = "SELECT COUNT(*) FROM Client WHERE mail = ?";
        try {
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, mail);  // Remplacement du paramètre par la valeur réelle
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                connexion.closeConnection();
                return count == 0; // Retourne vrai si le mail est unique
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
        }
        // En cas d'erreur, considérer que le mail n'est pas unique
        return false;
    }

    public ClientModel RecupClientById(int idClient) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Exécuter la requête SQL pour récupérer les informations du client avec l'ID spécifié
            String query = "SELECT * FROM client WHERE id_client = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, idClient);
            ResultSet resultSet = statement.executeQuery();


            // Vérifier si un client a été trouvé avec cet ID
            if (resultSet.next()) {
                ClientModel client = new ClientModel();
                client.setId_client(resultSet.getInt("id_client"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setNom(resultSet.getString("nom"));
                client.setMotDePasse(resultSet.getString("mot_de_passe"));
                client.setMail(resultSet.getString("mail"));
                client.setDateNaissance(resultSet.getString("date_naissance"));
                client.setFidelite(resultSet.getBoolean("fidelite"));
                client.setId_vehicule_loue(resultSet.getString("id_vehicule_loue"));
                client.setDate_debut_loc(resultSet.getString("date_debut_loc"));
                client.setDate_fin_loc(resultSet.getString("date_fin_loc"));
                client.setId_facture(resultSet.getInt("id_facture"));

                return client;
            } else {
                // Aucun client trouvé avec cet ID
                System.out.println("Aucun client trouvé avec l'ID spécifié : " + idClient);
                return null;
            }
        } finally {
            connexion.closeConnection();
        }
    }

    public int getId_facture() {
        return id_facture;
    }
}