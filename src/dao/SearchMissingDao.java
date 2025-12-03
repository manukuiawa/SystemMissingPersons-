package dao;

import model.DisappearanceListItem;
import model.StatusRegister;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchMissingDao {

    private final BaseDao baseDao = new BaseDao();

    public List<DisappearanceListItem> pesquisar(
            String nome,
            String idade,
            String altura,
            String cabelo,
            String olhos,
            String roupas,
            String local
    ) {
        List<DisappearanceListItem> lista = new ArrayList<>();

        // Query alinhada ao seu schema (peoples, physicalCharacteristics, disappearance, register, communicant)
        StringBuilder sql = new StringBuilder(
                "SELECT " +
                        "p.id_peoples, r.id_register, p.personName, p.age, p.gender, " +
                        "pc.height, pc.weight, pc.hairColor, pc.eyesColor, " +
                        "d.clothesDisappearance, d.location, d.contextDisappearance, " +
                        "c.kinship, c.cellphone, r.statusRegister " +
                "FROM peoples p " +
                "LEFT JOIN physicalCharacteristics pc ON p.id_peoples = pc.id_peoples " +
                "LEFT JOIN disappearance d ON p.id_peoples = d.id_peoples " +
                "LEFT JOIN informs i ON d.id_disappearance = i.id_disappearance " +
                "LEFT JOIN communicant c ON i.id_communicant = c.id_communicant " +
                "LEFT JOIN register r ON p.id_peoples = r.id_peoples " +
                "WHERE 1=1 "
        );

        List<Object> params = new ArrayList<>();

        if (nome != null && !nome.isBlank()) {
            sql.append(" AND LOWER(p.personName) LIKE ?");
            params.add("%" + nome.toLowerCase() + "%");
        }
        if (idade != null && !idade.isBlank()) {
            sql.append(" AND p.age = ?");
            params.add(Integer.parseInt(idade));
        }
        if (altura != null && !altura.isBlank()) {
            sql.append(" AND pc.height = ?");
            params.add(Double.parseDouble(altura));
        }
        if (cabelo != null && !cabelo.isBlank()) {
            sql.append(" AND LOWER(pc.hairColor) LIKE ?");
            params.add("%" + cabelo.toLowerCase() + "%");
        }
        if (olhos != null && !olhos.isBlank()) {
            sql.append(" AND LOWER(pc.eyesColor) LIKE ?");
            params.add("%" + olhos.toLowerCase() + "%");
        }
        if (local != null && !local.isBlank()) {
            sql.append(" AND LOWER(d.location) LIKE ?");
            params.add("%" + local.toLowerCase() + "%");
        }
        if (roupas != null && !roupas.isBlank()) {
            sql.append(" AND LOWER(d.clothesDisappearance) LIKE ?");
            params.add("%" + roupas.toLowerCase() + "%");
        }

        try (Connection conn = baseDao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            // set params dinamicamente
            for (int i = 0; i < params.size(); i++) {
                Object p = params.get(i);
                if (p instanceof Integer) stmt.setInt(i + 1, (Integer) p);
                else if (p instanceof Double) stmt.setDouble(i + 1, (Double) p);
                else stmt.setString(i + 1, p.toString());
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // usa construtor vazio + setters (evita mismatch de assinatura)
                    DisappearanceListItem item = new DisappearanceListItem();

                    item.setIdPeoples(rs.getInt("id_peoples"));
                    item.setIdRegister(rs.getInt("id_register"));
                    item.setPersonName(rs.getString("personName")); // atenção: exatamente personName
                    item.setAge(rs.getInt("age"));
                    item.setGender(rs.getString("gender"));

                    // height/weight podem ser null no DB -> tratar
                    double height = rs.getDouble("height");
                    if (rs.wasNull()) item.setHeight(0.0);
                    else item.setHeight(height);

                    double weight = rs.getDouble("weight");
                    if (rs.wasNull()) item.setWeight(0.0);
                    else item.setWeight(weight);

                    item.setHairColor(rs.getString("hairColor"));
                    item.setEyesColor(rs.getString("eyesColor"));
                    item.setClothesDisappearance(rs.getString("clothesDisappearance"));
                    item.setLocation(rs.getString("location"));
                    item.setContextDisappearance(rs.getString("contextDisappearance"));
                    item.setKinship(rs.getString("kinship"));
                    item.setCellphone(rs.getString("cellphone"));

                    // converte o status vindo do DB (r.statusRegister)
                    item.setStatus(StatusRegister.fromString(rs.getString("statusRegister")));

                    lista.add(item);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
