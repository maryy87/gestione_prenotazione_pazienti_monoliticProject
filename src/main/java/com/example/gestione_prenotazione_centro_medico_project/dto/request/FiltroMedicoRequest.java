package com.example.gestione_prenotazione_centro_medico_project.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FiltroMedicoRequest {

    private String nome;

    private String cognome;

    private Integer numeroDiTelefono;

}
