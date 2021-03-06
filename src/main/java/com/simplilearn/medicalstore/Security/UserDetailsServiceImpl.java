package com.simplilearn.medicalstore.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplilearn.medicalstore.Entity.User;
import com.simplilearn.medicalstore.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User c = userRepo.getUserByUsername(username);
        if (c == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return new MyUserDetails(c);

    }

}
