package com.dzh.foodrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzh.foodrs.po.User;
import com.dzh.foodrs.repository.RoleRepository;
import com.dzh.foodrs.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    public User findOneUser(String id){
        return userRepository.findOneById(id);
    }
    
    @Transactional
    public User saveUser(User user){
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(),null));
        return userRepository.save(user);
    }

}