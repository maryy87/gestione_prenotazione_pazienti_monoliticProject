package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MediciRepository extends JpaRepository<Medici,Integer > {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO medico_specializzazione (id_medico,id_specializzazione) VALUES (:idMedico,:idSpecicalizzazione);")
    int addSpecializzazioneAdMedico(@Param(value = "idMedico") int idMedico,@Param(value = "idSpecicalizzazione") int idSpecicalizzazione);
}
