package Controler;

import Model.Connexion;
import Model.VoitureModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoitureController {

    private VoitureModel voiture;

    public VoitureController() throws SQLException, ClassNotFoundException {
        this.voiture = new VoitureModel();
    }

    public VoitureModel ajouterNouvelleVoiture(String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                          int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                          float prix, String lieu_prise_en_charge, int limite_km, String marque) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        if (!validerDonnees( id_plaque, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km)) {
            return null;
        }

        VoitureModel newvoiture = new VoitureModel(id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km, marque);


        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newvoiture.ajouterVoiture(newvoiture);
        return newvoiture; // Succès
    }

    private boolean validerDonnees(String id_plaque, String moteur,int nb_place,int capacite_valise,int nb_porte, String transmission,
                                   int capa_essence, int annee, int kilometrage_actuel, float prix, int limite_km) {

        if (!voiture.UnicitePlaque(id_plaque)) {
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
        } else if (nb_porte <= 0 || nb_porte % 2 == 0) {
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
    
    public String ChangeLocEstLouee(VoitureModel voiture) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , true);
        voiture.setLouee(true);
        return PhraseRetour;
    }

    public String ChangeLocEstPasLouee(VoitureModel voiture) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , false);
        voiture.setLouee(false);
        return PhraseRetour;
    }

    public String ChangeDate_debut_fin_loc(VoitureModel voiture, String date_debut_loc, String date_fin_loc) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"date_debut_loc" , date_debut_loc);
        String vartemp = voiture.MajPartielBdd(voiture.getId_plaque(),"date_fin_loc" , date_fin_loc);
        voiture.setDate_debut_loc(date_debut_loc);
        voiture.setDate_fin_loc(date_fin_loc);
        return PhraseRetour;

    }

    public String ChangeKilometrage_actuel(VoitureModel voiture, int kilometrage_actuel) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"kilometrage_actuel" , kilometrage_actuel);
        voiture.setKilometrage_actuel(kilometrage_actuel);
        return PhraseRetour;
    }

    public String ChangePrix(VoitureModel voiture, float prix) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"prix" , prix);
        voiture.setPrix(prix);
        return PhraseRetour;
    }

    public String ChangeLieuPriseEnCharge(VoitureModel voiture, String lieu_prise_en_charge) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"lieu_prise_en_charge" , lieu_prise_en_charge);
        voiture.setLieuPriseEnCharge(lieu_prise_en_charge);
        return PhraseRetour;
    }

    public String ChangeLimite_km(VoitureModel voiture, int limite_km) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"limite_km" , limite_km);
        voiture.setLimite_km(limite_km);
        return PhraseRetour;
    }

    public String ChangeMarque(VoitureModel voiture, String marque) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"marque" , marque);
        voiture.setMarque(marque);
        return PhraseRetour;
    }

    public String ChangeNom_modele(VoitureModel voiture, String nom_modele) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"nom_modele" , nom_modele);
        voiture.setNom_modele(nom_modele);
        return PhraseRetour;
    }

    public String ChangeType(VoitureModel voiture, String type) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"type" , type);
        voiture.setType(type);
        return PhraseRetour;
    }

    public String ChangeTransmission(VoitureModel voiture, String transmission) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"transmission" , transmission);
        voiture.setTransmission(transmission);
        return PhraseRetour;
    }

    public String ChangeCouleur(VoitureModel voiture, String couleur) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"couleur" , couleur);
        voiture.setCouleur(couleur);
        return PhraseRetour;
    }

    public String ChangeCapacite_valise(VoitureModel voiture, int capacite_valise) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"capacite_valise" , capacite_valise);
        voiture.setCapacite_valise(capacite_valise);
        return PhraseRetour;
    }

    public String ChangeNb_place(VoitureModel voiture, int nb_place) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"nb_place" , nb_place);
        voiture.setNbPlace(nb_place);
        return PhraseRetour;
    }

    public String ChangeNb_porte(VoitureModel voiture, int nb_porte) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"nb_porte" , nb_porte);
        voiture.setNbPorte(nb_porte);
        return PhraseRetour;
    }

    /*public VoitureModel modificationVoiture(VoitureModel voiture, Connexion connexion, String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                            int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                            float prix, String lieu_prise_en_charge, int limite_km, String marque) throws SQLException, ClassNotFoundException {

        if (!validerDonnees(connexion, "0", moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km)) {
            return null;
        }
        voiture.supprimerVoiture();
        VoitureModel voiture1 = this.ajouterNouvelleVoiture(connexion, id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km, marque);
        return voiture1;
    }*/

    public String ChangeId_facture(VoitureModel voiture, int Id_facture) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"id_facture" , Id_facture);
        voiture.setId_facture(Id_facture);
        return PhraseRetour;
    }

    public String ChangeAvis(VoitureModel voiture, int avis) {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"avis" , avis);
        voiture.setAvis(avis);
        return PhraseRetour;
    }

    public ArrayList<VoitureModel> recupListeVoitureNonLouee() throws ClassNotFoundException {
        return voiture.recupListeVoitureNonLouee();
    }

    /*public ArrayList<VoitureModel> recupListeVoitureLouee() throws ClassNotFoundException {
        return voiture.recupListeVoitureLouee();
    }

    public ArrayList<VoitureModel> recupListeVoiture() throws ClassNotFoundException {
        return voiture.recupListeVoiture();
    }*/

}

