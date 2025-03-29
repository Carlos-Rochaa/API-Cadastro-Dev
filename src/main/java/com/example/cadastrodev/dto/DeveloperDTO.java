package com.example.cadastrodev.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeveloperDTO {
    private String name;
    private String email;
    private List<Long> technologyIds;
}
