package uz.pdp.appbankcard.models;

public class CardType {
    private int id;
    private String name;
    private String prefix4;
    private boolean isDeleted ;

    public CardType(int id, String name, String prefix4) {
        this.id =id;
        this.name = name;
        this.prefix4 = prefix4;
        isDeleted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return false;
    }

    public String getPrefix4() {
        return prefix4;
    }

    public boolean setPrefix4(String prefix4) {
        this.prefix4 = prefix4;
        return false;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "CardType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prefix4='" + prefix4 + '\'' +
                '}';
    }
}
