package View;

import Controler.ClientController;
import Model.ClientModel;


import View.PageResultats.ConteneurHaut;
import com.mysql.cj.xdevapi.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Inscription extends JFrame {

    private JTextField prenomField;
    private JTextField nomField;
    private JTextField emailField;
    private JPasswordField motDePasseField;
    private JPasswordField confirmationMotDePasseField;
    private JTextField dateDeNaissanceField;
    private JButton inscriptionButton;
    private JButton retourButton;

    private ClientController clientcontroller;
    private ClientModel client;

    public Inscription(ClientModel clientModel) throws SQLException, ClassNotFoundException {
        this.clientcontroller = new ClientController();
        this.client = clientModel;

        setTitle("Inscription");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 600);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        prenomField = new JTextField(20);
        prenomField.setPreferredSize(new Dimension(300, 30));
        nomField = new JTextField(20);
        nomField.setPreferredSize(new Dimension(300, 30));
        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(300, 30));
        motDePasseField = new JPasswordField(20);
        motDePasseField.setPreferredSize(new Dimension(300, 30));
        confirmationMotDePasseField = new JPasswordField(20);
        confirmationMotDePasseField.setPreferredSize(new Dimension(300, 30));
        dateDeNaissanceField = new JTextField(20);
        dateDeNaissanceField.setPreferredSize(new Dimension(300, 30));

        inscriptionButton = new JButton("S'inscrire");
        inscriptionButton.setFont(new Font("Georgia", Font.BOLD, 20));
        inscriptionButton.setForeground(Color.white);
        inscriptionButton.setBackground(Color.decode("#7E3DFF"));

        retourButton = new JButton("Retour");
        retourButton.setFont(new Font("Georgia", Font.BOLD, 20));
        retourButton.setForeground(Color.decode("#7E3DFF"));
        retourButton.setBackground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel prenom = new JLabel("Prénom :");
        prenom.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(prenom, gbc);

        gbc.gridy = 1;
        panel.add(prenomField, gbc);

        gbc.gridy = 2;
        JLabel nom = new JLabel("Nom :");
        nom.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(nom, gbc);

        gbc.gridy = 3;
        panel.add(nomField, gbc);

        gbc.gridy = 4;
        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(email, gbc);

        gbc.gridy = 5;
        panel.add(emailField, gbc);

        gbc.gridy = 6;
        JLabel mdp = new JLabel("Mot de passe :");
        mdp.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(mdp, gbc);

        gbc.gridy = 7;
        panel.add(motDePasseField, gbc);

        gbc.gridy = 8;
        JLabel cmdp = new JLabel("Confirmer le mot de passe :");
        cmdp.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(cmdp, gbc);

        gbc.gridy = 9;
        panel.add(confirmationMotDePasseField, gbc);

        gbc.gridy = 10;
        JLabel ddn = new JLabel("Date de naissance (AAAA-MM-JJ) :");
        ddn.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(ddn, gbc);

        gbc.gridy = 11;
        panel.add(dateDeNaissanceField, gbc);

        gbc.gridy++;
        JPanel espaceBlanc1 = new JPanel();
        espaceBlanc1.setPreferredSize(new Dimension(300, 20));
        panel.add(espaceBlanc1, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(inscriptionButton, gbc);

        gbc.gridy++;
        panel.add(retourButton, gbc);

        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenom = prenomField.getText();
                String nom = nomField.getText();
                String email = emailField.getText();
                String motDePasse = new String(motDePasseField.getPassword());
                String confirmationMotDePasse = new String(confirmationMotDePasseField.getPassword());
                String dateDeNaissanceText = dateDeNaissanceField.getText();


                if (!motDePasse.equals(confirmationMotDePasse)) {
                    JOptionPane.showMessageDialog(Inscription.this, "Les mots de passe ne correspondent pas.");
                    return;
                }

                // Create a new ClientModel instance using the input fields
                String PhraseRecue = null;
                try {
                    ClientModel client = clientcontroller.ajouterNouveauClient(prenom, nom, motDePasse, email, dateDeNaissanceText);
                    PhraseRecue = clientcontroller.Phrase_de_reponse;
                    System.out.println(PhraseRecue);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if (PhraseRecue != null && PhraseRecue.equals("Toutes les données sont valides")) {
                    JOptionPane.showMessageDialog(Inscription.this, "Inscription réussie !");

                    // Masquer la fenêtre d'inscription actuelle
                    Inscription.this.setVisible(false);

                    // Créer une nouvelle instance de la fenêtre ConnexionVue et la rendre visible
                    try {
                        ConnexionVue connexionVue = new ConnexionVue();
                        connexionVue.setVisible(true);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Inscription.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Inscription.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }

                else {
                    JOptionPane.showMessageDialog(Inscription.this, "Erreur lors de l'inscription. Veuillez réessayer.");
                }




            }
        });


        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the current Inscription window
                Inscription.this.setVisible(false);

                // Create a new instance of the ConnexionVue window and make it visible
                try {
                    ConnexionVue connexionVue = new ConnexionVue();
                    connexionVue.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Inscription.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(Inscription.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        add(panel, BorderLayout.CENTER);
    }

    // Méthode pour enregistrer l'utilisateur dans la base de données


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Inscription(new ClientModel()).setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur de base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Classe introuvable : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
