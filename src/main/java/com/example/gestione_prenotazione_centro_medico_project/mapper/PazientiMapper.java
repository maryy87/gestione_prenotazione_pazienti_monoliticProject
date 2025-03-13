package com.example.gestione_prenotazione_centro_medico_project.mapper;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.PazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PazientiResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Pazienti;
import org.springframework.stereotype.Component;

@Component
public class PazientiMapper {

    public PazientiResponse mapEntityToResponse(Pazienti pazienti) {

        PazientiResponse pazientiResponse = new PazientiResponse();
        pazientiResponse.setId(pazienti.getId());
        pazientiResponse.setNome(pazienti.getNome());
        pazientiResponse.setCognome(pazienti.getCognome());
        pazientiResponse.setPrenotazioni(pazienti.getPrenotazioni());
        pazientiResponse.setCodiceFiscale(pazienti.getCodiceFiscale());
        pazientiResponse.setDataDiNascita(pazienti.getDataDiNascita());
        return pazientiResponse;

    }


    public Pazienti mapRequestToEntity(PazientiRequest pazientiRequest) {

        Pazienti pazienti=new Pazienti();
        pazienti.setNome(pazientiRequest.getNome());
        pazienti.setCognome(pazientiRequest.getCognome());
        pazienti.setPrenotazioni(pazientiRequest.getPrenotazioni());
        pazienti.setCodiceFiscale(pazientiRequest.getCodiceFiscale());
        pazienti.setDataDiNascita(pazientiRequest.getDataDiNascita());
        return pazienti;

    }
}
