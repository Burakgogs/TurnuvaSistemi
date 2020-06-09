package controller;

import dao.elemeDAO;
import dao.elemesonucDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import dao.turDAO;

//Sonucların ekrana verilmesi kura çekimi ve javabean validatör 
@Named
@SessionScoped
public class sonucController implements Serializable { 
    private elemesonucDAO esdao;
    private elemeDAO edao;
private turDAO turdao;

    public turDAO getTurdao() {
       if (turdao == null) {
            this.turdao = new turDAO();
        }
        return turdao;
    }

    public void setTurdao(turDAO turdao) {
        this.turdao = turdao;
    }
    public elemesonucDAO getEsdao() {
        if (esdao == null) {
            this.esdao = new elemesonucDAO();
        }
        return esdao;
    }

    public void setEsdao(elemesonucDAO esdao) {
        this.esdao = esdao;
    }
 public String yenile() {
        
          return "index";
    }
 
    public void eşleştirme() {
      //vize öncesi eşleştirme mantığı denenmesi için eşleştirme2 ve eşleştirme3 kullanılmıştır 
       // this.getEdao().eşleştirme2();
      //  this.getEsdao().eşleştirme3();
        this.getTurdao().evsahibi();
        this.getTurdao().deptakım();
        this.getEdao().tekilokuma();
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
