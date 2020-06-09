/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HP
 */
public class takım {

    private int id;
    private String takımAdı;
    private int  ilid;

    public takım(int id, String takımAdı, int ilid) {
        this.id = id;
        this.takımAdı = takımAdı;
        this.ilid = ilid;
    }

   
    
    public takım() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTakımAdı() {
        return takımAdı;
    }

    public void setTakımAdı(String takımAdı) {
        this.takımAdı = takımAdı;
    }

    public int getIlid() {
        return ilid;
    }

    public void setIlid(int ilid) {
        this.ilid = ilid;
    }

    @Override
    public String toString() {
        return "tak\u0131m{" + "id=" + id + ", tak\u0131mAd\u0131=" + takımAdı + ", ilid=" + ilid + '}';
    }
    

    

   
}
