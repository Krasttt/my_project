package com.example.my_project.Repositories;

import com.example.my_project.Domain.Logs;
import org.springframework.data.repository.CrudRepository;

public interface LogsRepository extends CrudRepository<Logs,Long> {
}
