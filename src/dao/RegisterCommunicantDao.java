package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterCommunicantDao {

    public void insert(Connection conn, int idRegister, int idCommunicant) throws SQLException {

        String sql = "INSERT INTO registerCommunicant (id_register, id_communicant) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRegister);
            stmt.setInt(2, idCommunicant);

            stmt.executeUpdate();
            System.out.println("Ligação entre registro e comunicante salva!");
        }
    }
}
