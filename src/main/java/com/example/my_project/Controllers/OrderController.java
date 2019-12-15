package com.example.my_project.Controllers;

import com.example.my_project.Domain.Cloth;
import com.example.my_project.Domain.Orders;
import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class OrderController {

    private final ModelRepository modelRepository;
    private final ClothRepository clothRepository;
    private final CutterRepository cutterRepository;
    private final StatusRepository statusRepository;
    private final OrderRepository orderRepository;

    public OrderController(ModelRepository modelRepository, ClothRepository clothRepository, CutterRepository cutterRepository, StatusRepository statusRepository, OrderRepository orderRepository) {
        this.modelRepository = modelRepository;
        this.clothRepository = clothRepository;
        this.cutterRepository = cutterRepository;
        this.statusRepository = statusRepository;
        this.orderRepository = orderRepository;
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
        Orders order = new Orders();
        order.setUsers(user);
        order.setModel(modelDB);
        order.setCloth(clothDB);
        order.setCutter(cutterRepository.findById(cutter));
        order.setDate(new Date());
        order.setPrice(clothDB.getPrice() + modelDB.getPrice());
        order.setStatus(statusRepository.findById(1));

        orderRepository.save(order);
        return "redirect:/profile";
    }
}
