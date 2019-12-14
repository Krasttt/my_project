package com.example.my_project.Repositories;

import com.example.my_project.Domain.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findById(int id);
}
