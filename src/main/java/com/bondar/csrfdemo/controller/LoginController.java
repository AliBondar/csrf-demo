package com.bondar.csrfdemo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

//    @GetMapping("/home")
//    public String showHome() {
//        return "Home";
//    }

    @PostMapping("/login")
    @ResponseBody
    public RedirectView processLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if ("user".equals(username) && "password".equals(password)) {
            session.setAttribute("loggedIn", true);
            return new RedirectView("/doTransfer");
        } else {
            return new RedirectView("/login");
        }
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public RedirectView processLogin(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
//        if ("user".equals(username) && "password".equals(password)) {
//
//            Cookie cookie = new Cookie("auth", "valid");
//            cookie.setPath("/");
//            cookie.setHttpOnly(false);
//            response.addCookie(cookie);
//
//            return new RedirectView("/home");
//        } else {
//            return new RedirectView("/login");
//        }
//    }
}
