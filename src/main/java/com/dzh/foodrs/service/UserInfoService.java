package com.dzh.foodrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzh.foodrs.po.UserInfo;
import com.dzh.foodrs.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo findOneUserInfo(String id){
        return userInfoRepository.findOneById(id);
    }
	public UserInfo saveUserInfo(UserInfo userInfo){
		return userInfoRepository.save(userInfo);
	}
}
