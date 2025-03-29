package com.example.cadastrodev.repository;

import com.example.cadastrodev.demo.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
