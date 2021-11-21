package entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetitive extends Member {

    private Coach coach;
    private ArrayList<Discipline> disciplines;

    public MemberCompetitive(String name, LocalDate age, boolean active, Coach coach, ArrayList<Discipline> disciplines) {
        super(name, age, active);
        this.disciplines = disciplines;
        this.coach = coach;
    }


    //ToString Tools
    private String toStringDisciplines(){
        String result = "";
        for(int i = 0; i < disciplines.size(); i++){
            result += disciplines.get(i);
            if(i < disciplines.size()-1){
                result += "\n";
            }
        }
        return result;
    }
    private String disciplinesGetData(){
        boolean crawl = false;
        boolean rygCrawl = false;
        boolean butterfly = false;
        boolean brystswømning = false;
        for(int i = 0; i < disciplines.size(); i++){
            Discipline discipline = disciplines.get(i);
            if(discipline==Discipline.Crawl){
                crawl = true;
            }
            if(discipline==Discipline.Rygcrawl){
                rygCrawl = true;
            }
            if(discipline==Discipline.Butterfly){
                butterfly = true;
            }
            if(discipline==Discipline.Brystswømning){
                brystswømning = true;
            }
        }
        return crawl + "_" + rygCrawl + "_" + butterfly + "_" + brystswømning;
    }

    @Override
    public String getData() {
        return super.getData() + "_" + coach.getData() + "_" + disciplinesGetData();
    }

    public String toString(){
        return super.toString() + "\nCompetitive Swimmer - Coach: " + coach +
                "\nDisciplines:\n" + toStringDisciplines();
    }

}
