package no.ntnu.ivansh.ToDoApplication.toDo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity
public class ToDO {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Size(min=3,message = "Enter at least 3 characters")
    private String descrpition;
    private LocalDate date;
    private boolean done;

    public ToDO(int id, String name, String descrpition, LocalDate date, boolean done) {
        this.id = id;
        this.name = name;
        this.descrpition = descrpition;
        this.date = date;
        this.done = done;
    }

    public ToDO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descrpition='" + descrpition + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
