package com.smarthoreca.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produse")
@Data
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private Double pret;
    private String descriere;
}