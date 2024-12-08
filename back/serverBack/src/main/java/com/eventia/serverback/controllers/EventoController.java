package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.FiltroEvento;
import com.eventia.serverback.services.AgendaService;
import com.eventia.serverback.services.CategoriaService;
import com.eventia.serverback.services.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoService eventoService;
    private final CategoriaService categoriaService;
    private final AgendaService agendaService;

    public EventoController(EventoService eventoService, CategoriaService categoriaService, AgendaService agendaService) {
        this.eventoService = eventoService;
        this.categoriaService = categoriaService;
        this.agendaService = agendaService;
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
        int idEvento = eventoService.addEvento(evento);
        categoriaService.handleCategorias(idEvento, evento.getCategorias());

        return idEvento;
    }

    @GetMapping("/filtrar")
    public ArrayList<Evento> filtrarEventos(@RequestBody FiltroEvento filtros) {
        return eventoService.filtrarEventos(filtros);
    }

    @PostMapping("/{id}/agenda")
    public String agregarAgenda(@PathVariable int id, @RequestBody Agenda agenda) {
        return agendaService.addAgenda(id, agenda);
    }


}
