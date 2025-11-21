package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.People;

public class PeopleDao extends BaseDao {

    public void salvar(People p) {
        String sql = "INSERT INTO peoples (personName, age, gender, CPF) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getPersonName());
            stmt.setInt(2, p.getAge());
            stmt.setString(3, p.getGender());
            stmt.setString(4, p.getCPF());

            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }
}
