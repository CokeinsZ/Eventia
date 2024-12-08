package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Recarga;
import com.eventia.serverback.services.RecargasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recargas")
public class RecargasController {
    private final RecargasService recargasService;

    public RecargasController(RecargasService recargasService) {
        this.recargasService = recargasService;
    }

    @PostMapping("/")
    public String recargarSaldo(@RequestBody Recarga recarga) {
        return this.recargasService.recargarSaldo(recarga.getUsr_id(), recarga.getRec_monto());
    }
}
