package controller;

import dao.elemeDAO;
import dao.elemesonucDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class sonucController implements Serializable { 
    private elemesonucDAO esdao;
    private elemeDAO edao;

    public elemesonucDAO getEsdao() {
        if (esdao == null) {
            this.esdao = new elemesonucDAO();
        }
        return esdao;
    }

    public void setEsdao(elemesonucDAO esdao) {
        this.esdao = esdao;
    }

    public String eşleştirme() {
        this.getEdao().eşleştirme2();
        this.getEsdao().eşleştirme3();
        return "index";
    }

    public elemeDAO getEdao() {
        if (edao == null) {
            this.edao = new elemeDAO();
        }

        return edao;
    }

    public void setEdao(elemeDAO edao) {
        this.edao = edao;
    }

}
