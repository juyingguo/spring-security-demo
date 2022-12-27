package com.blurooo.chapter7.controller;

import com.blurooo.chapter7.entity.User;
import com.blurooo.chapter7.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class LoginRegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("register")
    public String register(@RequestParam String username,@RequestParam String password) {
        if(!StringUtils.isEmpty(userMapper.findByUserName(username))){
            return "用户已经存在:" + username;
        }
        User user = new User();
        user.setUsername(username);
        user.setRoles("ROLE_USER");
        user.setPassword(passwordEncoder.encode(password));
        userMapper.insert(user);
        return "register success";
    }

}
