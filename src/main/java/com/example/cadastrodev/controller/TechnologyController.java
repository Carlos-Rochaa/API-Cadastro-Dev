package com.example.cadastrodev.controller;

import com.example.cadastrodev.demo.model.Technology;
import com.example.cadastrodev.dto.TechnologyDTO;
import com.example.cadastrodev.repository.TechnologyRepository;
import com.example.cadastrodev.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @PostMapping
    public Technology createTechnology(@RequestBody TechnologyDTO technology) {
        return technologyService.createTechnology(technology);
    }

    @GetMapping
    public List<Technology> getAllTechnologies() {
        return technologyService.getAllTechnologies();
    }

    @GetMapping("/{id}")
    public Technology getTechnology(@PathVariable Long id) {
        return technologyService.getTechnology(id);
    }

    @PutMapping("/{id}")
    public Technology updateTechnology(@PathVariable Long id, @RequestBody TechnologyDTO technology) {

        return technologyService.updateTechnology(id, technology);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnology(@PathVariable Long id) {
         technologyService.deleteTechnology(id);
    }

}
