package com.example.gestione_prenotazione_centro_medico_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrizione;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prenotazioni> prenotazioniList;
}
