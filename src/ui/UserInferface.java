package ui;

import domain.Controller;
import domain.ControllerT;
import entity.Member;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInferface {
    Scanner sc = new Scanner(System.in);
    ControllerT controllerT;
    Controller controller;

    public UserInferface(ControllerT controllerT){
        this.controllerT = controllerT;
    }
    public UserInferface(Controller controller){
        this.controller = controller;
    }

    public void mainMenu(){
        String userChoice = "";
        boolean activeMenu = true;
        while(activeMenu) {
            System.out.println("""
                    1: Administer Members
                    0: Exit
                    """);
            switch (menuScanner(0, 1)) {
                case 1:
                    administerMember();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }


    public void administerMember(){
        System.out.println("""
                1: Add Member
                2: Edit Member
                3: Remove Member
                0: Return
                """);
        switch (menuScanner(0, 3)){
            case 1:
                controller.addMember();
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                break;
        }
    }
    public void addMember(){

    }

    //Exit
    public String exit(){

        return "exit";
    }


    //Test
    public int menuScanner(int min, int max){
        System.out.print("please choose an option: ");
        int choice = intScanner();
        while(choice > max || choice < min){
            System.out.println("please type a number between " + min + " and " + max);
            choice = intScanner();
        }
        return choice;
    }

    //Features
    public void printMessage(String message){
        System.out.println(message);
    }
    public String userInput(){
        return sc.nextLine();
    }
    public int intScanner(){
        String input = sc.nextLine();
        while(!input.matches("\\d+")){
            System.out.print("please type a number: ");
            input = sc.nextLine();
        }
        return Integer.parseInt(input);
    }
}
