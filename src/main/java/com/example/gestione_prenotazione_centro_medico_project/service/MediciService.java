package com.example.gestione_prenotazione_centro_medico_project.service;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroMedicoRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.MediciRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.MediciResponse;
import com.example.gestione_prenotazione_centro_medico_project.mapper.MediciMapper;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import com.example.gestione_prenotazione_centro_medico_project.repository.CustomFiltroMedicoImpl;
import com.example.gestione_prenotazione_centro_medico_project.repository.MediciRepository;
import com.example.gestione_prenotazione_centro_medico_project.repository.SpecializzazioniRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediciService {

    @Autowired
    private MediciMapper mediciMapper;
    @Autowired
    private MediciRepository mediciRepository;
    @Autowired
    private SpecializzazioniRepository specializzazioniRepository;
    @Autowired
    private CustomFiltroMedicoImpl customFiltroMedico;
    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public MediciResponse addMediciAndSpecializzazione(MediciRequest mediciRequest) {
        Medici medici = mediciRepository.save(mediciMapper.mapRequestToEntity(mediciRequest));
        return mediciMapper.mapEntityToResponse(medici);
    }

    public int addSpecializzazioneMedico(int idMedico, int idSpecializzazione) {
        int b = mediciRepository.addSpecializzazioneAdMedico(idMedico, idSpecializzazione);
        return b;

    }

    @Transactional
    public MediciResponse updateMedici(MediciRequest mediciRequest, int idMedici) {
        Medici medici = mediciMapper.mapRequestToEntity(mediciRequest);
        if (mediciRepository.findById(idMedici).isPresent()) {
            medici.setId(idMedici);
            return mediciMapper.mapEntityToResponse(mediciRepository.save(medici));
        }
        return null;
    }

    public boolean deleteMedici(int idMedici) {
        if (mediciRepository.findById(idMedici).isPresent()) {
            mediciRepository.deleteById(idMedici);
            if (mediciRepository.findById(idMedici).isPresent()) {
                return false;
            }
            return true;
        }
        return false;

    }

    public MediciResponse ricercaMedici(int idMedici) {
        Optional<Medici> mediciOptional = mediciRepository.findById(idMedici);
        if (mediciOptional.isPresent()) {
            return mediciMapper.mapEntityToResponse(mediciRepository.save(mediciOptional.get()));
        }
        return null;

    }

    public List<MediciResponse> ricercaMedici(FiltroMedicoRequest filtroMedicoRequest) {
        if (filtroMedicoRequest != null) {
            List<Medici> mediciList = customFiltroMedico.findMediciFiltro(filtroMedicoRequest);
            List<MediciResponse> mediciResponseList = modelMapper.map(mediciList, new TypeToken<List<MediciResponse>>() {
            }.getType());
            return mediciResponseList;
        }
        return null;
    }
}
