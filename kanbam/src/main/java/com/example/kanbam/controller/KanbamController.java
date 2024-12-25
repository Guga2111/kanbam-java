package com.example.kanbam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KanbamController {

    @GetMapping("/")
    public String getKanbam() {
        return "kanbam";
    }
}
