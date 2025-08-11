package com.example.Maintenance.Request.System.models;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Complaints {

    public Complaints() {
        this.status = "pending"; 
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String priority;
    @Column(nullable = false)
    private String status;
    private String assignedTo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date updatedAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "Asia/Kolkata")
    private Time updatedTime;

    @PrePersist
    @PreUpdate
    public void updateDateTime() {
        updatedAt = Date.valueOf(LocalDate.now());
        updatedTime = Time.valueOf(java.time.LocalTime.now());
    
    }


    public Time getUpdatedTime() {
        return updatedTime;
    }


    public void setUpdatedTime(Time updatedTime) {
        this.updatedTime = updatedTime;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
