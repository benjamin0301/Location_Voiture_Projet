package View.PageDetails.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;

public class ProgressionDetails extends JPanel
{
    public ProgressionDetails()
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

        JPanel resuPanel = new JPanel();
        resuPanel.setPreferredSize(new Dimension(250, 60));
        resuPanel.setLayout(new BoxLayout(resuPanel, BoxLayout.Y_AXIS));
        resuPanel.setBackground(Color.WHITE);
        resuPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#5E17EB")));
        JTextArea resultats = new JTextArea("     Résultats");
        resultats.setBackground(Color.WHITE);
        resultats.setFont(new Font("Georgia", Font.BOLD, 16));
        resultats.setForeground(Color.decode("#5E17EB"));
        resultats.setEditable(false);
        resultats.setMargin(new Insets(18, 64, 5, 10));
        resuPanel.add(resultats);
        panelGlobal.add(resuPanel, gbc);

        gbc.gridx++;
        JPanel barreJaune = new JPanel();
        barreJaune.setBackground(Color.decode("#5E17EB"));
        barreJaune.setPreferredSize(new Dimension(40, 2));
        panelGlobal.add(barreJaune, gbc);

        gbc.gridx++;
        JTextArea details = new JTextArea("  Détails");
        details.setBackground(Color.decode("#5E17EB"));
        details.setForeground(Color.white);
        details.setPreferredSize(new Dimension(250, 60));
        details.setMargin(new Insets(20, 86, 20, 10)); // Ajustement des marges internes
        details.setEditable(false);
        details.setFont(new Font("Georgia", Font.BOLD, 16));
        panelGlobal.add(details, gbc);

        gbc.gridx++;
        JPanel barreJaune2 = new JPanel();
        barreJaune2.setBackground(Color.decode("#5E17EB"));
        barreJaune2.setPreferredSize(new Dimension(40, 2));
        panelGlobal.add(barreJaune2, gbc);

        gbc.gridx++;
        JPanel confPanel = new JPanel();
        confPanel.setPreferredSize(new Dimension(250, 60));
        confPanel.setLayout(new BoxLayout(confPanel, BoxLayout.Y_AXIS));
        confPanel.setBackground(Color.WHITE);
        confPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#5E17EB")));
        JTextArea confirmation = new JTextArea("Confirmation");
        confirmation.setBackground(Color.WHITE);
        confirmation.setFont(new Font("Georgia", Font.BOLD, 16));
        confirmation.setForeground(Color.decode("#5E17EB"));
        confirmation.setEditable(false);
        confirmation.setMargin(new Insets(18, 66, 5, 10));
        confPanel.add(confirmation);
        panelGlobal.add(confPanel, gbc);

        add(panelGlobal, BorderLayout.CENTER);
    }
}
