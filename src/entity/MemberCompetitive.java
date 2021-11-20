package entity;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetitive extends Member {

    private ArrayList<Discipline> disciplines = new ArrayList();
    private Coach coach;

    public MemberCompetitive(String name, LocalDate age, boolean active) {
        super(name, age, active);
    }

}
