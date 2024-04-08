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

        ClientController clientcontroller = new ClientController();
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

        JTextArea AType = new JTextArea("  " + listeVoitures.get(8).getType());
        AType.setLayout(new BorderLayout());
        AType.setPreferredSize(new Dimension(200, 25));
        AType.setEditable(false);
        AType.setFocusable(false);
        AType.setFont(new Font("Aleo", Font.BOLD, 17));
        panelA.add(AType, BorderLayout.WEST);

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
        panelB.setLayout(new FlowLayout());
        panelB.setPreferredSize(new Dimension(205, 300));
        panelB.setBackground(Color.decode("#F6F6F6"));
        panelB.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));


        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.decode("#F6F6F6"));
        espaceVideB.setPreferredSize(new Dimension(200, 25));
        panelB.add(espaceVideB);


        JTextArea LPC = new JTextArea("     ✈️   Lieu de prise en\n            charge :\n            Au terminal");
        LPC.setBackground(Color.decode("#F6F6F6"));
        LPC.setPreferredSize(new Dimension(200, 70));
        LPC.setFont(new Font("Aleo", Font.PLAIN, 15));
        panelB.add(LPC);

        JTextArea PMC = new JTextArea("     ⛽   Politique en matière\n            de carburant :\n            Même charge-\n            même charge");
        PMC.setBackground(Color.decode("#F6F6F6"));
        PMC.setPreferredSize(new Dimension(200, 90));
        PMC.setFont(new Font("Aleo", Font.PLAIN, 15));
        panelB.add(PMC);

        JTextArea kilometrage = new JTextArea("     🚗   Kilométrage limite :\n            " + listeVoitures.get(8).getLimite_km() + " km");
        kilometrage.setBackground(Color.decode("#F6F6F6"));
        kilometrage.setPreferredSize(new Dimension(200, 50));
        kilometrage.setFont(new Font("Aleo", Font.PLAIN, 15));
        panelB.add(kilometrage);

        JButton note = new JButton("Europcar   Bon       " + listeVoitures.get(8).getAvis());
        note.setBackground(Color.decode("#F6F6F6"));
        note.setFont(new Font("Aleo", Font.PLAIN, 15));
        panelB.add(note);

        panelCybertruck.add(panelB, gbc);

        gbc.gridx++;

        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(205, 300));
        panelC.setBackground(Color.decode("#F6F6F6"));
        panelC.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));

        JPanel espaceVideC = new JPanel();
        espaceVideC.setBackground(Color.decode("#F6F6F6"));
        espaceVideC.setPreferredSize(new Dimension(200, 50));
        panelC.add(espaceVideC);


        JTextArea areaC = new JTextArea("Inclus gratuitement :\n\n  ✅  Annulation\n  ✅  Modifications\n  ✅  Assurance dommage\n        en cas de collision\n  ✅  Assurance vol\n  ✅  Assurance\n        responsabilité civile");
        areaC.setBackground(Color.decode("#F6F6F6"));
        areaC.setFont(new Font("Aleo", Font.PLAIN, 15));
        areaC.setForeground(Color.decode("#206D00"));
        areaC.setPreferredSize(new Dimension(200, 200));
        panelC.add(areaC);


        panelCybertruck.add(panelC, gbc);

        gbc.gridx++;

        JPanel panelD = new JPanel();
        panelD.setPreferredSize(new Dimension(205, 300));
        panelD.setBackground(Color.decode("#E2FFD6"));
        panelD.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.lightGray));


        JPanel espaceVideD = new JPanel();
        espaceVideD.setBackground(Color.decode("#E2FFD6"));
        espaceVideD.setPreferredSize(new Dimension(200, 150));
        panelD.add(espaceVideD);


        JTextArea prixGras = new JTextArea("       " + listeVoitures.get(8).getPrix() + " €/jour");
        prixGras.setFont(new Font("Aleo", Font.BOLD, 25));
        prixGras.setBackground(Color.decode("#E2FFD6"));
        prixGras.setPreferredSize(new Dimension(200, 32));
        panelD.add(prixGras);

        JTextArea prixCumule = new JTextArea("                        " + "Total " + listeVoitures.get(8).getPrix() + " €");
        prixCumule.setFont(new Font("Aleo", Font.PLAIN, 15));
        prixCumule.setBackground(Color.decode("#E2FFD6"));
        prixCumule.setPreferredSize(new Dimension(200, 20));
        panelD.add(prixCumule);

        JPanel espaceVide2D = new JPanel();
        espaceVide2D.setBackground(Color.decode("#E2FFD6"));
        espaceVide2D.setPreferredSize(new Dimension(200, 10));
        panelD.add(espaceVide2D);

        JButton selectionner = new JButton("Sélectionner");
        selectionner.setPreferredSize(new Dimension(185, 50));
        selectionner.setBackground(Color.decode("#00C465"));
        selectionner.setForeground(Color.white);
        selectionner.setFont(new Font("Aleo", Font.BOLD, 24));
        panelD.add(selectionner);



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
