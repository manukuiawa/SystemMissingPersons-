package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Register;

public class RegisterDao extends BaseDao {

	public void salvar(Register register) {

		String sql = "INSERT INTO register (dateReport, statusRegister, id_peoples) VALUES (?, ?, ?)";

		try (Connection conn = getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			Timestamp ts = new Timestamp(register.getDateReport().getTime());
			stmt.setTimestamp(1, ts);

			stmt.setString(2, register.getStatusRegister().name());
			stmt.setInt(3, register.getIdPeople());

			stmt.executeUpdate();
			System.out.println("Registro salvo com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar registro: " + e.getMessage());
		}
	}
}
