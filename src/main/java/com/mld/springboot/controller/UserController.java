package com.mld.springboot.controller;

import com.mld.springboot.pojo.User;
import com.mld.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

    @GetMapping("/findAllUser")
    public String findAllUser(Model model) {
        List<User> users = userService.queryUsers();
        model.addAttribute("users", users);
        return "userList";
    }
}
