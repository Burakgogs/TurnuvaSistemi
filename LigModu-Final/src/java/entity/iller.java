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
public class iller {
    private int il_id;
    private String ilAdı;

    public iller() {
    }

    public iller(int il_id, String ilAdı) {
        this.il_id = il_id;
        this.ilAdı = ilAdı;
    }

    public int getIl_id() {
        return il_id;
    }

    public void setIl_id(int il_id) {
        this.il_id = il_id;
    }

    public String getIlAdı() {
        return ilAdı;
    }

    public void setIlAdı(String ilAdı) {
        this.ilAdı = ilAdı;
    }

    @Override
    public String toString() {
        return "iller{" + "il_id=" + il_id + ", ilAd\u0131=" + ilAdı + '}';
    }
    
    
}
