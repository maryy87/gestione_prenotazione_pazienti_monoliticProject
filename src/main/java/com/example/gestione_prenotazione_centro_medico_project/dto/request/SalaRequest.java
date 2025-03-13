package com.example.gestione_prenotazione_centro_medico_project.dto.request;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaRequest {

        @NotNull
        private String nome;
        @NotNull
        private String descrizione;

        private List<Prenotazioni> prenotazioniList;
}
