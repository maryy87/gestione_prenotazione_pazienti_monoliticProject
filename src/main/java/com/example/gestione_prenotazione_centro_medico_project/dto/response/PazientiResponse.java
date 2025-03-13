package com.example.gestione_prenotazione_centro_medico_project.dto.response;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PazientiResponse {

    private Integer id;

    private String nome;

    private String cognome;

    private LocalDate dataDiNascita;

    private String codiceFiscale;

    private List<Prenotazioni> prenotazioni;
}
