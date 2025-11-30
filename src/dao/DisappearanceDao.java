package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disappearance;

public class DisappearanceDao extends BaseDao {

    public int insert(Connection conn, Disappearance d) throws SQLException {

        String sql = "INSERT INTO disappearance "
                + "(dateDisappearance, hourDisappearance, location, contextDisappearance, clothesDisappearance, id_peoples) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setDate(1, Date.valueOf(d.getDateDisappearance()));
            stmt.setTime(2, Time.valueOf(d.getHourDisappearance()));
            stmt.setString(3, d.getLocation());
            stmt.setString(4, d.getContextDisappearance());
            stmt.setString(5, d.getClothesDisappearance());
            stmt.setInt(6, d.getId_peoples());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);

            return -1;
        }
    }


    public List<Disappearance> getAll() {

        List<Disappearance> lista = new ArrayList<>();

        String sql = "SELECT * FROM disappearance";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Disappearance d = new Disappearance();

                d.setId_disappearance(rs.getInt("id_disappearance"));
                d.setDateDisappearance(rs.getDate("dateDisappearance").toLocalDate());
                d.setHourDisappearance(rs.getTime("hourDisappearance").toLocalTime());
                d.setLocation(rs.getString("location"));
                d.setContextDisappearance(rs.getString("contextDisappearance"));
                d.setClothesDisappearance(rs.getString("clothesDisappearance"));
                d.setId_peoples(rs.getInt("id_peoples"));

                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
