package Model;

import com.pdfjet.*;
import com.pdfjet.Font;

import java.awt.*;
import java.io.*;
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
    public String Phrase_de_reponse;
    private String factureUrl;

    public FactureModel() {
    }


    public FactureModel CreerFacture(ClientModel client, VoitureModel voiture, int prix_voiture, String mail, String num_tel, String ville, String adresse, String num_vol, String nom, String prenom) throws Exception {
        String PhraseFinale = "";
        Connexion connexion = new Connexion("location_voiture", "root", "");
        FactureModel facture = new FactureModel();
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Générer l'ID unique pour la facture
            int idFacture = generateUniqueIdFacture();

            // Exécuter la requête SQL pour insérer une nouvelle facture
            String query = "INSERT INTO facture (id_client, id_voiture, date_facture, lieu_facture, id_facture, prix_voiture, factureUrl)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setInt(1, client.getId_client());
            statement.setString(2, voiture.getId_plaque());
            statement.setString(3, LocalDate.now().toString());
            statement.setString(4, "Paris, Beaugrenelle");
            statement.setInt(5, idFacture);
            statement.setFloat(6, prix_voiture);
            statement.setString(7, "facture" + idFacture + ".pdf");

            facture.id_facture = idFacture;
            facture.date_facture = LocalDate.now().toString();
            facture.lieu_facture = "Paris, Beaugrenelle";
            facture.prix_voiture = prix_voiture;
            facture.id_voiture = voiture.getId_plaque();
            facture.id_client = client.getId_client();
            facture.factureUrl = "facture" + idFacture + ".pdf";
            factureCreationPdf(facture, client, voiture);
            client.setId_facture(idFacture);
            client.setId_vehicule_loue(voiture.getId_plaque());
            client.setDate_debut_loc("2000-01-01");
            client.setDate_fin_loc("2000-01-01");


            // a changer car a faire dans le controller
            voiture.setId_facture(idFacture);
            voiture.setDate_debut_loc("2000-01-01");
            voiture.setDate_fin_loc("2000-01-01");

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            // Mettre à jour le champ id_facture dans la table client
            boolean success = updateClientIdFacture(client.getId_client(), idFacture);
            boolean success2 = updateVoitureIdFacture(voiture.getId_plaque(), idFacture);

            connexion.closeConnection();

            if (rowsInserted > 0) {
                Phrase_de_reponse = "La facture a été générée avec succès !";
                System.out.println(Phrase_de_reponse);
                return facture;
            } else {
                Phrase_de_reponse = "Erreur lors de la création de la facture";
                System.out.println(Phrase_de_reponse);
                return null;
            }
        } catch (SQLException e) {
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

    public void factureCreationPdf(FactureModel facture, ClientModel client, VoitureModel voiture) throws Exception {
        // Création d'un nouveau document PDF
        // Création d'un nouveau document PDF
        String lien = "Factures/facture" + facture.id_facture +".pdf";
        System.out.println("afficahge du lien " + lien);
        System.out.println("double facture = "+ facture.id_facture);
        PDF pdf = new PDF(new BufferedOutputStream(new FileOutputStream(lien)));
        try{



            // Ajout d'une page au document
            Page page = new Page(pdf, A4.PORTRAIT);

            // Coordonnées de départ pour le texte
            float x = 50f;
            float y = 50f;

            // Création d'un objet Font pour le titre
            Font titleFont = new Font(pdf, CoreFont.HELVETICA_BOLD);
            titleFont.setSize(18f);

            // Création d'un objet Font pour le texte
            Font textFont = new Font(pdf, CoreFont.HELVETICA);
            textFont.setSize(12f);

            // Section Informations générales
            TextLine titreGeneral = new TextLine(titleFont, "Confirmation de réservation");
            titreGeneral.setPosition(x, y);
            titreGeneral.drawOn(page);
            y += 50f;

            TextLine numeroReservationLabel = new TextLine(textFont, "Numéro de réservation:");
            numeroReservationLabel.setPosition(x, y);
            numeroReservationLabel.drawOn(page);

            TextLine numeroReservationValue = new TextLine(textFont, String.valueOf(facture.id_facture));
            numeroReservationValue.setPosition(x + 100f, y);
            numeroReservationValue.drawOn(page);
            y += 20f;

            TextLine nomClientLabel = new TextLine(textFont, "Informations du client");
            nomClientLabel.setPosition(x, y);
            nomClientLabel.drawOn(page);

            TextLine nomClientValue = new TextLine(textFont, client.getNom() + " " + client.getPrenom());
            nomClientValue.setPosition(x + 100f, y);
            nomClientValue.drawOn(page);
            y += 20f;

            // Section Informations de location
            TextLine titreLocation = new TextLine(titleFont, "Lieu de Prises en charge");
            titreLocation.setPosition(x, y);
            titreLocation.drawOn(page);
            y += 50f;

            TextLine stationDepartLabel = new TextLine(textFont, "Station de départ:");
            stationDepartLabel.setPosition(x, y);
            stationDepartLabel.drawOn(page);

            TextLine stationDepartValue = new TextLine(textFont, voiture.getLieuPriseEnCharge());
            stationDepartValue.setPosition(x + 100f, y);
            stationDepartValue.drawOn(page);
            y += 20f;

            TextLine stationRetourLabel = new TextLine(textFont, "Station de retour:");
            stationRetourLabel.setPosition(x, y);
            stationRetourLabel.drawOn(page);

            TextLine stationRetourValue = new TextLine(textFont, voiture.getLieuPriseEnCharge());
            stationRetourValue.setPosition(x + 100f, y);
            stationRetourValue.drawOn(page);
            y += 20f;

            TextLine dateDepartLabel = new TextLine(textFont, "Date de début de location");
            dateDepartLabel.setPosition(x, y);
            dateDepartLabel.drawOn(page);

            TextLine dateDepartValue = new TextLine(textFont, client.getDate_debut_loc());
            dateDepartValue.setPosition(x + 100f, y);
            dateDepartValue.drawOn(page);
            y += 20f;

            TextLine dateRetourLabel = new TextLine(textFont, "Date de retour:");
            dateRetourLabel.setPosition(x, y);
            dateRetourLabel.drawOn(page);

            TextLine dateRetourValue = new TextLine(textFont, client.getDate_fin_loc());
            dateRetourValue.setPosition(x + 100f, y);
            dateRetourValue.drawOn(page);
            y += 20f;

            TextLine categorieVehiculeLabel = new TextLine(textFont, "Catégorie du véhicule:");
            categorieVehiculeLabel.setPosition(x, y);
            categorieVehiculeLabel.drawOn(page);

            TextLine categorieVehiculeValue = new TextLine(textFont, voiture.getType());
            categorieVehiculeValue.setPosition(x + 100f, y);
            categorieVehiculeValue.drawOn(page);
            y += 20f;

            TextLine prixLocationLabel = new TextLine(textFont, "Prix de la location:");
            prixLocationLabel.setPosition(x, y);
            prixLocationLabel.drawOn(page);

            TextLine prixLocationValue = new TextLine(textFont, String.valueOf(facture.prix_voiture));
            prixLocationValue.setPosition(x + 100f, y);
            prixLocationValue.drawOn(page);
            y += 20f;

            TextLine dateFactureLabel = new TextLine(textFont, "Date de facture:");
            dateFactureLabel.setPosition(x, y);
            dateFactureLabel.drawOn(page);

            TextLine dateFactureValue = new TextLine(textFont, facture.date_facture);
            dateFactureValue.setPosition(x + 100f, y);
            dateFactureValue.drawOn(page);
            y += 20f;

            pdf.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Une erreur est survenue lors de la création du PDF : " + e.getMessage());
        } finally {
            if (pdf != null) {
                try {
                    pdf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Erreur lors de la fermeture du PDF : " + e.getMessage());
                }
            }
        }
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
                Phrase_de_reponse = "Champ id_facture mis à jour pour le client avec succès !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
                Phrase_de_reponse = "Erreur lors de la mise à jour du champ id_facture pour le client";
                System.out.println(Phrase_de_reponse);
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
               Phrase_de_reponse = "Champ id_facture mis à jour pour la voiture avec succès !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
               Phrase_de_reponse = "Erreur lors de la mise à jour du champ id_facture pour la voiture";
                System.out.println(Phrase_de_reponse);
                return false;
            }
        }catch (SQLException e) {
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

    // Méthode
    // pour générer un identifiant unique
    public int generateUniqueIdFacture() throws SQLException, ClassNotFoundException {
        Random random = new Random();
        int newFactureId;
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try{
            // Préparation de la requête SQL pour vérifier l'unicité de l'identifiant généré
            String query = "SELECT COUNT(*) FROM facture WHERE id_facture = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);

            do {
                // Génération d'un nombre aléatoire entre 0 et 999999
                newFactureId = random.nextInt(1000000);

                if (newFactureId < 100000) {
                    newFactureId = Integer.parseInt("0" + newFactureId);
                }

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
        } catch (SQLException e){
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a ete annulee en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }        }
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
                Phrase_de_reponse = "La facture a été supprimée avec succès !";
                System.out.println(Phrase_de_reponse);
                return true;
            } else {
                Phrase_de_reponse = "Aucune facture trouvée avec l'ID spécifié.";
                System.out.println(Phrase_de_reponse);
                return false;
            }
        } catch (SQLException e) {
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

    public boolean MajPartielBdd(String id_plaque, String champ, Object Value) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);


            // Exécuter la requête SQL pour mettre à jour le champ spécifié
            String query = "UPDATE voiture SET " + champ + " = ? WHERE id_plaque = ?";
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

            statement.setString(2, id_plaque);

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
                return false;
            }
        } catch (SQLException e) {
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                connexion.closeConnection();
                ex.printStackTrace();
            }
        }
        Phrase_de_reponse = "Echec de la mise à jour";
        System.out.println(Phrase_de_reponse);
        return false;
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


