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
public class Medici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cognome;

    @Column(name = "numero_di_telefono")
    private Integer numeroDiTelefono;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "medico_specializzazione",
            joinColumns = @JoinColumn(name = "idMedico"),
            inverseJoinColumns = @JoinColumn(name = "idSpecializzazione")
    )
    private List<Specializzazioni> specializzazioniList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prenotazioni> PrenotazioniList;
}
