package com.example.cadastrodev.service;

import com.example.cadastrodev.demo.model.Developer;
import com.example.cadastrodev.demo.model.Technology;
import com.example.cadastrodev.dto.DeveloperDTO;
import com.example.cadastrodev.repository.DeveloperRepository;
import com.example.cadastrodev.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    public Developer createDeveloper(DeveloperDTO developerDTO) {
        List<Technology> technologies = technologyRepository.findAllById(developerDTO.getTechnologyIds());
        Developer developer = new Developer();
        developer.setName(developerDTO.getName());
        developer.setEmail(developerDTO.getEmail());
        developer.setTechnologies(technologies);
        return developerRepository.save(developer);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloper(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer updateDeveloper(Long id, DeveloperDTO developerDTO) {
        Developer developer = getDeveloper(id);
        if (developer != null) {
            developer.setName(developerDTO.getName());
            developer.setEmail(developerDTO.getEmail());
            List<Technology> technologies = technologyRepository.findAllById(developerDTO.getTechnologyIds());
            developer.setTechnologies(technologies);
            return developerRepository.save(developer);
        }
        return null;
    }

    public void deleteDeveloper(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer not found"));

        developerRepository.delete(developer);
    }

}
