package ZCA.page_principale;

import ZCA.EspacePersonnel;
import ZCA.EspacePersonnelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConteneurHaut extends JPanel {

    private EspacePersonnelListener listener;
    public ConteneurHaut() {
        setBackground(Color.decode("#FFFFFF")); // Couleur de fond du conteneur principal
        setPreferredSize(new Dimension(800, 80)); // Taille fixe definie

        // Ajout d'un label pour le texte "RentMyRide"
        JLabel labelTitre = new JLabel("RentMyRide");
        labelTitre.setForeground(Color.decode("#5E17EB")); // Couleur du texte
        labelTitre.setFont(new Font("Arial", Font.BOLD, 23)); // Definition de la police et de la taille

        // Creation d'un BoxLayout vertical pour le conteneur principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Ajout d'un espace vertical avant le panneau pour centrer verticalement les elements
        add(Box.createVerticalGlue());

        // Ajout d'eléments dans le conteneur placé en haut
        JPanel barreNavigation = new JPanel();
        barreNavigation.setBackground(Color.decode("#FFFFFF")); // Couleur de fond de la barre de navigation
        barreNavigation.setLayout(new BoxLayout(barreNavigation, BoxLayout.X_AXIS)); // Utilisation d'un BoxLayout horizontal

        barreNavigation.add(labelTitre); // Ajout du label

        // Ajout d'un espace rigide pour créer un grand espace entre "RentMyRide" et "Accueil"
        barreNavigation.add(Box.createRigidArea(new Dimension(500, 0))); // Espacement de 100 pixels

        JButton boutonAccueil = new JButton("Accueil");
        JButton boutonContact = new JButton("Contact");
        JButton boutonEspacePerso = new JButton("Mon espace personnel");
        JButton boutonConnexion = new JButton("Connexion");

        // Ajout des boutons avec un espace rigide entre chaque bouton
        barreNavigation.add(boutonAccueil);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0))); // Espacement de 10 pixels entre les boutons
        barreNavigation.add(boutonContact);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0))); // Espacement de 10 pixels entre les boutons
        barreNavigation.add(boutonEspacePerso);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0))); // Espacement de 10 pixels entre les boutons
        barreNavigation.add(boutonConnexion);

        add(barreNavigation); // Ajout de la barre de navigation au conteneur principal

        // Ajout d'un espace vertical après le panneau pour centrer verticalement les éléments
        add(Box.createVerticalGlue());

        boutonEspacePerso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    try {
                        listener.onEspacePersonnelClicked();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public void setEspacePersonnelListener(EspacePersonnelListener listener) {
        this.listener = listener;
    }
}
