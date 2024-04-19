package View;

import Controler.ClientController;
import View.PageResultats.ConteneurHaut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ConnexionVue extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;

    public ClientController clientcontroller;

    public ConnexionVue() throws SQLException, ClassNotFoundException {
        this.clientcontroller = new ClientController();

        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut();
        add(conteneurHaut, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Se connecter");
        createAccountButton = new JButton("Créer un compte");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridy = 1;
        panel.add(emailField, gbc);

        gbc.gridy = 2;
        panel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridy = 3;
        panel.add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        gbc.gridy = 5;
        panel.add(createAccountButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                int isConnected = 0;
                try {
                    isConnected = authenticate(email, password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (isConnected == 0) {
                    // Afficher l'interface de connexion
                    // Vous pouvez remplacer cette partie par l'affichage de votre interface de connexion
                    JOptionPane.showMessageDialog(ConnexionVue.this, "Connexion réussie !");

                    // Masquer la fenêtre de connexion actuelle
                    ConnexionVue.this.setVisible(false);

                    // Créer une nouvelle instance de la classe Vue et appeler la méthode initialize
                    try {
                        String lieuDepart = ""; // Fournir la valeur appropriée
                        String dateDepart = ""; // Fournir la valeur appropriée
                        String lieuRetour = ""; // Fournir la valeur appropriée
                        String dateRetour = ""; // Fournir la valeur appropriée

                        Vue vue = new Vue();


                        vue.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (isConnected == 1 || isConnected == 2) {
                    // Afficher un message d'erreur
                    JOptionPane.showMessageDialog(ConnexionVue.this, "Email ou mot de passe incorrect, veuillez réessayer ou créer un compte.");
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnexionVue.this.setVisible(false);
                // Créer une nouvelle instance de la fenêtre d'inscription et la rendre visible
                try {
                    Inscription inscription = new Inscription();
                    inscription.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel, BorderLayout.CENTER);
    }

    // Méthode pour authentifier l'utilisateur en utilisant le programme xxxx
    private int authenticate(String email, String password) throws SQLException, ClassNotFoundException {
        // Appel à votre programme xxxx avec les informations d'authentification
        // Ici, vous devrez appeler le programme xxxx et obtenir la réponse
        // Pour cet exemple, je suppose que le programme retourne true si l'authentification réussit et false sinon
        // Vous devez remplacer ce code par l'appel réel à votre programme xxxx
        int isConnected = clientcontroller.verifierConnexionClient(email, password);
        // Exemple fictif :
        //isConnected = MyApp.authenticate(email, password);
        return isConnected;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ConnexionVue().setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}