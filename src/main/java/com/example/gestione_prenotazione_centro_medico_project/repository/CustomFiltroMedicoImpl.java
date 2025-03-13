package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroMedicoRequest;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFiltroMedicoImpl implements CustomMedicoRepository {

    @Autowired
    final EntityManager entityManager;

    public CustomFiltroMedicoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Medici> findMediciFiltro(FiltroMedicoRequest filtroMedicoRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Medici> cq = cb.createQuery(Medici.class);
        Root<Medici> mediciRoot = cq.from(Medici.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroMedicoRequest.getNome() != null && !filtroMedicoRequest.getNome().isEmpty()) {
            Predicate predicate = cb.like(mediciRoot.get("nome"), "%" + filtroMedicoRequest.getNome() + "%");
            predicateList.add(predicate);
        }
        if (filtroMedicoRequest.getCognome() != null && !filtroMedicoRequest.getCognome().isEmpty()) {
            Predicate predicate = cb.like(mediciRoot.get("cognome"), "%" + filtroMedicoRequest.getCognome() + "%");
            predicateList.add(predicate);
        }
        if (filtroMedicoRequest.getNumeroDiTelefono() != null) {
            Predicate predicate = cb.equal(mediciRoot.get("numeroDiTelefono"), filtroMedicoRequest.getNumeroDiTelefono());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
