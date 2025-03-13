package com.example.gestione_prenotazione_centro_medico_project.mapper;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.MediciRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.MediciResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import org.springframework.stereotype.Component;

@Component
public class MediciMapper {

    public MediciResponse mapEntityToResponse(Medici medici) {

        MediciResponse mediciResponse = new MediciResponse();
        mediciResponse.setId(medici.getId());
        mediciResponse.setNome(medici.getNome());
        mediciResponse.setCognome(medici.getCognome());
        mediciResponse.setNumeroDiTelefono(medici.getNumeroDiTelefono());
        mediciResponse.setPrenotazioniList(medici.getPrenotazioniList());
        mediciResponse.setSpecializzazioniList(medici.getSpecializzazioniList());
        return mediciResponse;

    }

    public Medici mapRequestToEntity(MediciRequest mediciRequest) {

        Medici medici = new Medici();
        medici.setNome(mediciRequest.getNome());
        medici.setCognome(mediciRequest.getCognome());
        medici.setNumeroDiTelefono(mediciRequest.getNumeroDiTelefono());
        medici.setSpecializzazioniList(mediciRequest.getSpecializzazioniList());
        return medici;

    }
}
