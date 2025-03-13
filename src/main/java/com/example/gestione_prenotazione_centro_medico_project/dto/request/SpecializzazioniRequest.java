package com.example.gestione_prenotazione_centro_medico_project.dto.request;

import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecializzazioniRequest {

    private String nome;

    private String descrizione;

    private List<Medici> mediciList;
}
