package com.example.gestione_prenotazione_centro_medico_project.dto.request;

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
public class PrenotazioniRequest {

    @NotNull
    private LocalDate dataPrenotazione;

    @NotNull
    private LocalTime orario;

    @NotNull
    private int idPazienti;

    @NotNull
    private int idMedici;

    @NotNull
    private int  idSala;
}
