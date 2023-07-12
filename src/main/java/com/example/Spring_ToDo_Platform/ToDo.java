package com.example.Spring_ToDo_Platform;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class ToDo {
 private long id ; 
 private String userName; 
 @Size(min=10,message="Description must have at least 10 characters")
 private String description; 
 private LocalDate targetDate ;
 private boolean done ;
 
public ToDo() {
}
public ToDo(long id, String userName, String description, LocalDate targetDate, boolean done) {
    super(); 
    this.id = id;
    this.userName = userName;
    this.description = description;
    this.targetDate = targetDate;
    this.done = done;
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public LocalDate getTargetDate() {
    return targetDate;
}
public void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
}
public boolean isDone() {
    return done;
}
public void setDone(boolean done) {
    this.done = done;
} 
 

    
}
