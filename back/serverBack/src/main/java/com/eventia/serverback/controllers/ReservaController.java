package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Reserva;
import com.eventia.serverback.services.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.ArrayList;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/")
    public ArrayList<Reserva> getReservasEvt(@RequestBody int idAgenda) {
        return reservaService.getReservasEvt(idAgenda);
    }

    @GetMapping("/usuario")
    public ArrayList<Reserva> getReservasUsr(@RequestBody int idUsuario) {
        return reservaService.getReservasUsr(idUsuario);
    }

    @GetMapping("/{idReserva}")
    public Reserva getReserva(@PathVariable int idReserva) {
        return reservaService.getReserva(idReserva);
    }

    @PostMapping("/")
    public String addReserva(@RequestBody Reserva reserva) {
        return reservaService.addReserva(reserva);
    }

    @DeleteMapping("/{idReserva}")
    public String cancelarReserva(@PathVariable int idReserva) {
        return reservaService.cancelarReserva(idReserva);
    }

}
