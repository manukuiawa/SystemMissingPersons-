package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Disappearance;

public class DisappearanceDao extends BaseDao {

    public void insert(Disappearance d) {

        String sql = "INSERT INTO disappearance "
                + "(dateDisappearance, hourDisappearance, location, contextDisappearance, clothesDisappearance, id_peoples) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            stmt.setDate(1, Date.valueOf(d.getDateDisappearance()));

           
            stmt.setTime(2, Time.valueOf(d.getHourDisappearance()));

            stmt.setString(3, d.getLocation());
            stmt.setString(4, d.getContextDisappearance());
            stmt.setString(5, d.getClothesDisappearance());

            stmt.setInt(6, d.getId_peoples());

            stmt.executeUpdate();
            System.out.println("Desaparecimento registrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar desaparecimento: " + e.getMessage());
        }
    }
}
