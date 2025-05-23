package com.bondar.csrfdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHome() {
        return "Home";
    }

    @GetMapping("/doTransfer")
    @ResponseBody
    public RedirectView transferPage(HttpSession session) {
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn"))) {
            return new RedirectView("/home");
        } else {
            return new RedirectView("/login");
        }
    }

    @PostMapping("/change-password")
    @ResponseBody
    public String changePassword(@RequestParam String newPassword, HttpSession session) {
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn"))) {
            return "Password changed to: " + newPassword;
        } else {
            return "Unauthorized!";
        }
    }
}
