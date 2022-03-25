package com.svalero.webapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionsMenu {

    private Scanner Scanner;
    private List<Task> catalogTasks;

    public OptionsMenu() {
        Scanner = new Scanner(System.in);
        catalogTasks = new ArrayList<>();
    }

    public void mostrarMenu() {
        // TODO Acordarse de esto
        generateTaskList();
        String option = null;

        do {
            System.out.println("List of asigments in your area.");
            System.out.println("1. Add Task.");
            System.out.println("2. Search a Task.");
            System.out.println("3. Delete a Task.");
            System.out.println("4. Modify a Task.");
            System.out.println("5. Look up the list of Tasks.");
            System.out.println("6. EXIT");
            System.out.print("Type your Option: ");
            option = Scanner.nextLine();

            switch(option) {
                case "1":
                    addTask();
                    break;
                case "2":
                    findTask();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    modifyTask();
                    break;
                case "5":
                    showTaskList();
                    break;
            }
        } while (!option.equals("6"));
    }

    public void addTask() {
        System.out.print("Title: ");
        String title = Scanner.nextLine();
        System.out.print("Task Description: ");
        String Description = Scanner.nextLine();
        System.out.print("Location: ");
        String taskLocation = Scanner.nextLine();
        Task task = new Task(title.trim(), Description.trim(), taskLocation.trim());
        catalogTasks.add(task);
    }

    public void findTask() {
        boolean found = false;
        System.out.print("Search by titile: ");
        String titulo = Scanner.nextLine();
        for (Task task : catalogTasks) {
            if (task.getTitle().contains(titulo)) {
                System.out.println("Libro encontrado");
                System.out.println(task.getTitle());
                System.out.println(task.getDescription());
                System.out.println(task.getLocation());
                found = true;
            }
        }

        if (!found)
            System.out.println("No se ha encontrado ningún libro");
    }

    public void deleteTask() {
        System.out.print("Titulo del libro a eliminar:");
        String titulo = Scanner.nextLine();
        boolean eliminado = catalogTasks.removeIf(task -> task.getTitle().equals(titulo));
        if (eliminado)
            System.out.println("Libro eliminado correctamente");
        else
            System.out.println("No se ha podido eliminar. El libro no existe");
    }

    public void modifyTask() {
        boolean modified = false;
        System.out.print("Titulo del libro a modificar: ");
        String titulo = Scanner.nextLine();
        for (Task task : catalogTasks) {
            if (task.getTitle().equalsIgnoreCase(titulo)) {
                System.out.print("Nuevo Título: ");
                String nuevoTitulo = Scanner.nextLine();
                System.out.print("Nuevo Autor: ");
                String nuevoAutor = Scanner.nextLine();
                System.out.print("Nueva Editorial: ");
                String nuevaEditorial = Scanner.nextLine();
                task.setTitle(nuevoTitulo);
                task.setDescription(nuevoAutor);
                task.setLocation(nuevaEditorial);
                System.out.println("Libro modificado correctamente");
                modified = true;
            }
        }

        if (!modified)
            System.out.println("No se ha encontrado el libro");

    }

    public void showTaskList() {
        for (Task task : catalogTasks) {
            System.out.println(task.getTitle());
            System.out.println(task.getDescription());
            System.out.println(task.getLocation());
        }
    }

    public void generateTaskList() {
        catalogTasks.add(new Task("El Quijote", "Cervantes", "Anaya"));
        catalogTasks.add(new Task("Java desde cero", "asd", "Anaya"));
        catalogTasks.add(new Task("Cómo aprobar Java", "asd", "Anaya"));
        catalogTasks.add(new Task("Java", "asda", "asd"));
        catalogTasks.add(new Task("Las aventuras de", "asd", "asd"));
        catalogTasks.add(new Task("Zipi y Zape", "asd", "asd"));
    }
}