package com.eventia.serverback.services;

import com.eventia.serverback.models.Evento;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.repositories.TransaccionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final UsuarioService usuarioService;
    private final AgendaService agendaService;

    public TransaccionService(TransaccionRepository transaccionRepository, UsuarioService usuarioService, AgendaService agendaService) {
        this.transaccionRepository = transaccionRepository;
        this.usuarioService = usuarioService;
        this.agendaService = agendaService;
    }

    public String addTransaccion(int usuarioId, int idReserva, Evento evento, String tipo) {
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        Usuario organizador = usuarioService.getUsuario(evento.getEvt_organizador());

        float saldoAnteriorUsuario = usuario.getUsr_saldo();
        float saldoAnteriorOrganizador = organizador.getUsr_saldo();
        float precio = evento.getEvt_precio();
        if (tipo.equalsIgnoreCase("compra") && saldoAnteriorUsuario < precio) {
            return "Saldo insuficiente";
        }

        String response = crearTransaccion(usuario, idReserva, saldoAnteriorUsuario, saldoAnteriorUsuario - precio, tipo);
        response += " \n " + crearTransaccion(organizador, idReserva, saldoAnteriorOrganizador, saldoAnteriorOrganizador + precio, tipo);

        return response;
    }

    private String crearTransaccion(Usuario usuario, int idReserva, float saldoAnterior, float saldoNuevo, String tipo) {
        if (usuarioService.updateSaldo(usuario.getUsr_id(), saldoNuevo) == -1) {
            return "Error al actualizar saldo";
        }

        return transaccionRepository.addTransaccion(usuario.getUsr_id(), idReserva, saldoAnterior, saldoNuevo, tipo);
    }

}
