package com.example.gestione_prenotazione_centro_medico_project.service;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.SpecializzazioniRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.SpecializzazioniResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Specializzazioni;
import com.example.gestione_prenotazione_centro_medico_project.repository.SpecializzazioniRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecializzazioniService {

    @Autowired
    private SpecializzazioniRepository specializzazioniRepository;
    ModelMapper modelMapper = new ModelMapper();

    public SpecializzazioniResponse addSpecializzazione(SpecializzazioniRequest specializzazioniRequest) {
        Specializzazioni specializzazioni = modelMapper.map(specializzazioniRequest, Specializzazioni.class);
        Specializzazioni specializzazioneSave = specializzazioniRepository.save(specializzazioni);
        SpecializzazioniResponse specializzazioniResponse = modelMapper.map(specializzazioneSave, SpecializzazioniResponse.class);
        return specializzazioniResponse;
    }

    public SpecializzazioniResponse updateSpecializzazione(SpecializzazioniRequest specializzazioniRequest, int idSpecializzazione) {
        Specializzazioni specializzazioni = modelMapper.map(specializzazioniRequest, Specializzazioni.class);
        if (specializzazioniRepository.findById(idSpecializzazione).isPresent()) {
            specializzazioni.setId(idSpecializzazione);
            Specializzazioni specializzazioneSave = specializzazioniRepository.save(specializzazioni);
            SpecializzazioniResponse specializzazioniResponse = modelMapper.map(specializzazioneSave, SpecializzazioniResponse.class);
            return specializzazioniResponse;
        }
        return null;
    }

    public boolean deleteSpecializzazione(int idSpecializzazione){
        Optional<Specializzazioni> specializzazioniOptional = specializzazioniRepository.findById(idSpecializzazione);
        if (specializzazioniOptional.isPresent()) {
            specializzazioniRepository.deleteById(idSpecializzazione);
            return true;
        }
        return false;
    }

    public SpecializzazioniResponse ricercaSpecializzazione(int idSpecializzazione){
        Optional<Specializzazioni> specializzazioniOptional = specializzazioniRepository.findById(idSpecializzazione);
        if (specializzazioniOptional.isPresent()) {
            SpecializzazioniResponse specializzazioniResponse = modelMapper.map(specializzazioniOptional.get(), SpecializzazioniResponse.class);
            return specializzazioniResponse;
        }
        return null;
    }
}


















