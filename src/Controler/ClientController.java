package Controler;

import Model.ClientModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class ClientController {

    private final ClientModel client;

    private String Phrase;

    public ClientController() throws SQLException, ClassNotFoundException {
        this.client = new ClientModel();
    }

    public ClientModel ajouterNouveauClient( String prenom, String nom, String mot_de_passe, String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        // Valider les données saisies par l'utilisateur
        Phrase = validerDonneesClient( mail, date_naissance);
        if (!Phrase.equals("Toutes les données sont valides")) {
            return null;
        }

        ClientModel newclient = new ClientModel( prenom, nom, mot_de_passe, mail, date_naissance);
        int id_client = client.generateUniqueClientId();
        newclient.setId_client(id_client);

        // Si les données sont valides, passer au modèle pour les ajouter à la base de données
        newclient.ajouterClient(newclient, id_client);
        return newclient; // Succès
    }

    private String validerDonneesClient( String mail, String date_naissance) throws SQLException, ClassNotFoundException {

        if (!client.UniciteMail(mail)) {
            // methode de la vue pour afficher un message d'
            // erreur
            return "Le mail est déjà utilisée";
        } else if (!EstMajeur(date_naissance)) {
            // methode de la vue pour afficher un message d'erreur
            return "Vous devez être majeur pour vous inscrire";
        } else {
            return "Toutes les données sont valides";
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

    public boolean supprimerClient(ClientModel Client) throws SQLException, ClassNotFoundException {
        if (Client.supprimerClient()) {
            System.out.println("Le client a été supprimé avec succès !");
            return true;
        } else {
            System.out.println("Aucun client supprimé.");
            return false;
        }
    }

    public String ChangePrenom(ClientModel Client, String newprenom) throws SQLException, ClassNotFoundException {
        String PhraseRetour = client.MajPartielBdd(Client.getId_client(), "prenom", newprenom);
        Client.setPrenom(newprenom);
        return PhraseRetour;
    }

    public String ChangeNom(ClientModel Client, String newnom) throws SQLException, ClassNotFoundException {
        String PhraseRetour = client.MajPartielBdd(Client.getId_client(), "nom", newnom);
        Client.setPrenom(newnom);
        return PhraseRetour;
    }

    public String ChangeMotDePasse(ClientModel Client, String newpassword) throws SQLException, ClassNotFoundException {
        String PhraseRetour = client.MajPartielBdd(Client.getId_client(), "mot_de_passe", newpassword);
        Client.setPrenom(newpassword);
        return PhraseRetour;
    }

    public String ChangeMail(ClientModel Client, String newmail) throws SQLException, ClassNotFoundException {
        String PhraseRetour;
        if(client.UniciteMail(newmail)){
            PhraseRetour = client.MajPartielBdd(Client.getId_client(), "mail", newmail);
            Client.setPrenom(newmail);
        } else
            PhraseRetour = "Ce mail est déjà utilisé";
        return PhraseRetour;
    }

    public String ChangeFidelite(ClientModel Client) throws SQLException, ClassNotFoundException {
        String PhraseRetour = client.MajPartielBdd(Client.getId_client(), "fidelite", true);
        Client.setFidelite(true);
        return PhraseRetour;
    }

    public String ChangeDate_debut_fin_loc(ClientModel Client, String date_debut_loc, String date_fin_loc) throws SQLException, ClassNotFoundException {
        String valeurtemp = Client.MajPartielBdd(Client.getId_client(),"date_debut_loc" , date_debut_loc);
        String PhraseRetour = Client.MajPartielBdd(Client.getId_client(),"date_fin_loc" , date_fin_loc);
        Client.setDate_debut_loc(date_debut_loc);
        Client.setDate_fin_loc(date_fin_loc);
        return PhraseRetour;
    }

    public String Changefacture (ClientModel Client, String facture) throws SQLException, ClassNotFou

    public int verifierConnexionClient(String login, String password) throws SQLException, ClassNotFoundException {
        return client.verif_connexion_client(login, password);
    }

    public String getPhrase() {
        return Phrase;
    }
}
