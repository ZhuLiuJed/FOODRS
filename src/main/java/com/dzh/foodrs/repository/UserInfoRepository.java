package com.dzh.foodrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dzh.foodrs.po.UserInfo;
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

    public UserInfo findOneById(String id);
    
}
