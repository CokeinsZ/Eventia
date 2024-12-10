package com.eventia.serverback.services;

import com.eventia.serverback.models.AgendaAsientos;
import com.eventia.serverback.models.Asiento;
import com.eventia.serverback.repositories.AgendaAsientoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgendaAsientoService {
    private final AgendaAsientoRepository agendaAsientoRepository;

    public AgendaAsientoService(AgendaAsientoRepository agendaAsientoRepository) {
        this.agendaAsientoRepository = agendaAsientoRepository;
    }

    public ArrayList<AgendaAsientos> getAgendaAsientos(int idAgenda) {
        return agendaAsientoRepository.getAgendaAsientos(idAgenda);
    }

    public String asociarAgendaAsientos(int idAgenda, ArrayList<Asiento> asientos) {
        return agendaAsientoRepository.asociarAgendaAsientos(idAgenda, asientos);
    }

    public String addAgendaAsiento(int idAgenda, AgendaAsientos agendaAsientos) {
        return agendaAsientoRepository.addAgendaAsiento(idAgenda, agendaAsientos);
    }

    public String updateAgendaAsiento(int idAgenda, AgendaAsientos agendaAsientos) {
        return agendaAsientoRepository.updateAgendaAsiento(idAgenda, agendaAsientos);
    }

    public String deleteAgendaAsiento(int idAgenda, String ast_id) {
        return agendaAsientoRepository.deleteAgendaAsiento(idAgenda, ast_id);
    }

    public AgendaAsientos getAgendaAsiento(int idAgenda, String idAsiento) {
        return agendaAsientoRepository.getAgendaAsiento(idAgenda, idAsiento);
    }
}
