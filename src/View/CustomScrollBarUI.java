package View;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI
{
    public CustomScrollBarUI()
    {
    }

    private JButton b = new JButton()
    {
        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(0, 0);
        }
    };
    @Override
    protected void configureScrollBarColors()
    {
        super.configureScrollBarColors();
        // Set the desired color for the thumb
        thumbColor = Color.decode("#7E3DFF"); // Example: Dark green
        trackColor = Color.white;
        thumbHighlightColor = Color.decode("#7E3DFF");
        thumbDarkShadowColor = Color.decode("#7E3DFF");
        thumbLightShadowColor = Color.decode("#7E3DFF");
    }


    @Override
    protected JButton createDecreaseButton(int orientation) {
        return b;
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return b;
    }
}
