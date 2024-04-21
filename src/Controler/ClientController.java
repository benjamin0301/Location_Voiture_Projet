package Controler;

import Model.ClientModel;
import Model.VoitureModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class ClientController {

    private final ClientModel client;

    public String Phrase_de_reponse;

    public ClientController() throws SQLException, ClassNotFoundException {
        this.client = new ClientModel();
    }

    private boolean success;

    public ClientModel ajouterNouveauClient( String prenom, String nom, String mot_de_passe, String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        if (!validerDonneesClient( mail, date_naissance)) {
            return null;
        }

        ClientModel newclient = new ClientModel( prenom, nom, mot_de_passe, mail, date_naissance);
        int id_client = client.generateUniqueClientId();
        newclient.setId_client(id_client);

        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newclient.ajouterClient(newclient, id_client);
        return newclient; // Succès
    }

    private boolean validerDonneesClient( String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        if (!client.UniciteMail(mail)) {
            Phrase_de_reponse = client.Phrase_de_reponse;
            return false;
        } else if (!EstMajeur(date_naissance)) {
            Phrase_de_reponse = "Vous devez être majeur pour vous inscrire" ;
            return false;
        } else {
            Phrase_de_reponse = "Toutes les données sont valides";
            return true;
        }
    }

    private static boolean EstMajeur(String dateNaissance) {
        // Convertir la date de naissance en objet LocalDate
        LocalDate dateNaissanceFormatted = LocalDate.parse(dateNaissance);

        // Calculer la période entre la date de naissance et la date actuelle
        Period difference = Period.between(dateNaissanceFormatted, LocalDate.now());

        // Vérifier si la personne a plus de 18 ans
        return difference.getYears() >= 18;
    }

    public boolean supprimerClient(ClientModel Client) throws SQLException, ClassNotFoundException {
        if (Client.supprimerClient()) {
            Phrase_de_reponse = client.Phrase_de_reponse;
            return true;
        } else {
            Phrase_de_reponse = client.Phrase_de_reponse;
            return false;
        }
    }

    public Boolean ChangePrenom(ClientModel Client, String newprenom) throws SQLException, ClassNotFoundException {
        success = client.MajPartielBdd(Client.getId_client(), "prenom", newprenom);
        Phrase_de_reponse = client.Phrase_de_reponse;
        Client.setPrenom(newprenom);
        return success;
    }

    public Boolean ChangeNom(ClientModel Client, String newnom) throws SQLException, ClassNotFoundException {
        success = client.MajPartielBdd(Client.getId_client(), "nom", newnom);
        Phrase_de_reponse = client.Phrase_de_reponse;
        Client.setPrenom(newnom);
        return success;
    }

    public boolean ChangeMotDePasse(ClientModel Client, String newpassword) throws SQLException, ClassNotFoundException {
        success = client.MajPartielBdd(Client.getId_client(), "mot_de_passe", newpassword);
        Phrase_de_reponse = client.Phrase_de_reponse;
        Client.setPrenom(newpassword);
        return success;
    }

    public Boolean ChangeMail(ClientModel Client, String newmail) throws SQLException, ClassNotFoundException {
        if(client.UniciteMail(newmail)) {
            success = client.MajPartielBdd(Client.getId_client(), "mail", newmail);
            Client.setPrenom(newmail);
            Phrase_de_reponse = client.Phrase_de_reponse;
            return success;
        }else
            return false;
    }

    public Boolean ChangeFidelite(ClientModel Client) throws SQLException, ClassNotFoundException {
        success = client.MajPartielBdd(Client.getId_client(), "fidelite", true);
        Client.setFidelite(true);
        Phrase_de_reponse = client.Phrase_de_reponse;
        return success;
    }

    public Boolean ChangeDate_debut_fin_loc(ClientModel Client, String date_debut_loc, String date_fin_loc) throws SQLException, ClassNotFoundException {
        success = Client.MajPartielBdd(Client.getId_client(),"date_debut_loc" , date_debut_loc);
        success = Client.MajPartielBdd(Client.getId_client(),"date_fin_loc" , date_fin_loc);
        Client.setDate_debut_loc(date_debut_loc);
        Client.setDate_fin_loc(date_fin_loc);
        Phrase_de_reponse = client.Phrase_de_reponse;
        return success;
    }


    public ClientModel verifierConnexionClient(String login, String password) throws SQLException, ClassNotFoundException {
        ClientModel client2= client.verif_connexion_client(login, password);
        System.out.println("client2 = "+ client2.Resultat_connexion) ;
        return client2;
    }


}
