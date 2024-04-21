package View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Accueil accueil = new Accueil(1);
                accueil.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}










