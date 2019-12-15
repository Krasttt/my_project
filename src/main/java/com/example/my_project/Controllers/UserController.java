package com.example.my_project.Controllers;

import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.OrderRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final OrderRepository orderRepository;

    public UserController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal Users user,
                                 Model model) {
        model.addAttribute("user", user);
        if (user.isAdmin()){
            model.addAttribute("orders", orderRepository.findAll());
        }
        else {
            model.addAttribute("orders", orderRepository.findByUsersId(user.getId()));
        }
        return "profile";
    }
}
