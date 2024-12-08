package com.eventia.serverback.services;

import com.eventia.serverback.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public void addAgenda(int idEvento, int idAgenda) {
        agendaRepository.addAgenda(idEvento, idAgenda);
    }
}
