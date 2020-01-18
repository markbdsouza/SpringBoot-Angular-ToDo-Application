package com.marksample.trustfulwebservice.ToDo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String description;
    private Date targetDate;
    private boolean status;

    public ToDo(){

    }

    public ToDo(long id, String username, String description, Date targetDate, boolean status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return id == toDo.id &&
                status == toDo.status &&
                Objects.equals(username, toDo.username) &&
                Objects.equals(description, toDo.description) &&
                Objects.equals(targetDate, toDo.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

