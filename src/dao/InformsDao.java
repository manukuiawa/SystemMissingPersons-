package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InformsDao extends BaseDao {

    public void insert(int idCommunicant, int idDisappearance) {

        String sql = "INSERT INTO informs (id_communicant, id_disappearance) VALUES (?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCommunicant);
            stmt.setInt(2, idDisappearance);

            stmt.executeUpdate();
            System.out.println("Informado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao informar ligação comunicante/desaparecimento: " + e.getMessage());
        }
    }
}
