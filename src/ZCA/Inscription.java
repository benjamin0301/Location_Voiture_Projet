package ZCA;

import Controler.ClientController;
import Model.ClientModel;


import ZCA.page_principale.ConteneurHaut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

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

    public Inscription() throws SQLException, ClassNotFoundException {
        this.clientcontroller = new ClientController();

        setTitle("Inscription");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut();
        add(conteneurHaut, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        prenomField = new JTextField(20);
        nomField = new JTextField(20);
        emailField = new JTextField(20);
        motDePasseField = new JPasswordField(20);
        confirmationMotDePasseField = new JPasswordField(20);
        dateDeNaissanceField = new JTextField(20);
        inscriptionButton = new JButton("S'inscrire");
        retourButton = new JButton("Retour");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Prénom:"), gbc);

        gbc.gridy = 1;
        panel.add(prenomField, gbc);

        gbc.gridy = 2;
        panel.add(new JLabel("Nom:"), gbc);

        gbc.gridy = 3;
        panel.add(nomField, gbc);

        gbc.gridy = 4;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridy = 5;
        panel.add(emailField, gbc);

        gbc.gridy = 6;
        panel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridy = 7;
        panel.add(motDePasseField, gbc);

        gbc.gridy = 8;
        panel.add(new JLabel("Confirmer le mot de passe:"), gbc);

        gbc.gridy = 9;
        panel.add(confirmationMotDePasseField, gbc);

        gbc.gridy = 10;
        panel.add(new JLabel("Date de naissance (AAAA-MM-JJ):"), gbc);

        gbc.gridy = 11;
        panel.add(dateDeNaissanceField, gbc);

        gbc.gridy = 12;
        gbc.gridwidth = 2;
        panel.add(inscriptionButton, gbc);

        gbc.gridy = 13;
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
                    PhraseRecue = clientcontroller.getPhrase();
                    System.out.println(PhraseRecue);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if (PhraseRecue == "Toutes les données sont valides") {
                    JOptionPane.showMessageDialog(Inscription.this, "Inscription réussie !");
                    // Rediriger vers la page de connexion
                } else {
                    JOptionPane.showMessageDialog(Inscription.this, "Erreur lors de l'inscription. Veuillez réessayer.");
                }




            }
        });


        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Rediriger vers la page de connexion
                // Vous pouvez remplacer cette partie par la redirection vers votre interface de connexion
                JOptionPane.showMessageDialog(Inscription.this, "Redirection vers la connexion");
            }
        });

        add(panel, BorderLayout.CENTER);
    }

    // Méthode pour enregistrer l'utilisateur dans la base de données


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Inscription().setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur de base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Classe introuvable : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
