package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroMedicoRequest;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomMedicoRepository  {

    List<Medici> findMediciFiltro(FiltroMedicoRequest filtroMedicoRequest);

}
