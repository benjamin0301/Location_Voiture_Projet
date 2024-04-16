package Controler;

import Model.VoitureModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class VoitureController {

    private VoitureModel voiture;

    private boolean success;

    public String Phrase_de_reponse;

    public VoitureController() throws SQLException, ClassNotFoundException {
        this.voiture = new VoitureModel();
    }

    public VoitureModel ajouterNouvelleVoiture(String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                          int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                          int prix, String lieu_prise_en_charge, int limite_km, String marque, String image_voiture) throws SQLException, ClassNotFoundException {

        if (!validerDonnees( id_plaque, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km)) {
            System.out.println(Phrase_de_reponse);
            return null;
        }
        VoitureModel newvoiture = new VoitureModel(id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km, marque, image_voiture);

        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newvoiture = newvoiture.ajouterVoiture(newvoiture);
        return newvoiture; // Succès
    }

    private boolean validerDonnees(String id_plaque, String moteur,int nb_place,int capacite_valise,int nb_porte, String transmission,
                                   int capa_essence, int annee, int kilometrage_actuel, int prix, int limite_km) throws SQLException, ClassNotFoundException {

        if (!voiture.UnicitePlaque(id_plaque)) {
            Phrase_de_reponse = "La plaque est déja utilisée";
            return false;
        } else if (!verifierTypeMoteur(moteur)) {
            Phrase_de_reponse = "Le moteur n'est pas valide";
            return false;
        } else if (nb_place <= 0) {
            Phrase_de_reponse = "Le nombre de places doit être supérieur à zéro.";
            return false;
        } else if (capacite_valise <= 0) {
            Phrase_de_reponse = "La capacité de la valise doit être supérieure à zéro.";
            return false;
        } else if (nb_porte <= 0) {
            Phrase_de_reponse = "Le nombre de portes doit être supérieur à zéro et impair";
            return false;
        } else if (!verifTransmission(transmission)) {
            Phrase_de_reponse = "La transmission doit être soit automatique (1) soit manuelle (0).";
            return false;
        } else if (capa_essence <= 0) {
            Phrase_de_reponse = "La capacité du réservoir d'essence doit être supérieure à zéro.";
            return false;
        } else if (annee <= 1900 || annee > 2024) {
            Phrase_de_reponse = "L'année n'est pas correcte";
            return false;
        } else if (kilometrage_actuel < 0) {
            Phrase_de_reponse = "Le kilométrage actuel doit être supérieur ou égal à zéro.";
            return false;
        } else if (prix <= 0) {
            Phrase_de_reponse = "Le prix doit être supérieur à zéro.";
            return false;
        } else if (limite_km < 0 || limite_km < kilometrage_actuel) {
            Phrase_de_reponse = "La limite de kilométrage doit être supérieure ou égale à zéro.";
            return false;
        } else {
            Phrase_de_reponse = "Toutes les données sont valides";
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

    public boolean supprimerVoiture(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        success = voiture.supprimerVoiture(voiture.getId_plaque());
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;
    }
    
    public Boolean ChangeLocEstLouee(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , true);
        voiture.setLouee(true);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;
    }

    public Boolean ChangeLocEstPasLouee(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , false);
        voiture.setLouee(false);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;
    }

    public Boolean ChangeDate_debut_fin_loc(VoitureModel voiture, String date_debut_loc, String date_fin_loc) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"date_debut_loc" , date_debut_loc);
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"date_fin_loc" , date_fin_loc);
        voiture.setDate_debut_loc(date_debut_loc);
        voiture.setDate_fin_loc(date_fin_loc);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;
    }

    public Boolean ChangeKilometrage_actuel(VoitureModel voiture, int kilometrage_actuel) throws SQLException, ClassNotFoundException {
        success= voiture.MajPartielBdd(voiture.getId_plaque(),"kilometrage_actuel" , kilometrage_actuel);
        voiture.setKilometrage_actuel(kilometrage_actuel);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangePrix(VoitureModel voiture, int prix) throws SQLException, ClassNotFoundException {
        success= voiture.MajPartielBdd(voiture.getId_plaque(),"prix" , prix);
        voiture.setPrix(prix);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeLieuPriseEnCharge(VoitureModel voiture, String lieu_prise_en_charge) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"lieu_prise_en_charge" , lieu_prise_en_charge);
        voiture.setLieuPriseEnCharge(lieu_prise_en_charge);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeLimite_km(VoitureModel voiture, int limite_km) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"limite_km" , limite_km);
        voiture.setLimite_km(limite_km);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeMarque(VoitureModel voiture, String marque) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"marque" , marque);
        voiture.setMarque(marque);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeNom_modele(VoitureModel voiture, String nom_modele) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"nom_modele" , nom_modele);
        voiture.setNom_modele(nom_modele);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeType(VoitureModel voiture, String type) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"type" , type);
        voiture.setType(type);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeTransmission(VoitureModel voiture, String transmission) throws SQLException, ClassNotFoundException {
       success = voiture.MajPartielBdd(voiture.getId_plaque(),"transmission" , transmission);
        voiture.setTransmission(transmission);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeCouleur(VoitureModel voiture, String couleur) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"couleur" , couleur);
        voiture.setCouleur(couleur);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeCapacite_valise(VoitureModel voiture, int capacite_valise) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"capacite_valise" , capacite_valise);
        voiture.setCapacite_valise(capacite_valise);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeNb_place(VoitureModel voiture, int nb_place) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"nb_place" , nb_place);
        voiture.setNbPlace(nb_place);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeNb_porte(VoitureModel voiture, int nb_porte) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"nb_porte" , nb_porte);
        voiture.setNbPorte(nb_porte);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeImage_voiture(VoitureModel voiture, String image_voiture) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(), "image_voiture", image_voiture);
        voiture.setImage_voiture(image_voiture);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }


    public Boolean ChangeId_facture(VoitureModel voiture, int Id_facture) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"id_facture" , Id_facture);
        voiture.setId_facture(Id_facture);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public Boolean ChangeAvis(VoitureModel voiture, int avis) throws SQLException, ClassNotFoundException {
        success = voiture.MajPartielBdd(voiture.getId_plaque(),"avis" , avis);
        voiture.setAvis(avis);
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return success;    }

    public ArrayList<VoitureModel> recupListeVoitureNonLouee() throws ClassNotFoundException, SQLException {
        ArrayList<VoitureModel> listeVoiture;
        listeVoiture = voiture.recupListeVoitureNonLouee();
        Phrase_de_reponse = voiture.Phrase_de_reponse;
        return listeVoiture;
    }

    /*public ArrayList<VoitureModel> recupListeVoitureLouee() throws ClassNotFoundException {
        return voiture.recupListeVoitureLouee();
    }

    public ArrayList<VoitureModel> recupListeVoiture() throws ClassNotFoundException {
        return voiture.recupListeVoiture();
    }*/

}

