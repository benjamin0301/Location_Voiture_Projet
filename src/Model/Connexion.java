package Model;

import java.sql.*;
import java.util.ArrayList;


public class Connexion {
    public final Connection conn;
    public final Statement stmt;
    private ResultSet rset;


    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.cj.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/"+ nameDatabase;
        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }

    public static PreparedStatement prepareStatement(Connexion connexion, String query) throws SQLException {
        return connexion.conn.prepareStatement(query);
    }

    public void closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rset != null) {
                rset.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
