package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemaDesaparecimentos";
    private static final String USER = "root";
    private static final String PASS = "0166";

    // A conexão principal (uma única por operação)
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado!", e);
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Recupera o último ID da sessão atual
    public int getLastInsertedId(Connection conn) throws SQLException {
        String sql = "SELECT LAST_INSERT_ID() AS id";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return -1;
            }
        }
    }

    // Fecha a conexão (se quiser)
    public void close(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
