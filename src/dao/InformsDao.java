package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InformsDao {

    public void insert(Connection conn, int idCommunicant, int idDisappearance) throws SQLException {
        String sql = "INSERT INTO informs (id_communicant, id_disappearance) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCommunicant);
            stmt.setInt(2, idDisappearance);

            stmt.executeUpdate();
        }
    }
}
