package View.PageEspacePersonnel;

import Model.ClientModel;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MesInfosPerso extends JPanel
{
    ClientModel client = new ClientModel();
    public MesInfosPerso(ClientModel client) throws SQLException, ClassNotFoundException
    {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setPreferredSize(new Dimension(40, 300));

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        JLabel titre = new JLabel("Mes informations personnelles");
        titre.setPreferredSize(new Dimension(1000, 30));
        titre.setFont(new Font("Georgia", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1000, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.white);
        espaceVideB.setPreferredSize(new Dimension(700, 10));
        add(espaceVideB);

        JPanel englobulle = new JPanel();
        englobulle.setPreferredSize(new Dimension(1050, 220));
        englobulle.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 1;

        JPanel panelA = new JPanel();
        panelA.setPreferredSize(new Dimension(400, 220));
        panelA.setBackground(Color.white);

        JPanel ebj = new JPanel();
        ebj.setBackground(Color.white);
        ebj.setPreferredSize(new Dimension(380, 30));
        panelA.add(ebj);

        JLabel prenom = new JLabel("Votre prénom : " + client.getPrenom());
        prenom.setPreferredSize(new Dimension(300, 45));
        prenom.setFont(new Font("Georgia", Font.PLAIN, 20));
        panelA.add(prenom);

        JLabel nom = new JLabel("Votre nom : " + client.getNom());
        nom.setPreferredSize(new Dimension(300, 45));
        nom.setFont(new Font("Georgia", Font.PLAIN, 20));
        panelA.add(nom);

        JLabel dn = new JLabel("Vous êtes né le " + client.getDateNaissance());
        dn.setPreferredSize(new Dimension(300, 45));
        dn.setFont(new Font("Georgia", Font.PLAIN, 20));
        panelA.add(dn);

        englobulle.add(panelA, gbc);

        gbc.gridx++;
        JSeparator sep1 = new JSeparator(SwingConstants.VERTICAL);
        sep1.setPreferredSize(new Dimension(2, 200));
        sep1.setForeground(Color.BLACK);
        englobulle.add(sep1, gbc);

        gbc.gridx++;
        JPanel panelB = new JPanel();
        panelB.setPreferredSize(new Dimension(398, 220));
        panelB.setBackground(Color.white);

        JPanel ebs = new JPanel();
        ebs.setBackground(Color.white);
        ebs.setPreferredSize(new Dimension(380, 30));
        panelB.add(ebs);

        JLabel id = new JLabel("Votre ID : " + client.getId_client());
        id.setPreferredSize(new Dimension(300, 45));
        id.setFont(new Font("Georgia", Font.PLAIN, 20));
        panelB.add(id);

        JLabel mail = new JLabel("Votre e-mail : " + client.getMail());
        mail.setPreferredSize(new Dimension(300, 45));
        mail.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelB.add(mail);

        JLabel mdp = new JLabel("Votre mot de passe : " + client.getMotDePasse());
        mdp.setPreferredSize(new Dimension(300, 45));
        mdp.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelB.add(mdp);

        englobulle.add(panelB, gbc);

        gbc.gridx++;
        JSeparator sep2 = new JSeparator(SwingConstants.VERTICAL);
        sep2.setPreferredSize(new Dimension(2, 200));
        sep2.setForeground(Color.BLACK);
        englobulle.add(sep2, gbc);

        gbc.gridx++;
        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(248, 220));
        panelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelC.setBackground(Color.white);

        JPanel ebr = new JPanel();
        ebr.setBackground(Color.white);
        ebr.setPreferredSize(new Dimension(380, 30));
        panelC.add(ebr);

        JLabel CF = new JLabel("Niveau de fidélité :");
        CF.setPreferredSize(new Dimension(200, 70));
        CF.setHorizontalAlignment(SwingConstants.CENTER);
        CF.setFont(new Font("Georgia", Font.PLAIN, 23));
        panelC.add(CF);

        JLabel CFR = new JLabel(String.valueOf(client.isFidelite()));
        CFR.setPreferredSize(new Dimension(60, 30));
        CFR.setHorizontalAlignment(SwingConstants.CENTER);
        CFR.setForeground(Color.decode("#7E3DFF"));
        CFR.setFont(new Font("Georgia", Font.BOLD, 21));
        panelC.add(CFR);

        englobulle.add(panelC, gbc);


        add(englobulle);


        /*

        JLabel id = new JLabel("ID : " + clientModel.getId_client());
        add(id);

        JLabel mail = new JLabel("E-mail : " + clientModel.getMail());
        add(mail);

        JLabel mdp = new JLabel("Mot de passe : " + clientModel.getMotDePasse());
        add(mdp);

        JLabel ddn = new JLabel("Date de naissance : " + clientModel.getDateNaissance());
        add(ddn);

        JLabel fidelite = new JLabel("Client fidèle : " + clientModel.isFidelite());
        add(fidelite);*/
    }
}
