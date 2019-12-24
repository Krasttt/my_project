package com.example.my_project.Controllers;

import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final OrderRepository orderRepository;
    private final ModelRepository modelRepository;
    private final CutterRepository cutterRepository;
    private final StatusRepository statusRepository;
    private final ClothRepository clothRepository;

    public UserController(OrderRepository orderRepository, ModelRepository modelRepository, CutterRepository cutterRepository, StatusRepository statusRepository, ClothRepository clothRepository) {
        this.orderRepository = orderRepository;
        this.modelRepository = modelRepository;
        this.cutterRepository = cutterRepository;
        this.statusRepository = statusRepository;
        this.clothRepository = clothRepository;
    }

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal Users user,
                                 @RequestParam(defaultValue = "") String model_id,
                                 @RequestParam(defaultValue = "") String cutter_id,
                                 @RequestParam(defaultValue = "") String cloth_id,
                                 @RequestParam(defaultValue = "") String status_id,
                                 Model model) {
        model.addAttribute("user", user);
        model.addAttribute("models", modelRepository.findAll());
        model.addAttribute("cutters", cutterRepository.findAll());
        model.addAttribute("clothes", clothRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());

        if (user.isAdmin()){
            if(!model_id.equals("")){
                model.addAttribute("orders", orderRepository.findByModelId(Integer.parseInt(model_id)));
            }
            else if(!cutter_id.equals("")){
                model.addAttribute("orders", orderRepository.findByCutterId(Integer.parseInt(cutter_id)));
            }
            else if(!cloth_id.equals("")){
                model.addAttribute("orders", orderRepository.findByClothId(Integer.parseInt(cloth_id)));
            }
            else if(!status_id.equals("")){
                model.addAttribute("orders", orderRepository.findByStatusId(Integer.parseInt(status_id)));
            }
            else {
                model.addAttribute("orders", orderRepository.findAll());
            }
        }
        else {
            if(!model_id.equals("")){
                model.addAttribute("orders", orderRepository.
                        findByModelIdAndUsersId(Integer.parseInt(model_id),user.getId()));
            }
            else if(!cutter_id.equals("")){
                model.addAttribute("orders", orderRepository.
                        findByCutterIdAndUsersId(Integer.parseInt(cutter_id),user.getId()));
            }
            else if(!cloth_id.equals("")){
                model.addAttribute("orders", orderRepository.
                        findByClothIdAndUsersId(Integer.parseInt(cloth_id),user.getId()));
            }
            else if(!status_id.equals("")){
                model.addAttribute("orders", orderRepository.
                        findByStatusIdAndUsersId(Integer.parseInt(status_id),user.getId()));
            }
            else {
                model.addAttribute("orders", orderRepository.
                        findByUsersId(user.getId()));
            }

        }
        return "profile";
    }
}
