package com.example.gestione_prenotazione_centro_medico_project.dto.response;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaResponse {

    private Integer id;

    private String nome;

    private String descrizione;

    private List<Prenotazioni> prenotazioniList;
}
