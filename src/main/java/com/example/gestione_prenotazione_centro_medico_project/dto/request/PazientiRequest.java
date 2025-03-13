package com.example.gestione_prenotazione_centro_medico_project.dto.request;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PazientiRequest {
    @NotNull
    private String nome;
    @NotNull
    private String cognome;
    @NotNull
    private LocalDate dataDiNascita;
    @NotNull
    private String codiceFiscale;

    private List<Prenotazioni> prenotazioni;
}
