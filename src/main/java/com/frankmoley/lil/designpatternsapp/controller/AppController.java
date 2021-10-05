package com.frankmoley.lil.designpatternsapp.controller;


import com.frankmoley.lil.designpatternsapp.factory.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }

}
