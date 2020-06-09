/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.iller;
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
public class illerDAO {
   

    

    public List<iller> findAll() {
        List<iller> ilist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            //$sorgu     = mysql_query("SELECT * FROM haberler ORDER BY rand() LIMIT 5");
            //Select ROW_NUMBER() OVER(ORDER BY Id ASC) 0,* From eleme ;
            ResultSet rs = st.executeQuery("select * from iller");

            while (rs.next()) {

                iller tmp = new iller(rs.getInt("il_id"), rs.getString("ilAdı"));

                ilist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ilist;
    }

    public void insert(iller il) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            st.executeUpdate("insert into iller (il_id,ilAdı) values ('" + il.getIl_id() + "','"+il.getIlAdı() +"')");
            

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(iller il) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("delete from iller where id=" + il.getIl_id());

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(iller il ) {
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            
            st.executeUpdate("update iller set ilAdı='" + il.getIlAdı() + "' where id= " + il.getIlAdı());
            

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    }

