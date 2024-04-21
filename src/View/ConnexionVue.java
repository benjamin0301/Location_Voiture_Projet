package View;

import Controler.ClientController;
import Controler.EmployeController;
import Model.ClientModel;
import Model.EmployeModel;
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
    public EmployeController employeController;
    private ClientModel client;
    private EmployeModel employe;

    public ConnexionVue() throws SQLException, ClassNotFoundException {
        this.clientcontroller = new ClientController();
        this.employeController = new EmployeController();
        this.client = new ClientModel();
        this.employe = new EmployeModel();

        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut(1);
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
                int userType = 0;
                try {
                    userType = authenticate(email, password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (userType == 0) {
                    // C'est un client, redirigez vers la vue client
                    // ...
                    JOptionPane.showMessageDialog(ConnexionVue.this, "Connexion réussie !");
                    ConnexionVue.this.setVisible(false);
                    try {
                        String lieuDepart = ""; // Fournir la valeur appropriée
                        String dateDepart = ""; // Fournir la valeur appropriée
                        String lieuRetour = ""; // Fournir la valeur appropriée
                        String dateRetour = ""; // Fournir la valeur appropriée

                        Vue vue = new Vue(client);


                        vue.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }



                } else if (userType == 3) {
                    // C'est un employé, redirigez vers la vue employé
                    // ...
                    JOptionPane.showMessageDialog(ConnexionVue.this, "Connexion réussie !");
                    ConnexionVue.this.setVisible(false);
                    try {
                        String lieuDepart = ""; // Fournir la valeur appropriée
                        String dateDepart = ""; // Fournir la valeur appropriée
                        String lieuRetour = ""; // Fournir la valeur appropriée
                        String dateRetour = ""; // Fournir la valeur appropriée

                        VueEmploye vp = new VueEmploye(employe);


                        vp.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Erreur de base de données : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ConnexionVue.this), "Classe introuvable : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // La connexion a échoué, affichez un message d'erreur
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
        int userType = 5;
        try {
            int idEmploye = Integer.parseInt(email);
            userType = 3;
            employe = employeController.verifierConnexionEmploye(idEmploye, password);
        } catch (NumberFormatException e) {
            client = clientcontroller.verifierConnexionClient(email, password);
            System.out.println("test du client number 2" + client.getId_client());
            userType = 0;
        }
        return userType;
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
