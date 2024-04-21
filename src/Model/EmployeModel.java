package Model;

import Controler.EmployeController;
import Controler.FactureController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class EmployeModel {

    private int id_employe;
    private String mdp;
    private String nom;
    private String prenom;
    private String mail;
    private String num_tel;
    public String Phrase_de_reponse;

    public EmployeModel() {
    }

    public EmployeModel( String mdp, String nom, String prenom, String mail, String num_tel) {
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.num_tel = num_tel;
    }

    // Méthode pour ajouter un employé à la base de données
    public Boolean ajouterEmploye(EmployeModel employe) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer un nouvel employé
            String query = "INSERT INTO employe (id_employe, mdp, nom, prenom, mail, num_tel)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, employe.id_employe);
            statement.setString(2, employe.mdp);
            statement.setString(3, employe.nom);
            statement.setString(4, employe.prenom);
            statement.setString(5, employe.mail);
            statement.setString(6, employe.num_tel);

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();
            connexion.closeConnection();
            if (rowsInserted > 0) {
                Phrase_de_reponse = "Le nouvel employé a été ajouté avec succès !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
                Phrase_de_reponse = "Aucun employé ajouté.";
                System.out.println(Phrase_de_reponse);
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

    // Méthode pour supprimer un employé de la base de données
    public boolean supprimerEmploye(EmployeModel employe) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour supprimer l'employé avec l'ID spécifié
            String query = "DELETE FROM employe WHERE id_employe = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, employe.id_employe);

            int rowsDeleted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsDeleted > 0) {
                Phrase_de_reponse = "L'employé a été supprimé avec succès !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
                Phrase_de_reponse = "Aucun employé trouvé avec l'ID spécifié.";
                System.out.println(Phrase_de_reponse);
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

    // Méthode pour vérifier l'authentification d'un employé
    public int verif_connexion_employe(int id_employe, String password) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier les identifiants
            String query = "SELECT * FROM employe WHERE id_employe = ? AND mdp = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, id_employe);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            // Si une ligne est retournée, cela signifie que les identifiants sont valides
            if (resultSet.next()) {
                Phrase_de_reponse = "Identifiants valides.";
                System.out.println(Phrase_de_reponse);
                connexion.closeConnection();
                return 3; // Tout est correct
            } else {
                // Vérifier si l'id_employe existe
                query = "SELECT * FROM employe WHERE id_employe = ?";
                statement = connexion.conn.prepareStatement(query);
                statement.setInt(1, id_employe);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Phrase_de_reponse = "Mot de passe incorrect.";
                    System.out.println(Phrase_de_reponse);
                    connexion.closeConnection();
                    return 1; // Mot de passe incorrect
                } else {
                    Phrase_de_reponse = "Numéro d'identification incorrect.";
                    System.out.println(Phrase_de_reponse);
                    connexion.closeConnection();
                    return 2; // Mail incorrect
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
        }
        Phrase_de_reponse = "Erreur de connexion à la base de données";
        System.out.println(Phrase_de_reponse);
        return -1; // Erreur de connexion à la base de données
    }

    // Méthode pour générer un identifiant unique pour un employé
    public int generateUniqueEmployeeId() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        int newEmployeeId;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Préparation de la requête SQL pour vérifier l'unicité de l'identifiant généré
            String query = "SELECT COUNT(*) FROM employe WHERE id_employe = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            do {
                // Génération d'un nombre aléatoire entre 0 et 999999
                newEmployeeId = random.nextInt(1000000);

                // Vérification de l'unicité de l'identifiant
                statement.setInt(1, newEmployeeId);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                resultSet.close();

                if (count == 0) {
                    // L'identifiant est unique, on peut le retourner
                    connexion.closeConnection();
                    return newEmployeeId;
                }

            } while (true);
        } catch (SQLException e) {
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a ete annulee en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
            return -1; // Exemple de valeur par défaut
        }
    }

    // Méthode pour vérifier l'unicité de l'email d'un employé
    public boolean UniciteMail(String mail) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");

        // Requête SQL pour vérifier l'unicité de l'email
        String query = "SELECT COUNT(*) FROM Employe WHERE mail = ?";
        try {
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, mail);  // Remplacement du paramètre par la valeur réelle
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                connexion.closeConnection();
                Phrase_de_reponse = "Le mail est valide";
                return true; // Retourne vrai si l'email est unique
            }
        } catch (SQLException e) {
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a ete annulee en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        Phrase_de_reponse = "Le mail est déjà utilisé";
        System.out.println(Phrase_de_reponse);
        // En cas d'erreur, considérer que l'email n'est pas unique
        return false;
    }


    public boolean UniciteNumeroTel(String numeroTel) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");

        // Requête SQL pour vérifier l'unicité du numéro de téléphone
        String query = "SELECT num_tel FROM Employe";
        try {
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Récupération du numéro de téléphone existant dans la base de données
                String numTelExist = resultSet.getString("num_tel");
                // Comparaison des 9 derniers caractères
                if (numTelExist.substring(numTelExist.length() - 9).equals(numeroTel.substring(numeroTel.length() - 9))) {
                    // Si les 9 derniers caractères correspondent, le numéro de téléphone n'est pas unique
                    connexion.closeConnection();
                    Phrase_de_reponse = "Ce numéro de tel est déja utilisé";
                    System.out.println(Phrase_de_reponse);
                    return false;
                }
            }
            // Si aucun numéro de téléphone correspondant n'est trouvé, alors le numéro est unique
            connexion.closeConnection();
            Phrase_de_reponse = "Le numéro de tel est valide";
            System.out.println(Phrase_de_reponse);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
            // En cas d'erreur, considérer que le numéro de téléphone n'est pas unique
            return false;
        }
    }


    public Boolean majPartielBdd(int id_employe, String champ, Object Value) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);


            // Exécuter la requête SQL pour mettre à jour le champ spécifié
            String query = "UPDATE employe SET "+champ+" = ? WHERE id_employe = ?";
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
            }


            statement.setInt(2, id_employe);

            int rowsUpdated = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            connexion.closeConnection();
            if (rowsUpdated > 0) {
                Phrase_de_reponse = "Mise à jour réussie !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
                Phrase_de_reponse = "Aucun champ mis à jour.";
                System.out.println(Phrase_de_reponse);
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
        }
        Phrase_de_reponse = "Echec de la connexion";
        System.out.println(Phrase_de_reponse);
        return false;
    }




    // Méthode pour récupérer un employé par son ID
    public EmployeModel RecupEmployeById(int idEmploye) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Exécuter la requête SQL pour récupérer les informations de l'employé avec l'ID spécifié
            String query = "SELECT * FROM employe WHERE id_employe = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, idEmploye);
            ResultSet resultSet = statement.executeQuery();

            // Vérifier si un employé a été trouvé avec cet ID
            if (resultSet.next()) {
                EmployeModel employe = new EmployeModel();
                employe.setId_employe(resultSet.getInt("id_employe"));
                employe.setMdp(resultSet.getString("mdp"));
                employe.setNom(resultSet.getString("nom"));
                employe.setPrenom(resultSet.getString("prenom"));
                employe.setMail(resultSet.getString("mail"));
                employe.setNum_tel(resultSet.getString("num_tel"));

                return employe;
            } else {
                // Aucun employé trouvé avec cet ID
                Phrase_de_reponse = "Aucun employé trouvé avec l'ID spécifié : " + idEmploye;
                System.out.println(Phrase_de_reponse);
                return null;
            }
        } catch (SQLException e){
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a ete annulee en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        return null;
    }

    // Getters and setters
    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

}

