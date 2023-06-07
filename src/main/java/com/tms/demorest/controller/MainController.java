package com.tms.demorest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/mainpage")
    public String main() {
        return "main-page.html";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "my-page.html";
    }
}
