package com.smarthoreca.server.repository;

import com.smarthoreca.server.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}