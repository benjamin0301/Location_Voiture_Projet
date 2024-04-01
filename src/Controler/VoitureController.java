package Controler;

import Model.Connexion;
import Model.VoitureModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoitureController {

    public VoitureModel ajouterNouvelleVoiture(Connexion connexion, String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                          int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                          float prix, String lieu_prise_en_charge, int limite_km) {

        // Valider les données saisies par l'utilisateur
        if (!validerDonnees(connexion, id_plaque, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km)) {
            return null;
        }

        VoitureModel newvoiture = new VoitureModel(connexion, id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km );


        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newvoiture.ajouterVoiture(newvoiture);
        return newvoiture; // Succès
    }

    private boolean validerDonnees(Connexion connexion, String id_plaque, String moteur,int nb_place,int capacite_valise,int nb_porte, String transmission,
                                   int capa_essence, int annee, int kilometrage_actuel, float prix, int limite_km) {

        if (!UnicitePlaque(connexion,id_plaque)) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("La plaque est déjà utilisée.");
            return false;
        } else if (!verifierTypeMoteur(moteur)) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le type de moteur est incorrect.");
            return false;
        } else if (nb_place <= 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le nombre de places doit être supérieur à zéro.");
            return false;
        } else if (capacite_valise <= 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("La capacité de la valise doit être supérieure à zéro.");
            return false;
        } else if (nb_porte <= 0 || nb_porte % 2 != 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le nombre de portes doit être supérieur à zéro et impair");
            return false;
        } else if (!verifTransmission(transmission)) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("La transmission doit être soit automatique (1) soit manuelle (0).");
            return false;
        } else if (capa_essence <= 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("La capacité du réservoir d'essence doit être supérieure à zéro.");
            return false;
        } else if (annee <= 1900 || annee > 2024) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("L'année n'est pas correcte");
            return false;
        } else if (kilometrage_actuel < 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le kilométrage actuel doit être supérieur ou égal à zéro.");
            return false;
        } else if (prix <= 0) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le prix doit être supérieur à zéro.");
            return false;
        } else if (limite_km < 0 || limite_km < kilometrage_actuel) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("La limite de kilométrage doit être supérieure ou égale à zéro.");
            return false;
        } else {
            System.out.println("Toutes les données sont valides.");
            return true;
        }
    }


    private boolean UnicitePlaque(Connexion connexion, String idPlaque) {
        // Requête SQL pour vérifier l'unicité de la plaque
        String query = "SELECT COUNT(*) FROM voiture WHERE id_plaque = ?";
        try {
            PreparedStatement statement = connexion.conn.prepareStatement(query);
            statement.setString(1, idPlaque);  // Remplacement du paramètre par la valeur réelle
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 0; // Retourne vrai si la plaque est unique
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // En cas d'erreur, considérer que la plaque n'est pas unique
        return false;
    }


    private boolean verifierTypeMoteur(String moteur) {
        // Conversion de la valeur en minuscules et suppression des accents
        moteur = moteur.toLowerCase().replaceAll("[éèê]", "e");
        // Vérification avec le switch
        return switch (moteur) {
            case "essence" -> true;
            case "diesel" -> true;
            case "hybride" -> true;
            case "electrique" -> true;
            default -> false;
        };
    }

    private boolean verifTransmission(String transmission) {
        transmission = transmission.toLowerCase().replaceAll("[éèê]", "e").replaceAll("[à]", "a").replaceAll("[ù]", "u");
        return switch (transmission) {
            case "manuelle" -> true;
            case "automatique" -> true;
            default -> false;
        };
    }

    public boolean supprimerVoiture(VoitureModel voiture) {
        boolean success = voiture.supprimerVoiture();
        return true;
    }
    
    public void ChangeLocEstLouee(VoitureModel voiture) {
        voiture.setLouee(true);
    }

    public void ChangeLocEstPasLouee(VoitureModel voiture) {
        voiture.setLouee(false);
    }

    public void ChangeDate_debut_fin_loc(VoitureModel voiture, String date_debut_loc, String date_fin_loc) {
        voiture.setDate_debut_loc(date_debut_loc);
        voiture.setDate_fin_loc(date_fin_loc);
    }

    public VoitureModel modificationVoiture(VoitureModel voiture, Connexion connexion, String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                            int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                            float prix, String lieu_prise_en_charge, int limite_km) {

        if (!validerDonnees(connexion, "0", moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km)) {
            return null;
        }
        voiture.supprimerVoiture();
        VoitureModel voiture1 = this.ajouterNouvelleVoiture(connexion, id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km);
        return voiture1;
    }

    public void ChangeId_facture(VoitureModel voiture, int Id_facture) {
        voiture.setId_facture(Id_facture);
    }

    public void ChangeAvis(VoitureModel voiture, int avis) {
        voiture.setAvis(avis);
    }
}

