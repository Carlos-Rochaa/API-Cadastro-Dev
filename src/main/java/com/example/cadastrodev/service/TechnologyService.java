package com.example.cadastrodev.service;

import com.example.cadastrodev.demo.model.Technology;
import com.example.cadastrodev.dto.TechnologyDTO;
import com.example.cadastrodev.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

   /* public Technology createTechnology(TechnologyDTO technologyDTO) {
        Technology technology = new Technology();
        technology.setName(technologyDTO.getName());
        return technologyRepository.save(technology);
    } */

    public Technology createTechnology(TechnologyDTO technologyDTO) {

        Optional<Technology> existingTechnology = technologyRepository.findByNameIgnoreCase(technologyDTO.getName());
        if (existingTechnology.isPresent()) {
            throw new IllegalArgumentException("A tecnologia '" + technologyDTO.getName() + "' já existe.");
        }
        Technology technology = new Technology();
        technology.setName(technologyDTO.getName());
        return technologyRepository.save(technology);
    }

    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    public Technology getTechnology(Long id) {
        return technologyRepository.findById(id).orElse(null);
    }

    public Technology updateTechnology(Long id, TechnologyDTO technologyDTO) {
        Technology technology = getTechnology(id);
        if (technology != null) {
            technology.setName(technologyDTO.getName());
            return technologyRepository.save(technology);
        }
        return null;
    }

    public void deleteTechnology(Long id) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Technology not found"));

        technologyRepository.delete(technology);
    }
}
