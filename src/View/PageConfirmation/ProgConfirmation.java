package View.PageConfirmation;

import javax.swing.*;
import java.awt.*;

public class ProgConfirmation extends JPanel
{
    public ProgConfirmation()
    {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        JPanel panelGlobal = new JPanel();
        panelGlobal.setBackground(Color.white);
        panelGlobal.setPreferredSize(new Dimension(200, 70));
        panelGlobal.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5); // Ajouter des marges ici

        JPanel resuPanel = new JPanel();
        resuPanel.setPreferredSize(new Dimension(250, 60));
        resuPanel.setLayout(new BoxLayout(resuPanel, BoxLayout.Y_AXIS));
        resuPanel.setBackground(Color.WHITE);
        resuPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#7E3DFF")));
        JTextArea resultats = new JTextArea("     Résultats");
        resultats.setEditable(false);
        resultats.setBackground(Color.WHITE);
        resultats.setFont(new Font("Georgia", Font.BOLD, 16));
        resultats.setForeground(Color.decode("#7E3DFF"));
        resultats.setEditable(false);
        resultats.setMargin(new Insets(18, 64, 5, 10));
        resuPanel.add(resultats);
        panelGlobal.add(resuPanel, gbc);

        gbc.gridx++;
        JPanel barreJaune = new JPanel();
        barreJaune.setBackground(Color.decode("#7E3DFF"));
        barreJaune.setPreferredSize(new Dimension(40, 2));
        panelGlobal.add(barreJaune, gbc);

        gbc.gridx++;
        JPanel detailsPanel = new JPanel();
        detailsPanel.setPreferredSize(new Dimension(250, 60));
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#7E3DFF")));
        JTextArea details = new JTextArea("     Détails");
        details.setEditable(false);
        details.setBackground(Color.WHITE);
        details.setFont(new Font("Georgia", Font.BOLD, 16));
        details.setForeground(Color.decode("#7E3DFF"));
        details.setEditable(false);
        details.setMargin(new Insets(18, 72, 5, 10));
        detailsPanel.add(details);
        panelGlobal.add(detailsPanel, gbc);

        gbc.gridx++;
        JPanel barreJaune2 = new JPanel();
        barreJaune2.setBackground(Color.decode("#7E3DFF"));
        barreJaune2.setPreferredSize(new Dimension(40, 2));
        panelGlobal.add(barreJaune2, gbc);

        gbc.gridx++;
        JTextArea confi = new JTextArea("Confirmation");
        confi.setEditable(false);
        confi.setBackground(Color.decode("#7E3DFF"));
        confi.setForeground(Color.white);
        confi.setPreferredSize(new Dimension(250, 60));
        confi.setMargin(new Insets(20, 68, 20, 10)); // Ajustement des marges internes
        confi.setEditable(false);
        confi.setFont(new Font("Georgia", Font.BOLD, 16));
        panelGlobal.add(confi, gbc);

        add(panelGlobal, BorderLayout.CENTER);
    }
}

