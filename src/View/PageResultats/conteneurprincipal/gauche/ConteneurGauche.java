package View.PageResultats.conteneurprincipal.gauche;
import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel
{
    private String lieuDepart;
    private String dateDepart;
    private String lieuRetour;
    private String dateRetour;
    public ConteneurGauche(String lieuDepart, String dateDepart, String lieuRetour, String dateRetour)
    {
        this.lieuDepart = lieuDepart;
        this.dateDepart = dateDepart;
        this.lieuRetour = lieuRetour;
        this.dateRetour = dateRetour;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(250, 1500));

        ResumeTrajet resumeTrajet = new ResumeTrajet(lieuDepart, dateDepart, lieuRetour, dateRetour);

        resumeTrajet.setPreferredSize(new Dimension(230, 300));
        add(resumeTrajet);

        Filtrer filtrer = new Filtrer();
        filtrer.setPreferredSize(new Dimension(230, 900));
        add(filtrer);
    }
}
