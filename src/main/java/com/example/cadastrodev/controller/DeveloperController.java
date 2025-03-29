package com.example.cadastrodev.controller;

import com.example.cadastrodev.demo.model.Developer;
import com.example.cadastrodev.dto.DeveloperDTO;
import com.example.cadastrodev.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    @PostMapping
    public Developer createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.createDeveloper(developerDTO);
    }

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public Developer getDeveloper(@PathVariable Long id) {
        return developerService.getDeveloper(id);
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable Long id, @RequestBody DeveloperDTO developerDTO) {
        return developerService.updateDeveloper(id, developerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
    }
}
