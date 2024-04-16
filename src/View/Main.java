package View;

import javax.swing.*;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        System.out.println("Connexion établie avec succès !");
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                Vue vue = new Vue();
                vue.initialize();
            }
            catch (SQLException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        });
    }
}









