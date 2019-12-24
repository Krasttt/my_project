package com.example.my_project.Repositories;

import com.example.my_project.Domain.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Long> {
    List<Orders> findByUsersId(int user_id);
    Orders findById(int id);
    List<Orders> findByModelId(int model_id);
    List<Orders> findByModelIdAndUsersId(int model_id,int user_is);

    List<Orders> findByCutterId(int cutter_id);
    List<Orders> findByCutterIdAndUsersId(int cutter_id,int user_is);
    List<Orders> findByClothId(int cloth_id);
    List<Orders> findByClothIdAndUsersId(int cloth_id,int user_is);
    List<Orders> findByStatusId(int status_id);
    List<Orders> findByStatusIdAndUsersId(int status_id,int user_is);

}
