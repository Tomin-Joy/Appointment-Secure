package com.ust.appointment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.appointment.common.UserRoleInfo;
import com.ust.appointment.model.UserInfo;
import com.ust.appointment.repository.UserInfoRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/registerR")
    public String registerR(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfo.setRoles(UserRoleInfo.RECEPTIONIST_ACCESS);
        userInfoRepository.save(userInfo);
        return "success";
    }
    @PostMapping("/registerD")
    public String registerD(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfo.setRoles(UserRoleInfo.DOCTOR_ACCESS);
        userInfoRepository.save(userInfo);
        return "success";
    }
    @PostMapping("/registerU")
    public String registerU(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfo.setRoles(UserRoleInfo.DEFAULT_ROLE);
        userInfoRepository.save(userInfo);
        return "success";
    }
   

}
