package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import model.Register;

public class RegisterDao {
    
    private Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistemaDesaparecimentos",
                "root",
                "0166"
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage());
        }
    }

    public boolean inserir(Register register) {
        String sqlPeople = "INSERT INTO peoples (personName, age, gender, CPF) VALUES (?, ?, ?, ?)";
        String sqlRegister = "INSERT INTO register (dateReport, statusRegister, id_peoples) VALUES (?, ?, ?)";
        String sqlPhysical = "INSERT INTO physicalCharacteristics (height, weight, hairColor, eyesColor, signs, id_peoples) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlDisappear = "INSERT INTO disappearance (dateDisappearance, hourDisappearance, location, contextDisappearance, clothesDisappearance, id_peoples) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexao()) {
            conn.setAutoCommit(false); 
            
            // 1: Inserir pessoa
            PreparedStatement stmtPeople = conn.prepareStatement(sqlPeople, Statement.RETURN_GENERATED_KEYS);
            stmtPeople.setString(1, register.getIdPeople().getName());
            stmtPeople.setInt(2, register.getPeople().getAge());
            stmtPeople.setString(3, register.getPeople().getGender());
            stmtPeople.setString(4, register.getPeople().getCpf());
            stmtPeople.executeUpdate();

            var rsPeople = stmtPeople.getGeneratedKeys();
            if (!rsPeople.next()) throw new SQLException("Erro ao obter ID da pessoa.");
            int personId = rsPeople.getInt(1);
            rsPeople.close();

            // 2: Inserir registro 
            PreparedStatement stmtRegister = conn.prepareStatement(sqlRegister);
            stmtRegister.setTimestamp(1, new Timestamp(register.getDateReport().getTime()));
            stmtRegister.setString(2, register.getstatusRegister().getstatusRegister());
            stmtRegister.setInt(3, personId);
            stmtRegister.executeUpdate();

            // 3: Inserir características físicas
            PreparedStatement stmtPhysical = conn.prepareStatement(sqlPhysical);
            stmtPhysical.setDouble(1, register.getPhysicalCharacteristics().getHeight());
            stmtPhysical.setDouble(2, register.getPhysicalCharacteristics().getWeight());
            stmtPhysical.setString(3, register.getPhysicalCharacteristics().getHairColor());
            stmtPhysical.setString(4, register.getPhysicalCharacteristics().getEyesColor());
            stmtPhysical.setString(5, register.getPhysicalCharacteristics().getSigns());
            stmtPhysical.setInt(6, personId);
            stmtPhysical.executeUpdate();

            // 4: Inserir desaparecimento
            PreparedStatement stmtDisappear = conn.prepareStatement(sqlDisappear);
            stmtDisappear.setDate(1, new java.sql.Date(register.getDisappearence().getDateDisappearance().getTime()));
            stmtDisappear.setTime(2, new java.sql.Time(register.getDisappearence().getHourDisappearance().getTime()));
            stmtDisappear.setString(3, register.getDisappearence().getLocation());
            stmtDisappear.setString(4, register.getDisappearence().getContextDisappearance());
            stmtDisappear.setString(5, register.getDisappearence().getClothesDisappearance());
            stmtDisappear.setInt(6, personId);
            stmtDisappear.executeUpdate();

            // Se tudo deu bom: COMMIT!
            conn.commit();
            System.out.println("Registro completo salvo com sucesso!");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar registro: " + e.getMessage());
            return false;
        }
    }
}
