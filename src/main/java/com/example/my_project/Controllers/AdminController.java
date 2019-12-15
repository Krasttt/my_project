package com.example.my_project.Controllers;

import com.example.my_project.Domain.Cloth;
import com.example.my_project.Domain.Cutter;
import com.example.my_project.Domain.Logs;
import com.example.my_project.Domain.Orders;
import com.example.my_project.Repositories.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@PreAuthorize("hasAuthority('admin')")
@Controller
public class AdminController {

    private final CutterRepository cutterRepository;
    private final ClothRepository clothRepository;
    private final ModelRepository modelRepository;
    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;
    private final LogsRepository logsRepository;
    private final LogLevelRepository logLevelRepository;

    public AdminController(CutterRepository cutterRepository, ClothRepository clothRepository, ModelRepository modelRepository, OrderRepository orderRepository, StatusRepository statusRepository, LogsRepository logsRepository, LogLevelRepository logLevelRepository) {
        this.cutterRepository = cutterRepository;
        this.clothRepository = clothRepository;
        this.modelRepository = modelRepository;
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
        this.logsRepository = logsRepository;
        this.logLevelRepository = logLevelRepository;
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
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("New cutter was add");
        logsRepository.save(log);
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
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("New cloth was add");
        logsRepository.save(log);
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
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("New model was add");
        logsRepository.save(log);
        return "redirect:/models";
    }

    @GetMapping("/removeOrder/{order_id}")
    public String removeOrder(@PathVariable int order_id){
        orderRepository.delete(orderRepository.findById(order_id));
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("Order removed - " + order_id);
        logsRepository.save(log);
        return "redirect:/profile";
    }

    @GetMapping("/readyOrder/{order_id}")
    public String readyOrder(@PathVariable int order_id){
        Orders order = orderRepository.findById(order_id);
        order.setStatus(statusRepository.findById(2));
        orderRepository.save(order);
        return "redirect:/profile";
    }

    @GetMapping("/add10cloth/{cloth_id}")
    public String add10cloth(@PathVariable int cloth_id){
        Cloth cloth = clothRepository.findById(cloth_id);
        cloth.setSize(cloth.getSize()+10);
        clothRepository.save(cloth);
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("Cloth size added");
        logsRepository.save(log);
        return "redirect:/clothes";
    }

    @GetMapping("/add50cloth/{cloth_id}")
    public String add50cloth(@PathVariable int cloth_id){
        Cloth cloth = clothRepository.findById(cloth_id);
        cloth.setSize(cloth.getSize()+50);
        clothRepository.save(cloth);
        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("Cloth size added");
        logsRepository.save(log);
        return "redirect:/clothes";
    }
}
