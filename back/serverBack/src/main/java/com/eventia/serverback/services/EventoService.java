package com.eventia.serverback.services;

import com.eventia.serverback.models.Evento;
import com.eventia.serverback.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public ArrayList<Evento> getEventos() {
        return eventoRepository.getEventos();
    }

    public Evento getEventoById(int id) {
        return eventoRepository.getEventoById(id);
    }

    public int addEvento(Evento evento) {
        return eventoRepository.addEvento(evento);
    }


}
