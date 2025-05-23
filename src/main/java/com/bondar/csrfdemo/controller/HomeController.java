package com.bondar.csrfdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//    @GetMapping("/home")
//    public String showHome() {
//        return "Home";
//    }

    @PostMapping("/change-password")
    @ResponseBody
    public String changePassword(@RequestParam String newPassword) {
        return "Password changed to: " + newPassword;
    }
}
