package controller;

import dao.turDAO;
import entity.sonuctakım;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

// tur kontrolü için Java Bean validatör ve arayüz bağlantısı
//Kura çekiminin bulunduğu class
@Named
@SessionScoped
public class turController implements Serializable {

    private List<takım> turlist;
    private List<takım> turlist2;
    private List<takım> eslesme2list;
    private turDAO turdao;
    private List<takım> tekilokuma;
   
 private takım turtakım = new takım();
    private List<takım> firstturlist;

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
//Eşleştirme için ev sahibi takım belirlenmesi
    public List<takım> getTurlist() {
        this.turlist = this.getTurdao().evsahibi();
        return turlist;
    }
//Eşleştirme için deplasman takımı belirlenmesi
    public List<takım> getTurlist2() {
        this.turlist = this.getTurdao().deptakım();
        return turlist;
    }

    public void setTurlist(List<takım> turlist) {
        this.turlist = turlist;
    }

    public void setTurlist2(List<takım> turlist2) {
        this.turlist2 = turlist2;
    }

    public List<takım> getFirstturlist() {
        this.firstturlist = this.getTurdao().denemeilktur();
        return firstturlist;
    }

}
