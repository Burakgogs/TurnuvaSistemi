/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.illerDAO;
import entity.iller;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author HP
 */

@Named
@SessionScoped
public class illerController implements Serializable{
    private List<iller> illerList;
    private List<iller> ilList;
    private illerDAO illerdao;
    private iller il = new iller();
    private List<iller> tlist;
    
   

    public illerController() {
    }

    public illerController(List<iller> illerList, List<iller> ilList, illerDAO illerdao, List<iller> tlist) {
        this.illerList = illerList;
        this.ilList = ilList;
        this.illerdao = illerdao;
        this.tlist = tlist;
    }

    
    public void ekle() {
        this.getIllerdao().insert(il);
        this.il=new iller();
        
    }
    public String delete(){
        this.getIllerdao().delete(il);
        this.il=new iller();
        return "index";
    }
    public String deleteConfirm(iller il1){
        this.il=il1;
        return "confirm_delete";
    }
    
    public void updateForm(iller il1){
        this.il=il1;
        
    }
    public void update(){
        this.getIllerdao().update(il);
        this.il=new iller();
        
    }

    public List<iller> getIllerList() {
        return illerList;
    }

    public void setIllerList(List<iller> illerList) {
        this.illerList = illerList;
    }

    public List<iller> getIlList() {
        return ilList;
    }

    public void setIlList(List<iller> ilList) {
        this.ilList = ilList;
    }

    public List<iller> getTlist() {
        return tlist;
    }

    public void setTlist(List<iller> tlist) {
        this.tlist = tlist;
    }

    

    public illerDAO getIllerdao() {
        return illerdao;
    }

    public void setIllerdao(illerDAO illerdao) {
        this.illerdao = illerdao;
    }

    public iller getIl() {
        return il;
    }

    public void setIl(iller il) {
        this.il = il;
    }
    
}
