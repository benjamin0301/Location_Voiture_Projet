package View.PageResultats;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel
{
    public Footer()
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(2, 500));
        setBackground(Color.white);
        JLabel labelFooter = new JLabel("Footer");

        Font font = new Font("Aleo", Font.BOLD, 50);
        labelFooter.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(labelFooter, gbc);
    }
}
