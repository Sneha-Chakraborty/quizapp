package com.example.quizapp.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime startTime;

    private LocalDateTime lastActivityTime;

    private boolean isActive;

    private boolean active;

    @OneToMany(mappedBy = "quizSession", cascade = CascadeType.ALL)
    private List<QuizLog> quizLogs;

    // Constructors, Getters, and Setters
    public QuizSession() {}

    public QuizSession(Long userId, LocalDateTime startTime, LocalDateTime lastActivityTime, boolean isActive, List<QuizLog> quizLogs) {
        this.userId = userId;
        this.startTime = startTime;
        this.lastActivityTime = lastActivityTime;
        this.isActive = isActive;
        this.quizLogs = quizLogs;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(LocalDateTime lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<QuizLog> getQuizLogs() {
        return quizLogs;
    }

    public void setQuizLogs(List<QuizLog> quizLogs) {
        this.quizLogs = quizLogs;
    }
    
}
