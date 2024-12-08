package com.eventia.serverback.services;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public ArrayList<Agenda> getAgendas(int idEvento) {
        return agendaRepository.getAgendas(idEvento);
    }

    public Agenda getAgendaById(int idEvento, int idAgenda) {
        return agendaRepository.getAgendaById(idEvento, idAgenda);
    }

    public String addAgenda(int idEvento, Agenda agenda) {
        return agendaRepository.addAgenda(idEvento, agenda);
    }

    public String updateAgenda(int idEvento, Agenda agenda) {
        return agendaRepository.updateAgenda(idEvento, agenda);
    }

    public String deleteAgenda(int idEvento, int idAgenda) {
        return agendaRepository.deleteAgenda(idEvento, idAgenda);
    }

}
