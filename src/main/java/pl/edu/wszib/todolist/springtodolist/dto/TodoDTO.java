package pl.edu.wszib.todolist.springtodolist.dto;

import pl.edu.wszib.todolist.springtodolist.model.Status;

import java.util.Date;

public class TodoDTO {

    private Integer id;
    private String title;
    private String dueDate;
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
