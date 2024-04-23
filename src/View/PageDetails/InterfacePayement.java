package View.PageDetails;
import Model.ClientModel;
import Model.FactureModel;
import Model.VoitureModel;
import View.PageConfirmation.FrameConfirmation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

public class InterfacePayement {
    private final ClientModel client;
    private JFrame fenetre;
    private JProgressBar barreProgression;
    private JLabel etiquette;
    private JButton bouton;
    private Container conteneurPrincipal;

    public InterfacePayement(Container conteneurPrincipal, VoitureModel voiture, int res, ClientModel clientModel, FactureModel factureModel) {
        this.client = clientModel;
        this.conteneurPrincipal = conteneurPrincipal;

        // Créer la fenêtre
        fenetre = new JFrame("Validation du paiement");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(600, 200);
        fenetre.setLayout(new BorderLayout());
        fenetre.setLocationRelativeTo(null);

        // Créer la barre de progression
        barreProgression = new JProgressBar();
        barreProgression.setStringPainted(true);
        fenetre.add(barreProgression, BorderLayout.CENTER);

        // Créer l'étiquette
        etiquette = new JLabel("Validation du paiement en cours...");
        fenetre.add(etiquette, BorderLayout.SOUTH);

        // Créer le bouton
        bouton = new JButton("Retourner vers le site marchand");
        bouton.setVisible(false); // Cacher le bouton au démarrage
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre de validation de paiement
                fenetre.dispose();

                try {
                    FrameAvis frameAvis = new FrameAvis(voiture, res, clientModel);
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        fenetre.add(bouton, BorderLayout.NORTH);

        // Afficher la fenêtre
        fenetre.setVisible(true);

        // Démarrer la validation du paiement
        validerPayement();
    }

    private void validerPayement() {
        Instant debut = Instant.now();
        Timer minuteur = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pourcentage = (int) ((Duration.between(debut, Instant.now()).getSeconds() + 1) * 10);
                barreProgression.setValue(pourcentage);
                if (pourcentage >= 100) {
                    etiquette.setText("Le paiement a été validé avec succès.");
                    bouton.setVisible(true); // Afficher le bouton lorsque la barre est à 100%
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        minuteur.start();
    }
}



