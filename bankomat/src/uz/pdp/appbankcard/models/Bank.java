package uz.pdp.appbankcard.models;

public class Bank {
    private int id;
    private String name;
    private boolean isDelete;

    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
        isDelete = false;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
