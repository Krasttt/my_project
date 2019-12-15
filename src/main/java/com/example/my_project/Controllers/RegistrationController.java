package com.example.my_project.Controllers;

import com.example.my_project.Domain.Logs;
import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.LogLevelRepository;
import com.example.my_project.Repositories.LogsRepository;
import com.example.my_project.Repositories.RoleRepository;
import com.example.my_project.Repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegistrationController {
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final LogsRepository logsRepository;
    private final LogLevelRepository logLevelRepository;

    public RegistrationController(UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, LogsRepository logsRepository, LogLevelRepository logLevelRepository) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.logsRepository = logsRepository;
        this.logLevelRepository = logLevelRepository;
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          @RequestParam String name,
                          @RequestParam(defaultValue = "") String surname) {

        if (!password.equals(confirmPassword) || usersRepository.findByUsername(username) != null) {
            return "redirect:/registration";
        }

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setSurname(surname);
        user.setName(name);
        user.setEnabled(true);
        user.setRole(roleRepository.findByRole("user"));
        usersRepository.save(user);

        Logs log = new Logs();
        log.setDate(new Date());
        log.setLevel(logLevelRepository.findById(2));
        log.setMessage("New user");
        logsRepository.save(log);

        return "redirect:/login";

    }
}
