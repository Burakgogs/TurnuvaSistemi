package controller;

import dao.elemeDAO;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Java Bean validatör ve arayüz bağlantısı
@Named
@SessionScoped
public class elemeController implements Serializable {

    private List<takım> tlist;
    private List<takım> eslesme2list;
    private elemeDAO edao;
    private List<takım> tekilokuma;
    private takım takım1 = new takım();

    public void ekle() {
        this.getEdao().insert(this.takım1);
    }

    public String delete() {
        this.getEdao().delete(this.takım1);
        this.takım1 = new takım();
          return "index";
    }
  public String deleteConfirm(takım tak){
        this.takım1=tak;
        return "confirm_delete";
    }
  
    public void updateForm(takım tak) {
        this.takım1 = tak;
    }

    public void update() {
        this.getEdao().update(this.takım1);
    }

    public elemeController() {
    }

    public takım getTakım1() {
        if (takım1 == null) {
            this.takım1 = new takım();
        }
        return takım1;
    }

    public void setTakım1(takım takım1) {
        this.takım1 = takım1;
    }

    public List<takım> getTlist() {
        this.tlist = this.getEdao().findAll();
        return tlist;
    }

    public void setTlist(List<takım> tlist) {
        this.tlist = tlist;
    }

    public elemeDAO getEdao() {
        if (edao == null) {
            this.edao = new elemeDAO();
        }
        return edao;
    }

    public void setTdao(elemeDAO edao) {
        this.edao = edao;
    }

    public List<takım> getEslesme2list() {
        this.eslesme2list = this.getEdao().eşleştirme2();
        return eslesme2list;
    }

    public List<takım> getTekillist() {
        this.tekilokuma = this.getEdao().tekilokuma();
        return tekilokuma;
    }

    public void setEslesme2list(List<takım> eslesme2list) {
        this.eslesme2list = eslesme2list;
    }
}
