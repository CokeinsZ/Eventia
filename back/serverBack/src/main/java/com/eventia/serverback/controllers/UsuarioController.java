package com.eventia.serverback.controllers;

import com.eventia.serverback.models.LoginResponse;
import com.eventia.serverback.models.Usuario;
import com.eventia.serverback.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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




}
