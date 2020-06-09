package entity;

import java.util.List;
//elemesonuc tablosu için entity classı
public class sonuctakım {

    private int id;

    private String takımAdı2;
    private List<takım> Kazananlar;

    public List<takım> getKazananlar() {
        return Kazananlar;
    }

    public void setKazananlar(List<takım> Kazananlar) {
        this.Kazananlar = Kazananlar;
    }

    public sonuctakım(int id, String takımAdı2) {
        this.id = id;

        this.takımAdı2 = takımAdı2;
    }

    public sonuctakım() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTakımAdı2() {
        return takımAdı2;
    }

    public void setTakımAdı2(String takımAdı2) {
        this.takımAdı2 = takımAdı2;
    }

    @Override
    public String toString() {
        return "tak\u0131m{" + "tak\u0131mAd\u01312" + takımAdı2 + '}';
    }

}
