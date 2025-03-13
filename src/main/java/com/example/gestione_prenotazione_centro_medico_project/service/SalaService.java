package com.example.gestione_prenotazione_centro_medico_project.service;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.MediciRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.SalaRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.MediciResponse;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.SalaResponse;
import com.example.gestione_prenotazione_centro_medico_project.mapper.MediciMapper;
import com.example.gestione_prenotazione_centro_medico_project.mapper.SalaMapper;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import com.example.gestione_prenotazione_centro_medico_project.model.Sala;
import com.example.gestione_prenotazione_centro_medico_project.repository.MediciRepository;
import com.example.gestione_prenotazione_centro_medico_project.repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaMapper salaMapper;
    @Autowired
    private SalaRepository salaRepository;

    @Transactional
    public SalaResponse addSala(SalaRequest salaRequest) {
        Sala sala = salaRepository.save(salaMapper.mapRequestToEntity(salaRequest));
        return salaMapper.mapEntityToResponse(sala);

    }

    @Transactional
    public SalaResponse updateSala(SalaRequest salaRequest, int idSala) {
        Sala sala = salaMapper.mapRequestToEntity(salaRequest);
        if (salaRepository.findById(idSala).isPresent()) {
            sala.setId(idSala);
            return salaMapper.mapEntityToResponse(salaRepository.save(sala));
        }
        return null;
    }

    public boolean deleteSala(int idSala) {
        if (salaRepository.findById(idSala).isPresent()) {
            salaRepository.deleteById(idSala);
            if (salaRepository.findById(idSala).isPresent()) {
                return false;
            }
            return true;
        }
        return false;

    }

    public SalaResponse ricercaSala(int idSala) {
        Optional<Sala> salaOptional = salaRepository.findById(idSala);
        if (salaOptional.isPresent()) {
            return salaMapper.mapEntityToResponse(salaRepository.save(salaOptional.get()));
        }
        return null;

    }
}
