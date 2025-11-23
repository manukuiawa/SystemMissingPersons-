package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import model.People;

public class PeopleDao {

    public int insert(Connection conn, People p) throws SQLException {

        String sql = "INSERT INTO peoples (personName, age, gender, CPF, address) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, p.getPersonName());
            stmt.setInt(2, p.getAge());
            stmt.setString(3, p.getGender());
            stmt.setString(4, p.getCPF());
            stmt.setString(5, p.getAddress());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);

            return -1;
        }
    }
}
