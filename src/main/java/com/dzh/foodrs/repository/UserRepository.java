package com.dzh.foodrs.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dzh.foodrs.po.Role;
import com.dzh.foodrs.po.User;

import java.util.List;

/**
 * Created by holyfrans on 2017/3/6.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findOneByUsername(String username);
    public List<User> findAllByRole(Role role);
    public User findOneById(String id);
}
