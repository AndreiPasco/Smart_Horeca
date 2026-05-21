package com.smarthoreca.server.repository;

import com.smarthoreca.server.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {
}