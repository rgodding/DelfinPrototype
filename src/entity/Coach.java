package entity;

public class Coach {

    private int id;
    private String name;

    public Coach(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getData(){
        return id + "";
    }

    public String toString(){
        return name + "(" + id + ")";
    }
}
