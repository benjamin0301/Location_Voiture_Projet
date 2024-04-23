package View.PageDetails.ConteneurPrincipal;

import Controler.VoitureController;
import Model.ClientModel;
import Model.VoitureModel;
import View.Accueil;
import View.PageConfirmation.FrameConfirmation;
import View.PageConfirmation.PageConfirmation;
import View.PageDetails.ConteneurPrincipal.ConteneurDroite.ConteneurDroite;

import View.PageDetails.InterfacePayement;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class ConteneurPrincipal extends JPanel {
    private ClientModel client;

    public ConteneurPrincipal(VoitureModel voiture, int res, ClientModel clientModel) throws SQLException, ClassNotFoundException {
        this.client = clientModel;
        setBackground(Color.decode("#E4E4E4"));
        setBorder(BorderFactory.createMatteBorder(30, 0, 30, 0, Color.decode("#E4E4E4")));

        JPanel pagePrincipale = createPagePrincipale(voiture, res, client);

        add(pagePrincipale);
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String defaultText) {
        JTextField field = new JTextField(defaultText, 20);
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(defaultText)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(defaultText);
                    field.setForeground(Color.GRAY);
                }
            }
        });

        gbc.gridy++;
        panel.add(field, gbc);
    }



    private JPanel createPagePrincipale(VoitureModel voiture, int res, ClientModel clientModel) throws SQLException, ClassNotFoundException {
        this.client = clientModel;
        JPanel pagePrincipale = new JPanel(new BorderLayout());
        pagePrincipale.setBackground(Color.white);

        ProgressionDetails progressionDetails = new ProgressionDetails();
        ConteneurDroite conteneurDroite = new ConteneurDroite(voiture, client);

        /// --------------------------------------------------------------------///
        /// AJOUT DE CONTENEUR FORMULAIRES

        //ConteneurFormulaires conteneurFormulaires = new ConteneurFormulaires(client);


        JPanel conteneurFormulaires = new JPanel();
        conteneurFormulaires.setLayout(new GridBagLayout());
        conteneurFormulaires.setBackground(Color.white);

        GridBagConstraints gbcCF = new GridBagConstraints();

        gbcCF.gridx = 0;
        gbcCF.gridy = 0;
        gbcCF.weightx = 1.0;

        JPanel espaceBlanc1CF = new JPanel();
        espaceBlanc1CF.setBackground(Color.white);
        espaceBlanc1CF.setPreferredSize(new Dimension(600, 10));
        conteneurFormulaires.add(espaceBlanc1CF, gbcCF);

        /// -------------------------------------------------------------------///
        /// FORMULAIRE CONDUCTEUR

        gbcCF.gridy++;
        JPanel formulaireConducteur = new JPanel();

        JPanel espaceVide1FC = new JPanel();
        espaceVide1FC.setBackground(Color.white);
        espaceVide1FC.setPreferredSize(new Dimension(700, 25));
        formulaireConducteur.add(espaceVide1FC);

        formulaireConducteur.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        formulaireConducteur.setBackground(Color.white);
        formulaireConducteur.setPreferredSize(new Dimension(810, 785));
        formulaireConducteur.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JTextArea titreFC = new JTextArea("Informations concernant le conducteur");
        titreFC.setEditable(false);
        titreFC.setPreferredSize(new Dimension(770, 30));
        titreFC.setFont(new Font("Georgia", Font.BOLD, 18));
        titreFC.setBackground(Color.white);
        formulaireConducteur.add(titreFC);

        JSeparator separator1FC = new JSeparator(SwingConstants.HORIZONTAL);
        separator1FC.setPreferredSize(new Dimension(770, 2));
        separator1FC.setForeground(Color.BLACK);
        formulaireConducteur.add(separator1FC);

        JPanel espaceVide2FC = new JPanel();
        espaceVide2FC.setBackground(Color.white);
        espaceVide2FC.setPreferredSize(new Dimension(700, 20));
        formulaireConducteur.add(espaceVide2FC);

        /// FORMULAIRE

        JPanel formulairePanelFC = new JPanel(new GridBagLayout());
        formulairePanelFC.setBackground(Color.WHITE);

        GridBagConstraints gbcFC = new GridBagConstraints();
        gbcFC.fill = GridBagConstraints.HORIZONTAL;
        gbcFC.ipady = 35;
        gbcFC.ipadx = 160;
        gbcFC.insets = new Insets(10, 10, 0, 10);
        gbcFC.weightx = 1.0;

        addLabeledField(formulairePanelFC, gbcFC, "Prénom *");

        gbcFC.gridy++; // Incremente le numero de ligne
        gbcFC.insets = new Insets(0, 10, 0, 10);
        gbcFC.gridwidth = GridBagConstraints.REMAINDER;
        JLabel infoLabel = new JLabel("<html>Le nom doit correspondre au nom qui figure sur le permis de conduire<br>et sur la carte de crédit utilisée lors du retrait de la voiture.</html>");
        infoLabel.setForeground(Color.GRAY);
        formulairePanelFC.add(infoLabel, gbcFC);

        gbcFC.insets = new Insets(0, 10, 10, 10);

        addLabeledField(formulairePanelFC, gbcFC, "Nom *");

        gbcFC.insets = new Insets(10, 10, 10, 10);

        addLabeledField(formulairePanelFC, gbcFC, "E-mail *");
        addLabeledField(formulairePanelFC, gbcFC, "Téléphone *");
        addLabeledField(formulairePanelFC, gbcFC, "Pays/Région *");
        addLabeledField(formulairePanelFC, gbcFC, "Ville *");
        addLabeledField(formulairePanelFC, gbcFC, "Adresse *");
        gbcFC.insets = new Insets(10, 10, 0, 10);
        addLabeledField(formulairePanelFC, gbcFC, "Numéro de vol (en option)");

        gbcFC.insets = new Insets(0, 10, 0, 10);

        gbcFC.gridy++;
        gbcFC.gridwidth = GridBagConstraints.REMAINDER;
        JLabel infoNVol = new JLabel("<html>Il est important de préciser votre numéro de vol en cas de retard ou d’annulation de celui-ci.<br>Cela aidera l’agence de location de voitures à connaître votre heure d’arrivée.</html>");
        infoNVol.setForeground(Color.GRAY);
        formulairePanelFC.add(infoNVol, gbcFC);


        formulaireConducteur.add(formulairePanelFC, BorderLayout.CENTER);


        conteneurFormulaires.add(formulaireConducteur, gbcCF);


        /// FIN FORMULAIRE CONDUCTEUR
        /// -------------------------------------------------------------------------------///

        gbcCF.gridy++;
        JPanel espaceVide2CF = new JPanel();
        espaceVide2CF.setBackground(Color.white);
        espaceVide2CF.setPreferredSize(new Dimension(700, 25));
        conteneurFormulaires.add(espaceVide2CF, gbcCF);

        /// --------------------------------------------------------------------------------///
        /// FORMULAIRE PAIEMENT

        gbcCF.gridy++;
        JPanel formulairePaiement = new JPanel();

        JPanel espaceVideFP1 = new JPanel();
        espaceVideFP1.setBackground(Color.white);
        espaceVideFP1.setPreferredSize(new Dimension(700, 25));
        formulairePaiement.add(espaceVideFP1);

        formulairePaiement.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        formulairePaiement.setBackground(Color.white);
        formulairePaiement.setPreferredSize(new Dimension(810, 415));
        formulairePaiement.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JTextArea titreFP = new JTextArea("Informations de paiement");
        titreFP.setEditable(false);
        titreFP.setPreferredSize(new Dimension(770, 30));
        titreFP.setFont(new Font("Georgia", Font.BOLD, 18));
        titreFP.setBackground(Color.white);
        formulairePaiement.add(titreFP);


        JSeparator separator1FP = new JSeparator(SwingConstants.HORIZONTAL);
        separator1FP.setPreferredSize(new Dimension(770, 2));
        separator1FP.setForeground(Color.BLACK);
        formulairePaiement.add(separator1FP);

        JPanel espaceVideFP2 = new JPanel();
        espaceVideFP2.setBackground(Color.white);
        espaceVideFP2.setPreferredSize(new Dimension(700, 30));
        formulairePaiement.add(espaceVideFP2);

        // FORMULAIRE

        JPanel formulairePanelFP = new JPanel(new GridBagLayout());
        formulairePanelFP.setBackground(Color.WHITE);

        GridBagConstraints gbcFP = new GridBagConstraints();
        gbcFP.fill = GridBagConstraints.HORIZONTAL;
        gbcFP.ipady = 35;
        gbcFP.ipadx = 160;
        gbcFP.insets = new Insets(10, 10, 10, 10); // Marge autour de chaque champ de texte
        gbcFP.weightx = 1.0; // Permet au champ de texte de remplir l'espace horizontalement

        addLabeledField(formulairePanelFP, gbcFP, "Nom figurant sur la carte *");
        addLabeledField(formulairePanelFP, gbcFP, "Numéro de la carte *");
        addLabeledField(formulairePanelFP, gbcFP, "Date d'expiration *");
        addLabeledField(formulairePanelFP, gbcFP, "CVC *");

        formulairePaiement.add(formulairePanelFP, BorderLayout.CENTER);

        conteneurFormulaires.add(formulairePaiement, gbcCF);



        /// FIN FORMULAIRE PAIEMENT
        /// -----------------------------------------------------------------------------------

        gbcCF.gridy++;
        JPanel espaceVide3CF = new JPanel();
        espaceVide3CF.setBackground(Color.white);
        espaceVide3CF.setPreferredSize(new Dimension(700, 25));
        conteneurFormulaires.add(espaceVide3CF, gbcCF);

        gbcCF.gridy++;
        JPanel annulationCF = new JPanel();
        annulationCF.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        annulationCF.setBackground(Color.white);
        annulationCF.setPreferredSize(new Dimension(810, 70));
        annulationCF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JPanel espaceVideAnnulationCF = new JPanel();
        espaceVideAnnulationCF.setBackground(Color.white);
        espaceVideAnnulationCF.setPreferredSize(new Dimension(700, 17));
        annulationCF.add(espaceVideAnnulationCF);

        JTextArea infoAnnulationCF = new JTextArea("Bonne nouvelle ! Vous pouvez modifier votre programme grâce à l’annulation gratuite\njusqu’à 48 heures avant le retrait du véhicule.");
        infoAnnulationCF.setForeground(Color.black);
        infoAnnulationCF.setEditable(false);
        infoAnnulationCF.setFont(new Font("Georgia", Font.BOLD, 15));
        infoAnnulationCF.setAlignmentX(SwingConstants.LEFT);
        infoAnnulationCF.setAlignmentY(SwingConstants.CENTER);
        annulationCF.add(infoAnnulationCF);

        conteneurFormulaires.add(annulationCF, gbcCF);

        gbcCF.gridy++;
        gbcCF.weighty = 5;
        gbcCF.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc4CF = new JPanel();
        espaceBlanc4CF.setBackground(Color.white);
        conteneurFormulaires.add(espaceBlanc4CF, gbcCF);

        /// FIN CONTENEUR FORMULAIRES
        /// -----------------------------------------------------------------///


        JPanel englobeurCF = new JPanel();
        englobeurCF.setBackground(Color.white);
        englobeurCF.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        englobeurCF.add(conteneurFormulaires);

        JPanel panelConf = new JPanel();
        panelConf.setBackground(Color.white);
        panelConf.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;

        JButton confirmation = new JButton("Confirmer la réservation");
        confirmation.setPreferredSize(new Dimension(500, 45));
        confirmation.setFont(new Font("Georgia", Font.BOLD, 16));
        confirmation.setForeground(Color.white);
        confirmation.setBackground(Color.decode("#7E3DFF"));

        panelConf.add(confirmation, gbc);

        gbc.gridy++;
        JPanel ebz = new JPanel();
        ebz.setBackground(Color.white);
        ebz.setPreferredSize(new Dimension(1000, 20));
        panelConf.add(ebz, gbc);

        pagePrincipale.add(progressionDetails, BorderLayout.NORTH);
        pagePrincipale.add(conteneurDroite, BorderLayout.EAST);
        pagePrincipale.add(englobeurCF, BorderLayout.CENTER);
        pagePrincipale.add(panelConf, BorderLayout.SOUTH);

        confirmation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifier que tous les champs sont remplis


                if (((JTextField) formulairePanelFC.getComponent(0)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Prénom est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFC.getComponent(2)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Nom est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFC.getComponent(4)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ E-mail est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFC.getComponent(6)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Téléphone est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                /*if (((JTextField) formulairePanelFC.getComponent(8)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Pays/Région est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFC.getComponent(10)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Ville est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFC.getComponent(12)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Adresse est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }*/
                if (((JTextField) formulairePanelFP.getComponent(0)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Nom figurant sur la carte est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFP.getComponent(2)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Numéro de la carte est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }/*
                if (((JTextField) formulairePanelFP.getComponent(4)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ Date d'expiration est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (((JTextField) formulairePanelFP.getComponent(6)).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Le champ CVC est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }*/


                try {
                    VoitureController voitureController = new VoitureController();
                    //voitureController.ChangeDate_debut_fin_loc()
                    //voitureController.ajouterNouvelleVoiture(voiture.getId_plaque(), voiture.getnom_modele(), voiture.getType(), voiture.getCouleur(), voiture.getMoteur(), voiture.getNbPlace(), voiture.getCapaciteValise(), voiture.getNbPorte(), voiture.getTransmission(), voiture.getCapaEssence(), voiture.getAnnee(), voiture.getkilometrage_actuel(), )
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                //FrameConfirmation frameConfirmation = new FrameConfirmation(voiture, res, client);
                InterfacePayement interfacePayement = new InterfacePayement(ConteneurPrincipal.this, voiture, res, client);

                // Obtenez la fenêtre actuelle à partir du composant parent du bouton
                Window window = SwingUtilities.getWindowAncestor(confirmation);


            }
        });

        return pagePrincipale;
    }
}
