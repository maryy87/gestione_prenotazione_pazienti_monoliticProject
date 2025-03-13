package com.example.gestione_prenotazione_centro_medico_project.controller;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.SalaRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.SalaResponse;
import com.example.gestione_prenotazione_centro_medico_project.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;


    @PostMapping("/addSala")
    public ResponseEntity addSala(@RequestBody SalaRequest salaRequest) {
        SalaResponse salaResponse=salaService.addSala(salaRequest);
        if (salaResponse != null) {
             return ResponseEntity.ok(salaResponse);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/updateSala/{idSala}")
    public ResponseEntity updateSala(@RequestBody SalaRequest salaRequest, @PathVariable int idSala) {
        SalaResponse salaResponse=salaService.updateSala(salaRequest,idSala);
        if (salaResponse != null) {
            return ResponseEntity.ok(salaResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteSala/{idSala}")
    public ResponseEntity deleteSala(@PathVariable int idSala) {
        boolean b=salaService.deleteSala(idSala);
        if (b) {
            return ResponseEntity.ok("sala cancellata con successo!");
        }
        return ResponseEntity.ofNullable("l'id indicato non corresponde a nessuna sala!");

    }

    @GetMapping("/ricercaSala{idSala}")
    public ResponseEntity ricercaSala(@PathVariable int idSala) {
        SalaResponse salaResponse=salaService.ricercaSala(idSala);
        if (salaResponse != null) {
            return ResponseEntity.ok(salaResponse);
        }
        return ResponseEntity.notFound().build();

    }
}
