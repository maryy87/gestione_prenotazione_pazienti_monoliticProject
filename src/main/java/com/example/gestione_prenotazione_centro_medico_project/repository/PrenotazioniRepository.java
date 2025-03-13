package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.model.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni,Integer> {

    @Query(nativeQuery = true,value = "SELECT*  FROM prenotazioni \n" +
            "WHERE id_pazienti=:idPaziente AND  id_medici=:idMedico AND data_prenotazione=:data")
    List<Prenotazioni> verificaPrenotazione(@Param("idPaziente") int idPaziente, @Param("idMedico")int idMedico, @Param("data") LocalDate data);

    @Query(nativeQuery = true,value = "SELECT* FROM prenotazioni \n" +
            "        WHERE id_sala =:idSala  AND data_prenotazione=:dataPrenotazione AND orario=:orario")
    List<Prenotazioni> verificaOrario( @Param("orario") LocalTime orario,@Param("idSala") int idSala,@Param("dataPrenotazione") LocalDate dataPrenotazione);

}
