package com.example.kanbam.controller;

import com.example.kanbam.pojo.Task;
import com.example.kanbam.service.KanbamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KanbamController {

    @Autowired
    KanbamService kanbamService;

    @GetMapping("/")
    public String getKanbam() {


        return "kanbam";
    }

    @GetMapping("/form")
    public String taskForm(Model model) {

        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/SubmitTask")
    public String submitForm() {

        return "a";
    }


}
