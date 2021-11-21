package domain;

import database.FileHandler;
import entity.Coach;
import entity.Discipline;
import entity.Member;
import entity.MemberCompetitive;
import entity.Record;
import ui.UserInferface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    FileHandler fileHandler;
    UserInferface ui;
    ArrayList<Member> members;
    ArrayList<Coach> coaches;
    ArrayList<Record> records;
    Member testMember;

    public void start(){
        fileHandler = new FileHandler();
        ui = new UserInferface();
        members = getMembers();
        coaches = getCoaches();
        records = getRecords();
        test();
    }

    public void test(){
        ArrayList<Discipline> testDisciplines = new ArrayList<>();
        testDisciplines.add(Discipline.Crawl);
        testDisciplines.add(Discipline.Butterfly);

        LocalDate testDate = LocalDate.of(1999,7,29);

        //String name, LocalDate age, boolean active, Coach coach, ArrayList<Discipline> disciplines
        Member member1 = new MemberCompetitive("Jack", testDate, true, coaches.get(1), testDisciplines);
        testMember = member1;
        System.out.println(member1);
        System.out.println(member1.getData());

    }


    public ArrayList<Member> getMembers(){
        ArrayList<Member> members = new ArrayList<>();
        return members;
    }

    public ArrayList<Coach> getCoaches(){
        ArrayList<Coach> coaches = new ArrayList<>();
        coaches.add(new Coach(1,"coach 1"));
        coaches.add(new Coach(2,"coach 2"));
        coaches.add(new Coach(3,"coach 3"));
        return coaches;
    }
    public ArrayList<Record> getRecords(){
        ArrayList<Record> records = new ArrayList<>();
        //public Record(Member holder, String time, LocalDate date, int placement, String discipline){
        Record record1 = new Record(testMember, "05:05", LocalDate.now(),1,"Butterfly");
        Record record2 = new Record(testMember, "04:05", LocalDate.now(),2,"Crawl");
        Record record3 = new Record(testMember, "02:05", LocalDate.now(),4,"Butterfly");
        Record record4 = new Record(testMember, "03:05", LocalDate.now(),3,"Butterfly");
        Record record5 = new Record(testMember, "01:05", LocalDate.now(),5,"Crawl");
        return records;
    }
    public void createMember(){
        Scanner sc = new Scanner(System.in);
        //(String name, LocalDate age, boolean active)
        //Evt. Motionist or Competitive
        System.out.println("type member's name: ");
        String name = sc.nextLine();
        System.out.println("type member's birthdate: ");
        LocalDate age = typeDate();
        System.out.println("is the member active? ");
        boolean active = yesOrNo();
        System.out.println("is the member a competitive swimmer? ");
        boolean competitive = yesOrNo();

        Member member;
        if(competitive){
            System.out.println("creating competitive member...");
            member = createCompetitiveMember(name, age, active);
        } else {
            System.out.println("creating motionist member...");
            member = new Member(name, age, active);
        }

        System.out.println(member);

    }
    public Member createCompetitiveMember(String name, LocalDate age, boolean active){
        Scanner sc = new Scanner(System.in);
        System.out.println("which disciplines does the swimmer practice?");
        ArrayList<Discipline> disciplines = new ArrayList<>();
        System.out.println("Crawl?");
        if(yesOrNo()){
            disciplines.add(Discipline.Crawl);
        }
        System.out.println("Rygcrawl?");
        if (yesOrNo()){
            disciplines.add(Discipline.Rygcrawl);
        }
        System.out.println("Butterfly?");
        if (yesOrNo()){
            disciplines.add(Discipline.Butterfly);
        }
        System.out.println("Brystswømning?");
        if (yesOrNo()){
            disciplines.add(Discipline.Brystswømning);
        }
        printCoaches();
        System.out.println("Select a coach: ");
        int coachID = sc.nextInt();
        Coach coach = null;
        boolean invalidCoach = true;
        while(invalidCoach) {
            for (int i = 0; i < coaches.size(); i++) {
                if(coachID==coaches.get(i).getId()){
                    coach = coaches.get(i);
                    invalidCoach = false;
                }
            }
        }
        return new MemberCompetitive(name, age, active, coach, disciplines);
    }
    public void printCoaches(){
        for (int i = 0; i < coaches.size(); i++){
            System.out.println(coaches.get(i));
        }
    }


    public LocalDate typeDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("year(YYYY): ");
        int year = sc.nextInt();
        while(year > LocalDate.now().getYear() || year < (LocalDate.now().getYear()) - 110){
            System.out.println("invalid birth year");
            year = sc.nextInt();
        }
        System.out.print("month(MM): ");
        int month = sc.nextInt();
        while(month > 12 || month < 1){
            System.out.println("invalid month");
            month = sc.nextInt();
        }
        System.out.println("day(DD): ");
        int day = sc.nextInt();
        while(day > 31 || day < 1){
            System.out.println("invalid day");
            day = sc.nextInt();
        }

        return LocalDate.of(year, month, day);
    }
    public boolean yesOrNo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("yes or no?");
        String answer = sc.nextLine().toLowerCase();
        while(!answer.equals("yes") && !answer.equals("no")){
            System.out.println("please type 'yes' or 'no'");
            answer = sc.nextLine();
        }
        return answer.equals("yes");
    }
    public Member stringToMember(String memberData){
        //id + "_" + name + "_" + age + "_" + active + "_" + debt + "_" + startDate.toString();
        String[] data = memberData.split("_");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        LocalDate age = stringToLocalDate(data[2]);
        boolean active = Boolean.getBoolean(data[3]);
        double debt = Double.parseDouble(data[4]);
        LocalDate startDate = stringToLocalDate(data[5]);
        return new Member(id, name, age, active, debt, startDate);
    }
    public LocalDate stringToLocalDate(String date){
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        return LocalDate.of(year, month, day);
    }
}
