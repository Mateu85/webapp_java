package com.svalero.webappjava;

public class Task {

    private String title;
    private String type;
    private String description;
    private String location;
    private String paid;

    public Task(String title, String type, String description, String paid, String location) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.paid = paid;
    }

    public String getTitulo() {
        return title;
    }

    public String  getType(String type) {return type;}

    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    public String getAutor() {
        return description;
    }

    public void setAutor(String autor) {
        this.description = autor;
    }

    public String getEditorial() {
        return paid;
    }



}
