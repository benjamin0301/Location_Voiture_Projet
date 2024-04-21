package View.PageResultats.conteneurprincipal;
import javax.swing.*;
import java.awt.*;

public class Progression extends JPanel
{
    public Progression()
    {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        //setPreferredSize(new Dimension(2, 80));

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

        JTextArea resultats = new JTextArea("Résultats");
        resultats.setBackground(Color.decode("#7E3DFF"));
        resultats.setForeground(Color.white);
        resultats.setPreferredSize(new Dimension(250, 60));
        resultats.setMargin(new Insets(20, 88, 20, 10)); // Ajustement des marges internes
        resultats.setEditable(false);
        resultats.setFont(new Font("Georgia", Font.BOLD, 16));
        panelGlobal.add(resultats, gbc);

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
        JTextArea details = new JTextArea("Détails");
        details.setBackground(Color.WHITE);
        details.setFont(new Font("Georgia", Font.BOLD, 16));
        details.setForeground(Color.decode("#7E3DFF"));
        details.setEditable(false);
        details.setMargin(new Insets(18, 94, 5, 10));
        detailsPanel.add(details);
        panelGlobal.add(detailsPanel, gbc);

        gbc.gridx++;
        JPanel barreJaune2 = new JPanel();
        barreJaune2.setBackground(Color.decode("#7E3DFF"));
        barreJaune2.setPreferredSize(new Dimension(40, 2));
        panelGlobal.add(barreJaune2, gbc);

        gbc.gridx++;
        JPanel confPanel = new JPanel();
        confPanel.setPreferredSize(new Dimension(250, 60));
        confPanel.setLayout(new BoxLayout(confPanel, BoxLayout.Y_AXIS));
        confPanel.setBackground(Color.WHITE);
        confPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#7E3DFF")));
        JTextArea confirmation = new JTextArea("Confirmation");
        confirmation.setBackground(Color.WHITE);
        confirmation.setFont(new Font("Georgia", Font.BOLD, 16));
        confirmation.setForeground(Color.decode("#7E3DFF"));
        confirmation.setEditable(false);
        confirmation.setMargin(new Insets(18, 66, 5, 10));
        confPanel.add(confirmation);
        panelGlobal.add(confPanel, gbc);

        add(panelGlobal, BorderLayout.CENTER);
    }
}
