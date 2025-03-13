package com.example.gestione_prenotazione_centro_medico_project.controller;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.FiltroMedicoRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.request.MediciRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.MediciResponse;
import com.example.gestione_prenotazione_centro_medico_project.model.Medici;
import com.example.gestione_prenotazione_centro_medico_project.service.MediciService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medici")
public class MediciController {

    @Autowired
    private MediciService mediciService;

    @PostMapping("/ricercaMedico")
    public ResponseEntity ricercaMedico(@RequestBody FiltroMedicoRequest filtroMedicoRequest) {
        List<MediciResponse> mediciResponseList=mediciService.ricercaMedici(filtroMedicoRequest);

        if (!mediciResponseList.isEmpty()) {
            return ResponseEntity.ok(mediciResponseList);
        }
        return ResponseEntity. ofNullable("n");
    }

    @PostMapping("/addSpecializzazioneMedico/{idMedico}/{idSpecializzazione}")
    public ResponseEntity addSpecializzazioneMedico(@PathVariable int idMedico, @PathVariable int idSpecializzazione) {
        int b = mediciService.addSpecializzazioneMedico(idMedico, idSpecializzazione);
        if (b > 0) {
            return ResponseEntity.ok("sppecializzazione aggiunta con successo");
        }
        return ResponseEntity.ofNullable("la specializzazione non è stata aggiunta");

    }

    @PostMapping("/addMedici")
    public ResponseEntity addMedici(@RequestBody @Valid MediciRequest mediciRequest) {
        MediciResponse mediciResponse = mediciService.addMediciAndSpecializzazione(mediciRequest);
        if (mediciResponse != null) {
            return ResponseEntity.ok(mediciResponse);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/updateMedici/{idMedici}")
    public ResponseEntity updateMedici(@RequestBody @Valid MediciRequest mediciRequest, @PathVariable int idMedici) {
        MediciResponse mediciResponse = mediciService.updateMedici(mediciRequest, idMedici);
        if (mediciResponse != null) {
            return ResponseEntity.ok(mediciResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteMedici/{idMedici}")
    public ResponseEntity deleteMedici(@PathVariable int idMedici) {
        boolean b = mediciService.deleteMedici(idMedici);
        if (b) {
            return ResponseEntity.ok("medico cancellato con successo!");
        }
        return ResponseEntity.ofNullable("l'id indicato non corresponde a nessun medico!");
    }

    @GetMapping("/ricercaMedici/{idMedici}")
    public ResponseEntity ricercaMedici(@PathVariable int idMedici) {
        MediciResponse mediciResponse = mediciService.ricercaMedici(idMedici);
        if (mediciResponse != null) {
            return ResponseEntity.ok(mediciResponse);
        }
        return ResponseEntity.notFound().build();

    }
}
