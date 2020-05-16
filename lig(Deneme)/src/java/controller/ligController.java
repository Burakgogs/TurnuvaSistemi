/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ligDAO;
import entity.takım;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ligController implements Serializable {

    private List<takım> tlist;
    private List<takım> llist;
    private ligDAO Ldao;
    private takım takım1= new takım();

    public void ekle() {
        this.getLdao().insert(this.takım1);
        this.takım1=new takım();
        
    }
    public String delete(){
        this.getLdao().delete(this.takım1);
        this.takım1=new takım();
        return "index";
    }
    public String deleteConfirm(takım tak){
        this.takım1=tak;
        return "confirm_delete";
    }
    
    public void updateForm(takım tak){
        this.takım1=tak;
        
    }
    public void update(){
        this.getLdao().update(this.takım1);
        this.takım1=new takım();
        
    }
    public void eşleştirme(){
        this.getLdao().eşleştirme();
        
    }
    public void clearForm(){
        this.takım1=new takım();
        
    }

    public ligController() {
    }

    public List<takım> getLlist() {
        this.llist=this.getLdao().eşleştirme();
        return llist;
    }

    public void setLlist(List<takım> llist) {
        this.llist = llist;
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
        this.tlist = this.getLdao().findAll();
        return tlist;
    }

    public void setTlist(List<takım> tlist) {
        this.tlist = tlist;
    }

    public ligDAO getLdao() {
        if(Ldao==null)
            this.Ldao = new ligDAO();
        
        return Ldao;
    }

    public void setLdao(ligDAO Ldao) {
        this.Ldao = Ldao;
    }

}
