package com.example.gestione_prenotazione_centro_medico_project.controller;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.SpecializzazioniRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.SpecializzazioniResponse;
import com.example.gestione_prenotazione_centro_medico_project.service.SpecializzazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/specializzazione")
public class SpecializzazioneController {

    @Autowired
    private SpecializzazioniService specializzazioniService;

    @PostMapping("/addSpecializzazione")
    public ResponseEntity addSpecializzazione(@RequestBody SpecializzazioniRequest specializzazioniRequest) {
        SpecializzazioniResponse specializzazioniResponse=specializzazioniService.addSpecializzazione(specializzazioniRequest);
        if (specializzazioniResponse != null) {
            return ResponseEntity.ok(specializzazioniResponse);
        }
       return null;
    }

    @PutMapping("/updateSpecializzazione/{idSpecializzazione}")
    public ResponseEntity updateSpecializzazione(@RequestBody SpecializzazioniRequest specializzazioniRequest,@PathVariable int idSpecializzazione) {
        SpecializzazioniResponse specializzazioniResponse=specializzazioniService.updateSpecializzazione(specializzazioniRequest,idSpecializzazione);
        if (specializzazioniResponse != null) {
            return ResponseEntity.ok(specializzazioniResponse);
        }
        return null;
    }

    @DeleteMapping("/deleteSpecializzazione/{idSpecializzazione}")
    public ResponseEntity deleteSpecializzazione(@PathVariable int idSpecializzazione){
        boolean b= specializzazioniService.deleteSpecializzazione(idSpecializzazione);
        if (b) {
            return ResponseEntity.ok("la specializzazione è stata cancellata!");
        }
        return ResponseEntity.badRequest().body("la specializzazione non esiste!");
    }

    @GetMapping("/ricercaSpecializzazione/{idSpecializzazione}")
    public ResponseEntity ricercaSpecializzazione(@PathVariable int idSpecializzazione){
        SpecializzazioniResponse specializzazioniResponse=specializzazioniService.ricercaSpecializzazione(idSpecializzazione);
        if (specializzazioniResponse != null) {
            return ResponseEntity.ok(specializzazioniResponse);
        }
        return null;
    }
}
