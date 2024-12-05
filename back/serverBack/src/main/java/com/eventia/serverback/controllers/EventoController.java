package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Categoria;
import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.Filtro;
import com.eventia.serverback.services.CategoriaService;
import com.eventia.serverback.services.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoService eventoService;
    private final CategoriaService categoriaService;

    public EventoController(EventoService eventoService, CategoriaService categoriaService) {
        this.eventoService = eventoService;
        this.categoriaService = categoriaService;
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
    public ArrayList<Evento> filtrarEventos(@RequestBody Filtro filtros) {
        System.out.println(filtros.getNombre());

        return eventoService.filtrarEventos(filtros);
    }


}
