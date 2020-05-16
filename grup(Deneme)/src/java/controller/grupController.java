/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.grupDAO;
import entity.takım;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class grupController implements Serializable {

    private List<takım> tlist;
    private List<takım> glist;
    private grupDAO gdao;
    private takım takım1= new takım();

    public String ekle() {
        this.getGdao().insert(this.takım1);
        return "index";
    }
    public String delete(takım tak){
        this.getGdao().delete(tak);
        return "index";
    }
    public String updateForm(takım tak){
        this.takım1=tak;
        return "index";
    }
    public String update(){
        this.getGdao().update(this.takım1);
        return"index";
    }
    public void eşleştirme(){
        this.getGdao().eşleştirme();
        
    }

    public grupController() {
    }

    public List<takım> getGlist() {
        this.glist=this.getGdao().eşleştirme();
        return glist;
    }

    public void setGlist(List<takım> elist) {
        this.glist = elist;
    }
    
    public takım getTakım1() {
        if(takım1==null)
            this.takım1 = new takım();
        
        return takım1;
    }

    public void setTakım1(takım takım1) {
        this.takım1 = takım1;
    }

    public List<takım> getTlist() {
        this.tlist = this.getGdao().findAll();
        return tlist;
    }

    public void setTlist(List<takım> tlist) {
        this.tlist = tlist;
    }

    public grupDAO getGdao() {
        if(gdao==null)
            this.gdao = new grupDAO();
        
        return gdao;
    }

    public void setGdao(grupDAO gdao) {
        this.gdao = gdao;
    }

}
