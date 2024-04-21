package Model;
import com.pdfjet.*;
import com.pdfjet.Font;

import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class PDFCreation {

    public static void main(String[] args) throws Exception {
        // Récupération des informations de location
       FactureModel facture = new FactureModel();
       VoitureModel voiture = new VoitureModel();
       ClientModel client = new ClientModel();
       client.RecupClientById(0, null, null,191627);
       voiture.RecupVoitureByIdPlaque("GO-317-AT");
       facture.CreerFacture(client, voiture, 10, "bite", "0694345678","bite","bite","vol 3456789", "bite", "bite");
    }
}

