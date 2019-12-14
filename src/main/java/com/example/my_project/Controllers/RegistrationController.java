package com.example.my_project.Controllers;

import com.example.my_project.Domain.Users;
import com.example.my_project.Repositories.RoleRepository;
import com.example.my_project.Repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          @RequestParam String name,
                          @RequestParam(defaultValue = "") String surname ){

        if (!password.equals(confirmPassword) || usersRepository.findByUsername(username)!=null){
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

        return "redirect:/login";

    }
}
