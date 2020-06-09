package controller;

import dao.elemesonucDAO;
import entity.sonuctakım;
import entity.takım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


//Java Bean validatör ve arayüz bağlantısı
@Named
@SessionScoped
public class elemesonucController implements Serializable {
    
//Eleme tablosu ile birlikte kullanıldığı için index bağlantılarını ortak olan sonucController sınıfına eklenmiştir.
    private List<sonuctakım> eslesme3list;
    private List<sonuctakım> eslist;
    private sonuctakım takım2 = new sonuctakım();
    private elemesonucDAO esdao;
    private List<sonuctakım> ikinciturkazanani;
    
    public sonuctakım getTakım2() {
        if (takım2 == null) {
            this.takım2 = new sonuctakım();
        }
        return takım2;
    }

    public void setTakım2(sonuctakım takım2) {
        this.takım2 = takım2;
    }

    public void setEslist(List<sonuctakım> eslist) {
        this.eslist = eslist;
    }

    public List<sonuctakım> setEslesme3list(List<sonuctakım> eslesme3list) {
        this.eslesme3list = this.getEsdao().findAl();
        return eslesme3list;

    }
 
    public List<sonuctakım> getEslesme3list() {
        this.eslesme3list = this.getEsdao().eşleştirme3();
        return eslesme3list;
    }

    public elemesonucDAO getEsdao() {
        if (esdao == null) {
            this.esdao = new elemesonucDAO();
        }
        return esdao;
    }

}
