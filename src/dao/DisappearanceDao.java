package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import model.Disappearance;

public class DisappearanceDao {

	public int insert(Connection conn, Disappearance d) throws SQLException {

	    String sql = "INSERT INTO disappearance "
	            + "(dateDisappearance, hourDisappearance, location, contextDisappearance, clothesDisappearance, id_peoples) "
	            + "VALUES (?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

    }
