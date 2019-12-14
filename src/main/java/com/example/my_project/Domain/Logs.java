package com.example.my_project.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private LogLevel level;
    private String message;
    private Date date;

    public Logs() {
    }

    public Logs(Date date, String message, LogLevel level) {
        this.date = date;
        this.message = message;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
