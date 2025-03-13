package com.example.gestione_prenotazione_centro_medico_project.repository;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroPazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.model.Pazienti;
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
public class CustomFiltroPazientiImpl implements CustomPazientiRepository {
/***/
    @Autowired
    final EntityManager entityManager;

    public CustomFiltroPazientiImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Pazienti> findPazientiFiltro(FiltroPazientiRequest filtroPazientiRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pazienti> cq = cb.createQuery(Pazienti.class);
        Root<Pazienti> pazientiRoot = cq.from(Pazienti.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroPazientiRequest.getNome() != null && !filtroPazientiRequest.getNome().isEmpty()) {
            Predicate predicate = cb.like(pazientiRoot.get("nome"), "%" + filtroPazientiRequest.getNome() + "%");
            predicateList.add(predicate);
        }
        if (filtroPazientiRequest.getCognome() != null && !filtroPazientiRequest.getCognome().isEmpty()) {
            Predicate predicate = cb.like(pazientiRoot.get("cognome"), "%" + filtroPazientiRequest.getCognome() + "%");
            predicateList.add(predicate);
        }
        if (filtroPazientiRequest.getCodiceFiscale() != null && !filtroPazientiRequest.getCodiceFiscale().isEmpty()) {
            Predicate predicate = cb.like(pazientiRoot.get("codiceFiscale"), "%" + filtroPazientiRequest.getCodiceFiscale() + "%");
            predicateList.add(predicate);
        }
        if (filtroPazientiRequest.getDataDiNascita() != null) {
            Predicate predicate = cb.equal(pazientiRoot.get("dataDiNascita"), filtroPazientiRequest.getDataDiNascita());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
