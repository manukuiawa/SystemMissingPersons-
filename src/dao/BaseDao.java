package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    public Connection getConexao() {

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/sistemaDesaparecimentos";
        String senha = "0166";
        String user = "root";

        try {
            return java.sql.DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getLastInsertedId() {

        String sql = "SELECT LAST_INSERT_ID() AS id";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao recuperar ID gerado: " + e.getMessage());
        }

        return -1; 
    }

}
