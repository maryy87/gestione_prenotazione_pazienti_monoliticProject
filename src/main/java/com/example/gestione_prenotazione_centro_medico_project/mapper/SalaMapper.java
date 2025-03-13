package com.example.gestione_prenotazione_centro_medico_project.mapper;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.SalaRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.SalaResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {

    public SalaResponse mapEntityToResponse(Sala sala) {

        SalaResponse salaResponse = new SalaResponse();
        salaResponse.setId(sala.getId());
        salaResponse.setNome(sala.getNome());
        salaResponse.setDescrizione(sala.getDescrizione());
        salaResponse.setPrenotazioniList(sala.getPrenotazioniList());
        return salaResponse;

    }

    public Sala mapRequestToEntity(SalaRequest salaRequest) {

        Sala sala = new Sala();
        sala.setNome(salaRequest.getNome());
        sala.setDescrizione(salaRequest.getDescrizione());
        sala.setPrenotazioniList(salaRequest.getPrenotazioniList());
        return sala;

    }
}
