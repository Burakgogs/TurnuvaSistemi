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
public class Fikstür {
    private String Takım1;
    private String Takım2;
    private int Hafta;

    public Fikstür() {
    }

    public Fikstür(String Takım1, String Takım2, int HaftaId) {
        this.Takım1 = Takım1;
        this.Takım2 = Takım2;
        
        this.Hafta = HaftaId;
    }

    public String getTakım1() {
        return Takım1;
    }

    public void setTakım1(String Takım1) {
        this.Takım1 = Takım1;
    }

    public String getTakım2() {
        return Takım2;
    }

    public void setTakım2(String Takım2) {
        this.Takım2 = Takım2;
    }

    public int getHafta() {
        return Hafta;
    }

    public void setHafta(int Hafta) {
        this.Hafta = Hafta;
    }

    @Override
    public String toString() {
        return "Fikst\u00fcr{" + "Tak\u0131m1=" + Takım1 + ", Tak\u0131m2=" + Takım2  + ", Hafta=" + Hafta + '}';
    }
    
}
