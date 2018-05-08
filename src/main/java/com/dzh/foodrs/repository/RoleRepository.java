package com.dzh.foodrs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dzh.foodrs.po.Role;

/**
 * Created by acer on 2017/3/6.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
	public Page<Role> findAllByRoleNameLike(Pageable pageable, String roleName);
    public Role findOneByRoleName(String roleName);
}
