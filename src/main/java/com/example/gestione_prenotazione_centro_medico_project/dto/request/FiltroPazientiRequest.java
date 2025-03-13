package com.example.gestione_prenotazione_centro_medico_project.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FiltroPazientiRequest {

    private String nome;

    private String cognome;

    private LocalDate dataDiNascita;

    private String codiceFiscale;

}
