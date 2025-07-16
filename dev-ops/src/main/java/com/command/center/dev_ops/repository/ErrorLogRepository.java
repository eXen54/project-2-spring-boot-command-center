package com.command.center.dev_ops.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.command.center.dev_ops.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    List<ErrorLog> findByStatus(String status);
}
