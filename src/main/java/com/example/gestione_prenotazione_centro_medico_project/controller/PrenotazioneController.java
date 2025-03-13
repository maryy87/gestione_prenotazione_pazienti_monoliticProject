package com.example.gestione_prenotazione_centro_medico_project.controller;

import com.example.gestione_prenotazione_centro_medico_project.dto.request.PrenotazioniRequest;
import com.example.gestione_prenotazione_centro_medico_project.dto.response.PrenotazioniResponse;
import com.example.gestione_prenotazione_centro_medico_project.service.PrenotazioniService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

        @Autowired
        private PrenotazioniService prenotazioniService;

        @PostMapping("/addPrenotazioni")
        public ResponseEntity addPrenotazioni(@RequestBody @Valid PrenotazioniRequest prenotazioniRequest) {
            Object prenotazioniResponse = prenotazioniService.addPrenotazioni(prenotazioniRequest);
            if (prenotazioniResponse != null) {
                return ResponseEntity.ok(prenotazioniResponse);
            }

            return ResponseEntity.ofNullable("non si puo prenotare con lo stesso medico 2 volte al giorno!");
        }


        @PutMapping("/updatePrenotazioni/{idPrenotazioni}")
        public ResponseEntity updatePrenotazioni(@RequestBody @Valid PrenotazioniRequest prenotazioniRequest, @PathVariable int idPrenotazioni) {
            PrenotazioniResponse prenotazioniResponse = prenotazioniService.updatePrenotazioni(prenotazioniRequest, idPrenotazioni);
            if (prenotazioniResponse != null) {
                return ResponseEntity.ok(prenotazioniResponse);
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/deletePrenotazioni/{idPrenotazioni}")
        public ResponseEntity deletePrenotazioni(int idPrenotazioni) {
            boolean b = prenotazioniService.deletePrenotazioni(idPrenotazioni);
            if (b) {
                return ResponseEntity.ok("prenotazione cancellata con successo!");
            }
            return ResponseEntity.badRequest().body("l'id indicato non corresponde a nessuna prenotazione!");

        }

        @GetMapping("/ricercaPrenotazioni/{idPrenotazioni}")
        public ResponseEntity ricercaPrenotazioni(@PathVariable int idPrenotazioni) {
            PrenotazioniResponse prenotazioniResponse = prenotazioniService.ricercaPrenotazioni(idPrenotazioni);
            if (prenotazioniResponse != null) {
                return ResponseEntity.ok(prenotazioniResponse);
            }
            return ResponseEntity.notFound().build();

        }

}
