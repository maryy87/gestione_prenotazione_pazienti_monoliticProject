package com.example.gestione_prenotazione_centro_medico_project.controller;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroPazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.PazientiRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PazientiResponse;
import com.example.gestione_prenotazione_centro_medico_project.service.PazientiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pazienti")
public class PazientiController {

    @Autowired
    private PazientiService pazientiService;

    @PostMapping("/ricercapazientiFiltro")
    public ResponseEntity ricercaPazientiFiltro(@RequestBody FiltroPazientiRequest filtroPazientiRequest) {
        List<PazientiResponse> pazientiResponseList = pazientiService.ricercapazienti(filtroPazientiRequest);
        if (pazientiResponseList != null) {
            return ResponseEntity.ok(pazientiResponseList);
        }
        return ResponseEntity.badRequest().body("nessun paziente trovato!");

    }

    @PostMapping("/addPazienti")
    public ResponseEntity addPazienti(@RequestBody @Valid PazientiRequest pazientiRequest) {
        PazientiResponse pazientiResponse = pazientiService.addPazienti(pazientiRequest);
        if (pazientiResponse != null) {
            return ResponseEntity.ok(pazientiResponse);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/updatePazienti/{idPazienti}")
    public ResponseEntity updatePazienti(@RequestBody @Valid PazientiRequest pazientiRequest, @PathVariable int idPazienti) {
        PazientiResponse pazientiResponse = pazientiService.updatePazienti(pazientiRequest, idPazienti);
        if (pazientiResponse != null) {
            return ResponseEntity.ok(pazientiResponse);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/deletePazienti/{idPazienti}")
    public ResponseEntity deletePazienti(@PathVariable int idPazienti) {
        boolean b = pazientiService.deletePazienti(idPazienti);
        if (b) {
            return ResponseEntity.ok("paziente cancellato con successo!");
        }
        return ResponseEntity.ofNullable("paziente non cancellato");
    }

    @GetMapping("/ricercaPazienti/{idPazienti}")
    public ResponseEntity ricercaPazienti(@PathVariable int idPazienti) {
        PazientiResponse pazientiResponse = pazientiService.ricercapazienti(idPazienti);
        if (pazientiResponse != null) {
            return ResponseEntity.ok(pazientiResponse);
        }
        return ResponseEntity.notFound().build();
    }
}