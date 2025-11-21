package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PhysicalCharacteristics;

public class CharacteristicsDao extends BaseDao {

    public void insert(PhysicalCharacteristics pc) {

        String sql = "INSERT INTO physicalCharacteristics "
                + "(height, weight, hairColor, eyesColor, signs, id_peoples) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, pc.getHeight());
            stmt.setDouble(2, pc.getWeight());
            stmt.setString(3, pc.getHairColor());
            stmt.setString(4, pc.getEyesColor());
            stmt.setString(5, pc.getSigns());
            stmt.setInt(6, pc.getIdPeople());

            stmt.executeUpdate();
            System.out.println("Características físicas cadastradas com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar características físicas: " + e.getMessage());
        }
    }
}
