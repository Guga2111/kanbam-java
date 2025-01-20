package com.example.kanbam.controller;

import com.example.kanbam.pojo.Task;
import com.example.kanbam.service.KanbamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class KanbamController {

    @Autowired
    KanbamService kanbamService;

    @GetMapping("/")
    public String getKanbam(Model model) {

        //manual testing
        /*
        for(Task task : kanbamService.getTasks()) {
            System.out.println(task.getName());
            System.out.println(task.getId());
            System.out.println(task.getStatus());
        } */

        kanbamService.spreadingTasks();

        for(Task task : kanbamService.getToDo()) {
            System.out.println(task.getName());
            System.out.println(task.getId());
            System.out.println(task.getStatus());
        }

        Map<String, List<Task>> taskCollection = kanbamService.createTaskCollection(kanbamService.getTasks());
        model.addAllAttributes(taskCollection);

        return "kanbam";
    }

    @GetMapping("/form")
    public String taskForm(Model model, @RequestParam(required = false) String id) {

        model.addAttribute("task", kanbamService.getTaskById(id));
        return "form";
    }

    @PostMapping("/SubmitTask")
    public String submitForm(Task task) {

        kanbamService.submitTask(task);

        return "redirect:/";
    }

    @GetMapping("/task/{id}")
    public String getTask(Model model, @PathVariable String id) {

        if(id == null) return "redirect:/";

        model.addAttribute("task", kanbamService.getTaskById(id));
        return "task";
    }

}
