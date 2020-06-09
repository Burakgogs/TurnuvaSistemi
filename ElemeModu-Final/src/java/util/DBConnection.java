package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//veritabanı bağlantısı yapılması için kod bölümü
public class DBConnection {

    public Connection connect() {
        Connection c = null;
        try {

            Class.forName("org.mariadb.jdbc.Driver").newInstance();

            c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/turnuva?user=root&password=444");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
}
