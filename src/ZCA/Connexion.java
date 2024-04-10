package ZCA;

import Model.ClientModel;
import ZCA.page_principale.ConteneurHaut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class
Connexion extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;

    public ClientModel clientmodel;

    public Connexion() throws SQLException, ClassNotFoundException {
        this.clientmodel = new ClientModel();

        setTitle("Connexion");
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
                int isConnected = authenticate(email, password);
                if (isConnected == 0) {
                    // Afficher l'interface de connexion
                    // Vous pouvez remplacer cette partie par l'affichage de votre interface de connexion
                    JOptionPane.showMessageDialog(Connexion.this, "Connexion réussie !");
                } else if (isConnected == 1) {
                    // Afficher un message d'erreur
                    JOptionPane.showMessageDialog(Connexion.this, "Email ou mot de passe incorrect, veuillez réessayer ou créer un compte.");
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Rediriger vers la création de compte
                // Vous pouvez remplacer cette partie par la redirection vers votre interface de création de compte
                JOptionPane.showMessageDialog(Connexion.this, "Redirection vers la création de compte");
            }
        });

        add(panel, BorderLayout.CENTER);
    }

    // Méthode pour authentifier l'utilisateur en utilisant le programme xxxx
    private int authenticate(String email, String password) {
        // Appel à votre programme xxxx avec les informations d'authentification
        // Ici, vous devrez appeler le programme xxxx et obtenir la réponse
        // Pour cet exemple, je suppose que le programme retourne true si l'authentification réussit et false sinon
        // Vous devez remplacer ce code par l'appel réel à votre programme xxxx
        int isConnected = clientmodel.verif_connexion_client(email, password);
        // Exemple fictif :
        //isConnected = MyApp.authenticate(email, password);
        return isConnected;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Connexion().setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
