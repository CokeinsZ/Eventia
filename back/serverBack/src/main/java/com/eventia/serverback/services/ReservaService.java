package com.eventia.serverback.services;

import com.eventia.serverback.models.*;
import com.eventia.serverback.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final AgendaService agendaService;
    private final TransaccionService transaccionService;

    public ReservaService(ReservaRepository reservaRepository, AgendaService agendaService, TransaccionService transaccionService) {
        this.reservaRepository = reservaRepository;
        this.agendaService = agendaService;
        this.transaccionService = transaccionService;
    }

    public ArrayList<Reserva> getReservasEvt(int idAgenda) {
        return reservaRepository.getReservasEvt(idAgenda);
    }

    public ArrayList<Reserva> getReservasUsr(int idUsuario) {
        return reservaRepository.getReservasUsr(idUsuario);
    }

    public Reserva getReserva(int idReserva) {
        return reservaRepository.getReserva(idReserva);
    }

    public String addReserva(Reserva reserva) {
        AgendaAsientos asiento = agendaService.getAgendaAsiento(reserva.getRsv_agenda(), reserva.getRsv_asiento());
        if (asiento == null) {
            return "Asiento no encontrado";

        } else if (!asiento.getEstado().equalsIgnoreCase("libre")) {
            return "Asiento no disponible";

        }

        asiento.setEstado("reservado");
        reserva.setRsv_estado("confirmada");
        Evento evento = agendaService.getEvento(reserva.getRsv_agenda());
        Agenda agenda = agendaService.getAgendaById(reserva.getRsv_agenda());

        if(!agenda.getAgd_estado().equalsIgnoreCase("activo")){
            return "Agenda no disponible";
        }

        int reservaId = reservaRepository.addReserva(reserva);
        if (reservaId == -1) {
            return "No se pudo agregar la reserva";
        }

        String response = transaccionService.addTransaccion(reserva.getRsv_usuario(), reservaId, evento, "compra");
        response += " \n " + agendaService.updateAgendaAsiento(reserva.getRsv_agenda(), asiento);

        return response + "\n Reserva agregada con éxito. Id: " + reservaId;
    }

    public String cancelarReserva(int idReserva) {
        Reserva reserva = reservaRepository.getReserva(idReserva);
        Evento evento = agendaService.getEvento(reserva.getRsv_agenda());
        if (reserva == null) {
            return "Reserva no encontrada";
        }

        AgendaAsientos asiento = agendaService.getAgendaAsiento(reserva.getRsv_agenda(), reserva.getRsv_asiento());
        if (asiento == null) {
            return "Asiento no encontrado";

        } else if (!asiento.getEstado().equalsIgnoreCase("reservado")) {
            return "Asiento no reservado";

        }

        asiento.setEstado("libre");
        reserva.setRsv_estado("cancelada");

        String response = reservaRepository.updateReserva(reserva);
        response += " \n " + transaccionService.addTransaccion(reserva.getRsv_usuario(), idReserva, evento, "devolucion");
        response += " \n " + agendaService.updateAgendaAsiento(reserva.getRsv_agenda(), asiento);

        return response + "\n Reserva cancelada con éxito";
    }

}
