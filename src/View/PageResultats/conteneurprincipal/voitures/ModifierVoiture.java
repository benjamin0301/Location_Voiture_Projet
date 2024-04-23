package View.PageResultats.conteneurprincipal.voitures;

import Model.EmployeModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ModifierVoiture extends JFrame {

    private VoitureModel voiture;
    private JTextField fieldIdPlaque;
    private JTextField fieldNomModele;
    private JTextField fieldType;
    private JTextField fieldCouleur;
    private JTextField fieldMoteur;
    private JTextField fieldNbPlace;
    private JTextField fieldCapaciteValise;
    private JTextField fieldNbPorte;
    private JTextField fieldTransmission;
    private JTextField fieldCapaEssence;
    private JTextField fieldAnnee;
    private JTextField fieldKilometrageActuel;
    private JTextField fieldPrix;
    private JTextField fieldLieuPriseEnCharge;
    private JTextField fieldLimiteKm;
    private JTextField fieldMarque;
    private JTextField fieldImageVoiture;
    private EmployeModel employe;

    public ModifierVoiture(VoitureModel voiture, EmployeModel employeModel) throws SQLException, ClassNotFoundException {
        this.voiture = voiture;
        this.employe = employeModel;
        initialize();
    }

    public void initialize() {
        setTitle("Modifier Voiture");
        setSize(1200, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.LEADING));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        JPanel case1 = new JPanel();
        JLabel id_plaque = new JLabel("ID Plaque : ");
        id_plaque.setFont(new Font("Georgia", Font.PLAIN, 15));
        case1.add(id_plaque);
        fieldIdPlaque = new JTextField(voiture.getId_plaque());
        fieldIdPlaque.setPreferredSize(new Dimension(200, 30));
        case1.add(fieldIdPlaque);
        add(case1, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        JPanel case2 = new JPanel();
        JLabel modele = new JLabel("Nom modèle : ");
        modele.setFont(new Font("Georgia", Font.PLAIN, 15));
        case2.add(modele);
        fieldNomModele = new JTextField(voiture.getnom_modele());
        fieldNomModele.setPreferredSize(new Dimension(200, 30));
        case2.add(fieldNomModele);
        add(case2, gbc);


        // à partir de là, apporte les modifications demandées
        // Continuation de la disposition des composants avec GridBagLayout

        // Les éléments suivants seront placés dans la grille en utilisant GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case3 = new JPanel();
        JLabel typeLabel = new JLabel("Type : ");
        typeLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case3.add(typeLabel);
        fieldType = new JTextField(voiture.getType());
        fieldType.setPreferredSize(new Dimension(200, 30));
        case3.add(fieldType);
        add(case3, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case4 = new JPanel();
        JLabel couleurLabel = new JLabel("Couleur : ");
        couleurLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case4.add(couleurLabel);
        fieldCouleur = new JTextField(voiture.getCouleur());
        fieldCouleur.setPreferredSize(new Dimension(200, 30));
        case4.add(fieldCouleur);
        add(case4, gbc);

        // Répéter le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case5 = new JPanel();
        JLabel moteurLabel = new JLabel("Moteur : ");
        moteurLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case5.add(moteurLabel);
        fieldMoteur = new JTextField(voiture.getMoteur());
        fieldMoteur.setPreferredSize(new Dimension(200, 30));
        case5.add(fieldMoteur);
        add(case5, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case6 = new JPanel();
        JLabel nbPlaceLabel = new JLabel("Nb Place : ");
        nbPlaceLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case6.add(nbPlaceLabel);
        fieldNbPlace = new JTextField(String.valueOf(voiture.getNbPlace()));
        fieldNbPlace.setPreferredSize(new Dimension(200, 30));
        case6.add(fieldNbPlace);
        add(case6, gbc);

        // Répétez le même processus pour les autres champs...


        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case7 = new JPanel();
        JLabel capaciteValiseLabel = new JLabel("Capacite Valise : ");
        capaciteValiseLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case7.add(capaciteValiseLabel);
        fieldCapaciteValise = new JTextField(String.valueOf(voiture.getCapaciteValise()));
        fieldCapaciteValise.setPreferredSize(new Dimension(200, 30));
        case7.add(fieldCapaciteValise);
        add(case7, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case8 = new JPanel();
        JLabel nbPorteLabel = new JLabel("Nb Porte : ");
        nbPorteLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case8.add(nbPorteLabel);
        fieldNbPorte = new JTextField(String.valueOf(voiture.getNbPorte()));
        fieldNbPorte.setPreferredSize(new Dimension(200, 30));
        case8.add(fieldNbPorte);
        add(case8, gbc);

        // Répétez le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case9 = new JPanel();
        JLabel transmissionLabel = new JLabel("Transmission : ");
        transmissionLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case9.add(transmissionLabel);
        fieldTransmission = new JTextField(voiture.getTransmission());
        fieldTransmission.setPreferredSize(new Dimension(200, 30));
        case9.add(fieldTransmission);
        add(case9, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case10 = new JPanel();
        JLabel capaEssenceLabel = new JLabel("Capa Essence : ");
        capaEssenceLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case10.add(capaEssenceLabel);
        fieldCapaEssence = new JTextField(String.valueOf(voiture.getCapaEssence()));
        fieldCapaEssence.setPreferredSize(new Dimension(200, 30));
        case10.add(fieldCapaEssence);
        add(case10, gbc);

        // Répétez le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case11 = new JPanel();
        JLabel anneeLabel = new JLabel("Annee : ");
        anneeLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case11.add(anneeLabel);
        fieldAnnee = new JTextField(String.valueOf(voiture.getAnnee()));
        fieldAnnee.setPreferredSize(new Dimension(200, 30));
        case11.add(fieldAnnee);
        add(case11, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case12 = new JPanel();
        JLabel kilometrageLabel = new JLabel("Kilometrage Actuel : ");
        kilometrageLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case12.add(kilometrageLabel);
        fieldKilometrageActuel = new JTextField(String.valueOf(voiture.getkilometrage_actuel()));
        fieldKilometrageActuel.setPreferredSize(new Dimension(200, 30));
        case12.add(fieldKilometrageActuel);
        add(case12, gbc);

        // Répétez le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case13 = new JPanel();
        JLabel prixLabel = new JLabel("Prix : ");
        prixLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case13.add(prixLabel);
        fieldPrix = new JTextField(String.valueOf(voiture.getPrix()));
        fieldPrix.setPreferredSize(new Dimension(200, 30));
        case13.add(fieldPrix);
        add(case13, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case14 = new JPanel();
        JLabel lieuLabel = new JLabel("Lieu Prise En Charge : ");
        lieuLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case14.add(lieuLabel);
        fieldLieuPriseEnCharge = new JTextField(voiture.getLieuPriseEnCharge());
        fieldLieuPriseEnCharge.setPreferredSize(new Dimension(200, 30));
        case14.add(fieldLieuPriseEnCharge);
        add(case14, gbc);

        // Répétez le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case15 = new JPanel();
        JLabel limiteKmLabel = new JLabel("Limite Km : ");
        limiteKmLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case15.add(limiteKmLabel);
        fieldLimiteKm = new JTextField(String.valueOf(voiture.getLimite_km()));
        fieldLimiteKm.setPreferredSize(new Dimension(200, 30));
        case15.add(fieldLimiteKm);
        add(case15, gbc);

        gbc.gridx = 1; // Passage à la colonne suivante

        JPanel case16 = new JPanel();
        JLabel marqueLabel = new JLabel("Marque : ");
        marqueLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case16.add(marqueLabel);
        fieldMarque = new JTextField(voiture.getMarque());
        fieldMarque.setPreferredSize(new Dimension(200, 30));
        case16.add(fieldMarque);
        add(case16, gbc);

        // Répétez le même processus pour les autres champs...

        // Suite de la disposition des composants avec GridBagLayout

        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridx = 0; // Réinitialisation de la colonne à 0

        JPanel case17 = new JPanel();
        JLabel imageLabel = new JLabel("Image Voiture : ");
        imageLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        case17.add(imageLabel);
        fieldImageVoiture = new JTextField(voiture.getImage_voiture());
        fieldImageVoiture.setPreferredSize(new Dimension(200, 30));
        case17.add(fieldImageVoiture);
        add(case17, gbc);

        gbc.gridy++;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setPreferredSize(new Dimension(1000, 30));
        add(espaceBlanc, gbc);


        gbc.gridy++;
        JPanel panelBouton = new JPanel();
        panelBouton.setPreferredSize(new Dimension(1200, 100));
        JButton saveButton = new JButton("Enregistrer les modifications");
        saveButton.setFont(new Font("Georgia", Font.BOLD, 20));
        saveButton.setForeground(Color.white);
        saveButton.setBackground(Color.decode("#7E3DFF"));
        saveButton.setPreferredSize(new Dimension(400, 50));
        panelBouton.add(saveButton);
        add(panelBouton, gbc);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    voiture.setNom_modele(fieldNomModele.getText());
                    voiture.setType(fieldType.getText());
                    voiture.setCouleur(fieldCouleur.getText());
                    voiture.setMoteur(fieldMoteur.getText());
                    voiture.setNbPlace(Integer.parseInt(fieldNbPlace.getText()));
                    voiture.setCapacite_valise(Integer.parseInt(fieldCapaciteValise.getText()));
                    voiture.setNbPorte(Integer.parseInt(fieldNbPorte.getText()));
                    voiture.setTransmission(fieldTransmission.getText());
                    voiture.setCapaEssence(Integer.parseInt(fieldCapaEssence.getText()));
                    voiture.setAnnee(Integer.parseInt(fieldAnnee.getText()));
                    voiture.setKilometrage_actuel(Integer.parseInt(fieldKilometrageActuel.getText()));
                    voiture.setPrix(Integer.parseInt(fieldPrix.getText()));
                    voiture.setLieuPriseEnCharge(fieldLieuPriseEnCharge.getText());
                    voiture.setLimite_km(Integer.parseInt(fieldLimiteKm.getText()));
                    voiture.setMarque(fieldMarque.getText());
                    voiture.setImage_voiture(fieldImageVoiture.getText());

                    voiture.MajPartielBdd(voiture.getId_plaque(), "nom_modele", fieldNomModele.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "type", fieldType.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "couleur", fieldCouleur.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "moteur", fieldMoteur.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "nb_place", String.valueOf(voiture.getNbPlace()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "capacite_valise", String.valueOf(voiture.getCapaciteValise()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "nb_porte", String.valueOf(voiture.getNbPorte()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "transmission", fieldTransmission.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "capa_essence", String.valueOf(voiture.getCapaEssence()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "annee", String.valueOf(voiture.getAnnee()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "kilometrage_actuel", String.valueOf(voiture.getkilometrage_actuel()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "prix", String.valueOf(voiture.getPrix()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "lieu_prise_en_charge", fieldLieuPriseEnCharge.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "limite_km", String.valueOf(voiture.getLimite_km()));
                    voiture.MajPartielBdd(voiture.getId_plaque(), "marque", fieldMarque.getText());
                    voiture.MajPartielBdd(voiture.getId_plaque(), "image_voiture", fieldImageVoiture.getText());

                    JOptionPane.showMessageDialog(null, "Les modifications ont été enregistrées avec succès !");
                    dispose();
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour de la voiture : " + ex.getMessage());
                }
            }

        });
    }

    public static void main(String[] args) {
        try {
            VoitureModel voiture = new VoitureModel(/* Passer les arguments nécessaires pour créer une voiture */);
            EmployeModel employe = new EmployeModel(/* Passer les arguments nécessaires pour créer un employé */);
            ModifierVoiture modifierVoiture = new ModifierVoiture(voiture, employe);
            modifierVoiture.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
