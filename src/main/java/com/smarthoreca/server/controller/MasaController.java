package com.smarthoreca.server.controller;

import com.smarthoreca.server.model.Masa;
import com.smarthoreca.server.repository.MasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mese")
public class MasaController {

    @Autowired
    private MasaRepository masaRepository;

    // GET - Vezi toate mesele
    @GetMapping
    public List<Masa> getAllMese() {
        return masaRepository.findAll();
    }

    // POST - Adaugă o masă nouă în sistem
    @PostMapping
    public Masa createMasa(@RequestBody Masa masa) {
        return masaRepository.save(masa);
    }
}