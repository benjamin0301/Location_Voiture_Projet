package View.PageResultats.conteneurprincipal.gauche;
import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel
{
    public ConteneurGauche()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(250, 1500));

        ResumeTrajet resumeTrajet = new ResumeTrajet();
        resumeTrajet.setPreferredSize(new Dimension(230, 300));
        add(resumeTrajet);

        Filtrer filtrer = new Filtrer();
        filtrer.setPreferredSize(new Dimension(230, 900));
        add(filtrer);
    }
}
