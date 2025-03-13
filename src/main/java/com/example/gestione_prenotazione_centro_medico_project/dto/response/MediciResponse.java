package com.example.gestione_prenotazione_centro_medico_project.dto.response;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import com.example.gestione_prenotazione_centro_medico_project.model.Specializzazioni;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MediciResponse {

    private Integer id;

    private String nome;

    private String cognome;

    private Integer numeroDiTelefono;

    private List<Specializzazioni> specializzazioniList;

    private List<Prenotazioni> PrenotazioniList;
}
