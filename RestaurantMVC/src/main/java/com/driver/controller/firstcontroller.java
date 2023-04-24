package com.driver.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class firstcontroller {
    @GetMapping("/a")
    @ResponseBody
    public String test() {
        return "Success";
    }
}
