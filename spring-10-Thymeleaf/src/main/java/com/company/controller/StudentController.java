package com.company.controller;

import com.company.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    //@RequestMapping(value = "/register",method = RequestMethod.GET)
    @GetMapping("/register")// both are same
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }


    @GetMapping("/welcome")
    //@RequestMapping(value = "/welcome",method = RequestMethod.POST)
    //@PostMapping("/welcome")//both are same
    public String welcome(@RequestParam String name){

        System.out.println(name);

        return "student/welcome";
    }
}
