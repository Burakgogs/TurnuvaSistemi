package controller;

import dao.FikstürDAO;
import entity.Fikstür;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class FikstürController implements Serializable {

    private List<Fikstür> fikstürList;
    private List<takım> takımList;
    private FikstürDAO fiksdao;
    private Fikstür fikstür = new Fikstür();

    public FikstürController() {
    }

    public FikstürController(List<Fikstür> fikstürList, List<takım> takımList, FikstürDAO fiksdao) {
        this.fikstürList = fikstürList;
        this.takımList = takımList;
        this.fiksdao = fiksdao;
    }

    public List<Fikstür> Yazma() {
        if (fiksdao == null) {
            this.fiksdao = new FikstürDAO();
        }
        return fiksdao.Yazma();
    }

    public void insert() {
        this.fiksdao.insert(this.fikstür);
        this.fikstür = new Fikstür();
    }

    public void eşleştirme() {
        if(fikstür == null)
            this.fikstür=new Fikstür();
        this.fiksdao.eşleştirme();

    }

    public List<Fikstür> getFikstürList() {
        if (fiksdao == null) {
            this.fiksdao = new FikstürDAO();
        }
        this.fikstürList = fiksdao.Yazma();
        return fikstürList;
    }

    public void setFikstürList(List<Fikstür> fikstürList) {
        this.fikstürList = fikstürList;
    }

    public List<takım> getTakımList() {
        return takımList;
    }

    public void setTakımList(List<takım> takımList) {
        this.takımList = takımList;
    }

    public FikstürDAO getFiksdao() {
        if (fiksdao == null) {
            this.fiksdao = new FikstürDAO();
        }
        return fiksdao;
    }

    public void setFiksdao(FikstürDAO fiksdao) {
        this.fiksdao = fiksdao;
    }

    public Fikstür getFikstür() {
        if (fikstür == null) {
            this.fikstür = new Fikstür();
        }
        return fikstür;
    }

    public void setFikstür(Fikstür fikstür) {
        this.fikstür = fikstür;
    }

}
