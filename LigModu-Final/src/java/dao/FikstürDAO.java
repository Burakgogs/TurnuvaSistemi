/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Fikstür;
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
public class FikstürDAO {

    

    public List<takım> findAll() {
        //fikstür tablsoundaki verileri çekmekte kullanılır.
        List<takım> tlist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            //$sorgu     = mysql_query("SELECT * FROM haberler ORDER BY rand() LIMIT 5");
            //Select ROW_NUMBER() OVER(ORDER BY Id ASC) 0,* From eleme ;
            ResultSet rs = st.executeQuery("select * from lig  ");

            while (rs.next()) {

                takım tmp = new takım(rs.getInt("id"), rs.getString("takımAdı"),rs.getInt("il_id"));

                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

    public void insert(Fikstür fikstür) {
        //eşleştirme yapıldıktan sonra eşleştirme2 metotunun sonunda çağırılır ve fikstürü veri tabanına ekler.
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();

            st.executeUpdate("insert into fikstür (Takım1,Takım2,Hafta) values ('" + fikstür.getTakım1() + "' ,'" + fikstür.getTakım2() + "' , '" + fikstür.getHafta() + "')");
           
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sil() {
        //veri tabanının her işlemden sonra boş olmasını sağlar.eşleştirme metotunun başında çağırılır ve fikstür tablosunu temizler.
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {

            Statement st = c.createStatement();

            st.executeUpdate("delete from fikstür");

        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fikstür> Yazma() {
        //Oluşturulan fikstürün web tarafına aktarılmasını sağlar.
        List<Fikstür> tlist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection c = db.connect();

        try {
            Statement st = c.createStatement();
            //$sorgu     = mysql_query("SELECT * FROM haberler ORDER BY rand() LIMIT 5");
            //Select ROW_NUMBER() OVER(ORDER BY Id ASC) 0,* From eleme ;
            ResultSet rs = st.executeQuery("select * from fikstür");

            while (rs.next()) {
                
                Fikstür tmp = new Fikstür(rs.getString("Takım1"), rs.getString("Takım2"), rs.getInt("Hafta"));

                tlist.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ligDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tlist;
    }

    public void eşleştirme() {
        sil();
        eşleştirme2();
       
    }

    public List<takım> eşleştirme1() {
        //lig tablsoundaki takımları çeker.
        
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

    public void eşleştirme2() {
        List<String> insertedTeams = new ArrayList();
        List<takım> elist = eşleştirme1();
        List<Fikstür> f = new ArrayList();
        for (int i = 0; i < elist.size(); i++) {    // 2 for döngüsü ile listeyi 2 kez gezer ve takımları eşleştirir.

            for (int j = 0; j < elist.size(); j++) {
                if (elist.get(i).getTakımAdı() != elist.get(j).getTakımAdı()) {     //burada aynı iki takımın eşleşmesine engel olur. 
                    f.add(new Fikstür(elist.get(i).getTakımAdı(), elist.get(j).getTakımAdı(), -1));//Her takımın Hafta id lerini -1 yapıyor.
                }
            }
        }

        for (int i = 1; i <= (elist.size() - 1) * 2; i++) {//hafta sayısı kadar dönüp eşletirmeleri insertedTeams a atıyor.
            insertedTeams = null;
            insertedTeams = new ArrayList();
            for (int j = 0; j < f.size(); j++) {
                if (f.get(j).getHafta() == -1 && insertedTeams.contains(f.get(j).getTakım1()) == false && insertedTeams.contains(f.get(j).getTakım2()) == false) {
                    //takımların hafta id leri -1 se ve daha önce ikisi eşleşmemişse if içerisine giriyor ve burda ev sahibi takım1 e deplasman takım2 ye atanıyor. 
                    f.get(j).setHafta(i);
                    insertedTeams.add(f.get(j).getTakım1());
                    insertedTeams.add(f.get(j).getTakım2());
                    insert(f.get(j));

                }
            }
        }

    }

}
