package entity;

import java.time.LocalDate;
import java.util.Random;

public class Member {

    private boolean isComp = false;
    private int id;
    private String name;
    private LocalDate age;
    private boolean active;
    private double debt;
    private LocalDate startDate;

    public Member(String name, LocalDate age, boolean active) {
        idGenerator();
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //Super for Competitive
    public Member(boolean isComp, String name, LocalDate age, boolean active) {
        idGenerator();
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //Already Exists
    public Member(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate){
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        this.debt = debt;
        this.startDate = startDate;
    }



    private void idGenerator(){
        Random random = new Random();
        id = random.nextInt(9999);
    }
    public String getData(){
        return isComp + "_" + id + "_" + name + "_" + age + "_" + active + "_" + debt + "_" + startDate;
    }
    public String toString(){
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + LocalDate.now().compareTo(age) +
                "\nActive: " + active +
                "\nJoined at: " + startDate.toString();
    }

}
