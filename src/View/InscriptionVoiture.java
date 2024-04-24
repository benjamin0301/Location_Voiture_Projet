package View;

import Controler.VoitureController;
import Model.EmployeModel;
import Model.VoitureModel;
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
    private JComboBox<String> moteurComboBox;
    private JSpinner nbPlaceSpinner;
    private JSpinner capaciteValiseSpinner;
    private JSpinner nbPorteSpinner;
    private JComboBox<String> transmissionComboBox;
    private JSpinner capaEssenceSpinner;
    private JSpinner anneeSpinner;
    private JSpinner kilometrageActuelSpinner;
    private JSpinner prixSpinner;
    private JTextField lieuPriseEnChargeField;
    private JSpinner limiteKmSpinner;
    private JTextField marqueField;
    private JTextField imageVoitureField;
    private JButton inscriptionButton;
    private JButton retourButton;

    private VoitureController voitureController;
    private EmployeModel employe;

    public InscriptionVoiture(EmployeModel employeModel, String lieuDepart, String dateDepart, String lieuRetour, String dateRetour, int res) throws SQLException, ClassNotFoundException {
        this.voitureController = new VoitureController();
        this.employe = employeModel;
        setTitle("Inscription Voiture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        idPlaqueField = new JTextField(20);
        nomModeleField = new JTextField(20);
        typeField = new JTextField(20);
        couleurField = new JTextField(20);
        moteurComboBox = new JComboBox<>(new String[]{"essence", "diesel", "hybride", "electrique"});
        nbPlaceSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        capaciteValiseSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        nbPorteSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        transmissionComboBox = new JComboBox<>(new String[]{"manuelle", "automatique"});
        capaEssenceSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        anneeSpinner = new JSpinner(new SpinnerNumberModel(1900, 1900, 2024, 1));
        kilometrageActuelSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1));
        prixSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100000, 1));
        lieuPriseEnChargeField = new JTextField(20);
        limiteKmSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1));
        marqueField = new JTextField(20);
        imageVoitureField = new JTextField(20);
        inscriptionButton = new JButton("Ajouter");
        retourButton = new JButton("Retour");

        // Ajouter les composants au panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID Plaque:"), gbc);

        gbc.gridx = 1;
        panel.add(idPlaqueField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nom Modèle:"), gbc);

        gbc.gridx = 1;
        panel.add(nomModeleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Type:"), gbc);

        gbc.gridx = 1;
        panel.add(typeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Couleur:"), gbc);

        gbc.gridx = 1;
        panel.add(couleurField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Moteur:"), gbc);

        gbc.gridx = 1;
        panel.add(moteurComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Nombre de places:"), gbc);

        gbc.gridx = 1;
        panel.add(nbPlaceSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Capacité valise:"), gbc);

        gbc.gridx = 1;
        panel.add(capaciteValiseSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Nombre de portes:"), gbc);

        gbc.gridx = 1;
        panel.add(nbPorteSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Transmission:"), gbc);

        gbc.gridx = 1;
        panel.add(transmissionComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Capacité essence:"), gbc);

        gbc.gridx = 1;
        panel.add(capaEssenceSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Année:"), gbc);

        gbc.gridx = 1;
        panel.add(anneeSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(new JLabel("Kilométrage actuel:"), gbc);

        gbc.gridx = 1;
        panel.add(kilometrageActuelSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(new JLabel("Prix:"), gbc);

        gbc.gridx = 1;
        panel.add(prixSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(new JLabel("Lieu de prise en charge:"), gbc);

        gbc.gridx = 1;
        panel.add(lieuPriseEnChargeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        panel.add(new JLabel("Limite km:"), gbc);

        gbc.gridx = 1;
        panel.add(limiteKmSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 15;
        panel.add(new JLabel("Marque:"), gbc);

        gbc.gridx = 1;
        panel.add(marqueField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 16;
        panel.add(new JLabel("Image voiture:"), gbc);

        gbc.gridx = 1;
        panel.add(imageVoitureField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 2;
        panel.add(inscriptionButton, gbc);

        gbc.gridy = 18;
        gbc.gridwidth = 2;
        panel.add(retourButton, gbc);


        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPlaque = idPlaqueField.getText();
                String nomModele = nomModeleField.getText();
                String type = typeField.getText();
                String couleur = couleurField.getText();
                String moteur = (String) moteurComboBox.getSelectedItem();
                int nbPlace = (int) nbPlaceSpinner.getValue();
                int capaciteValise = (int) capaciteValiseSpinner.getValue();
                int nbPorte = (int) nbPorteSpinner.getValue();
                String transmission = (String) transmissionComboBox.getSelectedItem();
                int capaEssence = (int) capaEssenceSpinner.getValue();
                int annee = (int) anneeSpinner.getValue();
                int kilometrageActuel = (int) kilometrageActuelSpinner.getValue();
                int prix = (int) prixSpinner.getValue();
                String lieuPriseEnCharge = lieuPriseEnChargeField.getText();
                int limiteKm = (int) limiteKmSpinner.getValue();
                String marque = marqueField.getText();
                String imageVoiture = imageVoitureField.getText();

                try {
                    VoitureModel voiture = voitureController.ajouterNouvelleVoiture(idPlaque, nomModele, type, couleur, moteur,
                            nbPlace, capaciteValise, nbPorte, transmission, capaEssence, annee, kilometrageActuel,
                            prix, lieuPriseEnCharge, limiteKm, marque, imageVoiture);

                    if (voiture != null) {
                        JOptionPane.showMessageDialog(InscriptionVoiture.this, "Inscription réussie !");
                        InscriptionVoiture.this.setVisible(false);

                        // Create a new instance of the ConnexionVue window and make it visible
                        try {
                            //A REFAIRE GROS
                            VueEmploye vueEmploye = new VueEmploye(employe);
                            vueEmploye.initialize( lieuDepart,  dateDepart,  lieuRetour,  dateRetour, res);
                            vueEmploye.setVisible(true);

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(InscriptionVoiture.this, "Erreur lors de l'inscription. Veuillez réessayer.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current InscriptionVoiture window
                InscriptionVoiture.this.setVisible(false);

                // Create a new instance of the ConnexionVue window and make it visible
                try {
                    //A REFAIRE GROS
                    VueEmploye vueEmploye = new VueEmploye(employe);
                    vueEmploye.initialize( lieuDepart,  dateDepart,  lieuRetour,  dateRetour, res);
                    vueEmploye.setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(InscriptionVoiture.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel, BorderLayout.CENTER);
    }


}