package com.command.center.dev_ops.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.command.center.dev_ops.entity.ErrorLog;
import com.command.center.dev_ops.repository.ErrorLogRepository;

@RestController
@RequestMapping("/api/error-logs")
public class ErrorLogController {
    public final ErrorLogRepository errorLogRepository;

    public ErrorLogController(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }
    
    @GetMapping
    public ResponseEntity<List<ErrorLog>> getAll(){
        return ResponseEntity.ok(errorLogRepository.findAll());
    }
}
