package Controler;

import Model.ClientModel;
import Model.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class ClientController {

    private ClientModel client;

    public ClientController() throws SQLException, ClassNotFoundException {
        ClientModel client = new ClientModel();
        this.client = client;
    }


    public ClientModel ajouterNouveauClient( String prenom, String nom, String mot_de_passe, String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        if (!validerDonneesClient(prenom, nom, mot_de_passe, mail, date_naissance)) {
            return null;
        }

        ClientModel newclient = new ClientModel( prenom, nom, mot_de_passe, mail, date_naissance);


        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newclient.ajouterClient(newclient);
        return newclient; // Succès
    }

    private boolean validerDonneesClient( String prenom, String nom, String mot_de_passe, String mail, String date_naissance) {

        if (!client.UniciteMail(mail)) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Le mail est déjà utilisée.");
            return false;
        } else if (!EstMajeur(date_naissance)) {
            // methode de la vue pour afficher un message d'erreur
            System.out.println("Vous devez être majeur pour vous inscrire");
            return false;
        } else {
            System.out.println("Toutes les données sont valides.");
            return true;
        }
    }

    public static boolean EstMajeur(String dateNaissance) {
        // Convertir la date de naissance en objet LocalDate
        LocalDate dateNaissanceFormatted = LocalDate.parse(dateNaissance);

        // Calculer la période entre la date de naissance et la date actuelle
        Period difference = Period.between(dateNaissanceFormatted, LocalDate.now());

        // Vérifier si la personne a plus de 18 ans
        return difference.getYears() >= 18;
    }

    public boolean supprimerClient(ClientModel Client) {
        if (Client.supprimerClient()) {
            System.out.println("Le client a été supprimé avec succès !");
            return true;
        } else {
            System.out.println("Aucun client supprimé.");
            return false;
        }
    }

    public void ChangeFidelite(ClientModel Client) {
        Client.setFidelite(true);
    }

    public void ChangeId_vehicule_loue(ClientModel Client, String id_vehicule_loue) {
        Client.setId_vehicule_loue(false, id_vehicule_loue);
    }


    public void ChangeDate_debut_fin_loc(ClientModel Client, String date_debut_loc, String date_fin_loc) {
        Client.setDate_debut_loc(date_debut_loc);
        Client.setDate_fin_loc(date_fin_loc);
    }

    public ClientModel modificationClient( String prenom, String nom, String mot_de_passe, String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        if (!validerDonneesClient( prenom, nom, mot_de_passe, mail, date_naissance)) {
            return null;
        }
        client.supprimerClient();
        ClientModel Client1 = this.ajouterNouveauClient( prenom, nom, mot_de_passe, mail, date_naissance);
        return Client1;
    }


    public void verifierConnexionClient() {
        // TODO implement here
    }
}
