package ZCA.page_principale.conteneurprincipal.voitures;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListeVoitures extends JPanel
{
    public ArrayList<String> voitures;
    public ListeVoitures()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        voitures = new ArrayList<>();
        voitures.add("Toyota");
        voitures.add("Tesla");
        voitures.add("Bugatti");
        voitures.add("Lotus");
        voitures.add("Alpine");
        voitures.add("Mercedes");
        voitures.add("Audi");
        voitures.add("Nissan");
        voitures.add("Volkswagen");
        voitures.add("Hyundai");

        JPanel panelToyota = new JPanel();
        panelToyota.setPreferredSize(new Dimension(2, 300));
        panelToyota.setBackground(Color.CYAN);
        panelToyota.add(new JLabel(voitures.get(0)));
        add(panelToyota);

        JPanel panelTesla = new JPanel();
        panelTesla.setPreferredSize(new Dimension(2, 300));
        panelTesla.setBackground(Color.orange);
        panelTesla.add(new JLabel(voitures.get(1)));
        add(panelTesla);

        JPanel panelBugatti = new JPanel();
        panelBugatti.setPreferredSize(new Dimension(2, 300));
        panelBugatti.setBackground(Color.darkGray);
        panelBugatti.add(new JLabel(voitures.get(2)));
        add(panelBugatti);

        JPanel panelLotus = new JPanel();
        panelLotus.setPreferredSize(new Dimension(2, 300));
        panelLotus.setBackground(Color.decode("#0097B2"));
        panelLotus.add(new JLabel(voitures.get(3)));
        add(panelLotus);

        JPanel panelAlpine = new JPanel();
        panelAlpine.setPreferredSize(new Dimension(2, 300));
        panelAlpine.setBackground(Color.decode("#FF66C4"));
        panelAlpine.add(new JLabel(voitures.get(4)));
        add(panelAlpine);
    }
}
