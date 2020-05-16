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
 * @author HP
 */
public class ligDAO {

    public List<takım> findAll() {
        List<takım> tlist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            //$sorgu     = mysql_query("SELECT * FROM haberler ORDER BY rand() LIMIT 5");
            //Select ROW_NUMBER() OVER(ORDER BY Id ASC) 0,* From eleme ;
            ResultSet rs = st.executeQuery("select * from lig");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));

                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

    public void insert(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            st.executeUpdate("insert into lig (takımAdı) values ('" + takım1.getTakımAdı() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from lig where id=" + takım1.getId());

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(takım takım1) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update lig set takımAdı='" + takım1.getTakımAdı() + "' where id= " + takım1.getId());

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<takım> eşleştirme() {
        List<takım> elist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            
            ResultSet rs = st.executeQuery("select * from lig order by takımAdı");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"));
                elist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elist;
    }
    
}
