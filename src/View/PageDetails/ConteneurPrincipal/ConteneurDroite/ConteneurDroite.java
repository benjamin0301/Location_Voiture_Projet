package View.PageDetails.ConteneurPrincipal.ConteneurDroite;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class ConteneurDroite extends JPanel
{
    public ConteneurDroite(VoitureModel voiture)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(250, 1500));

        ResumeMontant resumeMontant = new ResumeMontant(voiture);
        resumeMontant.setPreferredSize(new Dimension(230, 300));
        add(resumeMontant);

        InfosVoitureSelect infosVoitureSelect = new InfosVoitureSelect(voiture);
        infosVoitureSelect.setPreferredSize(new Dimension(230, 800));
        add(infosVoitureSelect);
    }
}
