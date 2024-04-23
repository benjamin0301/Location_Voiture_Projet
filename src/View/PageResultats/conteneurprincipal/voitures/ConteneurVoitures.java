package View.PageResultats.conteneurprincipal.voitures;

import Controler.VoitureController;
import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConteneurVoitures extends JPanel
{
    public ClientModel clientModel;

    public ConteneurVoitures(ClientModel client, int res, int nbjour,String lieuDepart, String dateDepart, String lieuRetour, String dateRetour) throws SQLException, ClassNotFoundException
    {

        VoitureController voitureController = new VoitureController();
        VoitureModel voitureModel = new VoitureModel();

        this.clientModel = client;
        ListeVoitures listeVoitures = new ListeVoitures(clientModel);
        ArrayList<VoitureModel> listeVoituresPourAffichage = new ArrayList<>();
        listeVoituresPourAffichage = voitureController.recupListeVoitureNonLouee();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JPanel espaceBlanco = new JPanel();
        espaceBlanco.setBackground(Color.white);
        espaceBlanco.setPreferredSize(new Dimension(500, 15));
        add(espaceBlanco, gbc);

        gbc.gridy++;
        JPanel messageContainer = new JPanel(new BorderLayout());
        messageContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));
        JPanel messageIndicatif = new JPanel();
        messageIndicatif.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        messageIndicatif.setPreferredSize(new Dimension(2, 50));
        messageIndicatif.setBackground(Color.decode("#F5FFF4"));
        messageIndicatif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#25991B")));
        JTextArea areaMI = new JTextArea("Bonne nouvelle ! Annulation flexible pour chaque réservation.");
        areaMI.setBackground(Color.decode("#F5FFF4"));
        areaMI.setEditable(false);
        areaMI.setFont(new Font("Georgia", Font.BOLD, 14));
        areaMI.setForeground(Color.decode("#25991B"));
        messageIndicatif.add(areaMI);
        messageContainer.add(messageIndicatif, BorderLayout.CENTER);
        add(messageContainer, gbc);


        gbc.gridy++;
        JPanel messageAlerteContainer = new JPanel(new BorderLayout());
        messageAlerteContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));
        JPanel messageAlerte = new JPanel();
        messageAlerte.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        messageAlerte.setPreferredSize(new Dimension(2, 50));
        messageAlerte.setBackground(Color.decode("#FFF7F2"));
        messageAlerte.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#FF3D00")));
        JTextArea areaMA = new JTextArea("Mauvaise nouvelle ! Il y a une forte demande à Paris en avril. Les prix risquent d'augmenter.");
        areaMA.setBackground(Color.decode("#FFF7F2"));
        areaMA.setEditable(false);
        areaMA.setFont(new Font("Georgia", Font.BOLD, 14));
        areaMA.setForeground(Color.decode("#FF3D00"));
        messageAlerte.add(areaMA);
        messageAlerteContainer.add(messageAlerte, BorderLayout.CENTER);
        add(messageAlerteContainer, gbc);


        gbc.gridy++;
        CarouselVoitures carouselVoitures = new CarouselVoitures(listeVoituresPourAffichage, res, nbjour,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        add(carouselVoitures, gbc);


        gbc.gridy++;
        NbVoituresDispo nbVoituresDispo = new NbVoituresDispo();
        add(nbVoituresDispo, gbc);


        gbc.gridy++;


        listeVoitures.afficherListeVoitures(listeVoituresPourAffichage, 1, res, nbjour,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        add(listeVoitures, gbc);


        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }

    public ConteneurVoitures(ClientModel client, int res, ArrayList<VoitureModel> newliste, int nbjour, String lieuDepart, String dateDepart, String lieuRetour, String dateRetour) throws SQLException, ClassNotFoundException
    {
        VoitureController voitureController = new VoitureController();
        VoitureModel voitureModel = new VoitureModel();

        this.clientModel = client;
        ListeVoitures listeVoitures = new ListeVoitures(clientModel);
        ArrayList<VoitureModel> listeVoituresPourAffichage = new ArrayList<>();
        System.out.println("je suis dans le prochain controller");
        listeVoituresPourAffichage = newliste;


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JPanel espaceBlanco = new JPanel();
        espaceBlanco.setBackground(Color.white);
        espaceBlanco.setPreferredSize(new Dimension(500, 15));
        add(espaceBlanco, gbc);

        gbc.gridy++;
        JPanel messageContainer = new JPanel(new BorderLayout());
        messageContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));
        JPanel messageIndicatif = new JPanel();
        messageIndicatif.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        messageIndicatif.setPreferredSize(new Dimension(2, 50));
        messageIndicatif.setBackground(Color.decode("#F5FFF4"));
        messageIndicatif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#25991B")));
        JTextArea areaMI = new JTextArea("Bonne nouvelle ! Annulation flexible pour chaque réservation.");
        areaMI.setBackground(Color.decode("#F5FFF4"));
        areaMI.setEditable(false);
        areaMI.setFont(new Font("Georgia", Font.BOLD, 14));
        areaMI.setForeground(Color.decode("#25991B"));
        messageIndicatif.add(areaMI);
        messageContainer.add(messageIndicatif, BorderLayout.CENTER);
        add(messageContainer, gbc);


        gbc.gridy++;
        JPanel messageAlerteContainer = new JPanel(new BorderLayout());
        messageAlerteContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));
        JPanel messageAlerte = new JPanel();
        messageAlerte.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        messageAlerte.setPreferredSize(new Dimension(2, 50));
        messageAlerte.setBackground(Color.decode("#FFF7F2"));
        messageAlerte.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#FF3D00")));
        JTextArea areaMA = new JTextArea("Mauvaise nouvelle ! Il y a une forte demande à Paris en avril. Les prix risquent d'augmenter.");
        areaMA.setBackground(Color.decode("#FFF7F2"));
        areaMA.setEditable(false);
        areaMA.setFont(new Font("Georgia", Font.BOLD, 14));
        areaMA.setForeground(Color.decode("#FF3D00"));
        messageAlerte.add(areaMA);
        messageAlerteContainer.add(messageAlerte, BorderLayout.CENTER);
        add(messageAlerteContainer, gbc);


        gbc.gridy++;
        CarouselVoitures carouselVoitures = new CarouselVoitures(newliste, res, nbjour,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        add(carouselVoitures, gbc);


        gbc.gridy++;
        NbVoituresDispo nbVoituresDispo = new NbVoituresDispo();
        add(nbVoituresDispo, gbc);


        gbc.gridy++;

        System.out.println(listeVoituresPourAffichage.getFirst().getCouleur());
        listeVoitures.afficherListeVoitures(listeVoituresPourAffichage, 1, res, nbjour,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
        add(listeVoitures, gbc);


        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }


}
