package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VoitureModel {
    private  String id_plaque;  // plaque d'immatriculation
    private String nom_modele;
    private int avis; // de 1 à 5
    private String type; // berline, citadine, break, monospace, SUV, coupé, cabriolet, utilitaire
    private String couleur;
    private String moteur; // 0 = essence,  1 = diesel, 2 = hybride, 3 = électrique
    private int nb_place;
    private int capacite_valise;
    private int nb_porte;
    private String transmission; //0 pour manuelle, 1 pour automatique
    private int capa_essence;
    private int annee;
    private String date_debut_loc; //format : AAAA-MM-JJ
    private String date_fin_loc; //format : AAAA-MM-JJ
    private int kilometrage_actuel;
    private int limite_km;
    private int prix;
    private int id_facture;
    private boolean louee; //0 pour non louée, 1 pour louée
    private String lieu_prise_en_charge;
    private String marque;

    public VoitureModel() throws SQLException, ClassNotFoundException {
    }

    public VoitureModel( String id, String nom_modele, String type, String couleur, String moteur, int nb_place,
                        int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                        int prix, String lieu_prise_en_charge, int limite_km, String marque) throws SQLException, ClassNotFoundException {
        this.id_plaque = id;
        this.nom_modele = nom_modele;
        this.type = type;
        this.couleur = couleur;
        this.moteur = moteur;
        this.nb_place = nb_place;
        this.capacite_valise = capacite_valise;
        this.nb_porte = nb_porte;
        this.transmission = transmission;
        this.capa_essence = capa_essence;
        this.annee = annee;
        this.kilometrage_actuel = kilometrage_actuel;
        this.prix = prix;
        this.lieu_prise_en_charge = lieu_prise_en_charge;
        this.limite_km = limite_km;
        this.marque = marque;
    }

    public String getId_plaque() {
        return id_plaque;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
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

    public int getLimite_km() {
        return limite_km;
    }

    public void setLimite_km(int limite_km) {
        this.limite_km = limite_km;
    }
    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public String getnom_modele() {
        return nom_modele;
    }

    public String setNom_modele(String nom_modele) {
        return this.nom_modele = nom_modele;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMoteur() {
        return moteur;
    }

    public int getNbPlace() {
        return nb_place;
    }

    public void setNbPlace(int nb_place) {
        this.nb_place = nb_place;
    }
    public void setNbPorte(int nb_porte) {
        this.nb_porte = nb_porte;
    }

    public void setCapacite_valise(int capacite_valise) {
//        this.capacite_valise = capacite_valise;
    }
    public int getCapaciteValise() {
        return capacite_valise;
    }

    public int getNbPorte() {
        return nb_porte;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getCapaEssence() {
        return capa_essence;
    }

    public int getAnnee() {
        return annee;
    }

    public int getkilometrage_actuel () {
        return kilometrage_actuel;
    }

    public void setKilometrage_actuel ( int kilometrage_actuel){
        this.kilometrage_actuel = kilometrage_actuel;
    }

    public float getPrix () {
        return prix;
    }

    public void setPrix ( int prix){
        this.prix = prix;
    }
    public boolean isLouee () {
        return louee;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setLouee ( boolean louee){
        this.louee = louee;
    }

    public String getLieuPriseEnCharge () {
        return lieu_prise_en_charge;
    }

    public void setLieuPriseEnCharge (String lieu_prise_en_charge){
        this.lieu_prise_en_charge = lieu_prise_en_charge;
    }

    public void afficherInfos() {
        System.out.println("ID : " + id_plaque);
        System.out.println("nom_modele : " + nom_modele);
        System.out.println("Type : " + type);
        System.out.println("Couleur : " + couleur);
        System.out.println("Moteur : " + moteur);
        System.out.println("nom_modelebre de places : " + nb_place);
        System.out.println("Capacité de la valise : " + capacite_valise + " litres");
        System.out.println("nombre de portes : " + nb_porte);
        System.out.println("Transmission : " + transmission);
        System.out.println("Capacité du réservoir d'essence : " + capa_essence + " litres");
        System.out.println("Année : " + annee);
        System.out.println("Kilométrage actuel : " + kilometrage_actuel + " km");
        System.out.println("Prix : " + prix + " €");
        System.out.println("Louée : " + louee);
        System.out.println("Lieu de prise en charge : " + lieu_prise_en_charge);
        System.out.println("Date de début de location : " + date_debut_loc);
        System.out.println("Date de fin de location : " + date_fin_loc);
        System.out.println("Limite de kilométrage : " + limite_km + " km");
        System.out.println("ID de la facture : " + id_facture);
    }

    public VoitureModel ajouterVoiture(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer une nouvelle voiture
            String query = "INSERT INTO voiture (id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte," +
                    " transmission, capa_essence, annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km, marque)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, voiture.getId_plaque());
            statement.setString(2, voiture.getNom_modele());
            statement.setString(3, voiture.getType());
            statement.setString(4, voiture.getCouleur());
            statement.setString(5, voiture.getMoteur());
            statement.setInt(6, voiture.getNbPlace());
            statement.setInt(7, voiture.getCapaciteValise());
            statement.setInt(8, voiture.getNbPorte());
            statement.setString(9, voiture.getTransmission());
            statement.setInt(10, voiture.getCapaEssence());
            statement.setInt(11, voiture.getAnnee());
            statement.setInt(12, voiture.getkilometrage_actuel());
            statement.setFloat(13, voiture.getPrix());
            statement.setString(14, voiture.getLieuPriseEnCharge());
            statement.setInt(15, voiture.getLimite_km());
            statement.setString(16, voiture.getMarque());

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();
            connexion.closeConnection();
            if (rowsInserted > 0) {
                System.out.println("La nouvelle voiture a été ajoutée avec succès !");
                return voiture;
            }
            else return null;
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
            return null;
        }
    }

    public boolean supprimerVoiture() throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour supprimer la voiture avec l'ID spécifié
            String query = "DELETE FROM voiture WHERE id_plaque = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, this.id_plaque);

            int rowsDeleted = statement.executeUpdate();

            // Valider la transaction
            connexion.conn.commit();

            if (rowsDeleted > 0) {
                System.out.println("La voiture a été supprimée avec succès !");
                connexion.closeConnection();
                return true;
            } else {
                System.out.println("Aucune voiture trouvée avec l'ID spécifié.");
                connexion.closeConnection();
                return false;
            }
        } catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                connexion.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
                connexion.closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    /*public String ChargerInfosDepuisBDD(String voitureId) {
        // Model.Connexion à la base de données
        try {
            // Requête SQL pour récupérer les informations de la voiture avec l'ID spécifié
            String query = "SELECT * FROM voiture WHERE id_plaque = ?";
            PreparedStatement statement = Connexion.prepareStatement(conn,query);
            statement.setString(1, voitureId);

            // Exécution de la requête
            ResultSet resultSet = statement.executeQuery();

            // Traitement des résultats
            if (resultSet.next()) {
                // Récupération des valeurs de la base de données
                id_plaque = resultSet.getString("id_plaque");
                nom_modele = resultSet.getString("nom_modele");
                type = resultSet.getString("type");
                couleur = resultSet.getString("couleur");
                moteur = resultSet.getString("moteur");
                nb_place = resultSet.getInt("nb_place");
                capacite_valise = resultSet.getInt("capacite_valise");
                nb_porte = resultSet.getInt("nb_porte");
                transmission = resultSet.getString("transmission");
                capa_essence = resultSet.getInt("capa_essence");
                annee = resultSet.getInt("annee");
                kilometrage_actuel = resultSet.getInt("kilometrage_actuel");
                prix = resultSet.getFloat("prix");
                louee = resultSet.getBoolean("louee");
                lieu_prise_en_charge = resultSet.getString("lieu_prise_en_charge");
                date_debut_loc = resultSet.getString("date_debut_loc");
                date_fin_loc = resultSet.getString("date_fin_loc");
                limite_km = resultSet.getInt("limite_km");
                id_facture = resultSet.getInt("id_facture");
            } else {
                System.out.println("Aucune voiture trouvée avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public boolean UnicitePlaque(String idPlaque) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        // Requête SQL pour vérifier l'unicité de la plaque
        String query = "SELECT COUNT(*) FROM voiture WHERE id_plaque = ?";
        try {
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, idPlaque);  // Remplacement du paramètre par la valeur réelle
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                connexion.closeConnection();
                return count == 0; // Retourne vrai si la plaque est unique
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connexion.closeConnection();
        }
        // En cas d'erreur, considérer que la plaque n'est pas unique
        return false;
    }

    private String getNom_modele() { return nom_modele; }

    public ArrayList<VoitureModel> recupListeVoitureNonLouee() throws ClassNotFoundException, SQLException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        ArrayList<VoitureModel> listevoitures = new ArrayList<>();
        try {
            // Préparation de la requête SQL
            String query = "SELECT * FROM voiture WHERE louee = 0";
            Statement statement = connexion.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Parcours des résultats pour récupérer les voitures
            while (resultSet.next()) {
                // Création d'un objet Voiture pour chaque ligne de résultat
                VoitureModel voiture = new VoitureModel(
                        resultSet.getString("id_plaque"),
                        resultSet.getString("nom_modele"),
                        resultSet.getString("type"),
                        resultSet.getString("couleur"),
                        resultSet.getString("moteur"),
                        resultSet.getInt("nb_place"),
                        resultSet.getInt("capacite_valise"),
                        resultSet.getInt("nb_porte"),
                        resultSet.getString("transmission"),
                        resultSet.getInt("capa_essence"),
                        resultSet.getInt("annee"),
                        resultSet.getInt("kilometrage_actuel"),
                        resultSet.getInt("prix"),
                        resultSet.getString("lieu_prise_en_charge"),
                        resultSet.getInt("limite_km"),
                        resultSet.getString("marque")
                );
                voiture.setAvis(resultSet.getInt("avis"));
                // Ajout de la voiture à la liste
                listevoitures.add(voiture);
            }
            connexion.closeConnection();
            // Fermeture des ressources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            connexion.closeConnection();
            e.printStackTrace();
        }
        return listevoitures;
    }

    public ArrayList<VoitureModel> recupListeVoitureFiltrage(String filtre_1, String operateur_1, Object Value_1,
                                                             String filtre_2, String operateur_2, Object Value_2,
                                                             String filtre_3, String operateur_3, Object Value_3,
                                                             String filtre_4, String operateur_4, Object Value_4,
                                                             String filtre_5, String operateur_5, Object Value_5) throws ClassNotFoundException, SQLException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        ArrayList<VoitureModel> listevoitures = new ArrayList<>();
        try {
            // Préparation de la requête SQL
            String query = "SELECT * FROM voiture WHERE 1=1"; // Initialisation de la requête avec un prédicat vrai
            if (filtre_1 != null && operateur_1 != null && Value_1 != null) {
                query += " AND " + filtre_1 + " " + operateur_1 + " ?";
            }
            if (filtre_2 != null && operateur_2 != null && Value_2 != null) {
                query += " AND " + filtre_2 + " " + operateur_2 + " ?";
            }
            if (filtre_3 != null && operateur_3 != null && Value_3 != null) {
                query += " AND " + filtre_3 + " " + operateur_3 + " ?";
            }
            if (filtre_4 != null && operateur_4 != null && Value_4 != null) {
                query += " AND " + filtre_4 + " " + operateur_4 + " ?";
            }
            if (filtre_5 != null && operateur_5 != null && Value_5 != null) {
                query += " AND " + filtre_5 + " " + operateur_5 + " ?";
            }

            PreparedStatement statement = connexion.conn.prepareStatement(query);

            // Affectation des valeurs aux paramètres de la requête
            int parameterIndex = 1;
            if (filtre_1 != null && operateur_1 != null && Value_1 != null) {
                statement.setObject(parameterIndex++, Value_1);
            }
            if (filtre_2 != null && operateur_2 != null && Value_2 != null) {
                statement.setObject(parameterIndex++, Value_2);
            }
            if (filtre_3 != null && operateur_3 != null && Value_3 != null) {
                statement.setObject(parameterIndex++, Value_3);
            }
            if (filtre_4 != null && operateur_4 != null && Value_4 != null) {
                statement.setObject(parameterIndex++, Value_4);
            }
            if (filtre_5 != null && operateur_5 != null && Value_5 != null) {
                statement.setObject(parameterIndex, Value_5);
            }

            ResultSet resultSet = statement.executeQuery();

            // Parcours des résultats pour récupérer les voitures
            while (resultSet.next()) {
                // Création d'un objet Voiture pour chaque ligne de résultat
                VoitureModel voiture = new VoitureModel(
                        resultSet.getString("id_plaque"),
                        resultSet.getString("nom_modele"),
                        resultSet.getString("type"),
                        resultSet.getString("couleur"),
                        resultSet.getString("moteur"),
                        resultSet.getInt("nb_place"),
                        resultSet.getInt("capacite_valise"),
                        resultSet.getInt("nb_porte"),
                        resultSet.getString("transmission"),
                        resultSet.getInt("capa_essence"),
                        resultSet.getInt("annee"),
                        resultSet.getInt("kilometrage_actuel"),
                        resultSet.getInt("prix"),
                        resultSet.getString("lieu_prise_en_charge"),
                        resultSet.getInt("limite_km"),
                        resultSet.getString("marque")
                );
                voiture.setAvis(resultSet.getInt("avis"));
                // Ajout de la voiture à la liste
                listevoitures.add(voiture);
            }

            connexion.closeConnection();

        } catch (SQLException e) {
            connexion.closeConnection();
            e.printStackTrace();
        }
        return listevoitures;
    }




    public String MajPartielBdd(String id_plaque, String champ, Object Value) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", "");
        try {
            // Désactiver le mode d'auto-commit
            connexion.conn.setAutoCommit(false);


            // Exécuter la requête SQL pour mettre à jour le champ spécifié
            String query = "UPDATE voiture SET "+champ+" = ? WHERE id_plaque = ?";
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
                System.out.println("Le champ "+champ+" a été mis à jour avec succès !");
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

    public VoitureModel RecupVoitureByIdPlaque(String idPlaque) throws SQLException, ClassNotFoundException {
        Connexion connexion = new Connexion("location_voiture", "root", null);
        try {
            // Exécution de la requête SQL pour récupérer les informations de la voiture avec l'ID de plaque spécifié
            String query = "SELECT * FROM voiture WHERE id_plaque = ?";
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, idPlaque);
            ResultSet resultSet = statement.executeQuery();

            // Vérifier si une voiture a été trouvée avec cet ID de plaque
            if (resultSet.next()) {
                VoitureModel voiture = new VoitureModel(
                        resultSet.getString("id_plaque"),
                        resultSet.getString("nom_modele"),
                        resultSet.getString("type"),
                        resultSet.getString("couleur"),
                        resultSet.getString("moteur"),
                        resultSet.getInt("nb_place"),
                        resultSet.getInt("capacite_valise"),
                        resultSet.getInt("nb_porte"),
                        resultSet.getString("transmission"),
                        resultSet.getInt("capa_essence"),
                        resultSet.getInt("annee"),
                        resultSet.getInt("kilometrage_actuel"),
                        resultSet.getInt("prix"),
                        resultSet.getString("lieu_prise_en_charge"),
                        resultSet.getInt("limite_km"),
                        resultSet.getString("marque")
                );
                voiture.setAvis(resultSet.getInt("avis"));
                voiture.setDate_debut_loc(resultSet.getString("date_debut_loc"));
                voiture.setDate_fin_loc(resultSet.getString("date_fin_loc"));
                voiture.setLimite_km(resultSet.getInt("limite_km"));
                voiture.setId_facture(resultSet.getInt("id_facture"));
                voiture.setLouee(resultSet.getBoolean("louee"));
                return voiture;
            } else {
                // Aucune voiture trouvée avec cet ID de plaque
                System.out.println("Aucune voiture trouvée avec l'ID de plaque spécifié : " + idPlaque);
                return null;
            }
        } finally {
            connexion.closeConnection();
        }
    }
}
