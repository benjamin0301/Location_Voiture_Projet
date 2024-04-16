package View.PageResultats.conteneurprincipal.gauche;

import javax.swing.*;
import java.awt.*;

public class ResumeTrajet extends JPanel
{
    public ResumeTrajet()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(230, 300));
        setBackground(Color.decode("#FFFFFF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JLabel labelResume = new JLabel("     Résumé du trajet");
        labelResume.setHorizontalAlignment(SwingConstants.LEFT);
        labelResume.setVerticalAlignment(SwingConstants.CENTER);
        labelResume.setFont(new Font("Georgia", Font.BOLD, 13));
        labelResume.setOpaque(true);
        labelResume.setBackground(Color.decode("#E6E6E6"));
        labelResume.setPreferredSize(new Dimension(getWidth(), 50));
        labelResume.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        add(labelResume, BorderLayout.NORTH);


        JPanel zoneTexte = new JPanel(new GridBagLayout());
        zoneTexte.setBackground(Color.decode("#FFFFFF"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;

        JTextArea depart = new JTextArea("Départ\n");
        depart.setFont(new Font("Georgia", Font.BOLD, 13));
        zoneTexte.add(depart, gbc);

        gbc.gridy++;
        JTextArea infosDep = new JTextArea("Paris - Aéroport d'Orly\n" + "4 avril 2024\n" + "10:00\n" + "\n\n");
        infosDep.setFont(new Font("Georgia", Font.PLAIN, 13));
        zoneTexte.add(infosDep, gbc);

        gbc.gridy++;
        JTextArea retour = new JTextArea("Retour\n");
        retour.setFont(new Font("Georgia", Font.BOLD, 13));
        zoneTexte.add(retour, gbc);

        gbc.gridy++;
        JTextArea infosRet = new JTextArea("Paris - Aéroport d'Orly\n" + "5 avril 2024\n" + "10:00\n" + "\n");
        infosRet.setFont(new Font("Georgia", Font.PLAIN, 13));
        zoneTexte.add(infosRet, gbc);

        zoneTexte.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        add(zoneTexte, BorderLayout.CENTER);

        JPanel englobeur = new JPanel();
        englobeur.setLayout(new BorderLayout());
        englobeur.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        englobeur.setBackground(Color.white);

        englobeur.add(zoneTexte, BorderLayout.WEST);
        add(englobeur);


        JButton boutonModifier = new JButton("Modifier");
        boutonModifier.setPreferredSize(new Dimension(130, 25));
        boutonModifier.setForeground(Color.white);
        boutonModifier.setBackground(Color.decode("#5E17EB"));
        boutonModifier.setFont(new Font("Georgia", Font.BOLD, 12));
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelBouton.add(boutonModifier);
        panelBouton.setBackground(Color.decode("#FFFFFF"));
        add(panelBouton, BorderLayout.SOUTH);
    }
}