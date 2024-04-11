package ZCA;

import Controler.ClientController;
import Model.ClientModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MesInfosPerso extends JPanel
{
    ClientController clientController = new ClientController();
    ClientModel clientModel = new ClientModel();
    public MesInfosPerso() throws SQLException, ClassNotFoundException {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setPreferredSize(new Dimension(40, 400));

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        JLabel titre = new JLabel("Mes informations personnelles");
        titre.setPreferredSize(new Dimension(1000, 30));
        titre.setFont(new Font("Aleo", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1000, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JLabel nom = new JLabel("Nom : " + clientModel.getNom());
        add(nom);

        JLabel prenom = new JLabel("Prénom : " + clientModel.getPrenom());
        add(prenom);

        JLabel id = new JLabel("ID : " + clientModel.getId_client());
        add(id);

        JLabel mail = new JLabel("E-mail : " + clientModel.getMail());
        add(mail);

        JLabel mdp = new JLabel("Mot de passe : " + clientModel.getMotDePasse());
        add(mdp);

        JLabel ddn = new JLabel("Date de naissance : " + clientModel.getDateNaissance());
        add(ddn);

        JLabel fidelite = new JLabel("Client fidèle : " + clientModel.isFidelite());
        add(fidelite);
    }
}
