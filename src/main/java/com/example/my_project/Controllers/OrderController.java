package com.example.my_project.Controllers;

import com.example.my_project.Domain.Cloth;
import com.example.my_project.Domain.Logs;
import com.example.my_project.Domain.Orders;
import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.*;
import com.example.my_project.Services.ConnectionPool;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Controller
public class OrderController {

    private final ModelRepository modelRepository;
    private final ClothRepository clothRepository;
    private final CutterRepository cutterRepository;
    private final StatusRepository statusRepository;
    private final OrderRepository orderRepository;
    private final LogsRepository logsRepository;
    private final LogLevelRepository logLevelRepository;

    public OrderController(ModelRepository modelRepository, ClothRepository clothRepository, CutterRepository cutterRepository, StatusRepository statusRepository, OrderRepository orderRepository, LogsRepository logsRepository, LogLevelRepository logLevelRepository) {
        this.modelRepository = modelRepository;
        this.clothRepository = clothRepository;
        this.cutterRepository = cutterRepository;
        this.statusRepository = statusRepository;
        this.orderRepository = orderRepository;
        this.logsRepository = logsRepository;
        this.logLevelRepository = logLevelRepository;
    }

    @GetMapping("/createorder")
    public String getCreatOrderPage(Model model) {
        model.addAttribute("models", modelRepository.findAll());
        model.addAttribute("cutters", cutterRepository.findAll());
        model.addAttribute("clothes", clothRepository.findAll());
        return "createOrder";
    }

    @PostMapping("/createorder")
    public String createOrder(@AuthenticationPrincipal Users user,
                              @RequestParam int model,
                              @RequestParam int cloth,
                              @RequestParam int cutter) {

        com.example.my_project.Domain.Model modelDB = modelRepository.findById(model);
        Cloth clothDB = clothRepository.findById(cloth);
        if (modelDB.getClothSize() > clothDB.getSize()){
            return "redirect:/createorder";
        }
        clothDB.setSize(clothDB.getSize() - modelDB.getClothSize());

        Orders order = new Orders();
        order.setUsers(user);
        order.setModel(modelDB);
        order.setCloth(clothDB);
        order.setCutter(cutterRepository.findById(cutter));
        order.setDate(new Date());
        order.setPrice(clothDB.getPrice() + modelDB.getPrice());
        order.setStatus(statusRepository.findById(1));
        clothRepository.save(clothDB);
        orderRepository.save(order);

        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage(user.getUsername() + " - create new order");
        logsRepository.save(log);

        return "redirect:/profile";
    }

    private String filter(int id){
        String s = "filter";
        String filter = "select from \\\"Orders\\\"(id, cutter_id, cloth_id, model_id,user_id,date)\" +\n" +
                "            \" values (?,?,?,?,?,?) where id=?";
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try (Connection db = connectionPool.getConnection();
             PreparedStatement selectAppPreparedStatement = db.prepareStatement("");) {

            ResultSet resultSet = selectAppPreparedStatement.executeQuery();

            ResultSet resultSetNew = selectAppPreparedStatement.executeQuery();
            if (resultSetNew.next()) {
                //return resultSetNew.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}
