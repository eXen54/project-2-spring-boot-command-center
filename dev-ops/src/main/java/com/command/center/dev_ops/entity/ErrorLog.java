package com.command.center.dev_ops.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private String errorMessage;
    @Column(columnDefinition = "TEXT")
    private String stackTrace;
    private String status;
    public ErrorLog(LocalDateTime timestamp, String errorMessage, String stackTrace, String status) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
        this.status = status;
    }
    public ErrorLog() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getStackTrace() {
        return stackTrace;
    }
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
