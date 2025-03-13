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
public class Specializzazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrizione;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medici> mediciList;
}
