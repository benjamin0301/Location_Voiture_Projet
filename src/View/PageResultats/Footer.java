package View.PageResultats;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel
{
    public Footer()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        setPreferredSize(new Dimension(2, 110));
        setBackground(Color.decode("#7E3DFF"));

        JPanel pa = new JPanel();
        pa.setBackground(Color.decode("#7E3DFF"));
        pa.setPreferredSize(new Dimension(1000, 60));
        pa.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelFooter = new JLabel("© 2024 RentMyRide. Tous droits réservés.");
        Font font = new Font("Georgia", Font.BOLD, 20);
        labelFooter.setBackground(Color.decode("#7E3DFF"));
        labelFooter.setPreferredSize(new Dimension(1200, 25));
        labelFooter.setHorizontalAlignment(SwingConstants.CENTER);
        labelFooter.setForeground(Color.white);
        labelFooter.setFont(font);
        pa.add(labelFooter);

        JLabel labelFooter1 = new JLabel("Développé par : Benjamin GENDRY, Hugo MESSINA, Antoine LIMOUSIN");
        Font font1 = new Font("Georgia", Font.BOLD, 16);
        labelFooter1.setBackground(Color.decode("#7E3DFF"));
        labelFooter1.setPreferredSize(new Dimension(1200, 20));
        labelFooter1.setHorizontalAlignment(SwingConstants.CENTER);
        labelFooter1.setForeground(Color.white);
        labelFooter1.setFont(font1);
        pa.add(labelFooter1);

        add(pa, BorderLayout.SOUTH);
    }
}
