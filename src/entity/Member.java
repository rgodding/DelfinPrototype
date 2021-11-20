package entity;

import java.time.LocalDate;
import java.util.Random;

public class Member {

    private int id;
    private String name;
    private LocalDate age;
    private boolean active;
    private double debt;
    private LocalDate startDate;

    public Member(String name, LocalDate age, boolean active){
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
        idGenerator();
    }

    private void idGenerator(){
        Random random = new Random();
        id = random.nextInt(9999);
    }

    public String getData(){
        return id + "_" + name + "_" + age + "_" + active + "_" + debt + "_" + startDate.toString();
    }

    public String toString(){
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + LocalDate.now().compareTo(age) +
                "\nActive: " + active +
                "\nJoined at: " + startDate.toString();
    }

}
