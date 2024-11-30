package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Evento;
import com.eventia.serverback.services.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ArrayList<Evento> listarEventos() {
        return eventoService.getEventos();
    }

    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable int id) {
        return eventoService.getEventoById(id);
    }

    @PostMapping
    public int agregarEvento(@RequestBody Evento evento) {
        return eventoService.addEvento(evento);

    }


}
