package dao;

import java.sql.Connection;

public class BaseDao {

    public Connection getConexao() {

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/sistemaDesaparecimentos";
        String senha = "0166";
        String user = "root";

        try {
            return java.sql.DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
