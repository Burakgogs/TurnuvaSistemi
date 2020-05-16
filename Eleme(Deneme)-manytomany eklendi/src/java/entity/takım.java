package entity;

public class takım {

    private int id;
    private String takımAdı;

    public takım(int id, String takımAdı) {
        this.id = id;
        this.takımAdı = takımAdı;
    }

    public takım() {
    }

    public int getId() {
        return id;
    }

    public String getTakımAdı() {
        return takımAdı;
    }

    public void setTakımAdı(String takımAdı) {
        this.takımAdı = takımAdı;
    }

    @Override
    public String toString() {
        return "tak\u0131m{" + "tak\u0131mAd\u0131=" + takımAdı + '}';
    }

    public void setİd(long aLong) {

        this.id = id;
    }

}
