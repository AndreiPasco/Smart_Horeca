package com.smarthoreca.server.controller;

import com.smarthoreca.server.model.Produs;
import com.smarthoreca.server.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusRepository produsRepository;

    // GET /api/produse - Returnează lista cu toate produsele
    @GetMapping
    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    // POST /api/produse - Adaugă un produs nou
    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsRepository.save(produs);
    }

    @DeleteMapping("/{id}")
    public void deleteProdus(@PathVariable Long id) {
        produsRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produs updateProdus(@PathVariable Long id, @RequestBody Produs detaliiNoi) {
        Produs produsVechi = produsRepository.findById(id).orElseThrow();

        produsVechi.setNume(detaliiNoi.getNume());
        produsVechi.setPret(detaliiNoi.getPret());
        produsVechi.setDescriere(detaliiNoi.getDescriere());

        return produsRepository.save(produsVechi);
    }
}