package com.example.gestione_prenotazione_centro_medico_project.mapper;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.PrenotazioniRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PrenotazioniResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioniMapper {

    public PrenotazioniResponse mapEntityToResponse(Prenotazioni prenotazioni) {
        PrenotazioniResponse prenotazioniResponse = new PrenotazioniResponse();
        prenotazioniResponse.setId(prenotazioni.getId());
        prenotazioniResponse.setDataPrenotazione(prenotazioni.getDataPrenotazione());
        prenotazioniResponse.setOrario(prenotazioni.getOrario());
        prenotazioniResponse.setIdMedici(prenotazioni.getIdMedici().getId());
        prenotazioniResponse.setIdSala(prenotazioni.getIdSala().getId());
        prenotazioniResponse.setIdPazienti(prenotazioni.getIdPazienti().getId());

        return prenotazioniResponse;

    }

    public Prenotazioni mapRequestToEntity(PrenotazioniRequest prenotazioniRequest) {

        Prenotazioni prenotazioni = new Prenotazioni();
        prenotazioni.setDataPrenotazione(prenotazioniRequest.getDataPrenotazione());
        return prenotazioni;

    }
}
