package View;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Accueil accueil = new Accueil();
                accueil.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}










