package com.example.my_project.Controllers;

import com.example.my_project.Domain.LogLevel;
import com.example.my_project.Domain.Logs;
import com.example.my_project.Domain.UserServiceImpl;
import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.LogLevelRepository;
import com.example.my_project.Repositories.LogsRepository;
import com.example.my_project.Repositories.RoleRepository;
import com.example.my_project.Repositories.UserAccountRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class MainController {

    private final LogLevelRepository logLevelRepository;
    private final LogsRepository logsRepository;
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    private final UserServiceImpl userServiceImpl;


    public MainController(LogLevelRepository logLevelRepository, LogsRepository logsRepository,
                          UserAccountRepository userAccountRepository, RoleRepository roleRepository,
                          UserServiceImpl userServiceImpl) {
        this.logLevelRepository = logLevelRepository;
        this.logsRepository = logsRepository;
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String greeting() {
        LogLevel level = logLevelRepository.findById(2);
        Logs log = new Logs(new Date(),"HomePage", level);
        logsRepository.save(log);
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal Users user, Model model) {
        model.addAttribute("username", user.getUsername());
        LogLevel level = logLevelRepository.findById(2);
        Logs log = new Logs(new Date(),"GreetingPage", level);
        logsRepository.save(log);
        return "greeting";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Users userAccount){

        userAccount.setEnabled(true);
        userAccount.setRole(roleRepository.findByRole("USER"));
        userAccountRepository.save(userAccount);
        return "redirect:/login";
    }

}