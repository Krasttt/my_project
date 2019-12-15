package com.example.my_project.Controllers;

import com.example.my_project.Domain.LogLevel;
import com.example.my_project.Domain.Logs;
import com.example.my_project.Repositories.LogLevelRepository;
import com.example.my_project.Repositories.LogsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MainController {

    private final LogLevelRepository logLevelRepository;
    private final LogsRepository logsRepository;

    public MainController(LogLevelRepository logLevelRepository, LogsRepository logsRepository) {
        this.logLevelRepository = logLevelRepository;
        this.logsRepository = logsRepository;
    }

    @GetMapping("/")
    public String greeting() {
        LogLevel level = logLevelRepository.findById(2);
        Logs log = new Logs(new Date(), "HomePage", level);
        logsRepository.save(log);
        return "redirect:/profile";
    }


}