package com.example.my_project.Controllers;

import com.example.my_project.Domain.Cloth;
import com.example.my_project.Domain.Cutter;
import com.example.my_project.Domain.Orders;
import com.example.my_project.Repositories.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@PreAuthorize("hasAuthority('admin')")
@Controller
public class AdminController {

    private final CutterRepository cutterRepository;
    private final ClothRepository clothRepository;
    private final ModelRepository modelRepository;
    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;

    public AdminController(CutterRepository cutterRepository, ClothRepository clothRepository, ModelRepository modelRepository, OrderRepository orderRepository, StatusRepository statusRepository) {
        this.cutterRepository = cutterRepository;
        this.clothRepository = clothRepository;
        this.modelRepository = modelRepository;
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/cutters")
    public String getCutters(Model model){
        model.addAttribute("cutters", cutterRepository.findAll());
        return "cuttersPage";
    }

    @GetMapping("/addCutter")
    public String addCutterPage(){
        return "addCutterPage";
    }

    @PostMapping("/addCutter")
    public String addCutter(@RequestParam String name,
                            @RequestParam(defaultValue = "") String surname){
        Cutter cutter = new Cutter();
        cutter.setName(name);
        cutter.setSurname(surname);
        cutterRepository.save(cutter);
        return "redirect:/cutters";
    }

    @GetMapping("/clothes")
    public String getClothes(Model model){
        model.addAttribute("clothes", clothRepository.findAll());
        return "clothesPage";
    }

    @GetMapping("/addCloth")
    public String addClothPage(){
        return "addClothPage";
    }

    @PostMapping("/addCloth")
    public String addCloth(@RequestParam String name,
                           @RequestParam Double price){
        Cloth cloth = new Cloth();
        cloth.setName(name);
        cloth.setPrice(price);
        cloth.setSize(0);
        clothRepository.save(cloth);
        return "redirect:/clothes";
    }

    @GetMapping("/models")
    public String getModels(Model model){
        model.addAttribute("models", modelRepository.findAll());
        return "modelsPage";
    }

    @GetMapping("/addModel")
    public String addModelPage(){
        return "addModelPage";
    }

    @PostMapping("/addModel")
    public String addModel(@RequestParam String name,
                           @RequestParam Double price,
                           @RequestParam Double clothSize){

        com.example.my_project.Domain.Model model = new com.example.my_project.Domain.Model();
        model.setName(name);
        model.setPrice(price);
        model.setClothSize(clothSize);
        modelRepository.save(model);

        return "redirect:/models";
    }

    @GetMapping("/removeOrder/{order_id}")
    public String removeOrder(@PathVariable int order_id){
        orderRepository.delete(orderRepository.findById(order_id));
        return "redirect:/profile";
    }

    @GetMapping("/readyOrder/{order_id}")
    public String readyOrder(@PathVariable int order_id){
        Orders order = orderRepository.findById(order_id);
        order.setStatus(statusRepository.findById(2));
        orderRepository.save(order);
        return "redirect:/profile";
    }
}
