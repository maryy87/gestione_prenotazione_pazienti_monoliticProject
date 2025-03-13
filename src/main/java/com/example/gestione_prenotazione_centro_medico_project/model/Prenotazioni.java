package com.example.gestione_prenotazione_centro_medico_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prenotazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @Column
    private LocalTime orario;

    @ManyToOne
    @JoinColumn(name = "idPazienti")
    private Pazienti idPazienti;

    @ManyToOne
    @JoinColumn(name = "idMedici")
    private Medici idMedici;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala idSala;

}
