package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Communicant;

public class CommunicantDao {

    public int insert(Connection conn, Communicant c) throws SQLException {

        if (conn == null) {
            throw new SQLException("Conexão nula recebida no CommunicantDao!");
        }

        String sql = "INSERT INTO communicant (cellphone, kinship) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, c.getCellphone());
            stmt.setString(2, c.getKinship());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    System.out.println("Communicant cadastrado! ID = " + rs.getInt(1));
                    return rs.getInt(1);
                }
            }

            System.err.println("Nenhum ID retornado ao inserir Communicant!");
            return -1;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir Communicant: " + e.getMessage());
            throw e;
        }
    }
}
