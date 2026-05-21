package com.smarthoreca.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mese")

public class Masa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int numar;
    private int capacitate;
    private boolean ocupata;
}