package com.selflearning.distributed.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @RequestMapping("/first")
    public String print(){

        return "FirstController";
    }
}
