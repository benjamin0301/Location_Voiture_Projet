package View.PageConfirmation;

import Model.ClientModel;
import Model.FactureModel;
import Model.VoitureModel;
import View.CustomScrollBarUI;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;

import javax.swing.*;
import java.awt.*;

public class FrameConfirmation extends JFrame
{
    private ClientModel client;
    private JPanel contentPanel;
    private VoitureModel voiture;

    public FrameConfirmation(VoitureModel voitureModel, int res, ClientModel clientModel, FactureModel factureModel)
    {
        this.client = clientModel;
        this.voiture = voitureModel;
        setTitle("Confirmation de réservation");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurHaut conteneurHaut = new ConteneurHaut(res, client,"","","","");
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        PageConfirmation nouvellePage = new PageConfirmation( voiture, res, client, factureModel);

        JPanel englobeurPC = new JPanel(new BorderLayout());
        englobeurPC.setBackground(Color.decode("#E4E4E4"));
        englobeurPC.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));
        englobeurPC.add(nouvellePage, BorderLayout.CENTER);

        contentPanel.add(englobeurPC, BorderLayout.CENTER);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());

        add(scrollPane);

        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setVisible(true);
    }
}
