package com.example.gestione_prenotazione_centro_medico_project.service;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.PrenotazioniRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PrenotazioniResponse;
import com.example.gestione_prenotazione_centro_medico_project.mapper.PazientiMapper;
import com.example.gestione_prenotazione_centro_medico_project.mapper.PrenotazioniMapper;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import com.example.gestione_prenotazione_centro_medico_project.model.Pazienti;
import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import com.example.gestione_prenotazione_centro_medico_project.model.Sala;
import com.example.gestione_prenotazione_centro_medico_project.repository.MediciRepository;
import com.example.gestione_prenotazione_centro_medico_project.repository.PazientiRepository;
import com.example.gestione_prenotazione_centro_medico_project.repository.PrenotazioniRepository;
import com.example.gestione_prenotazione_centro_medico_project.repository.SalaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PrenotazioniService {

    @Autowired
    private PrenotazioniMapper prenotazioniMapper;
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    @Autowired
    private PazientiRepository pazientiRepository;
    @Autowired
    private PazientiMapper pazientiMapper;
    @Autowired
    private MediciRepository mediciRepository;
    @Autowired
    private SalaRepository salaRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Object addPrenotazioni(PrenotazioniRequest prenotazioniRequest) {
        Prenotazioni prenotazioni1 = new Prenotazioni();

        List<Prenotazioni> prenotazioni = prenotazioniRepository.verificaPrenotazione(prenotazioniRequest.getIdPazienti(), prenotazioniRequest.getIdMedici(), prenotazioniRequest.getDataPrenotazione());

        List<Prenotazioni> prenotazioniOrario =prenotazioniRepository.verificaOrario(prenotazioniRequest.getOrario(), prenotazioniRequest.getIdSala(), prenotazioniRequest.getDataPrenotazione());

        if (prenotazioni.isEmpty() ) {

            prenotazioni1.setDataPrenotazione(prenotazioniRequest.getDataPrenotazione());
            prenotazioni1.setOrario(prenotazioniRequest.getOrario());

            Optional<Pazienti> pazienti = pazientiRepository.findById(prenotazioniRequest.getIdPazienti());
            prenotazioni1.setIdPazienti(pazienti.get());
            log.info("pazienti aggiunto a prenotazione");

            Optional<Medici> mediciOptional = mediciRepository.findById(prenotazioniRequest.getIdMedici());
            prenotazioni1.setIdMedici(mediciOptional.get());
            log.info("medici aggiunto a prenotazione");

            Optional<Sala> salaOptional = salaRepository.findById(prenotazioniRequest.getIdSala());
            prenotazioni1.setIdSala(salaOptional.get());
            log.info("sala aggiunto a prenotazione");

            if (prenotazioniOrario.isEmpty()) {
                log.info("orario verificato");
                prenotazioni1.setOrario(prenotazioniRequest.getOrario());
                Prenotazioni prenotazioni2 = prenotazioniRepository.save(prenotazioni1);
                log.info("prenotazione salvata");
                PrenotazioniResponse prenotazioniResponse = prenotazioniMapper.mapEntityToResponse(prenotazioni2);

                return prenotazioniResponse;
            }
            else return "orario di prenotazione non disponibile  provare con un altro orario!";

        }
        return null;

    }


    @Transactional
    public PrenotazioniResponse updatePrenotazioni(PrenotazioniRequest prenotazioniRequest, int idPrenotazioni) {
        Prenotazioni prenotazioni = prenotazioniMapper.mapRequestToEntity(prenotazioniRequest);
        if (prenotazioniRepository.findById(idPrenotazioni).isPresent()) {

            Optional<Pazienti> pazienti = pazientiRepository.findById(prenotazioniRequest.getIdPazienti());
            prenotazioni.setIdPazienti(pazienti.get());

            Optional<Medici> mediciOptional = mediciRepository.findById(prenotazioniRequest.getIdMedici());
            prenotazioni.setIdMedici(mediciOptional.get());

            Optional<Sala> salaOptional = salaRepository.findById(prenotazioniRequest.getIdSala());
            prenotazioni.setIdSala(salaOptional.get());

            prenotazioni.setDataPrenotazione(prenotazioniRequest.getDataPrenotazione());
            prenotazioni.setOrario(prenotazioniRequest.getOrario());

            prenotazioni.setId(idPrenotazioni);
            return prenotazioniMapper.mapEntityToResponse(prenotazioniRepository.save(prenotazioni));
        }
        return null;
    }

    public boolean deletePrenotazioni(int idPrenotazioni) {
        Optional<Prenotazioni> prenotazioni = prenotazioniRepository.findById(idPrenotazioni);
        if (prenotazioni.isPresent()) {
            prenotazioniRepository.deleteById(idPrenotazioni);
            return true;
        }
        return false;

    }

    public PrenotazioniResponse ricercaPrenotazioni(int idPrenotazioni) {
        Optional<Prenotazioni> prenotazioniOptional = prenotazioniRepository.findById(idPrenotazioni);
        if (prenotazioniOptional.isPresent()) {
            return prenotazioniMapper.mapEntityToResponse(prenotazioniRepository.save(prenotazioniOptional.get()));
        }
        return null;

    }


}
