package com.warnoux.graph.controller;

import com.warnoux.graph.model.Element;
import com.warnoux.graph.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private GraphRepository graphRepository;

    @GetMapping("elements")
    public List<Element> getElements(){
        return graphRepository.findAll();
    }
}
