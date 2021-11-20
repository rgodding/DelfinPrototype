package entity;

public class Record {
    private Member member;
    private String time;
    private String date;
    private int placement;
    private Discipline discipline;

    public Record(Member member, String time, String date, String placement, Discipline discipline){
        this.member = member;
        this.time = time;
        this.date = date;
        this.placement = Integer.parseInt(placement);
        this.discipline = discipline;
    }
}
