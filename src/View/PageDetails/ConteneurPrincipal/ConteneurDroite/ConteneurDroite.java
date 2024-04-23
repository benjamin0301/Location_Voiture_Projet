package View.PageDetails.ConteneurPrincipal.ConteneurDroite;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class ConteneurDroite extends JPanel
{
    public ConteneurDroite(VoitureModel voiture, ClientModel client)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(250, 1300));

        ResumeMontant resumeMontant = new ResumeMontant(voiture, client);
        resumeMontant.setPreferredSize(new Dimension(230, 190));
        add(resumeMontant);

        InfosVoitureSelect infosVoitureSelect = new InfosVoitureSelect(voiture);
        infosVoitureSelect.setPreferredSize(new Dimension(230, 715));
        add(infosVoitureSelect);
    }
}
