package com.AromaMart.Apps.controller;

import com.AromaMart.Apps.model.Perfume;
import com.AromaMart.Apps.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeRepository perfumeRepository;


    @GetMapping
    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }

    @PostMapping
    public Perfume createPerfume(@RequestBody Perfume perfume) {
        return perfumeRepository.save(perfume);
    }
}
