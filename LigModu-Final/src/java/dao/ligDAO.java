/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.takım;
import entity.Fikstür;
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

    public List<takım> tekilokuma() {
        //Tekil okuma işlemini yapar lig tablosundan random bir takım alır ve onu lider olarak gösterir.
        List<takım> tekillist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lig ORDER BY RAND() LIMIT 1;");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"),rs.getInt("il_id"));

                tekillist.add(tmp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tekillist;
    }

    public List<takım> findAll() {
        //okuma işleminin yapıldığı metottur.lig tablosundan verileri çekmeye yarar.
        List<takım> tlist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            
            ResultSet rs = st.executeQuery("select * from lig");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"),rs.getInt("il_id"));

                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

    public void insert(takım takım1) {
        //lig tablosuna veri ekleme işlemi yapar.
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();
            st.executeUpdate("insert into lig (takımAdı,il_id) values ('" + takım1.getTakımAdı() + "','"+ takım1.getIlid()+"')");
            

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(takım takım1) {
        //lig tablosundan id ile veri silme işlemi yapar.
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
        //seçilen nesnenin güncellemesini yaparken kullanılan metottur.
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            st.executeUpdate("update lig set takımAdı='" + takım1.getTakımAdı() + "' where id= " + takım1.getId());
            st.executeUpdate("update lig set il_id='" + takım1.getIlid() + "' where id= " + takım1.getId());

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public List<takım> eşleştirme() {
        //Lig in alfabeye göre sıralamasını yapan metottur.

        List<takım> elist = new ArrayList();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("select * from lig order by takımAdı");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"),rs.getInt("il_id"));
                elist.add(tmp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elist;
    }
}
