package Controler;

import Model.VoitureModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class VoitureController {

    private VoitureModel voiture;

    public VoitureController() throws SQLException, ClassNotFoundException {
        this.voiture = new VoitureModel();
    }

    public String ajouterNouvelleVoiture(String id_plaque, String nom_modele, String type, String couleur, String moteur,
                                          int nb_place, int capacite_valise, int nb_porte, String transmission, int capa_essence, int annee, int kilometrage_actuel,
                                          float prix, String lieu_prise_en_charge, int limite_km, String marque) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        String phrase = validerDonnees( id_plaque, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence, annee, kilometrage_actuel,
                prix, limite_km);
        if (!phrase.equals("Toutes les données sont valides")) {
            return phrase;
        }

        VoitureModel newvoiture = new VoitureModel(id_plaque, nom_modele, type, couleur, moteur, nb_place, capacite_valise, nb_porte, transmission, capa_essence,
                annee, kilometrage_actuel, prix, lieu_prise_en_charge, limite_km, marque);


        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newvoiture.ajouterVoiture(newvoiture);
        return phrase; // Succès
    }

    private String validerDonnees(String id_plaque, String moteur,int nb_place,int capacite_valise,int nb_porte, String transmission,
                                   int capa_essence, int annee, int kilometrage_actuel, float prix, int limite_km) throws SQLException, ClassNotFoundException {

        if (!voiture.UnicitePlaque(id_plaque)) {
            return "La plaque est déjà utilisée.";
        } else if (!verifierTypeMoteur(moteur)) {
            return "Le type de moteur est incorrect.";
        } else if (nb_place <= 0) {
            return "Le nombre de places doit être supérieur à zéro.";
        } else if (capacite_valise <= 0) {
            return "La capacité de la valise doit être supérieure à zéro.";
        } else if (nb_porte <= 0) {
            return "Le nombre de portes doit être supérieur à zéro et impair";
        } else if (!verifTransmission(transmission)) {
            return "La transmission doit être soit automatique (1) soit manuelle (0).";
        } else if (capa_essence <= 0) {
            return "La capacité du réservoir d'essence doit être supérieure à zéro.";
        } else if (annee <= 1900 || annee > 2024) {
            return "L'année n'est pas correcte";
        } else if (kilometrage_actuel < 0) {
            return "Le kilométrage actuel doit être supérieur ou égal à zéro.";
        } else if (prix <= 0) {
            return "Le prix doit être supérieur à zéro.";
        } else if (limite_km < 0 || limite_km < kilometrage_actuel) {
            return "La limite de kilométrage doit être supérieure ou égale à zéro.";
        } else {
            return "Toutes les données sont valides";
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
        boolean success = voiture.supprimerVoiture();
        return true;
    }
    
    public String ChangeLocEstLouee(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , true);
        voiture.setLouee(true);
        return PhraseRetour;
    }

    public String ChangeLocEstPasLouee(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"louee" , false);
        voiture.setLouee(false);
        return PhraseRetour;
    }

    public String ChangeDate_debut_fin_loc(VoitureModel voiture, String date_debut_loc, String date_fin_loc) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"date_debut_loc" , date_debut_loc);
        String vartemp = voiture.MajPartielBdd(voiture.getId_plaque(),"date_fin_loc" , date_fin_loc);
        voiture.setDate_debut_loc(date_debut_loc);
        voiture.setDate_fin_loc(date_fin_loc);
        return PhraseRetour;

    }

    public String ChangeKilometrage_actuel(VoitureModel voiture, int kilometrage_actuel) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"kilometrage_actuel" , kilometrage_actuel);
        voiture.setKilometrage_actuel(kilometrage_actuel);
        return PhraseRetour;
    }

    public String ChangePrix(VoitureModel voiture, float prix) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"prix" , prix);
        voiture.setPrix(prix);
        return PhraseRetour;
    }

    public String ChangeLieuPriseEnCharge(VoitureModel voiture, String lieu_prise_en_charge) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"lieu_prise_en_charge" , lieu_prise_en_charge);
        voiture.setLieuPriseEnCharge(lieu_prise_en_charge);
        return PhraseRetour;
    }

    public String ChangeLimite_km(VoitureModel voiture, int limite_km) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"limite_km" , limite_km);
        voiture.setLimite_km(limite_km);
        return PhraseRetour;
    }

    public String ChangeMarque(VoitureModel voiture, String marque) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"marque" , marque);
        voiture.setMarque(marque);
        return PhraseRetour;
    }

    public String ChangeNom_modele(VoitureModel voiture, String nom_modele) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"nom_modele" , nom_modele);
        voiture.setNom_modele(nom_modele);
        return PhraseRetour;
    }

    public String ChangeType(VoitureModel voiture, String type) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"type" , type);
        voiture.setType(type);
        return PhraseRetour;
    }

    public String ChangeTransmission(VoitureModel voiture, String transmission) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"transmission" , transmission);
        voiture.setTransmission(transmission);
        return PhraseRetour;
    }

    public String ChangeCouleur(VoitureModel voiture, String couleur) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"couleur" , couleur);
        voiture.setCouleur(couleur);
        return PhraseRetour;
    }

    public String ChangeCapacite_valise(VoitureModel voiture, int capacite_valise) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"capacite_valise" , capacite_valise);
        voiture.setCapacite_valise(capacite_valise);
        return PhraseRetour;
    }

    public String ChangeNb_place(VoitureModel voiture, int nb_place) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"nb_place" , nb_place);
        voiture.setNbPlace(nb_place);
        return PhraseRetour;
    }

    public String ChangeNb_porte(VoitureModel voiture, int nb_porte) throws SQLException, ClassNotFoundException {
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

    public String ChangeId_facture(VoitureModel voiture, int Id_facture) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"id_facture" , Id_facture);
        voiture.setId_facture(Id_facture);
        return PhraseRetour;
    }

    public String ChangeAvis(VoitureModel voiture, int avis) throws SQLException, ClassNotFoundException {
        String PhraseRetour = voiture.MajPartielBdd(voiture.getId_plaque(),"avis" , avis);
        voiture.setAvis(avis);
        return PhraseRetour;
    }

    public ArrayList<VoitureModel> recupListeVoitureNonLouee() throws ClassNotFoundException, SQLException {
        return voiture.recupListeVoitureNonLouee();
    }

    /*public ArrayList<VoitureModel> recupListeVoitureLouee() throws ClassNotFoundException {
        return voiture.recupListeVoitureLouee();
    }

    public ArrayList<VoitureModel> recupListeVoiture() throws ClassNotFoundException {
        return voiture.recupListeVoiture();
    }*/

}

