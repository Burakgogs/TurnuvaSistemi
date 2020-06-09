package dao;

import entity.takım;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author burak
 */
//Eşleştirmeyi ve fikstürü belirleyen kodlar
public class turDAO {

    public List<takım> sonuclist = new ArrayList();

    //Ev sahibi takımlarının belirlenmesi
    public List<takım> evsahibi() {
        List<takım> tlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        List<takım> essonuc = new ArrayList();
        List<takım> es2sonuc = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from eleme");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                tlist.add(tmp);
                sonuclist.add(tmp);

            }

            
            for (int i = 0; i < tlist.size() / 2; i++) {

                essonuc.add(sonuclist.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return essonuc;
    }
    
//deplasman takımlarının belirlenmesi
    public List<takım> deptakım() {

        List<takım> tlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        List<takım> es2sonuc = new ArrayList();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from eleme");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                tlist.add(tmp);
                sonuclist.add(tmp);

            }
            int a = tlist.size();
            for (int j = a - 1; j > a / 2 ; j--) {

                es2sonuc.add(sonuclist.get(j));
            }
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return es2sonuc;
    }
//eşleştirme deneme kodu bölümü
    public List<takım> denemeilktur() {
      
      
        List<takım> turismi = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

       
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from turisimleri");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                turismi.add(tmp);
                

            }
          
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return turismi;
    }
//CRUD İŞLEMLERİ
    public void insert(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            st.executeUpdate("insert into takim (takimAdi) values ('" + takım1.getTakımAdı() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from takim where id=" + takım1.getId());

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update takim set takımAdı='" + takım1.getTakımAdı() + "' where id= " + takım1.getId());

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<takım> turakatilan() {
        List<takım> katilan = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from eleme");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                katilan.add(tmp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return katilan;
    }

    public List<takım> eşleştirme2() {

        List<takım> eslesme2list = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM takim ORDER BY RAND() LIMIT 5;");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takimAdi"));

                eslesme2list.add(tmp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eslesme2list;
    }
    
     public List<takım> fikstur() {

        List<takım> eslesme2list = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM takim ");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takimAdi"));

                eslesme2list.add(tmp);

            }
            int takımsayısı = eslesme2list.size();
            
        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eslesme2list;
    }
    
    
    
//Tekil okuma

    public List<takım> tekilokuma() {

        List<takım> tekillist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM takim ORDER BY RAND() LIMIT 1;");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takimAdi"));

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
//one to many

    public takım find(long id) {

        DBConnection db = new DBConnection();
        Connection c = db.connect();
        takım ktakım = null;
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from takim where id=" + id);

            rs.next();
            ktakım = new takım();
            ktakım.setİd(rs.getLong("id"));
            ktakım.setTakımAdı(rs.getString("takimAdi"));

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ktakım;
    }
}
