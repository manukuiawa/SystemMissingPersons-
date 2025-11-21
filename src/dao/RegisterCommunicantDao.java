package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterCommunicantDao extends BaseDao {

    public void insert(int idRegister, int idCommunicant) {

        String sql = "INSERT INTO RegisterCommunicant (id_register, id_communicant) VALUES (?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRegister);
            stmt.setInt(2, idCommunicant);

            stmt.executeUpdate();
            System.out.println("Ligação entre registro e comunicante salva!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar ligação: " + e.getMessage());
        }
    }
}
