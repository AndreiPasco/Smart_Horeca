package com.smarthoreca.server.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "comenzi")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; //preparing,waiting,done

    private double total;

    @ManyToOne
    @JoinColumn(name = "masa_id")
    private Masa masa;

    @ManyToMany
    @JoinTable(
            name = "comanda_produse",
            joinColumns = @JoinColumn(name = "comanda_id"),
            inverseJoinColumns = @JoinColumn(name = "produs_id")
    )
    private List<Produs> produse;
}