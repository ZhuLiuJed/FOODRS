package com.dzh.foodrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzh.foodrs.po.Role;
import com.dzh.foodrs.repository.RoleRepository;


@Service
public class RoleService {
	@Autowired
    private RoleRepository roleRepository;
	
	public Role findOneRole(Integer id) {
        return roleRepository.findOne(id);
    }

}
