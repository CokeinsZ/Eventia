package com.eventia.serverback.controllers;

import com.eventia.serverback.models.Calificacion;
import com.eventia.serverback.models.LoginResponse;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.services.CalificacionService;
import com.eventia.serverback.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final CalificacionService calificacionService;

    public UsuarioController(UsuarioService usuarioService, CalificacionService calificacionService) {
        this.usuarioService = usuarioService;
        this.calificacionService = calificacionService;
    }

    @GetMapping("/{id}")
    public Usuario getUsuarios(@PathVariable int id) {
        return this.usuarioService.getUsuario(id);
    }

    @GetMapping("/{correo}")
    public Usuario getUsuarios(@PathVariable String correo) {
        return this.usuarioService.getUsuario(correo);
    }

    @PostMapping("/register")
    public String registerUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.registerUsuario(usuario);
    }

    @PostMapping("/login")
    public LoginResponse loginUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.loginUsuario(usuario);
    }

    @GetMapping("/{id}/calificaciones")
    public ArrayList<Calificacion> getCalificacionesUsuario(@PathVariable int id) {
        return this.calificacionService.getCalificacionesUsuario(id);
    }

    @GetMapping("/{id}/calificaciones/{idEvento}")
    public Calificacion getCalificacion(@PathVariable int id, @PathVariable int idEvento) {
        return this.calificacionService.getCalificacion(idEvento, id);
    }

}
