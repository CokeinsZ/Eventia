package com.eventia.serverback.controllers;

import com.eventia.serverback.models.*;
import com.eventia.serverback.services.AgendaService;
import com.eventia.serverback.services.CalificacionService;
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
    private final CalificacionService calificacionService;

    public EventoController(EventoService eventoService, CategoriaService categoriaService, AgendaService agendaService, CalificacionService calificacionService) {
        this.eventoService = eventoService;
        this.categoriaService = categoriaService;
        this.agendaService = agendaService;
        this.calificacionService = calificacionService;
    }

    @GetMapping("/pagina")
    public ArrayList<Evento> listarEventos(@RequestParam int pagina) {
        return eventoService.getEventos(pagina);
    }

    @GetMapping("/organizador/{id}")
    public ArrayList<Evento> listarEventosOrganizador(@PathVariable int id) {
        return eventoService.getEventosOrganizador(id);
    }

    @GetMapping("/categorias")
    public ArrayList<Categoria> listarCategorias() {
        return categoriaService.getCategorias();
    }

    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable int id) {
        return eventoService.getEventoById(id);
    }

    @PostMapping("/")
    public int agregarEvento(@RequestBody Evento evento) {
        int idEvento = eventoService.addEvento(evento);
        categoriaService.handleCategorias(idEvento, evento.getCategorias());

        return idEvento;
    }

    @GetMapping("/filtrar")
    public ArrayList<Evento> filtrarEventos(@RequestBody FiltroEvento filtros) {
        return eventoService.filtrarEventos(filtros);
    }

    @PutMapping("/{id}")
    public String actualizarEvento(@PathVariable int id ,@RequestBody Evento evento) {
        return eventoService.updateEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public String eliminarEvento(@PathVariable int id) {
        String response = categoriaService.deleteEventoCategoria(id);
        response += " \n" + agendaService.deleteAgendas(id);
        response += " \n" + eventoService.deleteEvento(id);
        return response;
    }

    // Enpoints para Agendas

    @GetMapping("/{id}/agendas")
    public ArrayList<Agenda> listarAgendas(@PathVariable int id) {
        return agendaService.getAgendas(id);
    }

    @GetMapping("/{id}/agendas/{idAgenda}")
    public Agenda obtenerAgendaPorId(@PathVariable int id, @PathVariable int idAgenda) {
        return agendaService.getAgendaById(idAgenda);
    }

    @GetMapping("/{id}/agendas/asientos/{idAgenda}")
    public ArrayList<AgendaAsientos> obtenerAsientosPorAgenda(@PathVariable int idAgenda) {
        return agendaService.getAsientosByAgenda(idAgenda);
    }

    @PostMapping("/{id}/agendas")
    public String agregarAgenda(@PathVariable int id, @RequestBody Agenda agenda) {
        return agendaService.addAgenda(id, agenda);
    }

    @PutMapping("/{id}/agendas")
    public String actualizarAgenda(@PathVariable int id, @RequestBody Agenda agenda) {
        return agendaService.updateAgenda(id, agenda);
    }

    @PutMapping("/{id}/agendas/terminar")
    public String terminarAgenda(@PathVariable int id, @RequestParam int idAgenda) {
        return agendaService.terminarAgenda(id, idAgenda);
    }

    @DeleteMapping("/{id}/agendas/{idAgenda}")
    public String eliminarAgenda(@PathVariable int id, @PathVariable int idAgenda) {
        return agendaService.deleteAgenda(id, idAgenda);
    }

    // Endpoints para Calificaciones

    @GetMapping("/{id}/calificaciones")
    public ArrayList<Calificacion> listarCalificaciones(@PathVariable int id) {
        return calificacionService.getCalificacionesEvento(id);
    }

    @PostMapping("/{id}/calificaciones")
    public String agregarCalificacion(@PathVariable int id, @RequestParam int user ,@RequestBody Calificacion calificacion) {
        return calificacionService.addCalificacion(id, user, calificacion);
    }

    @PutMapping("/{id}/calificaciones")
    public String actualizarCalificacion(@PathVariable int id, @RequestParam int user ,@RequestBody Calificacion calificacion) {
        return calificacionService.updateCalificacion(id, user, calificacion);
    }

    @DeleteMapping("/{id}/calificaciones")
    public String eliminarCalificacion(@PathVariable int id, @RequestParam int user) {
        return calificacionService.deleteCalificacion(id, user);
    }

    @GetMapping("/{id}/calificaciones/promedio")
    public double obtenerPromedioCalificaciones(@PathVariable int id) {
        return calificacionService.getPromedioCalificaciones(id);
    }


}
