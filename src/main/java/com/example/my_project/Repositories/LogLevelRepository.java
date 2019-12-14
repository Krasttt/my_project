package com.example.my_project.Repositories;

import com.example.my_project.Domain.LogLevel;
import org.springframework.data.repository.CrudRepository;

public interface LogLevelRepository extends CrudRepository<LogLevel, Long> {
    LogLevel findById(Integer id);
}
