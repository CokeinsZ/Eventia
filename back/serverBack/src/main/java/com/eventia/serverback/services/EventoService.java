package com.eventia.serverback.services;

import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.FiltroEvento;
import com.eventia.serverback.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public ArrayList<Evento> getEventos(int pagina) {
        return eventoRepository.getEventos(pagina);
    }

    public Evento getEventoById(int id) {
        return eventoRepository.getEventoById(id);
    }

    public int addEvento(Evento evento) {
        return eventoRepository.addEvento(evento);
    }

    public ArrayList<Evento> filtrarEventos(FiltroEvento filtros) {
        return eventoRepository.filtrarEventos(filtros);
    }

    public String updateEvento(int id, Evento evento) {
        return eventoRepository.updateEvento(id, evento);
    }

    public String deleteEvento(int id) {
        return eventoRepository.deleteEvento(id);
    }

    public ArrayList<Evento> getEventosOrganizador(int id) {
        return eventoRepository.getEventosOrganizador(id);
    }
}
