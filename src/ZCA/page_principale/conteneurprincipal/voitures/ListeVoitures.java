package ZCA.page_principale.conteneurprincipal.voitures;

import Controler.ClientController;
import Controler.VoitureController;
import Model.Connexion;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeVoitures extends JPanel
{
    private ArrayList<VoitureModel> voitures;
    private ClientController clientcontroller;
    private VoitureController voiturecontroller;

    private Connexion connexion;
    public ListeVoitures() throws SQLException, ClassNotFoundException {

        VoitureController voiturecontroller = new VoitureController();


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ArrayList<VoitureModel> listeVoitures = voiturecontroller.recupListeVoiture();

        /// PANEL DU CYBERTRUCK

        JPanel panelCybertruck = new JPanel();
        panelCybertruck.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panelCybertruck.setPreferredSize(new Dimension(2, 300));
        panelCybertruck.setBackground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;

        JPanel panelA = new JPanel();
        panelA.setLayout(new FlowLayout());
        panelA.setPreferredSize(new Dimension(205, 300));
        panelA.setBackground(Color.decode("#FFFFFF"));
        panelA.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.lightGray));

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(200, 5));
        panelA.add(espaceVideA);

        /*JTextArea AType = new JTextArea("  " + listeVoitures.get(8).getType());
        AType.setLayout(new BorderLayout());
        AType.setPreferredSize(new Dimension(200, 25));
        AType.setEditable(false);
        AType.setFocusable(false);
        AType.setFont(new Font("Aleo", Font.BOLD, 17));
        panelA.add(AType, BorderLayout.WEST);*/

        JTextArea AModele = new JTextArea("  " + listeVoitures.get(8).getMarque() + " " + listeVoitures.get(8).getnom_modele());
        AModele.setLayout(new BorderLayout());
        AModele.setPreferredSize(new Dimension(200, 20));
        AModele.setFont(new Font("Aleo", Font.PLAIN, 15));
        panelA.add(AModele, BorderLayout.WEST);

        ImageIcon AImage = new ImageIcon("images\\Cybertruck-Dimensionné.png");
        JLabel imageLabel = new JLabel(AImage);
        panelA.add(imageLabel);

        JTextArea ACapacite = new JTextArea("    " + listeVoitures.get(8).getNbPlace() + " 👤 | " + listeVoitures.get(8).getCapaciteValise() + " 👜 | " + listeVoitures.get(8).getNbPorte() + " 🚪");
        ACapacite.setLayout(new BorderLayout());
        ACapacite.setPreferredSize(new Dimension(200, 40));
        ACapacite.setFont(new Font("Aleo", Font.BOLD, 20));
        panelA.add(ACapacite, BorderLayout.EAST);

        JTextArea AAvantages = new JTextArea("    ✅ Moteur " + listeVoitures.get(8).getMoteur() + "\n    ✅ Boîte " + listeVoitures.get(8).getTransmission());
        AAvantages.setLayout(new BorderLayout());
        AAvantages.setPreferredSize(new Dimension(200, 50));
        AAvantages.setFont(new Font("Aleo", Font.PLAIN, 13));
        panelA.add(AAvantages, BorderLayout.WEST);

        panelCybertruck.add(panelA, gbc);

        gbc.gridx++;

        JPanel panelB = new JPanel();
        panelB.setPreferredSize(new Dimension(205, 300));
        panelB.setBackground(Color.decode("#F6F6F6"));
        panelB.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));
        panelCybertruck.add(panelB, gbc);

        gbc.gridx++;

        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(205, 300));
        panelC.setBackground(Color.decode("#F6F6F6"));
        panelC.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));
        panelCybertruck.add(panelC, gbc);

        gbc.gridx++;

        JPanel panelD = new JPanel();
        panelD.setPreferredSize(new Dimension(205, 300));
        panelD.setBackground(Color.decode("#E2FFD6"));
        panelD.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.lightGray));
        panelCybertruck.add(panelD, gbc);


        add(panelCybertruck);

        /// FIN PANEL CYBERTRUCK

        JPanel miniEspaceBlanc = new JPanel();
        miniEspaceBlanc.setPreferredSize(new Dimension(2, 15));
        miniEspaceBlanc.setBackground(Color.WHITE);
        add(miniEspaceBlanc);

        JPanel panelTesla = new JPanel();
        panelTesla.setPreferredSize(new Dimension(2, 300));
        panelTesla.setBackground(Color.orange);
        add(panelTesla);

        JPanel panelBugatti = new JPanel();
        panelBugatti.setPreferredSize(new Dimension(2, 300));
        panelBugatti.setBackground(Color.darkGray);
        add(panelBugatti);

        JPanel panelLotus = new JPanel();
        panelLotus.setPreferredSize(new Dimension(2, 300));
        panelLotus.setBackground(Color.decode("#0097B2"));
        add(panelLotus);

        JPanel panelAlpine = new JPanel();
        panelAlpine.setPreferredSize(new Dimension(2, 300));
        panelAlpine.setBackground(Color.decode("#FF66C4"));
        add(panelAlpine);
    }
}
