package dao;

import model.DisappearanceListItem;
import model.StatusRegister;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisappearanceListDao {

    
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistemaDesaparecimentos",
                "root",
                "0166"
        );
    }

    // LISTAR TODOS OS DESAPARECIDOS
    public List<DisappearanceListItem> listarTodos() throws Exception {
        String sql = "SELECT p.id_peoples, r.id_register, p.personName, p.age, p.gender, " +
                     "pc.height, pc.weight, pc.hairColor, pc.eyesColor, " +
                     "d.contextDisappearance, d.location, " +
                     "c.kinship, c.cellphone, r.statusRegister " +
                     "FROM peoples p " +
                     "LEFT JOIN disappearance d ON p.id_peoples = d.id_peoples " +
                     "LEFT JOIN physicalCharacteristics pc ON p.id_peoples = pc.id_peoples " +
                     "LEFT JOIN informs i ON d.id_disappearance = i.id_disappearance " +
                     "LEFT JOIN communicant c ON i.id_communicant = c.id_communicant " +
                     "LEFT JOIN register r ON p.id_peoples = r.id_peoples";

        List<DisappearanceListItem> lista = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                StatusRegister status = StatusRegister.PENDENTE; // default
                String statusStr = rs.getString("statusRegister");
                if (statusStr != null) {
                    switch (statusStr.toUpperCase()) {
                        case "PENDENTE": status = StatusRegister.PENDENTE; break;
                        case "ANDAMENTO": status = StatusRegister.ANDAMENTO; break;
                        case "ENCERRADO": status = StatusRegister.ENCERRADO; break;
                    }
                }

                DisappearanceListItem item = new DisappearanceListItem(
                        rs.getInt("id_peoples"),
                        rs.getInt("id_register"),
                        rs.getString("personName"),
                        rs.getString("gender"),
                        rs.getInt("age"),
                        rs.getString("eyesColor"),
                        rs.getString("hairColor"),
                        rs.getString("contextDisappearance"),
                        rs.getDouble("height"),
                        rs.getDouble("weight"),
                        rs.getString("kinship"),
                        rs.getString("cellphone"),
                        rs.getString("location"),
                        status
                );

                lista.add(item);
            }
        }

        return lista;
    }

    
    public void atualizarStatusRegister(int idRegister, StatusRegister novoStatus) throws Exception {
        String sql = "UPDATE register SET statusRegister = ? WHERE id_register = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus.name());
            stmt.setInt(2, idRegister);
            stmt.executeUpdate();
        }
    }
}
