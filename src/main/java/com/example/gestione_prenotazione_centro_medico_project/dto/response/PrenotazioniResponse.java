package com.example.gestione_prenotazione_centro_medico_project.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrenotazioniResponse {

    private Integer id;

    private LocalDate dataPrenotazione;

    private LocalTime orario;

    private int idPazienti;

    private int idMedici;

    private int  idSala;
}
