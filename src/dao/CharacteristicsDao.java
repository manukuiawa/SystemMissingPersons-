package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PhysicalCharacteristics;

public class CharacteristicsDao {

    public void insert(Connection conn, PhysicalCharacteristics pc) throws SQLException {

        if (conn == null) {
            throw new SQLException("Conexão recebida é nula! Verifique o BaseDao.getConexao().");
        }

        String sql = "INSERT INTO physicalCharacteristics "
                   + "(height, weight, hairColor, eyesColor, signs, id_peoples) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, pc.getHeight());
            stmt.setDouble(2, pc.getWeight());
            stmt.setString(3, pc.getHairColor());
            stmt.setString(4, pc.getEyesColor());
            stmt.setString(5, pc.getSigns());
            stmt.setInt(6, pc.getIdPeople());

            stmt.executeUpdate();

            System.out.println("Características físicas cadastradas com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir características físicas: " + e.getMessage());
            throw e; 
        }
    }
}
