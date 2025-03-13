package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.model.Specializzazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializzazioniRepository extends JpaRepository<Specializzazioni,Integer> {

    Specializzazioni findByNome(String nome);
}
