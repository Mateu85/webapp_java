package com.svalero.webappjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionMenu {

    private Scanner Scanner;
    private List<Task> TaskList;

    public OptionMenu() {
        Scanner = new Scanner(System.in);
        TaskList = new ArrayList<>();
    }

    public void optionMenu() {

        fillUpList();
        String option = null;

        do {
            System.out.println("***** Options *****");
            System.out.println("1. Insert Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Modify a Task");
            System.out.println("5. See the Task List");
            System.out.println("6. EXIT");
            System.out.print("Type Option: ");
            option = Scanner.nextLine();

            switch(option) {
                case "1":
                    addTask();
                    break;
                case "2":
                    searchTask();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    modifytask();
                    break;
                case "5":
                    seeAllTask();
                    break;
            }
        } while (!option.equals("6"));
    }
// title,  type,  description,  paid,  location
    public void addTask(){
        System.out.print("Title: ");
        String title = Scanner.nextLine();
        System.out.print("type: ");
        String type = Scanner.nextLine();
        System.out.print("description: ");
        String description = Scanner.nextLine();
        System.out.print("Is it a paid task? Type either *FREE* or your budget: ");
        String paid = Scanner.nextLine();
        System.out.print("Type the Location where the task is gonna take place: ");
        String location = Scanner.nextLine();
        Task task = new Task(title.trim(), type.trim(), description.trim(), paid.trim(),location.trim() );
        TaskList.add(task);

    }

    public void searchTask(){
        System.out.println("Delete Task:");
        String task = Scanner.nextLine();


    }

    public void deleteTask(){

    }

    public void modifytask(){

    }

    public void seeAllTask(){

        for (Task task : TaskList){
            System.out.println(task.getTitulo());
            System.out.println(task.getAutor());
            System.out.println(task.getEditorial());
        }

    }

    public void fillUpList(){

    }

    public void TaskList(){
        TaskList.add(new Task(
                "Flat removal 1/2 Day Two people + Van",
                "Flat removal",
                 "I live in a second floor and in order to have my " +
                         "removal done I´d need two people and one van for roughly half day ",
                " 200 Pounds",
                "Wafol St, 0023 BCN"


        ));
    }



}
