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

    private LocalDate createDate;
    private LocalDate conclusionDate;

    public Task(String name, String description, Status status, LocalDate createDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

    public Task() {
        this.id = UUID.randomUUID().toString();
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
