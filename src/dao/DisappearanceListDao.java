package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DisappearanceListItem;

public class DisappearanceListDao extends BaseDao {

    public List<DisappearanceListItem> listarTodos() {

        List<DisappearanceListItem> lista = new ArrayList<>();

        String sql = 
            "SELECT p.personName, p.age, p.gender, d.location, d.dateDisappearance, " +
            "       pc.height, pc.weight, r.statusRegister " +
            "FROM peoples p " +
            "INNER JOIN disappearance d ON p.id_peoples = d.id_peoples " +
            "INNER JOIN physicalCharacteristics pc ON p.id_peoples = pc.id_peoples " +
            "INNER JOIN register r ON p.id_peoples = r.id_peoples";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                DisappearanceListItem item = new DisappearanceListItem();

                item.setName(rs.getString("personName"));
                item.setAge(rs.getInt("age"));
                item.setGender(rs.getString("gender"));
                item.setLocation(rs.getString("location"));
                item.setDate(rs.getDate("dateDisappearance"));
                item.setHeight(rs.getDouble("height"));
                item.setWeight(rs.getDouble("weight"));
                item.setStatus(rs.getString("statusRegister"));

                lista.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
