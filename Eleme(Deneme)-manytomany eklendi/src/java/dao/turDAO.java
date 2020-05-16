/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author burak
 */
public class turDAO {

    public List<takım> sonuclist = new ArrayList();

    public List<takım> findAll() {
        List<takım> tlist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from takim");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takimAdi"));

                tlist.add(tmp);
                sonuclist.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(elemeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

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
