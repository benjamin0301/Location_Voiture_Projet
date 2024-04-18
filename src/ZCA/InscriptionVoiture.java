/*package ZCA;

import Controler.VoitureController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InscriptionVoiture extends JFrame {

    private JTextField idPlaqueField;
    private JTextField nomModeleField;
    private JTextField typeField;
    private JTextField couleurField;
    private JTextField moteurField;
    private JTextField nbPlaceField;
    private JTextField capaciteValiseField;
    private JTextField nbPorteField;
    private JTextField transmissionField;
    private JTextField capaEssenceField;
    private JTextField anneeField;
    private JTextField kilometrageActuelField;
    private JTextField prixField;
    private JTextField lieuPriseEnChargeField;
    private JTextField limiteKmField;
    private JTextField marqueField;

    private VoitureController voitureController;

    public InscriptionVoiture() throws SQLException, ClassNotFoundException {
        this.voitureController = new VoitureController();

        setTitle("Inscription Voiture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(16, 2, 5, 5));

        idPlaqueField = new JTextField(15);
        nomModeleField = new JTextField(15);
        typeField = new JTextField(15);
        couleurField = new JTextField(15);
        moteurField = new JTextField(15);
        nbPlaceField = new JTextField(15);
        capaciteValiseField = new JTextField(15);
        nbPorteField = new JTextField(15);
        transmissionField = new JTextField(15);
        capaEssenceField = new JTextField(15);
        anneeField = new JTextField(15);
        kilometrageActuelField = new JTextField(15);
        prixField = new JTextField(15);
        lieuPriseEnChargeField = new JTextField(15);
        limiteKmField = new JTextField(15);
        marqueField = new JTextField(15);
        JButton inscriptionButton = new JButton("S'inscrire");
        JButton retourButton = new JButton("Retour");

        panel.add(new JLabel("ID Plaque:"));
        panel.add(idPlaqueField);
        panel.add(new JLabel("Nom Modèle:"));
        panel.add(nomModeleField);
        panel.add(new JLabel("Type:"));
        panel.add(typeField);
        panel.add(new JLabel("Couleur:"));
        panel.add(couleurField);
        panel.add(new JLabel("Moteur:"));
        panel.add(moteurField);
        panel.add(new JLabel("Nombre de places:"));
        panel.add(nbPlaceField);
        panel.add(new JLabel("Capacité valise:"));
        panel.add(capaciteValiseField);
        panel.add(new JLabel("Nombre de portes:"));
        panel.add(nbPorteField);
        panel.add(new JLabel("Transmission:"));
        panel.add(transmissionField);
        panel.add(new JLabel("Capacité essence:"));
        panel.add(capaEssenceField);
        panel.add(new JLabel("Année:"));
        panel.add(anneeField);
        panel.add(new JLabel("Kilométrage actuel:"));
        panel.add(kilometrageActuelField);
        panel.add(new JLabel("Prix:"));
        panel.add(prixField);
        panel.add(new JLabel("Lieu de prise en charge:"));
        panel.add(lieuPriseEnChargeField);
        panel.add(new JLabel("Limite km:"));
        panel.add(limiteKmField);
        panel.add(new JLabel("Marque:"));
        panel.add(marqueField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inscriptionButton);
        buttonPanel.add(retourButton);

        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPlaque = idPlaqueField.getText();
                String nomModele = nomModeleField.getText();
                String type = typeField.getText();
                String couleur = couleurField.getText();
                String moteur = moteurField.getText();
                int nbPlace = Integer.parseInt(nbPlaceField.getText());
                int capaciteValise = Integer.parseInt(capaciteValiseField.getText());
                int nbPorte = Integer.parseInt(nbPorteField.getText());
                String transmission = transmissionField.getText();
                int capaEssence = Integer.parseInt(capaEssenceField.getText());
                int annee = Integer.parseInt(anneeField.getText());
                int kilometrageActuel = Integer.parseInt(kilometrageActuelField.getText());
                float prix = Float.parseFloat(prixField.getText());
                String lieuPriseEnCharge = lieuPriseEnChargeField.getText();
                int limiteKm = Integer.parseInt(limiteKmField.getText());
                String marque = marqueField.getText();

                String phraseRecue;
                try {
                    phraseRecue = voitureController.ajouterNouvelleVoiture(idPlaque, nomModele, type, couleur, moteur, nbPlace, capaciteValise, nbPorte,
                            transmission, capaEssence, annee, kilometrageActuel, prix, lieuPriseEnCharge, limiteKm, marque);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if (phraseRecue.equals("Toutes les données sont valides")) {
                    JOptionPane.showMessageDialog(InscriptionVoiture.this, "Inscription réussie !");
                    // Rediriger vers la page de connexion
                } else {
                    JOptionPane.showMessageDialog(InscriptionVoiture.this, "Erreur lors de l'inscription : " + phraseRecue);
                }
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Rediriger vers la page de connexion
                // Vous pouvez remplacer cette partie par la redirection vers votre interface de connexion
                JOptionPane.showMessageDialog(InscriptionVoiture.this, "Redirection vers la connexion");
            }
        });

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new InscriptionVoiture().setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur de base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Classe introuvable : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
*/