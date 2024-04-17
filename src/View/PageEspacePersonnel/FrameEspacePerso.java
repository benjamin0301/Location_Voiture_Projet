package View.PageEspacePersonnel;

import View.PageConfirmation.PageConfirmation;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FrameEspacePerso extends JFrame
{
    private JPanel contentPanel;
    public FrameEspacePerso() throws SQLException, ClassNotFoundException
    {
        setTitle("Mon espace personnel");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurHaut conteneurHaut = new ConteneurHaut();
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        EspacePersonnel espacePersonnel = new EspacePersonnel();

        JPanel englobeurPC = new JPanel(new BorderLayout());
        englobeurPC.setBackground(Color.decode("#E4E4E4"));
        englobeurPC.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));
        englobeurPC.add(espacePersonnel, BorderLayout.CENTER);

        contentPanel.add(englobeurPC, BorderLayout.CENTER);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setVisible(true);
    }
}
