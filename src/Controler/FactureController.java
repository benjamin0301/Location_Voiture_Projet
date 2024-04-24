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

    public FactureModel CreerNouvelleFacture(VoitureModel voiture, ClientModel client,int prix, String email, String num_tel, String ville, String adresse, String num_vol, String nom, String prenom, String NumCarte, String dateexp, String cvc, String datedepart, String dateretour) throws Exception {
        facture = facture.CreerFacture(client, voiture, prix, email, num_tel, ville, adresse, num_vol, nom, prenom, NumCarte, dateexp, cvc, datedepart, dateretour);
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
}
