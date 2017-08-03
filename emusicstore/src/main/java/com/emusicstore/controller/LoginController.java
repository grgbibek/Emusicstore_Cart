package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by grgbibek22 on 8/1/2017.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false)String error, //the parameters "error" and "logout" come from spring filter
                        @RequestParam(value="logout", required = false)String logout,Model model){
        if(error!=null){
            model.addAttribute("error","Invalid username or password");
        }

        if(logout!=null){
            model.addAttribute("msg","You have been logged out successfully");
        }
        return "login";
    }
}
