package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Register;

public class RegisterDao {

    public void insert(Connection conn, Register register) throws SQLException {

        String sql = "INSERT INTO register (dateReport, statusRegister, id_peoples) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            Timestamp ts = new Timestamp(register.getDateReport().getTime());
            stmt.setTimestamp(1, ts);

            stmt.setString(2, register.getStatusRegister().name());
            stmt.setInt(3, register.getIdPeople());

            stmt.executeUpdate();
            System.out.println("Registro salvo com sucesso!");
        }
    }
}
