package com.smarthoreca.server.controller;

import com.smarthoreca.server.model.Comanda;
import com.smarthoreca.server.model.Masa;
import com.smarthoreca.server.model.Produs;
import com.smarthoreca.server.repository.ComandaRepository;
import com.smarthoreca.server.repository.MasaRepository;
import com.smarthoreca.server.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comenzi")
public class ComandaController {


    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ProdusRepository produsRepository;

    @GetMapping
    public List<Comanda> getAllComenzi() {
        return comandaRepository.findAll();
    }

    @PostMapping
    public Comanda createComanda(@RequestBody Comanda comanda) {
        double sumaTotala = 0;

        if(comanda.getProduse() != null){
            for(Produs produsComanda : comanda.getProduse()){
                Produs produsReal = produsRepository.findById(produsComanda.getId()).orElseThrow();
                sumaTotala += produsReal.getPret();
            }
        }

        comanda.setTotal(sumaTotala);
        return comandaRepository.save(comanda);
    }

    @PutMapping("/{id}/status")
    public Comanda updateStatusComanda(@PathVariable Long id, @RequestParam String NoulStatus){
        Comanda comandaExistenta = comandaRepository.findById(id).orElseThrow();

        comandaExistenta.setStatus(NoulStatus);

        return comandaRepository.save(comandaExistenta);
    }

    @DeleteMapping("/{id}")
    public void deleteComanda(@PathVariable Long id){
        comandaRepository.deleteById(id);
    }

}