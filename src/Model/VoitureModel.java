package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoitureModel {
    Connexion conn;
    private String id_plaque;  // plaque d'immatriculation
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
    private float prix;
    private int id_facture;
    private boolean louee; //0 pour non louée, 1 pour louée
    private String lieu_prise_en_charge;

    public VoitureModel(Connexion conn, String id, String nom_modele, String type, String couleur, String moteur, int nb_place,
                        int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                        float prix, String lieu_prise_en_charge, int limite_km) {
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
        this.conn = conn;
        this.limite_km = limite_km;
    }

    public String getId_plaque() {
        return id_plaque;
    }

    public void setId_plaque(String id) {
        this.id_plaque = id;
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

    public void setnom_modele(String nom_modele) {
        this.nom_modele = nom_modele;
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

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public int getNbPlace() {
        return nb_place;
    }

    public void setNbPlace(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getCapaciteValise() {
        return capacite_valise;
    }

    public void setCapaciteValise(int capacite_valise) {
        this.capacite_valise = capacite_valise;
    }

    public int getNbPorte() {
        return nb_porte;
    }

    public void setNbPorte(int nb_porte) {
        this.nb_porte = nb_porte;
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

    public void setCapaEssence(int capa_essence) {
        this.capa_essence = capa_essence;
    }

    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public int getkilometrage_actuel () {
        return kilometrage_actuel;
    }

    public void setkilometrage_actuel ( int kilometrage_actuel){
        this.kilometrage_actuel = kilometrage_actuel;
    }

    public float getPrix () {
        return prix;
    }

    public void setPrix ( float prix){
        this.prix = prix;
    }

    public boolean isLouee () {
        return louee;
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

    public void chargerInfosDepuisBDD(String voitureId) {
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
    }
    public void afficherInfos() {
        System.out.println("ID : " + id_plaque);
        System.out.println("nom_modele : " + nom_modele);
        System.out.println("Type : " + type);
        System.out.println("Couleur : " + couleur);
        System.out.println("Moteur : " + moteur);
        System.out.println("nom_modelebre de places : " + nb_place);
        System.out.println("Capacité de la valise : " + capacite_valise + " litres");
        System.out.println("nom_modelebre de portes : " + nb_porte);
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

    public void ajouterVoiture(VoitureModel voiture) {
        try {
            // Désactiver le mode d'auto-commit
            conn.conn.setAutoCommit(false);

            // Exécuter la requête SQL pour insérer une nouvelle voiture
            String query = "INSERT INTO voiture (id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte," +
                    " transmission, capa_essence, annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.conn.prepareStatement(query);
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

            int rowsInserted = statement.executeUpdate();

            // Valider la transaction
            conn.conn.commit();

            if (rowsInserted > 0) {
                System.out.println("La nouvelle voiture a été ajoutée avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout de la nouvelle voiture.");
            }
        } catch (SQLException e) {
            // En cas d'erreur, annuler la transaction
            try {
                conn.conn.rollback();
                System.out.println("La transaction a été annulée en raison d'une erreur : " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Rétablir le mode d'auto-commit par défaut
                conn.conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getNom_modele() { return nom_modele; }
}