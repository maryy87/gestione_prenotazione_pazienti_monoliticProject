package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroMedicoRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroPazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import com.example.gestione_prenotazione_centro_medico_project.model.Pazienti;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomPazientiRepository {

    List<Pazienti> findPazientiFiltro(FiltroPazientiRequest filtroPazientiRequest);

}
