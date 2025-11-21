package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Communicant;

public class CommunicantDao extends BaseDao {

    public void insert(Communicant c) {
        String sql = "INSERT INTO communicant (cellphone, kinship) VALUES (?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getCellphone());
            stmt.setString(2, c.getKinship());

            stmt.executeUpdate();
            System.out.println("Comunicante cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar comunicante: " + e.getMessage());
        }
    }
}
