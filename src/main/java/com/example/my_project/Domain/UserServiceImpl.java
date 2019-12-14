package com.example.my_project.Domain;

import com.example.my_project.Repositories.UserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService  {
    private final UserAccountRepository userAccountRepository;

    public UserServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userAccountRepository.findByUsername(s);
        if (user==null){
            throw new UsernameNotFoundException("User not found.");
        }
        return user;
    }
}
