package com.expense.Sulaah.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World - come to Sulaah for one stop solution";
    }
}
