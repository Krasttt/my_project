package com.example.my_project.Repositories;

import com.example.my_project.Domain.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Long> {
    List<Orders> findByUsersId(int user_id);
}
