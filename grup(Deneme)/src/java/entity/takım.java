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

    public takım(int id, String takımAdı) {
        this.id = id;
        this.takımAdı = takımAdı;
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

    @Override
    public String toString() {
        return "tak\u0131m{" + "tak\u0131mAd\u0131=" + takımAdı + '}';
    }
   

   
}
