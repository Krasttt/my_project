package com.example.my_project.Repositories;

import com.example.my_project.Domain.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model,Long> {
    Model findById(int id);
}
