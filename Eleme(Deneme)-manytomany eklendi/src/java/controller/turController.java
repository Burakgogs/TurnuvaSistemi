package controller;

import dao.turDAO;
import entity.sonuctakım;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class turController implements Serializable {

    private List<takım> turlist;

    private List<takım> eslesme2list;
    private turDAO turdao;
    private List<takım> tekilokuma;
    private takım turtakım = new takım();

    public String ekle() {
        this.getTurdao().insert(this.turtakım);
        return "index";
    }

    public String delete(takım tak) {
        this.getTurdao().delete(tak);
        return "index";
    }

    public String updateForm(takım tak) {
        this.turtakım = tak;
        return "index";
    }

    public String update() {
        this.getTurdao().update(this.turtakım);
        return "index";
    }

    public turController() {
    }

    public turDAO getTurdao() {
        if (turdao == null) {
            this.turdao = new turDAO();
        }
        return turdao;
    }

    public void setTdao(turDAO edao) {
        this.turdao = edao;
    }

    public List<takım> getTurlist() {
        this.turlist = this.getTurdao().findAll();
        return turlist;
    }

    public void setTurlist(List<takım> turlist) {
        this.turlist = turlist;
    }
}
