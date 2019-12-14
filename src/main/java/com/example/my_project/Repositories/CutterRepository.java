package com.example.my_project.Repositories;

import com.example.my_project.Domain.Cutter;
import org.springframework.data.repository.CrudRepository;

public interface CutterRepository extends CrudRepository<Cutter,Long> {
    Cutter findById(int id);
}
