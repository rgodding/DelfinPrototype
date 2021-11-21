package entity;

import java.time.LocalDate;

public class Record {
    private int id;
    private Member holder;
    private String time;
    private LocalDate date;
    private int placement;
    private String discipline;

    public Record(Member holder, String time, LocalDate date, int placement, String discipline){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.placement = placement;
        this.discipline = discipline;
    }

    public Member getHolder() {
        return holder;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "holder=" + holder +
                ", time='" + time + '\'' +
                ", date=" + date +
                ", placement=" + placement +
                ", discipline='" + discipline + '\'' +
                '}';
    }
}
