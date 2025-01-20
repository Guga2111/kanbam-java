package com.example.kanbam.pojo;

import ch.qos.logback.core.status.StatusUtil;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private String id;

    private String name;
    private String description;

    private Status status;
    private Priority priority;

    private LocalDate createDate;
    private LocalDate conclusionDate;

    public Task(String name, String description, Status status,Priority priority, LocalDate createDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.priority = priority;
    }

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(LocalDate conclusionDate) {
        this.conclusionDate = conclusionDate;
    }
}
