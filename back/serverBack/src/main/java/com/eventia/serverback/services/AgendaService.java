package com.eventia.serverback.services;

import com.eventia.serverback.models.Agenda;
import com.eventia.serverback.models.AgendaAsientos;
import com.eventia.serverback.models.Asiento;
import com.eventia.serverback.models.Ubicacion;
import com.eventia.serverback.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final AgendaAsientoService agendaAsientoService;
    private final AsientoService asientoService;

    public AgendaService(AgendaRepository agendaRepository, AgendaAsientoService agendaAsientoService, AsientoService asientoService) {
        this.agendaRepository = agendaRepository;
        this.agendaAsientoService = agendaAsientoService;
        this.asientoService = asientoService;
    }

    public ArrayList<Agenda> getAgendas(int idEvento) {
        return agendaRepository.getAgendas(idEvento);
    }

    public Agenda getAgendaById(int idEvento, int idAgenda) {
        return agendaRepository.getAgendaById(idEvento, idAgenda);
    }

    public ArrayList<AgendaAsientos> getAsientosByAgenda(int idAgenda) {
        return agendaAsientoService.getAgendaAsientos(idAgenda);
    }

    public String addAgenda(int idEvento, Agenda agenda) {
        if (agenda.getAgd_fecha_inicio().isAfter(agenda.getAgd_fecha_fin())) {
            return "La fecha de inicio no puede ser después de la fecha de fin";
        }

        if (agendaRepository.isFechaOcupada(agenda.getUbc_id(), agenda.getAgd_fecha_inicio(), agenda.getAgd_fecha_fin())) {
            return "La fecha y ubicación ya están ocupadas por otro evento";
        }

        int agendaId = agendaRepository.addAgenda(idEvento, agenda);
        if (agendaId == 0) {
            return "No se pudo agregar la agenda";
        }

        ArrayList<Asiento> asientos = asientoService.getAsientosByUbc(agenda.getUbc_id());
        String response = agendaAsientoService.asociarAgendaAsientos(agendaId, asientos);

        return response + "\n Agenda agregada con éxito. Id: " + agendaId;
    }

    public String updateAgenda(int idEvento, Agenda agenda) {
        return agendaRepository.updateAgenda(idEvento, agenda);
    }

    public String deleteAgenda(int idEvento, int idAgenda) {
        return agendaRepository.deleteAgenda(idEvento, idAgenda);
    }

    public String deleteAgendas(int idEvento) {
        return agendaRepository.deleteAgendas(idEvento);
    }

}
