package com.example.my_project.Repositories;

import com.example.my_project.Domain.Cloth;
import org.springframework.data.repository.CrudRepository;

public interface ClothRepository extends CrudRepository<Cloth, Long> {
    Cloth findById(int id);
}
