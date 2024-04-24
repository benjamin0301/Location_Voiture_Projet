package View;

import Model.ClientModel;
import com.mysql.cj.xdevapi.Client;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ClientModel client = new ClientModel();
                Accueil accueil = new Accueil(1, client );
                accueil.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}










