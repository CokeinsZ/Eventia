package com.eventia.serverback.services;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final UbicacionService ubicacionService;

    public AgendaService(AgendaRepository agendaRepository, UbicacionService ubicacionService) {
        this.agendaRepository = agendaRepository;
        this.ubicacionService = ubicacionService;
    }

    public String addAgenda(int idEvento, Agenda agenda) {
        return agendaRepository.addAgenda(idEvento, agenda);
    }
}
