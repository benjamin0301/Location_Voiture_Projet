package View;

import Controler.ClientController;
import Controler.EmployeController;
import Model.ClientModel;
import Model.EmployeModel;
import View.PageResultats.ConteneurHaut;
import View.popup.popUpConnexion;
import View.popup.popUpDefault;
import View.popup.popUpReservation;

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

    public ConnexionVue(String lieuDepart, String dateDepart, String lieuRetour, String dateRetour) throws SQLException, ClassNotFoundException {
        this.clientcontroller = new ClientController();
        this.employeController = new EmployeController();
        this.client = new ClientModel();
        this.employe = new EmployeModel();

        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut(1, client, lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        add(conteneurHaut, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(200, 30));
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30));

        loginButton = new JButton("Se connecter");
        loginButton.setFont(new Font("Georgia", Font.BOLD, 20));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.decode("#7E3DFF"));

        createAccountButton = new JButton("Créer un compte");
        createAccountButton.setFont(new Font("Georgia", Font.BOLD, 20));
        createAccountButton.setForeground(Color.decode("#7E3DFF"));
        createAccountButton.setBackground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(email, gbc);

        gbc.gridy = 1;
        panel.add(emailField, gbc);

        gbc.gridy++;
        JLabel mdp = new JLabel("Mot de passe :");
        mdp.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(mdp, gbc);

        gbc.gridy++;
        panel.add(passwordField, gbc);

        gbc.gridy++;
        JPanel espaceVide1 = new JPanel();
        espaceVide1.setPreferredSize(new Dimension(200, 15));
        panel.add(espaceVide1, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        gbc.gridy++;
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

                    //popUpConnexion customDialog = new popUpConnexion(ConnexionVue.this);
                    //customDialog.setVisible(true);

                    popUpDefault popUpDefault = new popUpDefault(ConnexionVue.this, "Connexion réussie !");
                    popUpDefault.setVisible(true);

                    ConnexionVue.this.setVisible(false);
                    try {


                        Vue vue = new Vue(client);


                        vue.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);

                    }
                    catch (SQLException ex)
                    {
                        popUpDefault erreur1 = new popUpDefault(ConnexionVue.this, "Erreur de base de données : " + ex.getMessage());
                        erreur1.setVisible(true);
                    }
                    catch (ClassNotFoundException ex)
                    {
                        popUpDefault erreur2 = new popUpDefault(ConnexionVue.this, "Classe introuvable : " + ex.getMessage());
                        erreur2.setVisible(true);
                    }



                } else if (userType == 3) {
                    // C'est un employé, redirigez vers la vue employé
                    // ...
                    popUpDefault popUpEmp = new popUpDefault(ConnexionVue.this, "Connexion réussie !");
                    popUpEmp.setVisible(true);
                    ConnexionVue.this.setVisible(false);
                    try {
                        String lieuDepart = ""; // Fournir la valeur appropriée
                        String dateDepart = ""; // Fournir la valeur appropriée
                        String lieuRetour = ""; // Fournir la valeur appropriée
                        String dateRetour = ""; // Fournir la valeur appropriée

                        VueEmploye vp = new VueEmploye(employe);


                        vp.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);

                    } catch (SQLException ex)
                    {
                        popUpDefault erreur1emp = new popUpDefault(ConnexionVue.this, "Erreur de base de données : " + ex.getMessage());
                        erreur1emp.setVisible(true);
                    }
                    catch (ClassNotFoundException ex)
                    {
                        popUpDefault erreur2 = new popUpDefault(ConnexionVue.this, "Classe introuvable : " + ex.getMessage());
                        erreur2.setVisible(true);                    }
                } else
                {
                    // La connexion a échoué, affichez un message d'erreur
                    popUpDefault erreurMailMDP = new popUpDefault(ConnexionVue.this, "Email ou mot de passe incorrect, veuillez réessayer ou créer un compte.");
                    erreurMailMDP.setVisible(true);
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnexionVue.this.setVisible(false);
                // Créer une nouvelle instance de la fenêtre d'inscription et la rendre visible
                try {
                    Inscription inscription = new Inscription(client, lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
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

}