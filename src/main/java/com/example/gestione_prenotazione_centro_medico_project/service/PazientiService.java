package com.example.gestione_prenotazione_centro_medico_project.service;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroPazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.PazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PazientiResponse;
import com.example.gestione_prenotazione_centro_medico_project.mapper.PazientiMapper;
import com.example.gestione_prenotazione_centro_medico_project.model.Pazienti;
import com.example.gestione_prenotazione_centro_medico_project.repository.CustomFiltroPazientiImpl;
import com.example.gestione_prenotazione_centro_medico_project.repository.PazientiRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PazientiService {

    @Autowired
    private PazientiMapper pazientiMapper;
    @Autowired
    private PazientiRepository pazientiRepository;
    @Autowired
    private CustomFiltroPazientiImpl customFiltroPazienti;
    ModelMapper modelMapper=new ModelMapper();

    @Transactional
    public PazientiResponse addPazienti(PazientiRequest pazientiRequest) {
        Pazienti pazienti = pazientiRepository.save(pazientiMapper.mapRequestToEntity(pazientiRequest));
        return pazientiMapper.mapEntityToResponse(pazienti);

    }

    @Transactional
    public PazientiResponse updatePazienti(PazientiRequest pazientiRequest, int idPazienti) {
        Pazienti pazienti = pazientiMapper.mapRequestToEntity(pazientiRequest);
        if (pazientiRepository.findById(idPazienti).isPresent()) {
            pazienti.setId(idPazienti);
            return pazientiMapper.mapEntityToResponse(pazientiRepository.save(pazienti));
        }
        return null;
    }

    public boolean deletePazienti(int idPazienti) {
        if (pazientiRepository.findById(idPazienti).isPresent()) {
            pazientiRepository.deleteById(idPazienti);
            if (pazientiRepository.findById(idPazienti).isPresent()) {
                return false;
            }
            return true;
        }
        return false;

    }

    public PazientiResponse ricercapazienti(int idPazienti) {
        Optional<Pazienti> pazienti = pazientiRepository.findById(idPazienti);
        if (pazienti.isPresent()) {
            return pazientiMapper.mapEntityToResponse(pazienti.get());
        }
        return null;

    }

    public List<PazientiResponse> ricercapazienti(FiltroPazientiRequest filtroPazientiRequest) {
        List<Pazienti> pazientiList = customFiltroPazienti.findPazientiFiltro(filtroPazientiRequest);
        if (pazientiList!=null) {
            List<PazientiResponse> pazientiResponseList=pazientiList.stream().map(pazienti -> modelMapper.map(pazienti,PazientiResponse.class))
            .toList();
            return pazientiResponseList;
        }
        return null;

    }
}
