package dao;

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

public class elemeDAO {

    public List<takım> sonuclist = new ArrayList();
//many to many
    public List<takım> findAll() {
        List<takım> tlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from eleme");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                tlist.add(tmp);
                sonuclist.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }
//veritabanı ekleme
    public void insert(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            st.executeUpdate("insert into eleme (takımAdı) values ('" + takım1.getTakımAdı() + "')");
           

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//veritabanı silme
    public void delete(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from eleme where id=" + takım1.getId());
            st.executeUpdate("delete from elemesonuc where id=" + takım1.getId());
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//veritabanı güncelleme 
    public void update(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update eleme set takımAdı='" + takım1.getTakımAdı() + "' where id= " + takım1.getId());
            st.executeUpdate("update elemesonuc set takımAdı2='" + takım1.getTakımAdı() + "' where id= " + takım1.getId());
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Vize öncesi eşleştirmenin denendiği kod 
    public List<takım> eşleştirme2() {

        List<takım> eslesme2list = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM eleme ORDER BY RAND() LIMIT 5;");
            
            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));              
                eslesme2list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eslesme2list;
    }
//Tekil okuma işlemi ve şampiyon belirliyor
    public List<takım> tekilokuma() {

        List<takım> tekillist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM eleme ORDER BY RAND() LIMIT 1;");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                tekillist.add(tmp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tekillist;
    }
//one to many
    public List<takım> getKazananlar(Long id) {
        List<takım> takımKazananlar = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from elemesonuc where id=" + id);

            while (rs.next()) {
                takımKazananlar.add(this.find(rs.getLong("id")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takımKazananlar;
    }
//one to many için find metodu
    public takım find(long id) {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        takım ktakım = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from eleme where id=" + id);

            rs.next();
            ktakım = new takım();
            ktakım.setİd(rs.getLong("id"));
            ktakım.setTakımAdı(rs.getString("takımAdı"));

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ktakım;
    }
}
