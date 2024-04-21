package Controler;

import Model.ClientModel;
import Model.FactureModel;
import Model.VoitureModel;

import java.io.IOException;
import java.sql.SQLException;


public class FactureController {

    private FactureModel facture;

    private String Phrase;

    public FactureController() {
        this.facture = new FactureModel();
    }

    public FactureModel CreerNouvelleFacture(VoitureModel voiture, ClientModel client,int prix, String email, String num_tel, String ville, String adresse, String num_vol, String nom, String prenom) throws Exception {
        facture = facture.CreerFacture(client, voiture, prix, email, num_tel, ville, adresse, num_vol, nom, prenom);
        if(facture!=null)
            return facture;
        else return null;
    }

    public boolean supprimerFacture(ClientModel Client) throws SQLException, ClassNotFoundException {
        if (facture.updateVoitureIdFacture(Client.getId_vehicule_loue(), 0)) {
            if (facture.updateClientIdFacture(Client.getId_client(), 0)) {
                if (facture.supprimerFacture(Client.getId_facture())) {
                    return true;
                }
            }
        } else {
            System.out.println("Aucune facture supprimé.");
            return false;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FactureModel factureModel = new FactureModel();
        ClientModel clientModel = new ClientModel();

        clientModel = clientModel.RecupClientById(75239);
        VoitureModel voitureModel = new VoitureModel();
        voitureModel = voitureModel.RecupVoitureByIdPlaque("ABC23");
        int prix = 20;
        FactureController factureController = new FactureController();
        FactureModel factureModel1  = factureController.CreerNouvelleFacture(voitureModel, clientModel, prix,"mail", "num_tel", "d","test", "test", "test", "test");

        factureController.supprimerFacture(clientModel);

    }
}
