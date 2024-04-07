package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientModel {

    private String prenom;
    private String nom;
    private int id_client;
    private String mot_de_passe;
    private String mail;
    private boolean fidelite;
    private String date_naissance;
    private long numero_cb;
    private int cvc_cb;
    private int expiration_mois_cb;
    private int expiration_annee_cb;
    private int id_vehicule_loue;
    private Connexion connexion;

    // Autres attributs et méthodes de la classe ClientModel

    public ClientModel(Connexion connexion) {
        this.connexion = connexion;
    }

    public ClientModel(Connexion connexion, String prenom, String nom, String motDePasse, String mail, boolean fidelite, String dateNaissance, long numeroCb, int cvcCb, int expirationMoisCb, int expirationAnneeCb, int idVehiculeLoue, int idClient) {
        this.connexion = connexion;
        this.prenom = prenom;
        this.nom = nom;
        this.mot_de_passe = motDePasse;
        this.mail = mail;
        this.fidelite = fidelite;
        this.date_naissance = dateNaissance;
        this.numero_cb = numeroCb;
        this.cvc_cb = cvcCb;
        this.expiration_mois_cb = expirationMoisCb;
        this.expiration_annee_cb = expirationAnneeCb;
        this.id_vehicule_loue = idVehiculeLoue;
        this.id_client = idClient;
    }

    public void ajouterClient(ClientModel client) {
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer un nouveau client
            String query = "INSERT INTO client (prenom, nom, mot_de_passe, mail, fidelite, date_naissance, numero_cb, cvc_cb, expiration_mois_cb, expiration_annee_cb, id_vehicule_loue, id_client)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, client.prenom);
            statement.setString(2, client.nom);
            statement.setString(3, client.mot_de_passe);
            statement.setString(4, client.mail);
            statement.setBoolean(5, client.fidelite);
            statement.setString(6, client.date_naissance);
            statement.setLong(7, client.numero_cb);
            statement.setInt(8, client.cvc_cb);
            statement.setInt(9, client.expiration_mois_cb);
            statement.setInt(10, client.expiration_annee_cb);
            statement.setInt(11, client.id_vehicule_loue);
            statement.setInt(12, client.id_client);

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean supprimerClient() {
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
            } catch (SQLException ex) {
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

    public long getNumeroCb() {
        return numero_cb;
    }

    public void setNumeroCb(long numeroCb) {
        this.numero_cb = numeroCb;
    }

    public int getCvcCb() {
        return cvc_cb;
    }

    public void setCvcCb(int cvcCb) {
        this.cvc_cb = cvcCb;
    }

    public int getExpirationMoisCb() {
        return expiration_mois_cb;
    }

    public void setExpirationMoisCb(int expirationMoisCb) {
        this.expiration_mois_cb = expirationMoisCb;
    }

    public int getExpirationAnneeCb() {
        return expiration_annee_cb;
    }

    public void setExpirationAnneeCb(int expirationAnneeCb) {
        this.expiration_annee_cb = expirationAnneeCb;
    }

    public int verif_connexion_client(String login, String password) {
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
                return 0; // Tout est correct
            } else {
                // Vérifier si le mail existe
                query = "SELECT * FROM client WHERE mail = ?";
                statement = connexion.conn.prepareStatement(query);
                statement.setString(1, login);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Mot de passe incorrect.");
                    return 1; // Mot de passe incorrect
                } else {
                    System.out.println("Mail incorrect.");
                    return 2; // Mail incorrect
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Erreur lors de la vérification des identifiants.");
        return -1; // Erreur de connexion à la base de données
    }



    // Méthode pour générer un identifiant unique
    public int generateUniqueClientId() {
        Random random = new Random();
        int newClientId;

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
                    return newClientId;
                }

            } while (true);

        } catch (SQLException e) {
            e.printStackTrace();
            // En cas d'erreur, retourner une valeur par défaut ou gérer l'exception selon les besoins
            return -1; // Exemple de valeur par défaut
        }
    }

}