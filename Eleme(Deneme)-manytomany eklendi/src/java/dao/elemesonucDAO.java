package dao;

import entity.sonuctakım;
import entity.takım;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class elemesonucDAO {

    private elemesonucDAO elemesonucdao;
    private elemeDAO elemedao;

    public List<sonuctakım> findAl() {
        List<sonuctakım> sonuclist = new ArrayList();
        List<takım> kaz = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from elemesonuc");

            while (rs.next()) {
                sonuctakım tmp = new sonuctakım();
                //   takım tmp = new sonuctakım(rs.getInt("id"), rs.getString("takımAdı"));
                tmp.setId((int) rs.getLong("id"));
                tmp.setTakımAdı2("takımAdı2");
                //   sonuclist.add(tmp);
                // tmp.setKazananlar(this.getElemesonucDAO().getKazananlar(tmp));
                tmp.setKazananlar(this.getElemedao().getKazananlar((long) tmp.getId()));

            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuclist;
    }

    public List<sonuctakım> eşleştirme3() {

        List<sonuctakım> eslesme3list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM elemesonuc ORDER BY RAND() LIMIT 5;");

            while (rs.next()) {
                sonuctakım tmp = new sonuctakım(rs.getInt("id"), rs.getString("takımAdı2"));

                eslesme3list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eslesme3list;
    }

    public elemeDAO getElemedao() {
        if (this.elemedao == null) {
            this.elemedao = new elemeDAO();
        }
        return elemedao;
    }

}
