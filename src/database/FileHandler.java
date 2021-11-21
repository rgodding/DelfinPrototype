package database;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    //norm_8580_Jack_1999-07-29_true_0.0_2021-11-21_2_true_false_true_false
    //STATUS_ID_NAME_BIRTHDATE_ACTIVE_DEBT_CREATIONDATE_CRAWL_RYGCRAWL_BUTTERFLY_BRYSTSWØMNING
    //int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate, | COMP | + Coach coach, ArrayList<Discipline> disciplines

    public void addMember(String data){
        File file = new File("data/members.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/members.txt",file.exists()));
            writer.newLine();
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getMembers(){
        ArrayList<String> members = new ArrayList<>();
        File file = new File("data/members.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                members.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return members;
    }
    public void updateMember(String data){
        //https://stackoverflow.com/questions/31375972/how-to-replace-a-specific-line-in-a-file-using-java
        Path path = Paths.get("data/members.txt");
        List<String> lines = null;
        String[] memberData = data.split("_");
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int line = findMemberLine(memberData);
            if(line==-1){
                System.out.println("can't find member");
                return;
            }
            lines.set(line-1, data);
            Files.write(path,lines,StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int findMemberLine(String[] data){
        File file = new File("data/members.txt");
        try {
            Scanner sc = new Scanner(file);
            int lineCount = 0;
            while(sc.hasNextLine()){
                lineCount++;
                String[] tempData = sc.nextLine().split("_");
                if(tempData[0].equals(data[0])){
                    return lineCount;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
